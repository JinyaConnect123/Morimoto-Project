package IMP_Jinyaconnect.utils;

import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import IMP_Jinyaconnect.Util;

public class RakujanMessageLoader {
	private static Properties __CONFIG__ = null;
	
	static {
		// Propertiesオブジェクトを生成
		Properties config = new Properties();
		try {
			// アプリ起動用必須パラメータを取得する
			InputStream input= config.getClass().getResourceAsStream("/message.properties");
			config.load(input);
		} catch (Exception e) {
			Util.unexpectedTerminate(e);
		}
		
		__CONFIG__ = config;
	}
	
	/**
	 * メッセージKeyで、メッセージ定義ファイルからメッセージ情報を取得する
	 */
	public static String getMessage(String MessageKey) {
		return Util.safeString( __CONFIG__.get(MessageKey) );
	}
	
	/**
	 * メッセージKey、パラメータで、メッセージ情報を取得する
	 * @param messageKey
	 * @param parameters
	 * @return メッセージ(文字列)
	 */
	public static String getMessage(String messageKey, String[] parameters) {
        String msg = RakujanMessageLoader.getMessage(messageKey);
        
        for(int i = 0; msg != null && parameters != null && i < parameters.length; i++)
            msg = msg.replaceAll((new StringBuilder("\\{")).append(String.valueOf(i)).append("\\}").toString(), parameters[i]);
        
        if ( !Util.isStringEmpty( msg ) ) {
            Pattern pattern = Pattern.compile("\\{\\d+\\}");
            Matcher match = pattern.matcher(msg);
            msg = match.replaceAll("");
        }
        
        return msg;
	}
}
