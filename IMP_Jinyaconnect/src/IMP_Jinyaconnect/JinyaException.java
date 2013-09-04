package IMP_Jinyaconnect;

import java.util.List;

import IMP_Jinyaconnect.utils.RakujanMessageLoader;

/**
 *
 * DataGem連携IF用例外
 *　プロパティファイルのエラーメッセージ用接頭語をメッセージの先頭に埋め込む
 *
 */
public class JinyaException extends Exception {
	/**
	 * シリアライズUID
	 */
	private static final long serialVersionUID = -2622158271892496517L;

	@SuppressWarnings("unused")
	private static final String CONFIG = "C:\\SFDC\\GOC\\IF_Batch\\DataGem\\conf\\DataGem.properties";

	private int code;
	private String message = null;
	private List<String> errors = null;

	public JinyaException(int code, String message) {

		super(message);
		this.message = message;
		this.code = code;
	}

	public JinyaException(int code, String messageKey, String parameters[]) {
		String message = RakujanMessageLoader.getMessage(messageKey, parameters);
		this.message = message;
		this.code = code;
	}
	
	public JinyaException(List<String> errors) {
		this.errors = errors;
	}
	
	public int getCode() {
		return code;
	}

	public String getMessage(){
		/*
		// Propertiesオブジェクトを生成
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(CONFIG));
		} catch (Exception e) {
			try {
				String err = "[IF連携エラー(Datagem)]DataGemExceptionのプロパティファイル生成で予期せぬエラー";
				Runtime.getRuntime().exec("eventcreate /ID " + code +" /L system /SO Cmd /T Error /D \"" + err +"\"");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("プロパティファイル生成で予期せぬエラー  メッセージ："
					+ e.getMessage());
			System.exit(1);
		}
		return prop.getProperty("message.subject")+":"+this.message;*/
		return this.message;
	}
	
	public List<String> getMessageList() {
		return errors;
	}
}
