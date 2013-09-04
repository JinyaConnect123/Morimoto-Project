package IMP_Jinyaconnect.dto.ph3.sub;

public class CouponInformation {
	private String couponAmount;
	private String couponType;
	private String couponNumber;
	private String couponIssueDate;
	
	public String toString() {
		final String lv = "\n\t\t";
		
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\tcouponAmount = " + couponAmount);
		r.append(lv);
		r.append("\tcouponType = " + couponType);
		r.append(lv);
		r.append("\tcouponNumber = " + couponNumber);
		r.append(lv);
		r.append("\tcouponIssueDate = " + couponIssueDate);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}

	public String getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(String couponAmount) {
		this.couponAmount = couponAmount;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public String getCouponNumber() {
		return couponNumber;
	}

	public void setCouponNumber(String couponNumber) {
		this.couponNumber = couponNumber;
	}

	public String getCouponIssueDate() {
		return couponIssueDate;
	}

	public void setCouponIssueDate(String couponIssueDate) {
		this.couponIssueDate = couponIssueDate;
	}
}
