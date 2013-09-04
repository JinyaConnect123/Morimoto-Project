package IMP_Jinyaconnect.dto.ph3.sub;

import java.util.ArrayList;
import java.util.List;

public class RoomRateInformation {
	private String roomDate;
	private String perPaxRate;
	private String perChildA70Rate;
	private String perChildB50Rate;
	private String perChildC30Rate;
	private String perChildDRate;
	private String perChildERate;
	private String perChildFRate;
	private String perChildOtherRate;
	private String totalPerRoomRate;
	private String totalPerRoomConsumptionTax;
	private String totalRoomHotSpringTax;
	private String totalPerRoomHotelTax;
	private String totalPerRoomServiceFee;
	private String totalPerRoomBreakfastFee;
	private String totalPerRoomOtherFee;
	private String totalPerRoomCommissionAmount;
	private String totalPerRoomCommissionConsumptionTax;
	private List<RoomRateDetailInformation> roomRateDetailInformation = new ArrayList<RoomRateDetailInformation>();
	public String getRoomDate() {
		return roomDate;
	}
	public void setRoomDate(String roomDate) {
		this.roomDate = roomDate;
	}
	public String getPerPaxRate() {
		return perPaxRate;
	}
	public void setPerPaxRate(String perPaxRate) {
		this.perPaxRate = perPaxRate;
	}
	public String getPerChildA70Rate() {
		return perChildA70Rate;
	}
	public void setPerChildA70Rate(String perChildA70Rate) {
		this.perChildA70Rate = perChildA70Rate;
	}
	public String getPerChildB50Rate() {
		return perChildB50Rate;
	}
	public void setPerChildB50Rate(String perChildB50Rate) {
		this.perChildB50Rate = perChildB50Rate;
	}
	public String getPerChildC30Rate() {
		return perChildC30Rate;
	}
	public void setPerChildC30Rate(String perChildC30Rate) {
		this.perChildC30Rate = perChildC30Rate;
	}
	public String getPerChildDRate() {
		return perChildDRate;
	}
	public void setPerChildDRate(String perChildDRate) {
		this.perChildDRate = perChildDRate;
	}
	public String getPerChildERate() {
		return perChildERate;
	}
	public void setPerChildERate(String perChildERate) {
		this.perChildERate = perChildERate;
	}
	public String getPerChildFRate() {
		return perChildFRate;
	}
	public void setPerChildFRate(String perChildFRate) {
		this.perChildFRate = perChildFRate;
	}
	public String getPerChildOtherRate() {
		return perChildOtherRate;
	}
	public void setPerChildOtherRate(String perChildOtherRate) {
		this.perChildOtherRate = perChildOtherRate;
	}
	public String getTotalPerRoomRate() {
		return totalPerRoomRate;
	}
	public void setTotalPerRoomRate(String totalPerRoomRate) {
		this.totalPerRoomRate = totalPerRoomRate;
	}
	public String getTotalPerRoomConsumptionTax() {
		return totalPerRoomConsumptionTax;
	}
	public void setTotalPerRoomConsumptionTax(String totalPerRoomConsumptionTax) {
		this.totalPerRoomConsumptionTax = totalPerRoomConsumptionTax;
	}
	public String getTotalRoomHotSpringTax() {
		return totalRoomHotSpringTax;
	}
	public void setTotalRoomHotSpringTax(String totalRoomHotSpringTax) {
		this.totalRoomHotSpringTax = totalRoomHotSpringTax;
	}
	public String getTotalPerRoomHotelTax() {
		return totalPerRoomHotelTax;
	}
	public void setTotalPerRoomHotelTax(String totalPerRoomHotelTax) {
		this.totalPerRoomHotelTax = totalPerRoomHotelTax;
	}
	public String getTotalPerRoomServiceFee() {
		return totalPerRoomServiceFee;
	}
	public void setTotalPerRoomServiceFee(String totalPerRoomServiceFee) {
		this.totalPerRoomServiceFee = totalPerRoomServiceFee;
	}
	public String getTotalPerRoomBreakfastFee() {
		return totalPerRoomBreakfastFee;
	}
	public void setTotalPerRoomBreakfastFee(String totalPerRoomBreakfastFee) {
		this.totalPerRoomBreakfastFee = totalPerRoomBreakfastFee;
	}
	public String getTotalPerRoomOtherFee() {
		return totalPerRoomOtherFee;
	}
	public void setTotalPerRoomOtherFee(String totalPerRoomOtherFee) {
		this.totalPerRoomOtherFee = totalPerRoomOtherFee;
	}
	public String getTotalPerRoomCommissionAmount() {
		return totalPerRoomCommissionAmount;
	}
	public void setTotalPerRoomCommissionAmount(String totalPerRoomCommissionAmount) {
		this.totalPerRoomCommissionAmount = totalPerRoomCommissionAmount;
	}
	public String getTotalPerRoomCommissionConsumptionTax() {
		return totalPerRoomCommissionConsumptionTax;
	}
	public void setTotalPerRoomCommissionConsumptionTax(
			String totalPerRoomCommissionConsumptionTax) {
		this.totalPerRoomCommissionConsumptionTax = totalPerRoomCommissionConsumptionTax;
	}
	public List<RoomRateDetailInformation> getRoomRateDetailInformation() {
		return roomRateDetailInformation;
	}
	public void addRoomRateDetailInformation(RoomRateDetailInformation roomRateDetailInformation) {
		this.roomRateDetailInformation.add(roomRateDetailInformation);
	}
	
	public String toString() {
		final String lv = "\n\t\t";
		
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\troomDate = " + roomDate);
		r.append(lv);
		r.append("\tperPaxRate = " + perPaxRate);
		r.append(lv);
		r.append("\tperChildA70Rate = " + perChildA70Rate);
		r.append(lv);
		r.append("\tperChildB50Rate = " + perChildB50Rate);
		r.append(lv);
		r.append("\tperChildC30Rate = " + perChildC30Rate);
		r.append(lv);
		r.append("\tperChildDRate = " + perChildDRate);
		r.append(lv);
		r.append("\tperChildERate = " + perChildERate);
		r.append(lv);
		r.append("\tperChildFRate = " + perChildFRate);
		r.append(lv);
		r.append("\tperChildOtherRate = " + perChildOtherRate);
		r.append(lv);
		r.append("\ttotalPerRoomRate = " + totalPerRoomRate);
		r.append(lv);
		r.append("\ttotalPerRoomConsumptionTax = " + totalPerRoomConsumptionTax);
		r.append(lv);
		r.append("\ttotalRoomHotSpringTax = " + totalRoomHotSpringTax);
		r.append(lv);
		r.append("\ttotalPerRoomHotelTax = " + totalPerRoomHotelTax);
		r.append(lv);
		r.append("\ttotalPerRoomServiceFee = " + totalPerRoomServiceFee);
		r.append(lv);
		r.append("\ttotalPerRoomBreakfastFee = " + totalPerRoomBreakfastFee);
		r.append(lv);
		r.append("\ttotalPerRoomOtherFee = " + totalPerRoomOtherFee);
		r.append(lv);
		r.append("\ttotalPerRoomCommissionAmount = " + totalPerRoomCommissionAmount);
		r.append(lv);
		r.append("\ttotalPerRoomCommissionConsumptionTax = " + totalPerRoomCommissionConsumptionTax);
		r.append(lv);
		r.append("\troomRateDetailInformation = " + roomRateDetailInformation);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}
}
