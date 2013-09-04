package IMP_Jinyaconnect.dto.ph3.sub;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private String userName;
	private String userKana;
	private String userTel;
	private String userMailAddr;
	private String userZip;
	private String userAddr;
	private String userCorp;
	private String userDep;
	private String userID;
	private String vIPCode;
	private String pointCompanyName;
	private String pointName;
	private String userGivingPoints;
	private String userUsePoints;
	private String totalAccommodationDecleasePoints;
	private String totalAccommodationConsumptaionTax;
	private String amountClaimed;
	private String chargeEquation;
	private List<UserUsePointList> userUsePointList = new ArrayList<UserUsePointList>();
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserKana() {
		return userKana;
	}
	public void setUserKana(String userKana) {
		this.userKana = userKana;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserMailAddr() {
		return userMailAddr;
	}
	public void setUserMailAddr(String userMailAddr) {
		this.userMailAddr = userMailAddr;
	}
	public String getUserZip() {
		return userZip;
	}
	public void setUserZip(String userZip) {
		this.userZip = userZip;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserCorp() {
		return userCorp;
	}
	public void setUserCorp(String userCorp) {
		this.userCorp = userCorp;
	}
	public String getUserDep() {
		return userDep;
	}
	public void setUserDep(String userDep) {
		this.userDep = userDep;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getVIPCode() {
		return vIPCode;
	}
	public void setVIPCode(String vIPCode) {
		this.vIPCode = vIPCode;
	}
	public String getPointCompanyName() {
		return pointCompanyName;
	}
	public void setPointCompanyName(String pointCompanyName) {
		this.pointCompanyName = pointCompanyName;
	}
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	public String getUserGivingPoints() {
		return userGivingPoints;
	}
	public void setUserGivingPoints(String userGivingPoints) {
		this.userGivingPoints = userGivingPoints;
	}
	public String getUserUsePoints() {
		return userUsePoints;
	}
	public void setUserUsePoints(String userUsePoints) {
		this.userUsePoints = userUsePoints;
	}
	public String getTotalAccommodationDecleasePoints() {
		return totalAccommodationDecleasePoints;
	}
	public void setTotalAccommodationDecleasePoints(
			String totalAccommodationDecleasePoints) {
		this.totalAccommodationDecleasePoints = totalAccommodationDecleasePoints;
	}
	public String getTotalAccommodationConsumptaionTax() {
		return totalAccommodationConsumptaionTax;
	}
	public void setTotalAccommodationConsumptaionTax(
			String totalAccommodationConsumptaionTax) {
		this.totalAccommodationConsumptaionTax = totalAccommodationConsumptaionTax;
	}
	public String getAmountClaimed() {
		return amountClaimed;
	}
	public void setAmountClaimed(String amountClaimed) {
		this.amountClaimed = amountClaimed;
	}
	public String getChargeEquation() {
		return chargeEquation;
	}
	public void setChargeEquation(String chargeEquation) {
		this.chargeEquation = chargeEquation;
	}
	public List<UserUsePointList> getUserUsePointList() {
		return userUsePointList;
	}
	public void addUserUsePointList(UserUsePointList userUsePointList) {
		this.userUsePointList.add(userUsePointList);
	}

	public String toString() {
		final String lv = "\n\t\t";
		
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\tuserName = " + userName);
		r.append(lv);
		r.append("\tuserKana = " + userKana);
		r.append(lv);
		r.append("\tuserTel = " + userTel);
		r.append(lv);
		r.append("\tuserMailAddr = " + userMailAddr);
		r.append(lv);
		r.append("\tuserZip = " + userZip);
		r.append(lv);
		r.append("\tuserAddr = " + userAddr);
		r.append(lv);
		r.append("\tuserCorp = " + userCorp);
		r.append(lv);
		r.append("\tuserDep = " + userDep);
		r.append(lv);
		r.append("\tuserID = " + userID);
		r.append(lv);
		r.append("\tvIPCode = " + vIPCode);
		r.append(lv);
		r.append("\tpointCompanyName = " + pointCompanyName);
		r.append(lv);
		r.append("\tpointName = " + pointName);
		r.append(lv);
		r.append("\tuserGivingPoints = " + userGivingPoints);
		r.append(lv);
		r.append("\tuserUsePoints = " + userUsePoints);
		r.append(lv);
		r.append("\ttotalAccommodationDecleasePoints = " + totalAccommodationDecleasePoints);
		r.append(lv);
		r.append("\ttotalAccommodationConsumptaionTax = " + totalAccommodationConsumptaionTax);
		r.append(lv);
		r.append("\tamountClaimed = " + amountClaimed);
		r.append(lv);
		r.append("\tchargeEquation = " + chargeEquation);
		r.append(lv);
		r.append("\tuserUsePointList = " + userUsePointList);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}
	
	public Integer getUserUsePointListSize() {
		List<UserUsePointList> w = getUserUsePointList();
		return (w == null) ? 0 : w.size();
	}
	
	public UserUsePointList getUserUsePointInfo(int index) {
		int count = getUserUsePointListSize();
		return  (count > index && index >= 0) ? getUserUsePointList().get(index) : null;
	}
	
	public String getPointName(int index) {
		int count =  getUserUsePointListSize();
		if ( count > index && index >= 0 ) {
			return getUserUsePointInfo(index).getPointName();
		}
		else {
			return null;
		}
	}
	
	public String getUserUsePoint(int index) {
		int count =  getUserUsePointListSize();
		if ( count > index && index >= 0 ) {
			return getUserUsePointInfo(index).getUserUsePoint();
		}
		else {
			return null;
		}
	}
}
