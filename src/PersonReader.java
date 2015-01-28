import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class PersonReader {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document xmldoc = docReader.parse(new File("./XML/People.xml"));
		NodeList xmlPeople = xmldoc.getElementsByTagName("person");
		LinkedList<Person> people = new LinkedList<Person>();
		for(int i = 0; i < xmlPeople.getLength(); i++) {
			Node current = xmlPeople.item(i);
			if(current instanceof Element) {
				Element currentEl = (Element) current;
				String name = currentEl.getAttribute("name");
				String surname = currentEl.getAttribute("surname");
			
				Person currentPerson = new Person(name, surname);
				people.add(currentPerson);
				
				if(current.hasChildNodes()){
					NodeList xmlChildren =  currentEl.getChildNodes();
					for(int j=0; j<xmlChildren.getLength();j++){
						Node currentChild = xmlChildren.item(j);
						if(currentChild instanceof Element){
							Element currentChildElement = (Element) currentChild;
							String childName = currentChildElement.getAttribute("name");
							String childSurname = currentChildElement.getAttribute("surname");
							currentPerson.addChild(new Person(childName, childSurname));							
						}
					
					}
			}
			
			
		}
		Iterator<Person> iterator = people.iterator();
		while(iterator.hasNext()) {
			Person tmp = iterator.next();
			System.out.println(tmp.toString());
			if(tmp.hasChildren())				
				System.out.println("\t" + tmp.printChildren());
		}
	}

	}}
