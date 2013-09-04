package IMP_Jinyaconnect.dto.ph3.sub;

public class RoomRateDetailInformation {
	private String rateCategory;
	private String roomRate;
	private String ratePaxCount;
	private String rateDetailInformation;
	public String getRateCategory() {
		return rateCategory;
	}
	public void setRateCategory(String rateCategory) {
		this.rateCategory = rateCategory;
	}
	public String getRoomRate() {
		return roomRate;
	}
	public void setRoomRate(String roomRate) {
		this.roomRate = roomRate;
	}
	public String getRatePaxCount() {
		return ratePaxCount;
	}
	public void setRatePaxCount(String ratePaxCount) {
		this.ratePaxCount = ratePaxCount;
	}
	public String getRateDetailInformation() {
		return rateDetailInformation;
	}
	public void setRateDetailInformation(String rateDetailInformation) {
		this.rateDetailInformation = rateDetailInformation;
	}

	public String toString() {
		final String lv = "\n\t\t";
		
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\trateCategory = " + rateCategory);
		r.append(lv);
		r.append("\troomRate = " + roomRate);
		r.append(lv);
		r.append("\tratePaxCount = " + ratePaxCount);
		r.append(lv);
		r.append("\trateDetailInformation = " + rateDetailInformation);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}
}
