/*
 * 機能名     : 予約機能の見積書PDF
 * ファイル名 : LeadPDF.cls
 *
 *  VERSION    DATE        BY          CHANGE/COMMENT
 * ----------------------------------------------------------------
 *  1.00       2012/07/06  WSQ         Create
 */
public with sharing class LeadPDF {

    private Lead__c lead;
    private List<BookItem> bookItemLst;
    private final Integer MAX_SHOW_DETAIL_ROWS = 27;

    public LeadPDF(ApexPages.StandardController controller){
        //query '予約' current page
        lead = [select id, Name, No__c, Relcontact__r.name, EntryTime__c, ReservedDate__c from Lead__c where id = :controller.getId()][0];
        // 到着日の当日の消費税率を取得する
        Decimal taxRate = CommUtils.nullToZero(CommUtils.getTaxRate(lead.EntryTime__c.date()));
        //query '見積明細' current page
        bookItemLst = new List<BookItem>();
        sumInfo = new TotalInfo(taxRate);
        // 金額計算共通クラス
        CommUtils.ProductInfo proc = new CommUtils.ProductInfo();
        for(BookingEstimateItem__c s: [select id, name, X2_1__c, Tankanonetax__c, Amount__c,TaxRate__c,
        				Total__c, ServiceRate__c, SpecialTax__c,GoukeinoneTax__c,UnitPrice__c
        				from BookingEstimateItem__c
                        where refBooking__c = :controller.getId() and Accountoutside__c = 1]) {
            // 単価（サービス料込、税込）計算を行う
            proc.process(s.UnitPrice__c, 1, s.TaxRate__c, s.ServiceRate__c);
            s.UnitPrice__c = proc.unitPriceTax;

            BookItem newItem = new BookItem(s, bookItemLst.size());
            bookItemLst.add(newItem);
            sumInfo.add(newItem);
        }
        // 宿泊税が存在する場合
        if (sumInfo.amoutSpecialIncTax > 0) {
        	BookingEstimateItem__c item = new BookingEstimateItem__c(
        	   X2_1__c = '宿泊税',
        	   Amount__c = 1,
        	   UnitPrice__c = sumInfo.amoutSpecialIncTax
        	);
        	bookItemLst.add(new BookItem(item, bookItemLst.size()));
        }
        integer len = MAX_SHOW_DETAIL_ROWS - bookItemLst.size();
        for (integer i=0; i < len; i++) {
            bookItemLst.add(new BookItem(new BookingEstimateItem__c(), bookItemLst.size()));
        }
    }

    public ReportLogo__c getReportLogo() {
    	return CommRepUtils.getReplogoInfoByTypeId(CommRepUtils.REP_TYPE.LOGO_00_SYSDEF);
    }

    //get Account#
    public Lead__c getLead(){
        return lead;
    }

    //get 'お客様'
    public string getCustomer(){
        if(lead.Relcontact__c!=null){
            return lead.Relcontact__r.name;
        }else{
            return '　　　　　　　　　　';
        }
    }

    /**
    * 統計情報情報を維持する
    **/
    public TotalInfo sumInfo{get;private set;}
    public class TotalInfo {
    	public TotalInfo(Decimal p_taxRate) {
    		amoutPriceIncTax = 0;
    		//amoutPriceExcTax = 0;
    		//amoutServiceIncTax = 0;
    		amoutSpecialIncTax = 0;
    		amoutPriceForTax = 0;
    		taxRate = p_taxRate / 100;
    	}
    	// 消費税率
    	private Decimal taxRate;
    	// 送金額（税込：消費税計算対象金額）
    	private Decimal amoutPriceForTax;
    	// 総金額（税込）
    	public Decimal amoutPriceIncTax{get;set;}
    	// 総金額（税抜）
    	//public Decimal amoutPriceExcTax{get;set;}
    	// サービス料（税込）
    	//public Decimal amoutServiceIncTax{get;set;}
    	// 特別税（宿泊税）
    	public Decimal amoutSpecialIncTax{get;set;}
    	// 消費税:総金額（税込）-特別税 /
    	public Decimal amoutTax{get{
    		// 消費税率を取得する
    		//return (amoutPriceIncTax - amoutPriceExcTax - amoutServiceIncTax - amoutSpecialIncTax);
    		//System.debug('amoutPriceForTax:' + amoutPriceForTax);
    		//System.debug('taxRate:' + taxRate);
    		return CommUtils.RoundProcess(amoutPriceForTax / (1 + taxRate) * taxRate, 0);
    	}}
    	public void add(BookItem item) {
    		//　合計金額（税込）
    		amoutPriceIncTax += CommUtils.nullToZero(item.sobj.Total__c);
    		//　合計金額（税抜）
    		//amoutPriceExcTax += CommUtils.nullToZero(item.sobj.GoukeinoneTax__c);
    		// サビース料金（税込） = $合計金額(税込) - 宿泊税 *
    		//amoutServiceIncTax += CommUtils.RoundProcess(
    		//	(CommUtils.nullToZero(item.sobj.Total__c) - CommUtils.nullToZero(item.sobj.SpecialTax__c)) * CommUtils.nullToZero(item.sobj.ServiceRate__c) / 100, 0);
    		// 宿泊税
    		amoutSpecialIncTax += CommUtils.nullToZero(item.sobj.SpecialTax__c);
    		// 消費税計算用金額合計 = 合計金額（税込） - 宿泊税
    		if (CommUtils.nullToZero(item.sobj.TaxRate__c) > 0) {
                // 消費税計算用金額の合計:金額-特別税
                amoutPriceForTax += CommUtils.nullToZero(item.sobj.Total__c) - CommUtils.nullToZero(item.sobj.SpecialTax__c);
    		}
    	}
    }

    //get '会計明細'
    public List<BookItem> getDetaiLst(){
        return bookItemLst;
    }

    public class BookItem {
    	public BookItem(BookingEstimateItem__c s, Integer no ) {
    		sobj = s;
    		rowNo = no+1;
    	}
    	public BookingEstimateItem__c sobj{get; private set;}
    	public Integer rowNo{get; private set;}

    }
}