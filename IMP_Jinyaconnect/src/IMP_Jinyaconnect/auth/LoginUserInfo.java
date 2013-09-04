package IMP_Jinyaconnect.auth;

import java.net.PasswordAuthentication;

import com.sforce.soap.partner.SoapBindingStub;

import IMP_Jinyaconnect.JinyaMain;
import IMP_Jinyaconnect.Util;

public class LoginUserInfo {

	private static String userName = null;
	
	private static String password = null;

	private static SoapBindingStub stub  = null;
	
	public static SoapBindingStub getStub() {
		return stub; 
	}

	public static void setStub(SoapBindingStub stubobj) {
		stub = stubobj;
	}

	private static boolean lastLoginResult = false;
	
	/** Reset = true(再ログインする) */
	public static boolean RESET = true;
	
	public static void resetLoginInfo() {
		userName = null;
		password = null;
	}
	
	public static String getUserName(String defaultUser, String message) {
		if (Util.isStringEmpty(userName)) {
			getLoginInfo(defaultUser, message);
		}
		
		return userName;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public static boolean getLastLoginResult() {
		return lastLoginResult;
	}
	
	public static void setLastLoginResult(boolean result) {
		lastLoginResult = result;
	}
	
	public static void getLoginInfo(String defaultUser, String message, boolean reset) {
		PasswordAuthentication info = null;
		
		boolean showDialog = false;
		
		if (!reset) {
			if (Util.isStringEmpty(userName)) showDialog = true; 
			if (Util.isStringEmpty(password)) showDialog = true; 
		}
		else {
			showDialog = true;
		}
		
		if (showDialog) {
			DialogAuth da = new DialogAuth(defaultUser, JinyaMain.frame, message);
			da.setLocationRelativeTo(null);
			da.setSize(0, 0);
			da.setAlwaysOnTop(true);
			da.setVisible(true);
			da.dispose();
			info = da.getLoginInfo();
			if (info != null) {
				userName = info.getUserName();
				password = String.valueOf(info.getPassword());
			}
		}
		
		return;
		
	}
	
	public static void getLoginInfo(String defaultUser, String message) {
		getLoginInfo(defaultUser, message, false);
	}
}
