package IMP_Jinyaconnect.dto.ph3.sub;

import java.util.ArrayList;
import java.util.List;

public class ResultInformation {
	private String resultCode;
	
	private List<DetailedInformation> detailedInformation = new ArrayList<DetailedInformation>() ;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public List<DetailedInformation> getDetailedInformation() {
		return detailedInformation;
	}

	public void addDetailedInformation(DetailedInformation detailedInformation) {
		this.detailedInformation.add(detailedInformation);
	}

	public String toString() {
		final String lv = "\n\t";
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\tresultCode = " + resultCode);
		r.append(lv);
		r.append("\tdetailedInformation = " + detailedInformation);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}
}
