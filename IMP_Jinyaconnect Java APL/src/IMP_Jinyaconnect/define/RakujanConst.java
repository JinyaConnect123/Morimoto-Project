package IMP_Jinyaconnect.define;

import java.text.SimpleDateFormat;

public class RakujanConst {
	/**
	 * SOQL文に、検索条件項目および項目タイプを区切る文字列
	 */
	public static final String KEY_TYPE_SPLIT = ":";
	
	/**
	 * SOQL文に、日時検索時、日時範囲を表す区切り文字
	 */
	public static final String DATE_RANGE_SPLIT = "&";
	
	/**
	 * 特別リクエスト：正規表現
	 * ・予約詳細： 一日ごとの大人子供人数の内訳、料金詳細などを出力する。 
	 *  予約詳細情報は最初の情報が「ZZ」で始まり「,ZZ」で区切られる。
	 */
	public static final String REGEX_REQUEST = "[,]*ZZ([0-9]{4}/[0-9]{1,2}/[0-9]{1,2}) ([1-9]+)部屋目:([0-9]+)円[(](大人|子供)[)]×([0-9]+)名 = 小計([0-9]+)円";
	
	/**
	 * 日時フォーマット１
	 * 例： 2012-07-20T15:00:00.000Z
	 */
	public static final SimpleDateFormat DATE_FMT1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	public static final SimpleDateFormat DATE_FMT2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
	
	public static final SimpleDateFormat DATE_FMT3 = new SimpleDateFormat("yyyyMMdd_HHmmss");
	
	public static final SimpleDateFormat DATE_FMT4 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static final String[] PARAMETER_NONE = new String[] {};
}
