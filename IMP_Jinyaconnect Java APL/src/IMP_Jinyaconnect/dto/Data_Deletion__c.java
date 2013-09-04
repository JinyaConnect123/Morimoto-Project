package IMP_Jinyaconnect.dto;

import com.sforce.soap.partner.sobject.SObject;

public class Data_Deletion__c extends SObject {

	private String Record_Name__c;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRecord_Name__c() {
		return Record_Name__c;
	}

	public void setRecord_Name__c(String Record_Name__c) {
		this.Record_Name__c = Record_Name__c;
	}
}
