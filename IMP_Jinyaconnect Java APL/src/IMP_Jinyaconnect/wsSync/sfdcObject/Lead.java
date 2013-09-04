package IMP_Jinyaconnect.wsSync.sfdcObject;

import java.util.List;
import java.util.Map;

import IMP_Jinyaconnect.JinyaException;
import IMP_Jinyaconnect.dao.RakujanSoqlDao;
import IMP_Jinyaconnect.utils.RakujanSimpleSOQL;

import com.sforce.soap.partner.SoapBindingStub;

public class Lead {
//	private static final String __LEAD_OBJECT__ = "Lead__c";
	private static final String __LEAD_INDEX_OBJECT__ = "LeadIndex__c";
	private static final String __LEAD_INDEX_ID__ = "ID__c";
	
	private SoapBindingStub stub = null;
	
	public Lead(SoapBindingStub stub) {
		this.stub = stub;
	}
	
	public String getLeadId(String dataId) throws JinyaException {
		String soql = getSQLLeadIndexIdFromDataId(dataId);
		
		String leadIndexId = getObjectByName(soql, __LEAD_INDEX_ID__);
		
		return leadIndexId;
	}
	
	/*
	 * 予約Idを取得するSQL文を返す
	 * @param name 部屋名
	 * @return 検索SQL
	 */
	private String getSQLLeadIndexIdFromDataId(String dataId) {
		String _soql_ = "select Id__c From {0} Where Id__c = '{1}'";
		
		String soql = RakujanSimpleSOQL.getSOQL(_soql_, 
				new String[] {__LEAD_INDEX_OBJECT__, dataId});
		
		return soql;
	}
	
	/*
	 * SOQL発行より、SOQL対象オブジェクトIDを返す
	 * 
	 * @param soql 
	 * 
	 * @return オブジェクトのId
	 */
	private String getObjectByName(String soql, String name) {
		List<Map<String, Object>> listObjMap0 = null;
		listObjMap0 = RakujanSoqlDao.getQueryListMap(this.stub, soql);
		
		String id = null;
		
		if (listObjMap0 != null && listObjMap0.size() > 0) {
			id = (String)listObjMap0.get(0).get(name);
		}
		
		return id;
	}
}
