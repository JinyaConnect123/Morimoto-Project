package IMP_Jinyaconnect;

import java.util.Properties;

import org.apache.log4j.Logger;

public class TerminateHandler {

	// Propertiesオブジェクトを生成
	@SuppressWarnings("unused")
	private Properties prop = null;
	// 設定ファイルのパス
	@SuppressWarnings("unused")
	private  String CONFIG = null;

	// インスタンスの生成
	static Logger logger = Logger.getLogger(Util.class);
	/**
	 * コンストラクタ
	 */
	public TerminateHandler(Properties properties,String pass) {
		prop = properties;
		CONFIG = pass;
	}
	
	/**
	 * 終了処理メイン
	 *
	 * @param startTime
	 * 		今回のSOQL発行時刻。
	 * @param isMastarUpdate
	 * false:通常バッチ(10分間隔)、true:為替レート反映およびマスタ更新反映
	 */
	public void terminate(String batchSyncTime) throws JinyaException {

		logger.info("CALL IN:TerminateHandler.class");

		//チェックファイルを更新する。
//		setCheckFileStatus();

		// 起動ステータスを更新する。
//		setOutProcessStatus();

		logger.info("CALL OUT:TerminateHandler.class");
	}

	/**
	 * チェックファイルの更新
	 *//*
	private void setCheckFileStatus() throws RajujanException {
		logger.info("CALL IN:TerminateHandler.class >setCheckFileStatus");

		File file = new File(prop.getProperty("ftp.publicDirectory")
				+ prop.getProperty("file.check"));
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("1");
			fw.close();
		} catch (IOException e) {
			throw new RajujanException(18,"[TerminateHandler.class >setCheckFileStatus]チェックファイルの更新に失敗しました。" + e.getMessage());
		}

		logger.info("CALL OUT:TerminateHandler.class >setCheckFileStatus");
	}*/
	/**
	 * 起動ステータスの更新
	 *//*
	private void setOutProcessStatus() throws JinyaException {
		logger.info("CALL IN:TerminateHandler.class >setOutProcessStatus");

		try {
			
			prop.setProperty("process.status","0");
			prop.setProperty("process.errorCount", "0");
			//プロパティファイル更新
			prop.store(new FileOutputStream(CONFIG),null);
		} catch(Exception e) {
			throw new RajujanException(16, "[TerminateHandler.class >setOutProcessStatus]起動ステータスの更新に失敗しました。" + e.getMessage());
		}

		logger.info("CALL OUT:TerminateHandler.class >setOutProcessStatus");
		return;
	}*/

}
