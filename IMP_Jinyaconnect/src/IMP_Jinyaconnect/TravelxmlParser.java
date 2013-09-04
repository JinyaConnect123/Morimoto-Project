package IMP_Jinyaconnect;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;




public class TravelxmlParser {
	
	public enum xmlattr{DataFrom,};
	
	

	public TravelxmlParser(String xmlfile) throws FileNotFoundException, XMLStreamException {		 /* Useing StAX parser */
        
    	
    	XMLInputFactory factory = XMLInputFactory.newInstance();

        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(xmlfile));
        XMLStreamReader reader = factory.createXMLStreamReader(stream);

        
        for (; reader.hasNext(); reader.next()) {
//            int eventType = reader.getEventType();
//            if (eventType == XMLStreamConstants.START_ELEMENT) {									/* Check EVENT type */
//                System.out.println("Name: " + reader.getName());
//             }
            
            
            
            switch ( reader.getEventType() ) {
	            case XMLStreamConstants.START_ELEMENT:
	              //System.out.print("Start Element: " + reader.getName() + "\n" );	
	              break;
	            case XMLStreamConstants.END_ELEMENT:
	              //System.out.print("End Element: " + reader.getName() + "\n" );
	              break;
	            case XMLStreamConstants.SPACE:
	              //System.out.print("Space\n");
	              break;
	            case XMLStreamConstants.CHARACTERS:
	            	@SuppressWarnings("unused")
					String wchars =  reader.getText();
	            	//if ( !((wchars == "" ) || (wchars == " " )) ) {
	            		//System.out.print("Characters: " + wchars + "\n" );	
	            	//} else {
	            	//	System.out.print("Characters: " + "null or space " + "\n" );
	            	//}
	              break;
	            case XMLStreamConstants.PROCESSING_INSTRUCTION:
	              System.out.print("Processing Instrcutions\n");
	              break;
	            case XMLStreamConstants.CDATA:
	              System.out.print("CDATA\n");
	              break;
	            case XMLStreamConstants.COMMENT:
	              System.out.print("Comment\n");
	              break;
	            case XMLStreamConstants.DTD:
	              System.out.print("DTD\n");
	              break;
	            case XMLStreamConstants.ENTITY_REFERENCE:
	              System.out.print("Entity Reference\n");
	              break;
	            case XMLStreamConstants.ENTITY_DECLARATION:
	              System.out.print("Entity Declaration\n");
	              break;
	            case XMLStreamConstants.START_DOCUMENT:
	              //System.out.print("Start Document\n");
	              break;
	            case XMLStreamConstants.END_DOCUMENT:
	              //System.out.print("End Document\n");
	              break;
	            default:
	              System.out.print("*** Other Event type \n");
		          break;
            }
        }

        reader.close();
        
        // XML to JSON data
        
/*        package com.discursive.answers;

        import java.io.InputStream;

        import net.sf.json.JSON;
        import net.sf.json.xml.XMLSerializer;

        import org.apache.commons.io.IOUtils;

        public class ConvertXMLtoJSON {

                public static void main(String[] args) throws Exception {
                        InputStream is = 
                                ConvertXMLtoJSON.class.getResourceAsStream("sample-xml.xml");
                        String xml = IOUtils.toString(is);
                        
                        XMLSerializer xmlSerializer = new XMLSerializer(); 
                        JSON json = xmlSerializer.read( xml );  
                        System.out.println( json.toString(2) );
                }
        }
*/
        
        
        
        
        
        
        
    }
}
