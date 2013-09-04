package IMP_Jinyaconnect.dto.ph3.sub;

public class UserUsePointList {
	private String pointName;
	private String userUsePoint;
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	public String getUserUsePoint() {
		return userUsePoint;
	}
	public void setUserUsePoint(String userUsePoint) {
		this.userUsePoint = userUsePoint;
	}

	public String toString() {
		final String lv = "\n\t\t";
		
		StringBuffer r = new StringBuffer();
		r.append("[");
		r.append(lv);
		r.append("\tpointName = " + pointName);
		r.append(lv);
		r.append("\tuserUsePoint = " + userUsePoint);
		r.append(lv);
		r.append("]");
		
		return r.toString();
	}
}
