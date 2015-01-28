import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {

		Person child2 = new Person("Selma", "Tabakovic");
		Person child3 = new Person("Amra", "Poprzanovic");
		Person child4 = new Person("Nermin", "Vucinic");
		
		
		Person test1 = new Person("Gorjan", "Kalauzovic");
		Person test2 = new Person("Hiko", "Lini");
		Person test3 = new Person("Jesenko", "Gavric");
		Person test4 = new Person("Vedad", "Zornic");
		Person test5 = new Person("Sanela", "Grcic");
		Person test6 = new Person("Emina", "Muratovic");
		
		test1.addChild(child2);
		test2.addChild(child2);
		test3.addChild(child3);
		test4.addChild(child4);
		test5.addChild(child2);
		test6.addChild(child2);
		
		LinkedList<Person> test = new LinkedList<Person>();
		test.add(test1);
		test.add(test2);
		test.add(test3);
		test.add(test4);
		test.add(test5);
		test.add(test6);
		
		
		
		try {
 		Person.personToXML(test, new FileOutputStream("./XML/People.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
