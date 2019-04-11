import java.io.FileInputStream;

import javax.xml.stream.*;




public class GestisciXml {
	
	public static void leggiXml () {
		
		XMLInputFactory xmlif = null;
		XMLStreamReader xmlr = null;
		String filename;
		
		try {
		xmlif = XMLInputFactory.newInstance();
		xmlr = xmlif.createXMLStreamReader(new FileInputStream(filename), "utf-8");
		} catch (Exception e) {
		System.out.println("Errore nell'inizializzazione del reader:");
		System.out.println(e.getMessage());
		}
	}
	
	public static void parsing() {
		
		XMLInputFactory xmlif = null;
		XMLStreamReader xmlr = null;
		String filename= GetFileName();
		
		try {
			while (xmlr.hasNext()) { 
				switch (xmlr.getEventType()) { 
				case XMLStreamConstants.START_DOCUMENT: 
				System.out.println("Start Read Doc " + filename); break;
				case XMLStreamConstants.START_ELEMENT: 
				System.out.println("Tag " + xmlr.getLocalName());
				for (int i = 0; i < xmlr.getAttributeCount(); i++)
				System.out.printf(" => attributo %s->%s%n", xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i));
				break;
				case XMLStreamConstants.END_ELEMENT: 
				System.out.println("END-Tag " + xmlr.getLocalName()); break;
				case XMLStreamConstants.COMMENT:
				System.out.println("// commento " + xmlr.getText()); break; 
				case XMLStreamConstants.CHARACTERS: 
				if (xmlr.getText().trim().length() > 0) 
				System.out.println("-> " + xmlr.getText());
				break;
				}
				xmlr.next();
				}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	

}
