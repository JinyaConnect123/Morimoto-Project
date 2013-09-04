package IMP_Jinyaconnect.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;

import org.apache.axis.message.MessageElement;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;

import com.sforce.soap.partner.SforceServiceLocator;

public class RakujanMessageElement {
	private static Logger logger = Logger.getLogger(RakujanMessageElement.class);
	
	private static MessageElement TEMPLATE_MESSAGE_ELEMENT = new MessageElement("", "temp"); 
	// The Template org.w3c.dom.Element instance 
	private static Element TEMPLATE_XML_ELEMENT;
	
	static {
		try {
			// Create and cache this org.w3c.dom.Element instance for once here.         
			TEMPLATE_XML_ELEMENT = TEMPLATE_MESSAGE_ELEMENT.getAsDOM();     
		} catch (Exception e) {
			System.err.println(e);
			logger.error("テンプレートエレメント作成失敗。\n", e);
		}
		
		TEMPLATE_XML_ELEMENT.removeAttribute("xsi:type");
		TEMPLATE_XML_ELEMENT.removeAttribute("xmlns:ns1");
		TEMPLATE_XML_ELEMENT.removeAttribute("xmlns:xsd");
		TEMPLATE_XML_ELEMENT.removeAttribute("xmlns:xsi"); 
	}   
	
	private List<MessageElement> listObjects = null;
	
	public RakujanMessageElement() {
		this.listObjects = new ArrayList<MessageElement>();
	}
	
	public RakujanMessageElement(MessageElement[] subjects) {
		this.listObjects = new ArrayList<MessageElement>();
		if (subjects != null && subjects.length > 0) {
			listObjects.addAll(Arrays.asList(subjects));
		}
	}
	
	public MessageElement[] getElements() {
		MessageElement[] ret = null;
		
		if (this.listObjects != null && this.listObjects.size() > 0) {
			ret = this.listObjects.toArray( new MessageElement[0]);
		}
		else {
			ret = new MessageElement[] {};
		}
		
		return ret;
	}
	
	public void reset() {
		if (this.listObjects != null && this.listObjects.size() > 0) {
			this.listObjects.clear();
		}
		this.listObjects = new ArrayList<MessageElement>();
	}
	
	public void addStringElement(String name, String value) {
		MessageElement obj = new MessageElement(TEMPLATE_XML_ELEMENT);
		obj.setQName(new QName(
				new SforceServiceLocator().getServiceName().getNamespaceURI(), 
				name
				));
		obj.setValue(value);
		
		this.listObjects.add(obj);
	}
	
	public void addObjectElement(String name, Object value) throws SOAPException {
		MessageElement obj = new MessageElement(TEMPLATE_XML_ELEMENT);
		obj.setQName(new QName(
				new SforceServiceLocator().getServiceName().getNamespaceURI(), 
				name
		));
		obj.setObjectValue(value);
		
		this.listObjects.add(obj);
	}
}
