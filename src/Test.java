import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {

		Person child2 = new Person("Selma", "Tabakovic", 23);
		Person child3 = new Person("Amra", "Poprzanovic", 7);
		Person child4 = new Person("Nermin", "Vucinic", 8);
		
		
		Person test1 = new Person("Gorjan", "Kalauzovic", 32);
		Person test2 = new Person("Hiko", "Lini", 22);
		Person test3 = new Person("Jesenko", "Gavric",55);
		Person test4 = new Person("Vedad", "Zornic", 55);
		Person test5 = new Person("Sanela", "Grcic", 65);
		Person test6 = new Person("Emina", "Muratovic", 98);
		
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
