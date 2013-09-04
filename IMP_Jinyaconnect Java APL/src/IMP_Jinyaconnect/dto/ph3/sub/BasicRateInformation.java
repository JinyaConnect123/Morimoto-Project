package IMP_Jinyaconnect.dto.ph3.sub;

import java.util.ArrayList;
import java.util.List;



public class BasicRateInformation {
	private String roomRateOrPersonalRate;
	private String taxServiceFee;
	private String payment;
	private String bareNetRate;
	private String cancellationCharge;
	private String creditCardAuthority;
	private String creditCardNumber;
	private String expireDate;
	private String cardHolderName;
	private String totalAccommodationCharge;
	private String totalAccommodationConsumptionTax;
	private String totalAccommodationHotSpringTax;
	private List<String> totalAccommodationHotelTaxs = new ArrayList<String>();
	private String totalAccommodationServiceFee;
	private String totalAccommodationBreakfastFee;
	private List<String> totalAccommodationOtherFees = new ArrayList<String>();
	private String commissionPercentage;
	private String totalAccommodationCommissionAmount;
	private String totalAccommodationCommissionConsumptionTax;
	private String totalAccommodationChargeAfterCheckIn;
	private String totalBalanceAfterCheckIn;
	private String totalAccommodationConsumptionAfterCheckIn;
	private String cancellationChargeAfterCheckIn;
	private String membershipFee;
	private String adjustmentFee;
	private List<CouponInformation> couponList = new ArrayList<CouponInformation>();
	public String getRoomRateOrPersonalRate() {
		return roomRateOrPersonalRate;
	}
	public void setRoomRateOrPersonalRate(String roomRateOrPersonalRate) {
		this.roomRateOrPersonalRate = roomRateOrPersonalRate;
	}
	public String getTaxServiceFee() {
		return taxServiceFee;
	}
	public void setTaxServiceFee(String taxServiceFee) {
		this.taxServiceFee = taxServiceFee;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getBareNetRate() {
		return bareNetRate;
	}
	public void setBareNetRate(String bareNetRate) {
		this.bareNetRate = bareNetRate;
	}
	public String getCancellationCharge() {
		return cancellationCharge;
	}
	public void setCancellationCharge(String cancellationCharge) {
		this.cancellationCharge = cancellationCharge;
	}
	public String getCreditCardAuthority() {
		return creditCardAuthority;
	}
	public void setCreditCardAuthority(String creditCardAuthority) {
		this.creditCardAuthority = creditCardAuthority;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getTotalAccommodationCharge() {
		return totalAccommodationCharge;
	}
	public void setTotalAccommodationCharge(String totalAccommodationCharge) {
		this.totalAccommodationCharge = totalAccommodationCharge;
	}
	public String getTotalAccommodationConsumptionTax() {
		return totalAccommodationConsumptionTax;
	}
	public void setTotalAccommodationConsumptionTax(
			String totalAccommodationConsumptionTax) {
		this.totalAccommodationConsumptionTax = totalAccommodationConsumptionTax;
	}
	public String getTotalAccommodationHotSpringTax() {
		return totalAccommodationHotSpringTax;
	}
	public void setTotalAccommodationHotSpringTax(
			String totalAccommodationHotSpringTax) {
		this.totalAccommodationHotSpringTax = totalAccommodationHotSpringTax;
	}
	public List<String> getTotalAccommodationHotelTax() {
		return totalAccommodationHotelTaxs;
	}
	public void addTotalAccommodationHotelTax(String totalAccommodationHotelTax) {
		this.totalAccommodationHotelTaxs.add( totalAccommodationHotelTax );
	}
	public String getTotalAccommodationServiceFee() {
		return totalAccommodationServiceFee;
	}
	public void setTotalAccommodationServiceFee(String totalAccommodationServiceFee) {
		this.totalAccommodationServiceFee = totalAccommodationServiceFee;
	}
	public String getTotalAccommodationBreakfastFee() {
		return totalAccommodationBreakfastFee;
	}
	public void setTotalAccommodationBreakfastFee(
			String totalAccommodationBreakfastFee) {
		this.totalAccommodationBreakfastFee = totalAccommodationBreakfastFee;
	}
	public List<String> getTotalAccommodationOtherFee() {
		return totalAccommodationOtherFees;
	}
	public void addTotalAccommodationOtherFee(String totalAccommodationOtherFee) {
		this.totalAccommodationOtherFees.add( totalAccommodationOtherFee );
	}
	public String getCommissionPercentage() {
		return commissionPercentage;
	}
	public void setCommissionPercentage(String commissionPercentage) {
		this.commissionPercentage = commissionPercentage;
	}
	public String getTotalAccommodationCommissionAmount() {
		return totalAccommodationCommissionAmount;
	}
	public void setTotalAccommodationCommissionAmount(
			String totalAccommodationCommissionAmount) {
		this.totalAccommodationCommissionAmount = totalAccommodationCommissionAmount;
	}
	public String getTotalAccommodationCommissionConsumptionTax() {
		return totalAccommodationCommissionConsumptionTax;
	}
	public void setTotalAccommodationCommissionConsumptionTax(
			String totalAccommodationCommissionConsumptionTax) {
		this.totalAccommodationCommissionConsumptionTax = totalAccommodationCommissionConsumptionTax;
	}
	public String getTotalAccommodationChargeAfterCheckIn() {
		return totalAccommodationChargeAfterCheckIn;
	}
	public void setTotalAccommodationChargeAfterCheckIn(
			String totalAccommodationChargeAfterCheckIn) {
		this.totalAccommodationChargeAfterCheckIn = totalAccommodationChargeAfterCheckIn;
	}
	public String getTotalBalanceAfterCheckIn() {
		return totalBalanceAfterCheckIn;
	}
	public void setTotalBalanceAfterCheckIn(String totalBalanceAfterCheckIn) {
		this.totalBalanceAfterCheckIn = totalBalanceAfterCheckIn;
	}
	public String getTotalAccommodationConsumptionAfterCheckIn() {
		return totalAccommodationConsumptionAfterCheckIn;
	}
	public void setTotalAccommodationConsumptionAfterCheckIn(
			String totalAccommodationConsumptionAfterCheckIn) {
		this.totalAccommodationConsumptionAfterCheckIn = totalAccommodationConsumptionAfterCheckIn;
	}
	public String getCancellationChargeAfterCheckIn() {
		return cancellationChargeAfterCheckIn;
	}
	public void setCancellationChargeAfterCheckIn(
			String cancellationChargeAfterCheckIn) {
		this.cancellationChargeAfterCheckIn = cancellationChargeAfterCheckIn;
	}
	public String getMembershipFee() {
		return membershipFee;
	}
	public void setMembershipFee(String membershipFee) {
		this.membershipFee = membershipFee;
	}
	public String getAdjustmentFee() {
		return adjustmentFee;
	}
	public void setAdjustmentFee(String adjustmentFee) {
		this.adjustmentFee = adjustmentFee;
	}
	public List<CouponInformation> getCouponList() {
		return couponList;
	}
	public void addCouponList(CouponInformation couponList) {
		this.couponList.add(couponList);
	}
	
	public String toString() {
		final String lv = "\n\t\t";
		
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\troomRateOrPersonalRate = " + roomRateOrPersonalRate);
		r.append(lv);
		r.append("\ttaxServiceFee = " + taxServiceFee);
		r.append(lv);
		r.append("\tpayment = " + payment);
		r.append(lv);
		r.append("\tbareNetRate = " + bareNetRate);
		r.append(lv);
		r.append("\tcancellationCharge = " + cancellationCharge);
		r.append(lv);
		r.append("\tcreditCardAuthority = " + creditCardAuthority);
		r.append(lv);
		r.append("\tcreditCardNumber = " + creditCardNumber);
		r.append(lv);
		r.append("\texpireDate = " + expireDate);
		r.append(lv);
		r.append("\tcardHolderName = " + cardHolderName);
		r.append(lv);
		r.append("\ttotalAccommodationCharge = " + totalAccommodationCharge);
		r.append(lv);
		r.append("\ttotalAccommodationConsumptionTax = " + totalAccommodationConsumptionTax);
		r.append(lv);
		r.append("\ttotalAccommodationHotSpringTax = " + totalAccommodationHotSpringTax);
		r.append(lv);
		r.append("\ttotalAccommodationHotelTax = " + totalAccommodationHotelTaxs);
		r.append(lv);
		r.append("\ttotalAccommodationServiceFee = " + totalAccommodationServiceFee);
		r.append(lv);
		r.append("\ttotalAccommodationBreakfastFee = " + totalAccommodationBreakfastFee);
		r.append(lv);
		r.append("\ttotalAccommodationOtherFee = " + totalAccommodationOtherFees);
		r.append(lv);
		r.append("\tcommissionPercentage = " + commissionPercentage);
		r.append(lv);
		r.append("\ttotalAccommodationCommissionAmount = " + totalAccommodationCommissionAmount);
		r.append(lv);
		r.append("\ttotalAccommodationCommissionConsumptionTax = " + totalAccommodationCommissionConsumptionTax);
		r.append(lv);
		r.append("\ttotalAccommodationChargeAfterCheckIn = " + totalAccommodationChargeAfterCheckIn);
		r.append(lv);
		r.append("\ttotalBalanceAfterCheckIn = " + totalBalanceAfterCheckIn);
		r.append(lv);
		r.append("\ttotalAccommodationConsumptionAfterCheckIn = " + totalAccommodationConsumptionAfterCheckIn);
		r.append(lv);
		r.append("\tcancellationChargeAfterCheckIn = " + cancellationChargeAfterCheckIn);
		r.append(lv);
		r.append("\tmembershipFee = " + membershipFee);
		r.append(lv);
		r.append("\tadjustmentFee = " + adjustmentFee);
		r.append(lv);
		r.append("\tcouponList = " + couponList);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}
}
