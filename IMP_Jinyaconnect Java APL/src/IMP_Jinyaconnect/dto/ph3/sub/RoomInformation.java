package IMP_Jinyaconnect.dto.ph3.sub;

import java.util.ArrayList;
import java.util.List;

public class RoomInformation {
	private String roomTypeCode;
	private String roomTypeName;
	private String roomCategory;
	private String viewType;
	private String smokingOrNonSmoking;
	private String perRoomPaxCount;
	private String roomPaxMaleCount;
	private String roomPaxFemaleCount;
	private String roomChildA70Count;
	private String roomChildB50Count;
	private String roomChildC30Count;
	private String roomChildDNoneCount;
	private String roomChildECount;
	private String roomChildFCount;
	private String roomChildOtherCount;
	private String roomByRoomStatus;
	private String roomByRoomConfirmationNumber;
	private List<String> facilities = new ArrayList<String>();
	private String assignedRoomNumber;
	private List<String> roomSpecialRequest = new ArrayList<String>();
	private List<String> roomTypeAgent = new ArrayList<String>();
	public String getRoomTypeCode() {
		return roomTypeCode;
	}
	public void setRoomTypeCode(String roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}
	public String getRoomTypeName() {
		return roomTypeName;
	}
	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}
	public String getRoomCategory() {
		return roomCategory;
	}
	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}
	public String getViewType() {
		return viewType;
	}
	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	public String getSmokingOrNonSmoking() {
		return smokingOrNonSmoking;
	}
	public void setSmokingOrNonSmoking(String smokingOrNonSmoking) {
		this.smokingOrNonSmoking = smokingOrNonSmoking;
	}
	public String getPerRoomPaxCount() {
		return perRoomPaxCount;
	}
	public void setPerRoomPaxCount(String perRoomPaxCount) {
		this.perRoomPaxCount = perRoomPaxCount;
	}
	public String getRoomPaxMaleCount() {
		return roomPaxMaleCount;
	}
	public void setRoomPaxMaleCount(String roomPaxMaleCount) {
		this.roomPaxMaleCount = roomPaxMaleCount;
	}
	public String getRoomPaxFemaleCount() {
		return roomPaxFemaleCount;
	}
	public void setRoomPaxFemaleCount(String roomPaxFemaleCount) {
		this.roomPaxFemaleCount = roomPaxFemaleCount;
	}
	public String getRoomChildA70Count() {
		return roomChildA70Count;
	}
	public void setRoomChildA70Count(String roomChildA70Count) {
		this.roomChildA70Count = roomChildA70Count;
	}
	public String getRoomChildB50Count() {
		return roomChildB50Count;
	}
	public void setRoomChildB50Count(String roomChildB50Count) {
		this.roomChildB50Count = roomChildB50Count;
	}
	public String getRoomChildC30Count() {
		return roomChildC30Count;
	}
	public void setRoomChildC30Count(String roomChildC30Count) {
		this.roomChildC30Count = roomChildC30Count;
	}
	public String getRoomChildDNoneCount() {
		return roomChildDNoneCount;
	}
	public void setRoomChildDNoneCount(String roomChildDNoneCount) {
		this.roomChildDNoneCount = roomChildDNoneCount;
	}
	public String getRoomChildECount() {
		return roomChildECount;
	}
	public void setRoomChildECount(String roomChildECount) {
		this.roomChildECount = roomChildECount;
	}
	public String getRoomChildFCount() {
		return roomChildFCount;
	}
	public void setRoomChildFCount(String roomChildFCount) {
		this.roomChildFCount = roomChildFCount;
	}
	public String getRoomChildOtherCount() {
		return roomChildOtherCount;
	}
	public void setRoomChildOtherCount(String roomChildOtherCount) {
		this.roomChildOtherCount = roomChildOtherCount;
	}
	public String getRoomByRoomStatus() {
		return roomByRoomStatus;
	}
	public void setRoomByRoomStatus(String roomByRoomStatus) {
		this.roomByRoomStatus = roomByRoomStatus;
	}
	public String getRoomByRoomConfirmationNumber() {
		return roomByRoomConfirmationNumber;
	}
	public void setRoomByRoomConfirmationNumber(String roomByRoomConfirmationNumber) {
		this.roomByRoomConfirmationNumber = roomByRoomConfirmationNumber;
	}
	public List<String> getFacilities() {
		return facilities;
	}
	public void addFacilities(String facilities) {
		this.facilities.add(facilities);
	}
	public String getAssignedRoomNumber() {
		return assignedRoomNumber;
	}
	public void setAssignedRoomNumber(String assignedRoomNumber) {
		this.assignedRoomNumber = assignedRoomNumber;
	}
	public List<String> getRoomSpecialRequest() {
		return roomSpecialRequest;
	}
	public void addRoomSpecialRequest(String roomSpecialRequest) {
		this.roomSpecialRequest.add(roomSpecialRequest);
	}
	public List<String> getRoomTypeAgent() {
		return roomTypeAgent;
	}
	public void addRoomTypeAgent(String roomTypeAgent) {
		this.roomTypeAgent.add(roomTypeAgent);
	}
	
	public String toString() {
		final String lv = "\n\t\t";
		
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\troomTypeCode = " + roomTypeCode);
		r.append(lv);
		r.append("\troomTypeName = " + roomTypeName);
		r.append(lv);
		r.append("\troomCategory = " + roomCategory);
		r.append(lv);
		r.append("\tviewType = " + viewType);
		r.append(lv);
		r.append("\tsmokingOrNonSmoking = " + smokingOrNonSmoking);
		r.append(lv);
		r.append("\tperRoomPaxCount = " + perRoomPaxCount);
		r.append(lv);
		r.append("\troomPaxMaleCount = " + roomPaxMaleCount);
		r.append(lv);
		r.append("\troomPaxFemaleCount = " + roomPaxFemaleCount);
		r.append(lv);
		r.append("\troomChildA70Count = " + roomChildA70Count);
		r.append(lv);
		r.append("\troomChildB50Count = " + roomChildB50Count);
		r.append(lv);
		r.append("\troomChildC30Count = " + roomChildC30Count);
		r.append(lv);
		r.append("\troomChildDNoneCount = " + roomChildDNoneCount);
		r.append(lv);
		r.append("\troomChildECount = " + roomChildECount);
		r.append(lv);
		r.append("\troomChildFCount = " + roomChildFCount);
		r.append(lv);
		r.append("\troomChildOtherCount = " + roomChildOtherCount);
		r.append(lv);
		r.append("\troomByRoomStatus = " + roomByRoomStatus);
		r.append(lv);
		r.append("\troomByRoomConfirmationNumber = " + roomByRoomConfirmationNumber);
		r.append(lv);
		r.append("\tfacilities = " + facilities);
		r.append(lv);
		r.append("\tassignedRoomNumber = " + assignedRoomNumber);
		r.append(lv);
		r.append("\troomSpecialRequest = " + roomSpecialRequest);
		r.append(lv);
		r.append("\troomTypeAgent = " + roomTypeAgent);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}
}
