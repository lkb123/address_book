package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import deliverable1.*;

/**
 * @author Louie Kert Basay
 * @date
 * 
 */
public class AddressBookTest {
	AddressBook ab = new AddressBook();
	@Before
	public void buildAddressBook() {
		Address a = new Address("Barga Compound", "Iligan City", "9200");
		Phone ph = new Phone("09268940965");
		Person pe = new Person("Louie Kert", "Basay", a, ph);
		Entry e = new Entry(pe);
		ab.addEntry(e);
		
		a = new Address("Gensaville Subdivision", "General Santos City", "9500");
		ph = new Phone("09323001683");
		pe = new Person("Khristian", "Basay", a, ph);
		e = new Entry(pe);
		ab.addEntry(e);
	}
	
	@Test
	public void addPersonTest() {
		Address a = new Address("Patoray Drive", "Iligan City", "9200");
		Phone ph = new Phone("09263630986");
		Person pe = new Person("Michelle Ann", "Bation", a, ph);
		Entry e = new Entry(pe);
		ab.addEntry(e);
		ArrayList<Entry> ae = ab.getEntries();
		assertSame("The person not successfully added", pe, ae.get(2).getPerson());
	}
	
	@Test
	public void editPersonTest() {
		Address a = new Address("Gensanville Subdivision", "General Santos City", "9500");
		Phone ph = new Phone("09053107295");
		Person pe = new Person("Vilma", "Basay", a, ph);
		Entry e = new Entry(pe);
		ab.editEntry(1, e);
		ArrayList<Entry> ae = ab.getEntries();
		assertSame("The person not successfully edited", pe, ae.get(1).getPerson());
	}

} //end of class
