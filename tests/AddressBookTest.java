package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import deliverable1.*;

/**
 * @author Louie Kert Basay
 * @date
 * 
 */
public class AddressBookTest {
	static AddressBook ab;
		
	@Before
	public void initializeAddressBook() throws IOException {
		String file = "json_files/sample_json.json";
		ab = new AddressBook(file);
	}
	
	@Test
	public void getABSizeTest() {
		int size = ab.getSize();
		assertEquals(2, size);
	}
	
	@Test
	public void addPersonTest() {
		Address a = new Address("Patoray Drive", "Iligan City", "9200");
		Phone ph = new Phone("09263630986");
		Person pe = new Person("Michelle Ann", "Bation", a, ph);
		Entry e = new Entry(pe);
		ab.addPerson(e);
		Entry tmp = ab.getEntryAt(2);
		assertEquals(e, tmp);
	}
	
	@Test
	public void editPersonTest() {
		Address a = new Address("Gensanville Subdivision", "General Santos City", "9500");
		Phone ph = new Phone("09053107295");
		Person pe = new Person("Vilma", "Basay", a, ph);
		Entry e = new Entry(pe);
		ab.editAPerson(0, e);
		Entry tmp = ab.getEntryAt(0);
		assertEquals(e, tmp);
	}
	
	@Test
	public void editPersonMustFailTest() {
		Address a = new Address("Gensanville Subdivision", "General Santos City", "9500");
		Phone ph = new Phone("09053107295");
		Person pe = new Person("Vilma", "Basay", a, ph);
		Entry e = new Entry(pe);
		ab.editAPerson(0, e);
		Entry tmp = ab.getEntryAt(1);
		assertNotEquals(e, tmp);
	}
	
	@Test
	public void deletePersonTest() {
		Entry e = ab.getEntryAt(0);
		ab.deletePerson(0);
		Entry tmp = ab.getEntryAt(0);
		assertNotEquals(e, tmp);
	}
	
	@Test
	public void deletePersonMustEqualTest() {
		Entry e = ab.getEntryAt(1);
		ab.deletePerson(0);
		Entry tmp = ab.getEntryAt(0);
		assertEquals(e, tmp);
	}
	
	@Test
	public void deletePersonSizeTest() {
		ab.deletePerson(0);
		assertEquals(1, ab.getSize());
	}
	
} //end of class
