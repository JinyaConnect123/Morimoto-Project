package IMP_Jinyaconnect.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import IMP_Jinyaconnect.Util;

public class RakujanSimpleSOQL {
	
	public static String getSOQL(String sql, String[] parameters) {
        for(int i = 0; sql != null && parameters != null && i < parameters.length; i++)
            sql = sql.replaceAll((new StringBuilder("\\{")).append(String.valueOf(i)).append("\\}").toString(), parameters[i]);
        
        if ( !Util.isStringEmpty( sql ) ) {
            Pattern pattern = Pattern.compile("\\{\\d+\\}");
            Matcher match = pattern.matcher(sql);
            sql = match.replaceAll("");
        }
        
        return sql;
	}
}
