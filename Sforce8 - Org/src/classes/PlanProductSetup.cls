/******************************************
*
* プランの会計商品明細設定画面
* 商品登録順番変わらない様に変更を行う
*
*******************************************/
public with sharing class PlanProductSetup {
	// 10行目の商品設定が可能
	private static final Integer DEF_INPUT_ROWS = 10;
	// 会計商品の商品コード作成する場合、前方数字：例：Pxxxxコードで自動採番を行う
    private static final String PLAN_PRD_PREX_NUM = 'P';
    
	//private ApexPages.StandardController ctrl;
	private Id planId;
	// 商品金額合計値維持する
	public Decimal productAmount{get; private set;}
	// プラン金額（手入力情報維持する）
	public Decimal productInputAmout{get; set;}

	public PlanProductSetup(ApexPages.StandardController controller) {
		//ctrl = controller;
		planId = controller.getId();
		// プラン情報を取得する
		queryPlanInfo();
		// プラン明細情報を取得する
		queryPlanDetailInfo();
	}
	// プラン基本情報
	public Plan__c planInfo{get; private set;}
	//public AccountMaster__c planProductInfo{get; private set;}
	// プラン明細
	public List<PlanDetail> planDetailList{get; private set;}
	// プラン基本情報を取得する
	private Boolean queryPlanInfo() {
		List<Plan__c> planInfoLst = [select id, Name, PlanNo__c, JmstRef__c, JmstRef__r.TaxRate__c ,ServiceRate__c, DpRef__c, GpRef__c, Price__c from Plan__c where id = :planId limit 1];
		if (planInfoLst.isEmpty()) {
			Apexpages.addMessage(new ApexPages.Message(ApexPages.Severity.ERROR, '指定してプラン情報を見つかりません。'));
			return false;
		}
		planInfo = planInfoLst[0];
		return true;
	}
	/**
	* プランから会計商品プラン情報を取得する
	**/
	private AccountMaster__c queryPlanProductInfo(Plan__c plan) {
		// 会計商品（プラン）情報を取得する
		// プランと同じ商品コードのデータを取得する[単価、商品コード、リンクＤＰコード、#GP、]
		List<AccountMaster__c> productLst = [select id, name, Field5__c, Field3__c, Field4__c, GPChange__c, ServiceRate__c, jmstRef__c From AccountMaster__c
			where Field3__c = :this.getPlanProdCode(plan.PlanNo__c) limit 1];
		if (productLst.isEmpty()) return null;
		return productLst[0];
		/*
		List<PlanDetail__c> planProductLst = [Select PlanRef__c, PlanProdcut__r.Field5__c, 
			PlanProdcut__r.Field3__c, PlanProdcut__r.Id, PlanProdcut__c 
			From PlanDetail__c where PlanRef__c = :planId  and PlanProdcut__c != null limit 1];		
		if (!planProductLst.isEmpty()) {
			planProductInfo = planProductLst[0].PlanProdcut__r;
		}*/
	}
	/*
	* プランから、すでに設定された商品情報を取得する
	*/
	public void queryPlanDetailInfo () {
		// 金額と入力金額初期化する
		productAmount = 0;
		productInputAmout = 0;
		
		// 会計商品（プラン）情報を取得する
		//queryPlanProductInfo();
		// プラン明細一覧情報を維持する
		planDetailList = new List<PlanDetail>();
		// 明細一覧を検索する
		for ( PlanDetail__c sobj : [select Name, PlanRef__c, AccountMasterRef__c, AccountMasterRef__r.Name ,TaxRate__c,
		                            AccountMasterRef__r.Field5__c, JmstRef__c, ServiceRate__c, Price__c, ProductNumber__c, PlanProdcut__c
			from PlanDetail__c where PlanRef__c = :planId]) {
			// 詳細情報を設定ヲ行う
			planDetailList.add(new PlanDetail(sobj, planDetailList.size()));
			// 商品の単価(手入力)で金額を合計する
			productInputAmout += CommUtils.nullToZero(sobj.Price__c);
		}
		// 合計処理を行う
        for (PlanDetail dl : planDetailList) {
            productAmount += dl.amoutIncTax;
        }
		// 既存データ以外の自動追加
		if (planDetailList.size() < DEF_INPUT_ROWS) {
			Integer appendRsSize = DEF_INPUT_ROWS - planDetailList.size();
			// 2行目まで設定を行う
			for (Integer i = 0; i < appendRsSize; i++) {
				planDetailList.add(new PlanDetail(new PlanDetail__c(PlanRef__c = planId, Price__c = null),planDetailList.size()));
			}
		}
	}
	/**
	* 画面戻ります
	**/
	public Pagereference gotoBlack() {
		Pagereference page = new Pagereference('/' + planId);
		page.setRedirect(true);
		return page;
	}
    /**
    * 商品コード採番を行う
    * プラン商品登録場合、商品コードを取得する
    **//*
    private String generPlanProdNo() {
    	// 既存のプラン商品の最大番号を取得する
    	// 商品コードは最大4桁まで取得する、9999を超えると、0000に戻ります
    	Integer maxProdCode = Integer.valueOf(PLAN_PRD_PREX_NUM + String.valueOf(9999));
    	Integer startCode = 1;
    	Integer maxCdLen = 4;
    	// 商品種別はプランの最大商品コードを取得する（重複存在チェックを行う?）
    	List<AccountMaster__c> maxAccMst = [select nextitemcode__c from AccountMaster__c
    	   where ActionType__c = :CommConst.PROD_ACTION_TYPE_PL Order By nextitemcode__c desc limit 1];
        if (maxAccMst.isEmpty()) return PLAN_PRD_PREX_NUM + CommUtils.paddingLeftZero(startCode, maxCdLen);
        Decimal prodCd = maxAccMst[0].nextitemcode__c;
        if (prodCd == null || prodCd == 0) return PLAN_PRD_PREX_NUM + CommUtils.paddingLeftZero(startCode, maxCdLen);
        else {
        	// 最大値になる場合、0001に戻る
        	if (prodCd + 1 >= maxProdCode) return PLAN_PRD_PREX_NUM + CommUtils.paddingLeftZero(startCode, maxCdLen);
        	// 以外の場合、通常に番号を増える
        	return String.valueOf(prodCd + 1);
        }
    }*/
	/*
	* プラン情報を登録する
	*/
	public Pagereference savePlanDetail() {

		// プラン情報を取得、Lockを行う
		List<Plan__c> lockPlan = [select id, Name, PlanNo__c, JmstRef__c, ServiceRate__c, DpRef__c, GpRef__c, Price__c from Plan__c where id = :planId for update];
		if (lockPlan.isEmpty()) {
			Apexpages.addMessage(new ApexPages.Message(ApexPages.Severity.ERROR, '指定してプラン情報を見つかりません。'));
			return null;
		}
		// 会計商品（プラン）最新情報を取得する
		AccountMaster__c planProductInfo = this.queryPlanProductInfo(lockPlan[0]);
        // 会計商品（プラン）は未存在する場合、自動新規プラン商品を作成する、
		if (planProductInfo == null) {
			// 商品コードを取得する(自動採番)
			//String newProdCode = generPlanProdNo();
			// 新規情報を設定を行う
			planProductInfo = new AccountMaster__c(
				Name = lockPlan[0].Name,
				Field3__c = this.getPlanProdCode(lockPlan[0].PlanNo__c),		// 商品コード：プランコード
				Field5__c = lockPlan[0].Price__c,
				Field4__c  = lockPlan[0].DpRef__c,
				GPChange__c = lockPlan[0].GpRef__c,
				ServiceRate__c = lockPlan[0].ServiceRate__c,
				jmstRef__c = lockPlan[0].JmstRef__c,
				ActionType__c = CommConst.PROD_ACTION_TYPE_PL);
		} else {
			// すでに存在する会計商品（プラン）情報を再取得、確認を行う
			planProductInfo.Name = lockPlan[0].Name;
			planProductInfo.Field5__c = lockPlan[0].Price__c;
			planProductInfo.Field4__c  = lockPlan[0].DpRef__c;
			planProductInfo.GPChange__c = lockPlan[0].GpRef__c;
			planProductInfo.ServiceRate__c = lockPlan[0].ServiceRate__c;
            planProductInfo.jmstRef__c = lockPlan[0].JmstRef__c;
		}
		Database.upsert (planProductInfo, AccountMaster__c.Field3__c);
		// プラン明細を再作成する
		//List<PlanDetail__c> insLst = new List<PlanDetail__c>();
		//List<PlanDetail__c> updLst = new List<PlanDetail__c>();
		List<PlanDetail__c> upsertLst = new List<PlanDetail__c>();
		List<PlanDetail__c> delLst = new List<PlanDetail__c>();
		for (PlanDetail item : planDetailList) {
			// 削除対象場合
			if (item.isDeleteItem) delLst.add(item.sobj);
			// 無効対象場合
			if (!item.isValidata) continue;
			// 更新対象場合
			if (item.isUpdateItem) {
				item.sobj.name = lockPlan[0].Name + '-' + item.rowNo;
				item.sobj.PlanProdcut__c = planProductInfo.Id;
				//updLst.add(item.sobj);
				upsertLst.add(item.sobj);
			}
			// 新規対象場合
			if (item.isInsertItem) {
				item.sobj.PlanProdcut__c = planProductInfo.Id;
				item.sobj.Name = lockPlan[0].Name + '-' + item.rowNo;
				//insLst.add(item.sobj);
				upsertLst.add(item.sobj);
			}
		}

		//if (!insLst.isEmpty()) insert insLst;
		//if (!updLst.isEmpty()) update updLst;
		if (!upsertLst.isEmpty()) database.upsert(upsertLst);
		if (!delLst.isEmpty()) delete delLst;

		// 最新情報を取得する
		queryPlanDetailInfo();

		return null;
	}
	// 会計商品プランの商品コードを取得する
	private String getPlanProdCode(String planCd) {
		return PLAN_PRD_PREX_NUM + planCd;
	}
	/**
	* プラン詳細情報　
	**/
	public class PlanDetail {
		public PlanDetail(PlanDetail__c item, Integer index) {
			sobj = item;
			rowNo = index;
			productNm = item.AccountMasterRef__r.Name;
			//oldProdcutId = sobj.AccountMasterRef__c;
			//oldPrice = sobj.Price__c;
			oldId = sobj.id;
/* 20121005修正を行う（商品単価多目意味機能対応） */
/*
			// 元商品単価（税込） * 現在のサービス料
			amoutIncTax = CommUtils.nullToZero(item.AccountMasterRef__r.Field5__c) +
			              CommUtils.nullToZero(item.AccountMasterRef__r.Field5__c) * (CommUtils.nullToZero(item.ServiceRate__c) / 100);
*/
			CommUtils.ProductInfo priceInfo = new CommUtils.ProductInfo();
			priceInfo.process(CommUtils.nullToZero(item.AccountMasterRef__r.Field5__c), 1, CommUtils.nullToZero(item.TaxRate__c), CommUtils.nullToZero(item.ServiceRate__c));
			amoutIncTax = priceInfo.priceIncTax;
			
			diffPrice = amoutIncTax - CommUtils.nullToZero(item.Price__c);
		}
		// 見積明細
		public PlanDetail__c sobj{get;private set;}
		// 行番号
		public Integer rowNo{get;set;}
		// 商品名
		public String productNm{get;set;}
		// 商品単価
		public Decimal productPrice{get;set;}
		// 元商品単価金額の合計値
		public Decimal amoutIncTax{get; set;}
		// 合計値と入力した金額の差額値
		public Decimal diffPrice{get;set;}
		// 変更前の設定値
		//private Decimal oldPrice;
		//private Id      oldProdcutId;
		private Id      oldId;
		// 明細データ変更あり、なし判断を行う
		/*
		private Boolean isChange() {
			return (oldProdcutId != sobj.AccountMasterRef__c ||
				oldPrice != sobj.Price__c );
		}*/
		// 有効の入力データ
		public Boolean isValidata{get{return (!CommUtils.isBlank(productNm) && sobj.Price__c != null);}}
		// 新規対象[既存ID未設定する場合]
		public Boolean isInsertItem{get{return (oldId == null && isValidata);}}
		// 更新対象[有効データ　&&　oldI 存在　&& ProdcutId変更]
		public Boolean isUpdateItem{get{return (oldId != null && isValidata);}}
		// 削除対象[既存IDあり、無効データに変更する場合]
		public Boolean isDeleteItem{get{return (sobj.id != null && !isValidata);}}
	}

	// 自動チェックテスト
    static testMethod void myCheckinTest() {
    	Test.startTest();
    	// 商品情報を作成する
    	List<AccountMaster__c> productLst = TestCommon.createProductMst(3);
    	// プラン作成
    	Plan__c plan = TestCommon.createPlan();
    	Test.stopTest();

    	ApexPages.StandardController contrl = new ApexPages.StandardController(plan);
 		PlanProductSetup ctrl = new PlanProductSetup(contrl);
		List<PlanDetail> planDeLst = ctrl.planDetailList;

		planDeLst[0].productNm = productLst[0].Name;
		planDeLst[0].sobj.AccountMasterRef__c = productLst[0].Id;
		planDeLst[0].sobj.Price__c = 10000;
		planDeLst[1].productNm = productLst[1].Name;
		planDeLst[1].sobj.AccountMasterRef__c = productLst[1].Id;
		planDeLst[1].sobj.Price__c = 20000;
		planDeLst[2].productNm = productLst[2].Name;
		planDeLst[2].sobj.AccountMasterRef__c = productLst[2].Id;
		planDeLst[3].sobj.Price__c = 30000;

		ctrl.savePlanDetail();
		ctrl.queryPlanDetailInfo();
		Pagereference page = ctrl.gotoBlack();
		System.assert(page != null);
    }
}