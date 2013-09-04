package IMP_Jinyaconnect.define;

import IMP_Jinyaconnect.Util;

public class RakujanEnum {
	
	public static final int __CREATE__ = 1;
	public static final int __MODIFY__ = 2;
	public static final int __CANCEL__ = 3;
	public static final int __CONFIRM__ = 4;
	public static final int __TEJIMA__ = 5;
	public static final int __ISSUE__  = 6;
	public static final int __OTHER__  = 7;
	
	public static enum DATA_TYPE {
		// 予約, 変更, 取消, 予約確認, 手仕舞い, クーポン, 上記以外
		CREATE("NewBookReport"		, __CREATE__), 
		MODIFY("ModificationReport"	, __MODIFY__), 
		CANCEL("CancellationReport"	, __CANCEL__),
		CONFIRM("Reconfirmatio"		, __CONFIRM__),
		TEJIMA("TejimaiReport"		, __TEJIMA__),
		ISSUE("IssueReport"			, __ISSUE__),
		OTHER("OtherReport"			, __OTHER__),
		JUDGE("", -1);
		
		private DATA_TYPE(String s, int n) {
			this.stringValue = s;
			this.intValue = n;
		}
		public String getString() {
			return this.stringValue;
		}
		public int getValue() {
			return this.intValue;
		}
		public boolean equal(String str) {
			return ( getString().equalsIgnoreCase(str) );
		}
		public boolean equal(int n) {
			return ( getValue() == n );
		}
		public int judge(String s) {
			if ( !Util.isStringEmpty(s) ) {
				for (DATA_TYPE t : DATA_TYPE.values()) {
					if ( t.equal(s) ) {
						return t.getValue();
					}
				}
			}
			return -1;
		}
		private String stringValue;
		private int intValue;
	}
	
	public static enum DATA_TYPE_PH3 {
		// 予約, 変更, 取消, 予約確認, 手仕舞い, クーポン, 上記以外
		CREATE("NewBookReport"		, __CREATE__), 
		MODIFY("ModificationReport"	, __MODIFY__), 
		CANCEL("CancellationReport"	, __CANCEL__),
		JUDGE("", -1);
		
		private DATA_TYPE_PH3(String s, int n) {
			this.stringValue = s;
			this.intValue = n;
		}
		public String getString() {
			return this.stringValue;
		}
		public int getValue() {
			return this.intValue;
		}
		public boolean equal(String str) {
			return ( getString().equalsIgnoreCase(str) );
		}
		public boolean equal(int n) {
			return ( getValue() == n );
		}
		public int judge(String s) {
			if ( !Util.isStringEmpty(s) ) {
				for (DATA_TYPE t : DATA_TYPE.values()) {
					if ( t.equal(s) ) {
						return t.getValue();
					}
				}
			}
			return -1;
		}
		private String stringValue;
		private int intValue;
	}
	
	public static enum SERVICE_REQUEST {
		DATE(1), ROOM(2), PRICE(3), TYPE(4), COUNT(5), AMOUNT(6), JUDGE(-1);
		
		private SERVICE_REQUEST(int n) {
			this.intValue = n;
		}
		public int getValue() {
			return this.intValue;
		}
		private int intValue;
		
		public String getName(int n) {
			for (SERVICE_REQUEST t : SERVICE_REQUEST.values()) {
				if ( t.getValue() == n ) {
					return t.name();
				}
			}
			
			return String.valueOf(n);
		}
	}
	
	public static enum DATA_FROM {
		FROM1("FromTravelAgency"), 
		FROM2("TEL"),
		JUDGE("");
		
		private String alias;
		
		private DATA_FROM(String s) {
			alias = s;
		}
		
		public String getAlias() {
			return alias;
		}
		
		public String getName(String alias) {
			for (DATA_FROM t : DATA_FROM.values()) {
				if ( alias.equalsIgnoreCase(getAlias()) ) {
					return t.name();
				}
			}
			
			return null;
		}
	}
	
	// 食事条件
	// 1泊2食=1night2meals/1泊朝食付=1nightBreakfast/食事なし=WithoutMeal/他=Other
	public static enum MEALCONDITION {
		A("1night2meals"		,	"1泊2食"),
		B("1nightBreakfast"		,	"1泊朝食付"),
		C("WithoutMeal"			,	"食事なし"),
		D("Other"				,	"他"),
		X("Function"			,	"translate");
		
		private String alias;
		private String wamei;
		
		private MEALCONDITION(String a, String n) {
			this.alias = a;
			this.wamei = n;
		}
		public String getAlias() {
			return alias;
		}
		public String getWamei() {
			return this.wamei;
		}
		public boolean equal(String str) {
			return ( getAlias().equalsIgnoreCase(str) );
		}
		public String translate(String s) {
			if ( !Util.isStringEmpty(s) ) {
				for (MEALCONDITION t : MEALCONDITION.values()) {
					if ( t.equal(s) ) {
						return t.getWamei();
					}
				}
			}
			return null;
		}
	}
}
