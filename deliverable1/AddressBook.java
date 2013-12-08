package deliverable1;

import java.io.IOException;
import java.util.ArrayList;

import javax.json.JsonArray;

/**
 * @description The address book
 * @author Louie Kert Basay
 * @date 12-1-13
 * 
 */
public final class AddressBook {
	
	private Parser p;
	private ArrayList<Entry> entries = new ArrayList<Entry> ();
	
	public AddressBook() {
		
	}
	
	/**
	 * @param file the json file
	 * @throws IOException 
	 */
	public AddressBook(String file) throws IOException {
		p = new Parser(file);
		initialize();
	}

	/**
	 * Initializes the contents of the address book
	 */
	private void initialize() {
		JsonArray  jarray = p.getEntries();
		for(int i = 0; i < jarray.size(); i++) {
			String fname = p.getEntryInfo(i, "firstname");
			String lname = p.getEntryInfo(i, "lastname");
			String addr = p.getEntryInfo(i, "address");
			String city = p.getEntryInfo(i, "city");
			String zip = p.getEntryInfo(i, "zip");
			String phone = p.getEntryInfo(i, "phone");
			Address a = new Address(addr, city, zip);
			Phone p = new Phone(phone);
			
			Entry e = new Entry(new Person(fname, lname, a, p));
			entries.add(e);
		}
	}

	/**
	 * @param e the new entry
	 */
	public void addPerson(Entry e) {
		entries.add(e);
	}

	/**
	 * @param i the index of the entry
	 * @return the entry at that index
	 */
	public Entry getEntryAt(int i) {
		Entry e = entries.get(i);
		return e;
	}

	/**
	 * @return the number of elements in the address book
	 */
	public int getSize() {
		return entries.size();
	}

	/**
	 * @param i
	 * @param e
	 */
	public void editAPerson(int i, Entry e) {
		entries.set(i, e);
	}

	/**
	 * @param i the index of the entry to be removed
	 */
	public void deletePerson(int i) {
		entries.remove(i);
	}
	
	/**
	 * 
	 * @return array of entries of the address book
	 */
	public ArrayList<Entry> getEntries() {
		return entries;
	}
	
	
} //end of class
