package IMP_Jinyaconnect.dto.ph3.sub;

public class TransactionType {
	private String dataFrom;
	private String dataClassification;
	private String dataID;
	private String systemDate;
	private String systemTime;
	
	public String toString() {
		final String lv = "\n\t";
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\tDataFrom = " + dataFrom);
		r.append(lv);
		r.append("\tDataClassification = " + dataClassification);
		r.append(lv);
		r.append("\tDataID = " + dataID);
		r.append(lv);
		r.append("\tSystemDate = " + systemDate);
		r.append(lv);
		r.append("\tsystemTime = " + systemTime);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}

	public String getDataFrom() {
		return dataFrom;
	}

	public void setDataFrom(String dataFrom) {
		this.dataFrom = dataFrom;
	}

	public String getDataClassification() {
		return dataClassification;
	}

	public void setDataClassification(String dataClassification) {
		this.dataClassification = dataClassification;
	}

	public String getDataID() {
		return dataID;
	}

	public void setDataID(String dataID) {
		this.dataID = dataID;
	}

	public String getSystemDate() {
		return systemDate;
	}

	public void setSystemDate(String systemDate) {
		this.systemDate = systemDate;
	}

	public String getSystemTime() {
		return systemTime;
	}

	public void setSystemTime(String systemTime) {
		this.systemTime = systemTime;
	}
}
