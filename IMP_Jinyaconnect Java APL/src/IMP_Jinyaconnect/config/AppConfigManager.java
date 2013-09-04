package IMP_Jinyaconnect.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import IMP_Jinyaconnect.Util;

public class AppConfigManager {
	// Propertiesオブジェクトを生成
	private static Properties _APP_CONFIG_ = null;
	static {
		Properties sysConfig = new Properties();
		try {
			InputStream input= sysConfig.getClass().getResourceAsStream("/config.properties");
			sysConfig.load(input);
		} catch (Exception e) {
			Util.unexpectedTerminate(e);
		}
		
		String appConfigPath = sysConfig.getProperty("config.app.path");
		
		try {
			_APP_CONFIG_ = new Properties();
			InputStream input = new FileInputStream(appConfigPath);
			_APP_CONFIG_.load(input);
		} catch (Exception e) {
			Util.unexpectedTerminate(e);
		}
	}
	
	public static String loadProperty(String key) {
		if (_APP_CONFIG_ == null) return null;
		return _APP_CONFIG_.getProperty(key);
	}
	
	private Properties appConfig = null;
	
	public AppConfigManager(String appConfigPath) throws Throwable{
		try {
			appConfig = new Properties();
			// アプリ起動用必須パラメータを取得する
			InputStream input = new FileInputStream(appConfigPath);
			appConfig.load(input);
		} catch (Exception e) {
			Util.unexpectedTerminate(e);
			throw e;
		}
		
		// プロキシの設定
		if (isValue("http.proxyRequired", "true")) {
			System.setProperty("http.proxyRequired", "true");
			System.setProperty("http.proxyHost", appConfig.getProperty("http.proxyHost"));
			System.setProperty("http.proxyPort", appConfig.getProperty("http.proxyPort"));
			
			if (isValue("http.proxyUserRequired", "true")){
				System.setProperty("http.proxyUser",     appConfig.getProperty("http.proxyUser"));
				System.setProperty("http.proxyPassword", appConfig.getProperty("http.proxyPassword"));
			}
		}
	}
	
	public Properties getAppConfig() {
		return this.appConfig;
	}
	
	public String getProperty(String key) {
		if (appConfig == null) {
			return null;
		}
		String property = appConfig.getProperty(key);
		return property;
	}
	
	public boolean isValue(String key, String value) {
		String property = getProperty(key);
		
		String w1 = Util.safeString(property);
		String w2 = Util.safeString(value);
		return (w1.compareToIgnoreCase(w2) == 0);
	}
}
