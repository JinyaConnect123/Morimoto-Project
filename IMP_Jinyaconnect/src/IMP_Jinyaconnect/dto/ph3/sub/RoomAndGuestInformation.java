package IMP_Jinyaconnect.dto.ph3.sub;

import java.util.ArrayList;
import java.util.List;


public class RoomAndGuestInformation {
	private List<RoomAndGuestList> roomAndGuestLists = new ArrayList<RoomAndGuestList>();

	public List<RoomAndGuestList> getRoomAndGuestLists() {
		return roomAndGuestLists;
	}

	public void addRoomAndGuestList(RoomAndGuestList roomAndGuestList) {
		roomAndGuestLists.add(roomAndGuestList);
	}
	
	public String toString() {
		final String lv = "\n\t";
		
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\troomAndGuestLists = " + roomAndGuestLists);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}
}
