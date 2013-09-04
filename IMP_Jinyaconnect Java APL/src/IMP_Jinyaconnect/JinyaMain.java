package IMP_Jinyaconnect;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JFrame;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import IMP_Jinyaconnect.config.AppConfigManager;
import IMP_Jinyaconnect.utils.RakujanMessageLoader;
import IMP_Jinyaconnect.utils.RaskujanMutex;

public class JinyaMain {

	// インスタンスの生成
	private static Logger logger = Logger.getLogger(JinyaMain.class);
	
	public static JFrame frame = new JFrame();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Throwable {
		logger.info("CALL IN:JinyaMain.class");
		if ( ! isAlone() ) {
			String msg = RakujanMessageLoader.getMessage("error.mutex.info");
			logger.info(msg);
		}
		else {
			new TaskTrayMenu(args);
		}
		logger.info("CALL OUT:JinyaMain.class");
	}
	
	public static List<String> entry(String[] args) throws Throwable {
		List<String> ret = new ArrayList<String>();
		
		// 処理時間計測用
		long start = System.currentTimeMillis();
		System.out.println(start);

		// Propertiesオブジェクトを生成
		Properties prop = new Properties();
		try {
			// アプリ起動用必須パラメータを取得する
			InputStream input= prop.getClass().getResourceAsStream("/config.properties");
			prop.load(input);
		} catch (Exception e) {
			Util.unexpectedTerminate(e);
			ret.add(e.toString());
			return ret;
		}
		// Loggerの設定読み込み
		PropertyConfigurator.configure(prop.getProperty("config.log.path"));
		
		// 開始条件確認・初期処理
		long tmp = System.currentTimeMillis();
		System.out.print("InitialHandler-Process Start...");
		// アプリ通信用（前回バッチ実施時間の記憶、現状実施エラー回数な記憶必要な情報を維持するファイルのパスを取得する）
		String appConfigPath = prop.getProperty("config.app.path");
		AppConfigManager acm = new AppConfigManager(appConfigPath);
		System.out.println("End. processing time:" + ( System.currentTimeMillis() - tmp) + "(msec)");

		// データエクスポート
		tmp = System.currentTimeMillis();
		System.out.println("SyncProcessHandler-Process Start...");
		SyncProcessHandler sync = new SyncProcessHandler(prop, acm.getAppConfig());
		try {
			ret = sync.syncDataToSfdc();
		} catch (JinyaException e) {
			Util.errorTerminate(e);
//			return;
			throw e;
		} catch (Exception e) {
			Util.unexpectedTerminate(e);
//			return;
			throw e;
		}
		// 終了処理
		tmp = System.currentTimeMillis();
		System.out.print("TerminateHandler-Process Start...");
		/*
		TerminateHandler tmnt = new TerminateHandler(prop,appConfigPath);
		try {
			tmnt.terminate(sync.getBatchSyncTime());
		} catch (JinyaException e) {
			Util.errorTerminate(e);
//			return;
			throw e;
		} catch (Exception e) {
			Util.unexpectedTerminate(e);
//			return;
			throw e;
		}*/
		System.out.println("SyncProcessHandler-Process End. processing time:" + ( System.currentTimeMillis() - tmp) + "(msec)");
		
		return ret;
	}
	
	private static boolean isAlone() {
		boolean ret = false;
		RaskujanMutex rm = null;
		
		try {
			rm = new RaskujanMutex();
		} catch (JinyaException e) {
		}
		
		ret = ( rm.getLock() != null ); 
		
		return ret;
	}
}