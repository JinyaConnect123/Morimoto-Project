package IMP_Jinyaconnect;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.apache.commons.digester3.xmlrules.FromXmlRulesModule;
import org.xml.sax.SAXException;

import IMP_Jinyaconnect.dto.Travelxml;


public class XmlToBeanTest {
//	private static final String dataXmlPath = "/conf/Rakujan1234_110810164917.xml";
//	private static final String dataXmlRule = "/xml/xmlDataToBeanRule.xml";
	String dataXmlRule = "/Users/elegant/Documents/workspace/IMP_Jinyaconnect/conf/xmlDataToBeanRule.xml";
	String dataXmlPath = "/Users/elegant/Documents/workspace/IMP_Jinyaconnect/xml/Rakujan1234_110810164917.xml";
	public void parse() {

//		ConvertUtils.register(new MyDateConverter(), Date.class);
//		ConvertUtils.register(new MyTimeConverter(), Timer.class);
		DigesterLoader loader = DigesterLoader.newLoader( new FromXmlRulesModule()
	    {

	        @Override
	        protected void loadRules()
	        {
	            loadXMLRules(new File(dataXmlRule));
	        }

	    } );
		try {
			Digester digester = loader.newDigester();
//			Map mp = digester.parse(new File(dataXmlPath));
			Travelxml mp = digester.parse(new File(dataXmlPath));
System.out.println(mp.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Digester digester = new Digester();
//		digester.setValidating(false);
////		digester.setNamespaceAware("IMP_Jinyaconnect");
//		digester.addObjectCreate("AllotmentBookingReport", Travelxml.class);
//		digester.addObjectCreate("AllotmentBookingReport/TransactionType", TransactionType.class);
//		digester.addSetNext("AllotmentBookingReport/TransactionType", TransactionType.class.getName());
//		digester.addSetProperties("AllotmentBookingReport/TransactionType/DataFrom");
//		digester.addSetProperties("AllotmentBookingReport/TransactionType/DataClassification");
//		digester.addSetProperties("AllotmentBookingReport/TransactionType/SystemDate");
//		digester.addSetProperties("AllotmentBookingReport/TransactionType/SystemTime");
//		
//		String xmlPath = "/Users/elegant/Documents/workspace/IMP_Jinyaconnect/xml/Rakujan1234_110810164917.xml";
//		try {
//			//URL dataXml = this.getClass().getResource("/xml/Rakujan1234_110810164917.xml");
//			File file = new File(xmlPath);
//			Travelxml xmlBean = digester.parse(file);
//			System.out.println(xmlBean);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SAXException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		XmlToBeanTest test = new XmlToBeanTest();
		test.parse();
		
	}

	class MyDateConverter implements Converter {
	    @SuppressWarnings("rawtypes")
		@Override
	    public Object convert(Class clazz, Object value) {
	    	if (value == null) return value;
	        if (clazz.equals(java.util.Date.class)) {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            try {
	                return sdf.parse((String) value);
	            } catch (ParseException pe) {
	                throw new IllegalArgumentException(pe);
	            } catch (ClassCastException cce) {
	                throw new IllegalArgumentException(cce);
	            }
	        } else {
	            throw new IllegalArgumentException("Expected Date class");
	        }
	    }
	}
	class MyTimeConverter implements Converter {
	    @SuppressWarnings("rawtypes")
		@Override
	    public Object convert(Class clazz, Object value) {
	    	if (value == null) return value;
	        if (clazz.equals(java.util.Timer.class)) {
	            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	            try {
	                return sdf.parse((String) value);
	            } catch (ParseException pe) {
	                throw new IllegalArgumentException(pe);
	            } catch (ClassCastException cce) {
	                throw new IllegalArgumentException(cce);
	            }
	        } else {
	            throw new IllegalArgumentException("Expected Timer class");
	        }
	    }
	}
}
