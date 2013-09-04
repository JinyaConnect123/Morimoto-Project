package IMP_Jinyaconnect.dto.ph3.sub;

import java.util.ArrayList;
import java.util.List;

public class BasicInformation {
	private String travelAgencyBookingNumber;
	private String travelAgencyBookingDate;
	private String travelAgencyBookingTime;
	private String travelAgencyReportNumber;
	private String accommodationConfirmationNumber;
	private String guestOrGroupNameSingleByte;
	private String guestOrGroupNameDoubleByte;
	private String guestOrGroupNameKanjiName;
	private String groupNameWelcomeBoard;
	private String checkInDate;
	private String checkInTime;
	private String checkOutDate;
	private String checkOutTime;
	private String nights;
	private String transportaion;
	private String coachCount;
	private String coachCompany;
	private String totalRoomCount;
	private String grandTotalPaxCount;
	private String totalPaxMaleCount;
	private String totalPaxFemaleCount;
	private String totalChildA70Count;
	private String totalChildB50Count;
	private String totalChildC30Count;
	private String totalChildDNoneCount;
	private String totalChildECount;
	private String totalChildFCount;
	private String totalChildOtherCount;
	private String totalTourConductorCount;
	private String totalCoachDriverCount;
	private String totalGuideCount;
	private String typeOfGroup;
	private String status;
	private String packageType;
	private String packagePlanName;
	private String packagePlanCode;
	private String packagePlanContent;
	private List<Option> option = new ArrayList<Option>();
	private String mealCondition;
	private String specificMealCondition;
	private String mealPlace;
	private String banquetRoom;
	private String modificationType;
	private String modificationPoint;
	private String cancellationNumber;
	private String previousPlace;
	private List<String> previousAccommodationName = new ArrayList<String>();
	private List<String> specialServiceRequest = new ArrayList<String>();
	private String otherServiceInformation;
	private String followUpInformation;
	public String getTravelAgencyBookingNumber() {
		return travelAgencyBookingNumber;
	}
	public void setTravelAgencyBookingNumber(String travelAgencyBookingNumber) {
		this.travelAgencyBookingNumber = travelAgencyBookingNumber;
	}
	public String getTravelAgencyBookingDate() {
		return travelAgencyBookingDate;
	}
	public void setTravelAgencyBookingDate(String travelAgencyBookingDate) {
		this.travelAgencyBookingDate = travelAgencyBookingDate;
	}
	public String getTravelAgencyBookingTime() {
		return travelAgencyBookingTime;
	}
	public void setTravelAgencyBookingTime(String travelAgencyBookingTime) {
		this.travelAgencyBookingTime = travelAgencyBookingTime;
	}
	public String getTravelAgencyReportNumber() {
		return travelAgencyReportNumber;
	}
	public void setTravelAgencyReportNumber(String travelAgencyReportNumber) {
		this.travelAgencyReportNumber = travelAgencyReportNumber;
	}
	public String getAccommodationConfirmationNumber() {
		return accommodationConfirmationNumber;
	}
	public void setAccommodationConfirmationNumber(
			String accommodationConfirmationNumber) {
		this.accommodationConfirmationNumber = accommodationConfirmationNumber;
	}
	public String getGuestOrGroupNameSingleByte() {
		return guestOrGroupNameSingleByte;
	}
	public void setGuestOrGroupNameSingleByte(String guestOrGroupNameSingleByte) {
		this.guestOrGroupNameSingleByte = guestOrGroupNameSingleByte;
	}
	public String getGuestOrGroupNameDoubleByte() {
		return guestOrGroupNameDoubleByte;
	}
	public void setGuestOrGroupNameDoubleByte(String guestOrGroupNameDoubleByte) {
		this.guestOrGroupNameDoubleByte = guestOrGroupNameDoubleByte;
	}
	public String getGuestOrGroupNameKanjiName() {
		return guestOrGroupNameKanjiName;
	}
	public void setGuestOrGroupNameKanjiName(String guestOrGroupNameKanjiName) {
		this.guestOrGroupNameKanjiName = guestOrGroupNameKanjiName;
	}
	public String getGroupNameWelcomeBoard() {
		return groupNameWelcomeBoard;
	}
	public void setGroupNameWelcomeBoard(String groupNameWelcomeBoard) {
		this.groupNameWelcomeBoard = groupNameWelcomeBoard;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public String getNights() {
		return nights;
	}
	public void setNights(String nights) {
		this.nights = nights;
	}
	public String getTransportaion() {
		return transportaion;
	}
	public void setTransportaion(String transportaion) {
		this.transportaion = transportaion;
	}
	public String getCoachCount() {
		return coachCount;
	}
	public void setCoachCount(String coachCount) {
		this.coachCount = coachCount;
	}
	public String getCoachCompany() {
		return coachCompany;
	}
	public void setCoachCompany(String coachCompany) {
		this.coachCompany = coachCompany;
	}
	public String getTotalRoomCount() {
		return totalRoomCount;
	}
	public void setTotalRoomCount(String totalRoomCount) {
		this.totalRoomCount = totalRoomCount;
	}
	public String getGrandTotalPaxCount() {
		return grandTotalPaxCount;
	}
	public void setGrandTotalPaxCount(String grandTotalPaxCount) {
		this.grandTotalPaxCount = grandTotalPaxCount;
	}
	public String getTotalPaxMaleCount() {
		return totalPaxMaleCount;
	}
	public void setTotalPaxMaleCount(String totalPaxMaleCount) {
		this.totalPaxMaleCount = totalPaxMaleCount;
	}
	public String getTotalPaxFemaleCount() {
		return totalPaxFemaleCount;
	}
	public void setTotalPaxFemaleCount(String totalPaxFemaleCount) {
		this.totalPaxFemaleCount = totalPaxFemaleCount;
	}
	public String getTotalChildA70Count() {
		return totalChildA70Count;
	}
	public void setTotalChildA70Count(String totalChildA70Count) {
		this.totalChildA70Count = totalChildA70Count;
	}
	public String getTotalChildB50Count() {
		return totalChildB50Count;
	}
	public void setTotalChildB50Count(String totalChildB50Count) {
		this.totalChildB50Count = totalChildB50Count;
	}
	public String getTotalChildC30Count() {
		return totalChildC30Count;
	}
	public void setTotalChildC30Count(String totalChildC30Count) {
		this.totalChildC30Count = totalChildC30Count;
	}
	public String getTotalChildDNoneCount() {
		return totalChildDNoneCount;
	}
	public void setTotalChildDNoneCount(String totalChildDNoneCount) {
		this.totalChildDNoneCount = totalChildDNoneCount;
	}
	public String getTotalChildECount() {
		return totalChildECount;
	}
	public void setTotalChildECount(String totalChildECount) {
		this.totalChildECount = totalChildECount;
	}
	public String getTotalChildFCount() {
		return totalChildFCount;
	}
	public void setTotalChildFCount(String totalChildFCount) {
		this.totalChildFCount = totalChildFCount;
	}
	public String getTotalChildOtherCount() {
		return totalChildOtherCount;
	}
	public void setTotalChildOtherCount(String totalChildOtherCount) {
		this.totalChildOtherCount = totalChildOtherCount;
	}
	public String getTotalTourConductorCount() {
		return totalTourConductorCount;
	}
	public void setTotalTourConductorCount(String totalTourConductorCount) {
		this.totalTourConductorCount = totalTourConductorCount;
	}
	public String getTotalCoachDriverCount() {
		return totalCoachDriverCount;
	}
	public void setTotalCoachDriverCount(String totalCoachDriverCount) {
		this.totalCoachDriverCount = totalCoachDriverCount;
	}
	public String getTotalGuideCount() {
		return totalGuideCount;
	}
	public void setTotalGuideCount(String totalGuideCount) {
		this.totalGuideCount = totalGuideCount;
	}
	public String getTypeOfGroup() {
		return typeOfGroup;
	}
	public void setTypeOfGroup(String typeOfGroup) {
		this.typeOfGroup = typeOfGroup;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getPackagePlanName() {
		return packagePlanName;
	}
	public void setPackagePlanName(String packagePlanName) {
		this.packagePlanName = packagePlanName;
	}
	public String getPackagePlanCode() {
		return packagePlanCode;
	}
	public void setPackagePlanCode(String packagePlanCode) {
		this.packagePlanCode = packagePlanCode;
	}
	public String getPackagePlanContent() {
		return packagePlanContent;
	}
	public void setPackagePlanContent(String packagePlanContent) {
		this.packagePlanContent = packagePlanContent;
	}
	public List<Option> getOption() {
		return option;
	}
	public void addOption(Option option) {
		this.option.add(option);
	}
	public String getMealCondition() {
		return mealCondition;
	}
	public void setMealCondition(String mealCondition) {
		this.mealCondition = mealCondition;
	}
	public String getSpecificMealCondition() {
		return specificMealCondition;
	}
	public void setSpecificMealCondition(String specificMealCondition) {
		this.specificMealCondition = specificMealCondition;
	}
	public String getMealPlace() {
		return mealPlace;
	}
	public void setMealPlace(String mealPlace) {
		this.mealPlace = mealPlace;
	}
	public String getBanquetRoom() {
		return banquetRoom;
	}
	public void setBanquetRoom(String banquetRoom) {
		this.banquetRoom = banquetRoom;
	}
	public String getModificationType() {
		return modificationType;
	}
	public void setModificationType(String modificationType) {
		this.modificationType = modificationType;
	}
	public String getModificationPoint() {
		return modificationPoint;
	}
	public void setModificationPoint(String modificationPoint) {
		this.modificationPoint = modificationPoint;
	}
	public String getCancellationNumber() {
		return cancellationNumber;
	}
	public void setCancellationNumber(String cancellationNumber) {
		this.cancellationNumber = cancellationNumber;
	}
	public String getPreviousPlace() {
		return previousPlace;
	}
	public void setPreviousPlace(String previousPlace) {
		this.previousPlace = previousPlace;
	}
	public List<String> getPreviousAccommodationName() {
		return previousAccommodationName;
	}
	public void addPreviousAccommodationName(String previousAccommodationName) {
		this.previousAccommodationName.add(previousAccommodationName);
	}
	public List<String> getSpecialServiceRequest() {
		return specialServiceRequest;
	}
	public void addSpecialServiceRequest(String specialServiceRequest) {
		this.specialServiceRequest.add(specialServiceRequest);
	}
	public String getOtherServiceInformation() {
		return otherServiceInformation;
	}
	public void setOtherServiceInformation(String otherServiceInformation) {
		this.otherServiceInformation = otherServiceInformation;
	}
	public String getFollowUpInformation() {
		return followUpInformation;
	}
	public void setFollowUpInformation(String followUpInformation) {
		this.followUpInformation = followUpInformation;
	}
	
	public String toString() {
		final String lv = "\n\t\t";
		
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\ttravelAgencyBookingNumber = " + travelAgencyBookingNumber);
		r.append(lv);
		r.append("\ttravelAgencyBookingDate = " + travelAgencyBookingDate);
		r.append(lv);
		r.append("\ttravelAgencyBookingTime = " + travelAgencyBookingTime);
		r.append(lv);
		r.append("\ttravelAgencyReportNumber = " + travelAgencyReportNumber);
		r.append(lv);
		r.append("\taccommodationConfirmationNumber = " + accommodationConfirmationNumber);
		r.append(lv);
		r.append("\tguestOrGroupNameSingleByte = " + guestOrGroupNameSingleByte);
		r.append(lv);
		r.append("\tguestOrGroupNameDoubleByte = " + guestOrGroupNameDoubleByte);
		r.append(lv);
		r.append("\tguestOrGroupNameKanjiName = " + guestOrGroupNameKanjiName);
		r.append(lv);
		r.append("\tgroupNameWelcomeBoard = " + groupNameWelcomeBoard);
		r.append(lv);
		r.append("\tcheckInDate = " + checkInDate);
		r.append(lv);
		r.append("\tcheckInTime = " + checkInTime);
		r.append(lv);
		r.append("\tcheckOutDate = " + checkOutDate);
		r.append(lv);
		r.append("\tcheckOutTime = " + checkOutTime);
		r.append(lv);
		r.append("\tnights = " + nights);
		r.append(lv);
		r.append("\ttransportaion = " + transportaion);
		r.append(lv);
		r.append("\tcoachCount = " + coachCount);
		r.append(lv);
		r.append("\tcoachCompany = " + coachCompany);
		r.append(lv);
		r.append("\ttotalRoomCount = " + totalRoomCount);
		r.append(lv);
		r.append("\tgrandTotalPaxCount = " + grandTotalPaxCount);
		r.append(lv);
		r.append("\ttotalPaxMaleCount = " + totalPaxMaleCount);
		r.append(lv);
		r.append("\ttotalPaxFemaleCount = " + totalPaxFemaleCount);
		r.append(lv);
		r.append("\ttotalChildA70Count = " + totalChildA70Count);
		r.append(lv);
		r.append("\ttotalChildB50Count = " + totalChildB50Count);
		r.append(lv);
		r.append("\ttotalChildC30Count = " + totalChildC30Count);
		r.append(lv);
		r.append("\ttotalChildDNoneCount = " + totalChildDNoneCount);
		r.append(lv);
		r.append("\ttotalChildECount = " + totalChildECount);
		r.append(lv);
		r.append("\ttotalChildFCount = " + totalChildFCount);
		r.append(lv);
		r.append("\ttotalChildOtherCount = " + totalChildOtherCount);
		r.append(lv);
		r.append("\ttotalTourConductorCount = " + totalTourConductorCount);
		r.append(lv);
		r.append("\ttotalCoachDriverCount = " + totalCoachDriverCount);
		r.append(lv);
		r.append("\ttotalGuideCount = " + totalGuideCount);
		r.append(lv);
		r.append("\ttypeOfGroup = " + typeOfGroup);
		r.append(lv);
		r.append("\tstatus = " + status);
		r.append(lv);
		r.append("\tpackageType = " + packageType);
		r.append(lv);
		r.append("\tpackagePlanName = " + packagePlanName);
		r.append(lv);
		r.append("\tpackagePlanCode = " + packagePlanCode);
		r.append(lv);
		r.append("\tpackagePlanContent = " + packagePlanContent);
		r.append(lv);
		r.append("\toption = " + option);
		r.append(lv);
		r.append("\tmealCondition = " + mealCondition);
		r.append(lv);
		r.append("\tspecificMealCondition = " + specificMealCondition);
		r.append(lv);
		r.append("\tmealPlace = " + mealPlace);
		r.append(lv);
		r.append("\tbanquetRoom = " + banquetRoom);
		r.append(lv);
		r.append("\tmodificationType = " + modificationType);
		r.append(lv);
		r.append("\tmodificationPoint = " + modificationPoint);
		r.append(lv);
		r.append("\tcancellationNumber = " + cancellationNumber);
		r.append(lv);
		r.append("\tpreviousPlace = " + previousPlace);
		r.append(lv);
		r.append("\tpreviousAccommodationName = " + previousAccommodationName);
		r.append(lv);
		r.append("\tspecialServiceRequest = " + specialServiceRequest);
		r.append(lv);
		r.append("\totherServiceInformation = " + otherServiceInformation);
		r.append(lv);
		r.append("\tfollowUpInformation = " + followUpInformation);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}
}
