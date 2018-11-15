package libros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	private Document dom = null;
	private ArrayList<Libros> libro = null;

	public Parser() {
		libro = new ArrayList<Libros>();
	}

	public void parseFicheroXml(String fichero) {
		// creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			// creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// parseamos el XML y obtenemos una representación DOM
			dom = db.parse(fichero);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public void parseDocument() {
		// obtenemos el elemento raíz
		Element docEle = dom.getDocumentElement();

		// obtenemos el nodelist de elementos
		NodeList nl = docEle.getElementsByTagName("libro");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				// obtenemos un elemento de la lista (persona)
				Element el = (Element) nl.item(i);

				// obtenemos una persona
				Libros p = getLibros(el);

				// lo añadimos al array
				libro.add(p);
			}
		}
	}
	
	private Libros getLibros(Element personaEle){
		
		//para cada elemento persona, obtenemos su nombre y su edad
		String titulo = getTextValue(personaEle,"titulo");
		String autor = getTextValue(personaEle,"autor");
		String editor = getTextValue(personaEle,"editor");
		int paginas = getIntValue(personaEle,"paginas");
		
		//Creamos una nueva persona con los elementos leídos del nodo
		Libros e = new Libros(titulo,autor,editor,paginas);

		return e;		
		
	}
	
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}		
		return textVal;
	}
	
	private int getIntValue(Element ele, String tagName) {				
		return Integer.parseInt(getTextValue(ele,tagName));
	}
	
	public void print(){

		Iterator it = libro.iterator();
		while(it.hasNext()) {
			Libros p=(Libros) it.next();
			p.mostrar();
		}
	}
	
	

}
