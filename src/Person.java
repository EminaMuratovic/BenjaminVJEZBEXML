import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Person {
	private String name;
	private String surname;
	private LinkedList<Person> children;
	private int age;
	
	public Person(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		children   = new LinkedList<Person>();
		this.age = age;
	}
	
	public boolean hasChildren(){
		if(children.isEmpty())
			return false;
		return true;
	}
	
	public String printChildren(){
		return "	Children: " + children.toString();
	}
	
	public String toString() {
		String str = "";
		str += "Name = " + name + "; Surname = " + surname + "; Age: " + age;
		Iterator<Person> iterator = children.iterator();
//		while(iterator.hasNext()) {
//			str += "; Child = " + iterator.next().toString();
//		}
		return str;
	}
	
	public void addChild(Person p) {
		children.add(p);
	}
	
	public static void personToXML(List<Person> people, OutputStream os) {
		PrintWriter pw = new PrintWriter(os);
		pw.println("<?xml version = \"1.0\"?>");
		pw.println("<people>");
		Iterator<Person> iterator = people.iterator();
		
		Person temp;
		Person temp2;
		while(iterator.hasNext()) {
			temp = iterator.next();
			pw.println("	<person name = \"" + temp.name + "\" surname = \"" + temp.surname + "\" age = \"" + temp.age + "\" >");
			Iterator<Person> iterator2 = temp.children.iterator();
			while(iterator2.hasNext()) {
				temp2 = iterator2.next();
				pw.println("		<child name = \"" + temp2.name + "\" surname = \"" + temp2.surname + "\" age = \"" + temp2.age + "\" />");
			}
			pw.println("	</person>");
			
		}
		pw.println("</people>");
		pw.flush();
		
	}

}
