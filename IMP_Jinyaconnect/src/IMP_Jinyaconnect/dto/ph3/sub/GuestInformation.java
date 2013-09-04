package IMP_Jinyaconnect.dto.ph3.sub;

import java.util.ArrayList;
import java.util.List;


public class GuestInformation {
	private List<GuestInformationList> guestInformationLists = new ArrayList<GuestInformationList>();
	
	public List<GuestInformationList> getGuestInformationLists() {
		return guestInformationLists;
	}

	public void addGuestInformationList(GuestInformationList guestInformationList) {
		guestInformationLists.add(guestInformationList);
	}
	
	public String toString() {
		final String lv = "\n\t\t\t";
		
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\tguestInformationLists = " + guestInformationLists);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}
}
