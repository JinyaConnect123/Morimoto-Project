/*
* 一括処理ロイック
* autoCheckInProcess : 自動チェックイン機能
* autoCalDayAmount : 指定日の会計情報を統計する
*/
public with sharing class BulkProcessBatch {

	public BulkProcessBatch() {
		checkInDate = System.now().Format('yyyy/MM/dd');
		amoutDate = checkInDate;
		message = '';
	}
    /**
    * 2012/10/30 全データ処理MODE変数設定を行う
    */
    // 全データ処理を行う[支払方法は複数存在する会計データに対して、処理対象外]
    private Boolean isAllFlg = false;
    // 売上自動計算を続いて処理を行うフラグ
    public Boolean isContinueFlg {get; private set;}
    public void setInitVar() {
    	isAllFlg = true;
    	isContinueFlg = false;
    }
    // システム時間を取得する
    public String getApexSystemTime() {
        return String.valueof(DateTime.now().getTime());
    }
    // 画面表示用メッセージ
    public String message{get;private set;}
    private void clearInfo() {
    	isContinueFlg = false;
    	message = '';
    }
    public void addInfMessage(String msg) {
        message += '<br></br><span style="           font-weight: bold">バッチ処理[INF]</span>: ' + msg;
    }
    public void addErrMessage(String msg) {
        message += '<br></br><span style="color: red;font-weight: bold">バッチ処理[ERR]</span>: ' + msg;
    }
    public Boolean isShowMessage{get{return !CommUtils.isBlank(message);}}
	/**
	* 2012/08/14 WSQ ADD BEGIN
	* 指定日の予約情報を自動チェックインを行う　
	**/
	// 8桁日付入力項目
	public String checkInDate{get; set;}
	public Boolean isShowCheckinMsg{get;set;}
	// 自動チェックイン処理日
	public void autoCheckInProcess() {
        // 処理日
		Date checkinDt = null;
		// 処理メッセージ
		message = '';
		try {
			checkinDt = Date.parse(checkInDate);
		} catch (Exception e) {
			//throw new CommException('有効な処理日を入力ください。');
			//ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.ERROR, '有効な処理日を入力ください.'));
			addErrMessage('有効な処理日を入力ください.');
			return;
		}

		// 表示フラグクリアする
		this.clearMsgFlg();
		isShowCheckinMsg = true;

		// 自動チェックインリスト
		List<Lead__c> upLst = new List<Lead__c>();
		// 全データは処理対象モード場合
		if (isAllFlg) {
			// 宴会のレコードタイプ
			Id enkaiRecTypeId = CommLogicProcess.getLeadEnkaiRecType();
			
            for (Lead__c leadItem: [select Id, Field298__c from Lead__c
                where CancelBool__c != :CommConst.LEAD_ST_CANCEL_FLG And DAY_ONLY(convertTimezone(EntryTime__c)) = :checkinDt
                //And (LeadIndexRef__r.Nights__c > 1 Or LeadIndexRef__r.Rooms__c > 1 ) And RecordTypeId = :bookingRecTypeId
                //And CancelBool__c != :CommConst.LEAD_ST_CANCEL_FLG
                // 2013/02/11 宴会場は自動チェックイン処理を行わない
                And RecordTypeId != :enkaiRecTypeId
                And Field298__c != :CommConst.LEAD_GUEST_ST_CI And Field298__c != :CommConst.LEAD_GUEST_ST_CO]) {
                // チェックイン完了
                leadItem.Field298__c = CommConst.LEAD_GUEST_ST_CI;
                upLst.add(leadItem);
            }
		} else {
			// 宿泊のレコードタイプ
			Id bookingRecTypeId = CommLogicProcess.getLeadBookingRecType();
			// 宴会のレコードタイプ
			Id enkaiRecTypeId = CommLogicProcess.getLeadEnkaiRecType();

			// 前日の予約チェックイン情報を取得する[宴会データ]
			// 2012/10/10 取り消しデータは対象外にする
			// 2013/02/11 宴会場は自動チェックイン処理を行わない
			/*
			for (Lead__c leadItem: [select Id, Field298__c from Lead__c
				where CancelBool__c != :CommConst.LEAD_ST_CANCEL_FLG And DAY_ONLY(convertTimezone(EntryTime__c)) = :checkinDt
				And RecordTypeId = :enkaiRecTypeId
				//And CancelBool__c != :CommConst.LEAD_ST_CANCEL_FLG
				And Field298__c != :CommConst.LEAD_GUEST_ST_CI And Field298__c != :CommConst.LEAD_GUEST_ST_CO]) {
				// チェックイン完了
				leadItem.Field298__c = CommConst.LEAD_GUEST_ST_CI;
				upLst.add(leadItem);
			}*/
			// チェックイン対象外 AND お客様ステータス != 'チェックイン完' AND お客様ステータス != 'チェックアウト完'
			// 連泊する場合　OR　複数部屋の予約データ
			for (Lead__c leadItem: [select Id, Field298__c from Lead__c
				where CancelBool__c != :CommConst.LEAD_ST_CANCEL_FLG And DAY_ONLY(convertTimezone(EntryTime__c)) = :checkinDt
				And (LeadIndexRef__r.Nights__c > 1 Or LeadIndexRef__r.Rooms__c > 1 ) And RecordTypeId = :bookingRecTypeId
				//And CancelBool__c != :CommConst.LEAD_ST_CANCEL_FLG
				And Field298__c != :CommConst.LEAD_GUEST_ST_CI And Field298__c != :CommConst.LEAD_GUEST_ST_CO]) {
				// チェックイン完了
				leadItem.Field298__c = CommConst.LEAD_GUEST_ST_CI;
				upLst.add(leadItem);
			}

		}
		// １件単位でデータコミットを行う
		Database.Saveresult[] rsLst = Database.update(upLst, false);
		Integer successRsCnt = 0;
		Integer failureRsCnt = 0;
		for (Database.Saveresult rs: rsLst) {
			// データ処理結果
			if (!rs.isSuccess()) {
				failureRsCnt ++;
				Database.Error err = rs.getErrors()[0];
				//ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.ERROR, err.getMessage()));
				addErrMessage(err.getMessage());
			} else {
				successRsCnt ++;
			}
		}
		//if (!rsLst.isEmpty()) {
		//ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.INFO,
		//	'一括チェックイン処理：成功件数：' + String.valueOf(successRsCnt) + '(件)  ' + '失敗件数：' + String.valueOf(failureRsCnt) + '(件)  '));
		//ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.INFO, 'チェックイン処理済。'));
		addInfMessage('チェックイン処理済。');
		//}
		// 当日の売上自動計算を行う
		this.amoutDate = this.checkInDate;
		// 全処理以外モード場合、売上連結計算を行う
		if (!isAllFlg) {
		this.autoCalDayAmount();
		} else {
			isContinueFlg = true;
		}
	}
	// 2012/08/14 WSQ ADD END
	/**
	* 2012/08/23 WSQ ADD BEGIN
	* 指定日の会計情報を自動合計計算を行う　
	**/
	// 会計日格納 8桁日付入力項目(YYYY/MM/DD)
	public String amoutDate{get;set;}
//	public Boolean isShowCalDayAmoutMsg{get;set;}

	private void clearMsgFlg() {
//		isShowCalDayAmoutMsg = false;
		isShowCheckinMsg = false;
//		calDayAmoutErrMsg = null;
//		calDayAmoutInfMsg = null;
	}
	// 売上計算メッセージ設定
//	public String calDayAmoutErrMsg{get; set;}
//	public String calDayAmoutInfMsg{get; set;}
	public void autoCalDayAmount() {
		// 売上続いて処理フラグはFalseに戻る
		isContinueFlg = false;
		// 指定日の会計情報自動合計を行う
		Date amoutDt = null;
//		try {
			amoutDt = Date.parse(amoutDate);
//		} catch (Exception e) {
			//throw new CommException('有効な処理日を入力ください。');
			//ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.ERROR, '有効な処理日を入力ください.'));
//			calDayAmoutErrMsg = '有効な処理日を入力ください.';
//			return;
//		}
		// 表示フラグクリアする
//		this.clearMsgFlg();
//		isShowCalDayAmoutMsg = true;

        // 該当日の売上存在がどうかチェックを行う
        String whereDate = amoutDate.replaceAll('/','');
        Id rsvAccId = null;
        List<RsvAccount__c> existRsvAccLst = [select id from RsvAccount__c where name = :whereDate limit 1 for update];
		// 同じ日付の会計情報を一括取得して、取得する会計情報は処理を行う
        if (existRsvAccLst.isEmpty()) {
            //throw new CommException('該当売上日のデータが存在しません。');
            //ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.WARNING, '売上日('+amoutDate+')データがありません。'));
            addErrMessage('売上日('+amoutDate+')データがありません。');
            //calDayAmoutErrMsg = '指定日の売上データが見つかりませんため、更新できせん。';
            return;
        }
        rsvAccId = existRsvAccLst[0].Id;
//System.debug('rsvAccId::::::::' + rsvAccId);
        // 売上日の会計金額を計算を行う[5万件まで検索できるため:->BatchApexで処理を行う
        // 一括やります「会計支払データは複数存在の会計情報の再計算は要らないです→既に画面に会計済みのものです」
        // MAP<会計ID、会計支払>
        Map<Id, TTend__c> ttendMap = new Map<Id, TTend__c>();
        // 複数会計支払存在すると、会計対象外(理由：複数存在すると、既に画面から会計済みのものです)
        Map<Id, Integer> ttendRsCntMap = new Map<Id, Integer>();
        for(TTend__c item: [select Field19__c, Field20__c, Field21__c,Field1__c from TTend__c where RelAccount__c = :rsvAccId And Field1__c != null]) {
        	if (ttendRsCntMap.containsKey(item.Field1__c)) ttendRsCntMap.put(item.Field1__c, ttendRsCntMap.get(item.Field1__c) + 1);
        	else ttendRsCntMap.put(item.Field1__c, 1);
        	// 複数存在する場合、処理対象外
        	if (ttendRsCntMap.get(item.Field1__c) > 1) ttendMap.remove(item.Field1__c);
        	else ttendMap.put(item.Field1__c, item);
        }
//System.debug('ttendRsCntMap;;;;' + ttendRsCntMap);
        // 会計情報を取得する
        Map<Id, AccountAcount__c> accAcountMap = new Map<Id, AccountAcount__c>();
        for(AccountAcount__c item: [
			Select relaccount__c, frs__c, comment__c, TeaTimeFlag__c, Target__c, TableNo__c, Seq__c, Relreserve__c,
			      PlanNo__c, POSNo__c, OutSideAccount__c, Field99__c, Field98__c, Field97__c, Field96__c, Field95__c,
			      Field94__c, Field93__c, Field92__c, Field91__c, Field90__c, Field89__c, Field88__c, Field87__c,
			      Field86__c, Field85__c, Field84__c, Field83__c, Field82__c, Field81__c, Field80__c, Field7__c,
			      Field79__c, Field78__c, Field77__c, Field76__c, Field75__c, Field74__c, Field73__c, Field72__c,
			      Field71__c, Field70__c, Field69__c, Field68__c, Field67__c, Field66__c, Field65__c, Field64__c,
			      Field63__c, Field62__c, Field61__c, Field60__c, Field59__c, Field58__c, Field57__c, Field56__c,
			      Field55__c, Field54__c, Field53__c, Field52__c, Field51__c, Field50__c, Field49__c, Field48__c,
			      Field45__c, Field44__c, Field43__c, Field42__c, Field40__c, Field39__c, Field159__c, Field158__c,
			      Field157__c, Field156__c, Field155__c, Field154__c, Field152__c, Field151__c, Field150__c,
			      Field149__c, Field148__c, Field147__c, Field146__c, Field145__c, Field143__c, Field142__c,
			      Field141__c, Field140__c, Field139__c, Field138__c, Field137__c, Field136__c, Field135__c,
			      Field134__c, Field133__c, Field132__c, Field131__c, Field130__c, Field129__c, Field128__c,
			      Field127__c, Field126__c, Field125__c, Field124__c, Field123__c, Field122__c, Field121__c,
			      Field120__c, Field119__c, Field118__c, Field117__c, Field116__c, Field115__c, Field114__c,
			      Field113__c, Field112__c, Field111__c, Field110__c, Field109__c, Field108__c, Field107__c,
			      Field106__c, Field105__c, Field104__c, Field103__c, Field102__c, Field101__c, Field100__c,
			      DivisionName__c, SystemModstamp, Name, SumSrvPriceIncTax__c, SumSrvPriceExcTax__c,AmoutSpecialPrice__c,
			      LastModifiedDate, LastModifiedById, LastActivityDate, IsDeleted, Id, CreatedDate, CreatedById,
			      Relreserve__r.StayPersons__c,Relreserve__r.Rroom__r.Name,Relreserve__r.Rroom__c
			from AccountAcount__c where frs__c = :rsvAccId ]) {
        	accAcountMap.put(item.Id, item);
        }

        // 会計明細情報を取得する
        Map<Id, List<Tran1__c>> tranMap = new Map<Id, List<Tran1__c>>();
        // 詳細仕様： 請求書非表示(InvoiceNoShowFlg__c)の場合、統計対象外になる
        //          単価(Field20__c)
        //          数量(Field40__c/Field21__c)
        //          消費税(TaxRate__c)
        //          サービス料(ServiceRate__c) xx%方式
        //          特別税(SpecialTax__c)
        //  Where   商品処理種別　!= 前受け金 AND
        //  下記処理詳細：　処理対象の会計明細を取得して、
        //  取得する会計明細の会計支払データ件数は1件以上が存在する場合、処理対象外→既に処理済みの会計情報
        //  会計情報単位で、会計明細Groupする
        for (Tran1__c item : [select Id, Field1__c, ActionType__c, InvoiceNoShowFlg__c, Field20__c, Field21__c, Field40__c, TaxRate__c, ServiceRate__c, SpecialTax__c from Tran1__c
            where RelAccount__c = :rsvAccId And Field1__c != null And InvoiceNoShowFlg__c != true And ActionType__c != :CommConst.PROD_ACTION_TYPE_AR
            Order By Field1__c]) {
            // 存在している会計支払データは2件以上（2件含め）場合、再計算を行わない
            if (ttendRsCntMap.containsKey(item.Field1__c) && ttendRsCntMap.get(item.Field1__c) > 1) continue;
        	// 会計単位で、金額計算を行う
        	// 会計情報は既に設定されている場合
        	if (tranMap.containsKey(item.Field1__c)) tranMap.get(item.Field1__c).add(item);
        	else {
        		List<Tran1__c> tranLst = new List<Tran1__c>();
        		tranLst.add(item);
        		tranMap.put(item.Field1__c, tranLst);
        	}
        }
        // 金額計算を行う:計算方法は会計編集画面：必ず同じルールで計算ください、修正する場合、必ず両方連動ください:
        // TODO:税抜の計算方法は：　商品　＊　数量総税込から　税抜を計算する、元システムに（数式）、先に商品の税込金額を計算後、この金額と数量で税抜く金額を計算する

        List<TTend__c> insTTend = new List<TTend__c>();
        List<TTend__c> updTTend = new List<TTend__c>();
        List<AccountAcount__c> updAccAcount = new List<AccountAcount__c>();
        // 上記に関して、調整、統一が必要ですね
        for (Id acountId: tranMap.keyset()) {
        	// 1日１会計情報の会計総額金額計算

        	// 売上計4（税込）金額
            Decimal totalAmoutIncTax = 0;
        	// 売上計3（税抜）金額
        	Decimal totalAmoutExcTax = 0;
        	// サービス料金(税込)
        	Decimal totalAmoutSrvIncTax = 0;
        	// サービス料金(税抜)
        	Decimal totalAmoutSrvExcTax = 0;
        	// 宿泊税
        	Decimal totalAmoutSPTax = 0;
        	// 金額計算共通
        	CommUtils.ProductInfo priceInfo = new CommUtils.ProductInfo();
        	// １会計:1会計支払：N会計明細
        	for (Tran1__c tranItem: tranMap.get(acountId)) {
        		// 金額計算を行う
	            // 単価と数量はNULLの場合、
	            Decimal unitPrice = CommUtils.nullToZero(tranItem.Field20__c);  // <-税金含め単価です
	            Decimal qty = CommUtils.nullToZero(tranItem.Field21__c);
/* 20121005修正を行う（商品単価多目意味機能対応） */
/*
	            // 合計金額(税込)
	            Decimal amoutIncTax = CommUtils.RoundProcess((unitPrice * qty), 0);
	            // 合計金額(税抜)※※※※（１円未満切り上げ）※※※※
	            Decimal amoutExcTax = CommUtils.CalExcTaxPrice(amoutIncTax, tranItem.TaxRate__c, 0, RoundingMode.CEILING);
	            // サービス料金（税込）
	            Decimal servicePriceIncTax = CommUtils.RoundProcess(amoutIncTax * (CommUtils.nullToZero(tranItem.ServiceRate__c) / 100), 0);
	            // 税込合計金額再計算を行う（商品合計金額＋サービス料金（税込）+特別税）
	            totalAmoutIncTax += amoutIncTax + servicePriceIncTax + tranItem.SpecialTax__c;*/
				// 金額計算を行う
				priceInfo.process(unitPrice , qty, tranItem.TaxRate__c, tranItem.ServiceRate__c);
	            // 合計金額(税抜)※※※※（１円未満切り上げ）※※※※
	            Decimal amoutExcTax = priceInfo.priceExcTax;
	            // サービス料金（税込）
	            Decimal servicePriceIncTax = priceInfo.priceService;
	            // 2012/10/30 宿泊税の処理追加を行う
	            /* 封印する
	            // 合計金額（税込:サービス込）
	            totalAmoutIncTax += priceInfo.priceIncTax;
	            // TODO:見積明細データは：直接DataloaderからIMP　OR　見積明細標準画面直接登録する場合、特別税の自動計算を行わない
	            // 設定されている商品は室料場合、宿泊税計算を行う
	            if (tranItem.ActionType__c == CommConst.PROD_ACTION_TYPE_RP) {
	                // 単価価額(税抜) + サビース料金(税抜)で計算結果を取得する[数量固定１で計算を行う]
	                Decimal roomPrice = priceInfo.unitPriceExcTax + priceInfo.unitPriceExcService;
	                // 特別税計算を行う
	                if (tranItem.SpecialTax__c == null) tranItem.SpecialTax__c = priceInfo.specialTaxCal(roomPrice) * qty;
	            }*/
	            // 合計金額(税込)[合計金額（税込:サービス込）＋特別税]
	            totalAmoutIncTax += priceInfo.priceIncTax + CommUtils.nullToZero(tranItem.SpecialTax__c);
	            // ----------- 会計へ設定用情報 ----------

	            // サービス料金(税込)
	            totalAmoutSrvIncTax += servicePriceIncTax;
	            // サービス料金(税抜)
	            totalAmoutSrvExcTax += CommUtils.CalExcTaxPrice(servicePriceIncTax, tranItem.TaxRate__c, 0);
	            // 宿泊税[TODO]自動計算する場合、宿泊税の設定が必要
	            totalAmoutSPTax += CommUtils.nullToZero(tranItem.SpecialTax__c);
                // 商品販売金額（税抜き）
                totalAmoutExcTax += amoutExcTax + totalAmoutSrvExcTax;

        	} // End For
        	// 会計支払へ該当統計金額を計算を行う
        	TTend__c ttendSobj = ttendMap.get(acountId);
        	// 該当会計関連の開始払い存在チェック
        	if (ttendSobj != null){
                    // *********** 合計金額 **********
                    // 預かり　金額
                    ttendSobj.Field19__c = String.valueOf(totalAmoutIncTax);
                    // 支払　金額
                    ttendSobj.Field20__c = String.valueOf(totalAmoutIncTax);
                    // 更新リスト設定
                    updTTend.add(ttendSobj);
        	} else {
        		// 新規作成
        		insTTend.add(new TTend__c(
                    // *********** 初期値設定 **********
                    Field4__c = '1',
                    Field5__c = '1',
                    POSNo__c = CommUtils.getPosNoByComdefine(),
                    // 支払方法は現金で設定行う
                    Field2__c = CommConst.MEDIA_TYPE_CD_01,
                    Field3__c = CommConst.MEDIA_TYPE_01,
                    // *********** 合計金額 **********
                    // 預かり　金額
                    Field19__c = String.valueOf(totalAmoutIncTax),
                    // 支払　金額
                    Field20__c = String.valueOf(totalAmoutIncTax),
                    // *********** 参照関係設定 **********
                    // 売上情報
                    RelAccount__c = rsvAccId,
                    // 会計情報
                    Field1__c = acountId
        		));
        	}

        	// 会計情報へ設定を行う
        	AccountAcount__c oAcountSobj = accAcountMap.get(acountId);
        	// TODO $会計日付/$会計日時　設定必要
			// TODO：営業日付 ←　チェックイン日付で設定を行う　
			oAcountSobj.Field141__c = CommUtils.getBusinessDay();
			// 会計日時: TODO->原システム確認要
			oAcountSobj.Field53__c = DateTime.valueOf(String.valueOf(System.now())).format('yyyyMMddHHmmss');
			// 会計人数
			oAcountSobj.Field57__c = String.valueOf(
										CommUtils.nullToZero(oAcountSobj.Field66__c) +
										CommUtils.nullToZero(oAcountSobj.Field67__c) +
										CommUtils.nullToZero(oAcountSobj.Field68__c));
	        // 売上計4（税込）金額:Field116__c  ->値引き存在と関係なし、実際の商品の売上を合計で設定する
	        oAcountSobj.Field116__c = String.valueOf(totalAmoutIncTax);
	        // 売上計3（税抜）金額:Field114__c[商品販売の金額税抜き＋サービス料金税抜き] // TODO:該当内容はBillInput__Ctrl差異あり
	        oAcountSobj.Field114__c = String.valueOf(totalAmoutExcTax);
	        // サービス料金(税込)
	        oAcountSobj.SumSrvPriceIncTax__c = totalAmoutSrvIncTax;
	        // サービス料金(税抜)
	        //oAcountSobj.SumSrvPriceExcTax__c = pTranFooter.amoutServicePrice;
	        // 宿泊税
	        oAcountSobj.AmoutSpecialPrice__c = totalAmoutSPTax;
	        // 割引金額（税込）
	        oAcountSobj.Discount__c =
	           (ttendSobj.Field2__c == CommConst.MEDIA_TYPE_CD_12 ? totalAmoutIncTax : 0);
	        updAccAcount.add(oAcountSobj);
        } // End For
        try {
        if (!insTTend.isEmpty()) insert insTTend;
        if (!updTTend.isEmpty()) update updTTend;
        if (!updAccAcount.isEmpty()) update updAccAcount;
        } catch (Exception e) {
        	addErrMessage(e.getMessage());
        	return;
        }
        /**
        // 会計テーブル情報を更新を行う
        // 売上計4（税込）金額:Field116__c  ->値引き存在と関係なし、実際の商品の売上を合計で設定する
        oAcountSobj.Field116__c = String.valueOf(pTranFooter.amoutPriceIncTax);
        // 売上計3（税抜）金額:Field114__c
        oAcountSobj.Field114__c = String.valueOf(pTranFooter.amoutPriceExcTax);
        // サービス料金(税込)
        oAcountSobj.SumSrvPriceIncTax__c = pTranFooter.amoutServicePriceIncTax;
        // サービス料金(税抜)
        oAcountSobj.SumSrvPriceExcTax__c = pTranFooter.amoutServicePrice;
        // 宿泊税
        oAcountSobj.AmoutSpecialPrice__c = pTranFooter.amoutSpecialTax;
        // 割引金額（税込）
        oAcountSobj.Discount__c = pTttendFooter.amoutDiscountPrice;
        **/
		//ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.INFO,
		//	'売上会計件数：' + String.valueOf(updAccAcount.size()) + '(件)  '));
		//calDayAmoutInfMsg = '処理会計件数：' + String.valueOf(updAccAcount.size()) + '(件)  ';
        //ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.INFO, '売上計算処理済。　　'));
        addInfMessage('売上計算処理済。');
	}
	// 2012/09/12 UpdateforSalesforcas処理追加
	public void UpdateforSalesforcast() {
		//documentExt doc = new documentExt();
		//doc.UpdateforSalesforcast();
		// 処理メッセージを初期化する
        message = '';
		// 売り上げ３が月分データを自動作成する
		// 当日から３ヶ月売上初期データを自動作成する
		DateTime cDate = DateTime.newInstance(Date.today(), Time.newInstance(0, 0, 0, 0));
		DateTime eDate = cDate.addDays(90);
		DateTime indexDate = cDate;
		Set<String> dateSet = new Set<String>();
		do {
			dateSet.add(indexDate.format('yyyyMMdd'));
			indexDate = indexDate.addDays(1);

		} while(indexDate < eDate);
		List<RsvAccount__c> rsvLst = [select id,name from RsvAccount__c where name in :dateSet];
		for (RsvAccount__c rsv: rsvLst) {
			// 既に存在データ、　SKIPする
			if (dateSet.contains(rsv.name)) dateSet.remove(rsv.name);
		}
		list<RsvAccount__c> insLst = new List<RsvAccount__c>();
		for (String strDate : dateSet) {
			RsvAccount__c newItem = new RsvAccount__c(name = strDate);
			insLst.add(newItem);
		}
		if (!insLst.isEmpty()) DataBase.upsert(insLst, RsvAccount__c.Name);
	}

	// 自動チェックテスト
    static testMethod void myCheckinTest() {
    	Test.startTest();
    	// 予約情報を作成する
    	Lead__c leadInfo = TestCommon.createLead();
    	// 商品情報を作成する
    	List<AccountMaster__c> productLst = TestCommon.createProductMst(1);
    	// 見積明細を作成する
    	TestCommon.createBookEstItem(leadInfo, productLst[0]);
    	Test.stopTest();

    	//
    	BulkProcessBatch batch = new BulkProcessBatch();
    	batch.checkInDate = leadInfo.EntryTime__c.format('yyyy/MM/dd');
    	batch.autoCheckInProcess();
        System.assert(batch.isShowCheckinMsg);
    }
    // 指定日会計を行う
    static testMethod void myCalDayAmountTest() {
    	Test.startTest();
    	// 予約情報を作成する
    	Lead__c leadInfo = TestCommon.createLead();
    	// 商品情報を作成する
    	List<AccountMaster__c> productLst = TestCommon.createProductMst(1);
    	// 見積明細を作成する
    	TestCommon.createBookEstItem(leadInfo, productLst[0]);
    	Test.stopTest();
System.debug('leadInfo:' + leadInfo);
    	//
    	BulkProcessBatch batch = new BulkProcessBatch();
    	batch.checkInDate = leadInfo.EntryTime__c.format('yyyy/MM/dd');
    	batch.autoCheckInProcess();

    	batch.checkInDate = leadInfo.EntryTime__c.addDays(-1).format('yyyy/MM/dd');
    	batch.autoCheckInProcess();
        System.assert(batch.isShowCheckinMsg);
    	batch.amoutDate = batch.checkInDate;
    	batch.autoCalDayAmount();
    	//System.assert(batch.isShowCalDayAmoutMsg);
		//
		batch.UpdateforSalesforcast();
    }
}