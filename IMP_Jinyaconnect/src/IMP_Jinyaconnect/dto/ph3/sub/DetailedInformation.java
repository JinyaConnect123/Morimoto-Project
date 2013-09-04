package IMP_Jinyaconnect.dto.ph3.sub;

public class DetailedInformation {
	private String errorCode;
	private String errorText;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorText() {
		return errorText;
	}
	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	public String toString() {
		final String lv = "\n\t";
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\terrorCode = " + errorCode);
		r.append(lv);
		r.append("\terrorText = " + errorText);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}
}
