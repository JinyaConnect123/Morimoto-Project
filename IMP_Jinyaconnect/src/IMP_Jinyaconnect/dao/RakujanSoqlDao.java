package IMP_Jinyaconnect.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.axis.message.MessageElement;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;

import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.SoapBindingStub;
import com.sforce.soap.partner.fault.InvalidFieldFault;
import com.sforce.soap.partner.fault.InvalidIdFault;
import com.sforce.soap.partner.fault.InvalidQueryLocatorFault;
import com.sforce.soap.partner.fault.InvalidSObjectFault;
import com.sforce.soap.partner.fault.MalformedQueryFault;
import com.sforce.soap.partner.fault.UnexpectedErrorFault;
import com.sforce.soap.partner.sobject.SObject;

public class RakujanSoqlDao {
	// インスタンスの生成
	static Logger logger = Logger.getLogger(RakujanSoqlDao.class);
	
	/**
	 * ・SOQL検索結果マップを出力する処理
	 *  実行結果確認用。
	 * 
	 * @param map SOQL検索結果マップ
	 */
	public static void outputMap(Map<String, MessageElement[]> map) {
		if (map.size() > 0) return;
		
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			String key = it.next();   
			MessageElement[] value = map.get(key); 
			
			System.out.println("Key: " + key + "[");
			for (int i = 0; i < value.length; i++) {
				
				String w0 = value[i].toString();
				String w1 = w0.replaceAll(" xsi:nil=\"true\"", "");
				String w2 = w1.replaceAll(" xmlns:ns1=\"urn:sobject.partner.soap.sforce.com\"", "");
				String w3 = w2.replaceAll(" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"", "");
				String w4 = w3.replaceAll("ns1:", "");
				
				if ( !w4.matches("<.+/>") ) System.out.println(" " + w4);
//				System.out.println(w0);
			}
			System.out.println("]\n");
		}
	}
	
	/**
	 * 検索SOQL文を発行し、その結果をマップのリストにセットし返す。
	 * ・map：key＝項目名／value＝項目値
	 * 
	 * @param soql 検索SOQL文
	 * 
	 * @return 検索処理結果リスト
	 */
	public static List<Map<String, Object>> getQueryListMap(SoapBindingStub stub, String soql) {
		SObject[] records = getQuerySObject(stub, soql);
		if (records == null || records.length == 0) return null;
		
		List<Map<String, Object>> listResultMap = new ArrayList<Map<String, Object>>();
		
		for (int i = 0; i < records.length; i++) {
			Map<String, Object> work = new HashMap<String, Object>();
			MessageElement[] els = records[i].get_any();
			
			for (int j = 0; j < els.length; j++){
				String key = els[j].getName();
				Object val = els[j].getValue();
				work.put(key, val);
			}
			
			listResultMap.add(work);
		}
		
		return listResultMap;
	}
	
	/**
	 * 検索SOQL文を発行し、その結果を配列にセットし返す。
	 * ・配列： SObject
	 * 
	 * @param soql 検索SOQL文
	 * 
	 * @return 検索処理結果配列
	 */
	public static SObject[] getQuerySObject(SoapBindingStub stub, String soql) {
		QueryResult queryResult = null;
		SObject[] records = null;
		
		try {
			queryResult = stub.query( soql );
		} catch (InvalidSObjectFault e) {
			e.printStackTrace();
		} catch (MalformedQueryFault e) {
			e.printStackTrace();
		} catch (InvalidFieldFault e) {
			e.printStackTrace();
		} catch (InvalidIdFault e) {
			e.printStackTrace();
		} catch (UnexpectedErrorFault e) {
			e.printStackTrace();
		} catch (InvalidQueryLocatorFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (queryResult != null && queryResult.getSize() != 0) {
			records = queryResult.getRecords();
		}
		
		return records;
	}
	
	private static int compareMessageElement(MessageElement o1, MessageElement o2) {
		return  (o1.getName() ).compareTo( o2.getName() ) ;
	}
	
	public static void updateSObject(SObject record, MessageElement[] subjects) {
		MessageElement[] es = record.get_any();
		
		List<MessageElement> l = Arrays.asList(subjects);
		MessageElement[] ups = l.toArray(new MessageElement[0]);
		Arrays.sort(ups, new Comparator<MessageElement>(){
			@Override
			public int compare(MessageElement o1, MessageElement o2) {
				return compareMessageElement(o1, o2) ;
			}});
		
		for (int i = 0; i < es.length; i ++ ) {
			int index = Arrays.binarySearch(ups, es[i], 
					new Comparator<MessageElement>() {
				@Override
				public int compare(MessageElement o1, MessageElement o2) {
					return compareMessageElement(o1, o2) ;
				}
			});
			
			if (index >= 0) {
				es[i] = ups[index];
				System.out.println( String.valueOf(i) + ":" +  es[i].getName() + " = " + ups[index].getValue() );
				try {
					Element e = es[i].getAsDOM();
					e.removeAttribute("xsi:nil");
					e.removeAttribute("xsi:type");
					e.removeAttribute("xmlns:xsd");
					e.removeAttribute("xmlns:xsi");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
