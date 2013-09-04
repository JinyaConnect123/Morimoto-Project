/**
 * This class contains unit tests for validating the behavior of Apex classes
 * and triggers.
 *
 * Unit tests are class methods that verify whether a particular piece
 * of code is working properly. Unit test methods take no arguments,
 * commit no data to the database, and are flagged with the testMethod
 * keyword in the method definition.
 *
 * All test methods in an organization are executed whenever Apex code is deployed
 * to a production organization to confirm correctness, ensure code
 * coverage, and prevent regressions. All Apex classes are
 * required to have at least 75% code coverage in order to be deployed
 * to a production organization. In addition, all triggers must have some code coverage.
 *
 * The @isTest class annotation indicates this class only contains test
 * methods. Classes defined with the @isTest annotation do not count against
 * the organization size limit for all Apex scripts.
 *
 * See the Apex Language Reference for more information about Testing and Code Coverage.
 */
@isTest(SeeAllData=false)
private class BillInput_Ctrl_Test {

    static testMethod void LeadToAccountCase() {
    	Test.startTest();
    	// 予約情報を作成する
    	Lead__c leadInfo = TestCommon.createLead();
    	// 商品情報を作成する
    	List<AccountMaster__c> productLst = TestCommon.createProductMst(1);
    	// 見積明細を作成する
    	TestCommon.createBookEstItem(leadInfo, productLst[0]);
    	// 予約情報のステータス：チェックインに変更する
    	leadInfo.Field298__c = 'チェックイン完';
    	update leadInfo;

    	Test.stopTest();

    	// 会計画面に動作確認を行う
    	List<AccountAcount__c> accObjLst = [select id,frs__c,Relreserve__c from AccountAcount__c where Relreserve__c = :leadInfo.Id];
    	AccountAcount__c accObj = accObjLst[0];

    	ApexPages.StandardController contrl = new ApexPages.StandardController(accObj);
    	BillInput_Ctrl ctrl = new BillInput_Ctrl(contrl);
    	ctrl.initAction();
    	ctrl.calPaymentInfo();
    	ctrl.upsertData();
    	System.assert(!Apexpages.hasMessages(Apexpages.Severity.ERROR));
    	ctrl.voidProcess();
    	ctrl.voidProcessCancel();

    	Apexpages.currentPage().getParameters().put('retUrl','TestPage');
    	ctrl.gotoCancel();
    	Pagereference pg = ctrl.gotoAccountsDetailPg();
    	System.assertNotEquals(pg, null);

        // Report Logo作成
        TestCommon.createRepLogo();

    	// PDF起動する
    	ApexPages.StandardController contr2 = new ApexPages.StandardController(accObj);
    	AccountPDF pdf = new AccountPDF(contr2);
    	pdf.getTran();
    	pdf.getCustomer();
    	pdf.getAccountNo();
    	pdf.getCharge();
    	pdf.getDate();
    	pdf.getTax();
    	pdf.getReportLogo();
//    	pdf.getAccoutInfo();

    	BillPDF bPdf = new BillPDF(contr2);
        bPdf.getTran();
        bPdf.getCustomer();
        bPdf.getAccountNo();
        bPdf.getCharge();
        bPdf.getDate();
        bPdf.getTax();
        bPdf.getReportLogo();
//        bPdf.getAccoutInfo();

        // 見積書

        ApexPages.StandardController contr3 = new ApexPages.StandardController(leadInfo);
        LeadPDF lPdf = new LeadPDF(contr3);
        System.assertNotEquals(lPdf.sumInfo, null);
        lPdf.getDetaiLst();
        lPdf.getReportLogo();
        lPdf.getLead();
    }

    static testMethod void productSearchCase() {
    	List<AccountMaster__c> prodList = TestCommon.createProductMst(5);
    	ProductSearch_Ctrl ctrl = new ProductSearch_Ctrl();
    	ctrl.init();
    	ctrl.c_productNm = prodList[0].Name;
    	ctrl.c_dpId = '1111';
    	ctrl.c_gpId = '2222';
    	//ctrl.c_opId = '3333';
    	ctrl.queryInfo();

    	ctrl.insertInit();
    	ctrl.newAccMst.name = 'テスト商品';
    	ctrl.newAccMst.Field5__c = 2000;
    	ctrl.newAccMst.jmstRef__c = TestCommon.createTaxMst().Id;
    	ctrl.insertData();
    	ctrl.cancelAct();

    	System.assert(!Apexpages.hasMessages(Apexpages.Severity.ERROR));
    }


}