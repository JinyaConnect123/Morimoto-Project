package IMP_Jinyaconnect.dto.ph3.sub;

public class Option {
	private String optionDate;
	private String name;
	private String nameRequest;
	private String optionCount;
	private String optionRate;
	private String optionCode;
	public String getOptionDate() {
		return optionDate;
	}
	public void setOptionDate(String optionDate) {
		this.optionDate = optionDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameRequest() {
		return nameRequest;
	}
	public void setNameRequest(String nameRequest) {
		this.nameRequest = nameRequest;
	}
	public String getOptionCount() {
		return optionCount;
	}
	public void setOptionCount(String optionCount) {
		this.optionCount = optionCount;
	}
	public String getOptionRate() {
		return optionRate;
	}
	public void setOptionRate(String optionRate) {
		this.optionRate = optionRate;
	}
	public String getOptionCode() {
		return optionCode;
	}
	public void setOptionCode(String optionCode) {
		this.optionCode = optionCode;
	}

	public String toString() {
		final String lv = "\n\t\t";
		
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\toptionDate = " + optionDate);
		r.append(lv);
		r.append("\tname = " + name);
		r.append(lv);
		r.append("\tnameRequest = " + nameRequest);
		r.append(lv);
		r.append("\toptionCount = " + optionCount);
		r.append(lv);
		r.append("\toptionRate = " + optionRate);
		r.append(lv);
		r.append("\toptionCode = " + optionCode);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}
}
