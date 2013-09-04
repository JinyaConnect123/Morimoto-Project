package IMP_Jinyaconnect.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sforce.soap.partner.SaveResult;

public class RakujanErrorFinder {
	private static Logger logger = Logger.getLogger(RakujanErrorFinder.class);
	
	private static final String _ERROR_UNKNOWN_ = "error.unknown";
	
	public static List<String> getErrors(SaveResult[] saveResult) {
		List<String> ret = new ArrayList<String>();
		
		if (saveResult == null) {
			String[] e = new String[] {"連携処理結果がNULL。(saveResult)"};
			String message = RakujanMessageLoader.getMessage(_ERROR_UNKNOWN_, e);
			ret.add(message);
			System.err.println("error." + message);
			logger.error(message);
		}
		
		int failure = 0;
		for (SaveResult sr : saveResult){
			com.sforce.soap.partner.Error[] errors = sr.getErrors();
			
			if (errors != null) {
				for (com.sforce.soap.partner.Error e : errors) {
					failure ++;
					String error = e.getMessage();
					
					StringBuffer names = new StringBuffer();
					for (String name : e.getFields() ) {
						if (names.length() > 0) {
							names.append(", ");
						}
						names.append(name);
					}
					ret.add(" ・(" + names + ") : " + error);
					System.err.println(error);
				}
			}
		}
		
		return ret;
	}
}
