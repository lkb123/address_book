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
	private ArrayList<Entry> entries = new ArrayList<Entry> ();
	
	public AddressBook() throws IOException {
		final String JSON_PATH = "json_files/sample_json.json";
		Parser p = new Parser(JSON_PATH);
		JsonArray jarray = p.getEntries();
		for(int i = 0; i < jarray.size(); i++) {
			String fname = p.getEntryInfo(i, "firstname");
			String lname = p.getEntryInfo(i, "lastname");
			String address = p.getEntryInfo(i, "address");
			String city = p.getEntryInfo(i, "city");
			String zip = p.getEntryInfo(i, "zip");
			String phone = p.getEntryInfo(i, "phone");
			Address a = new Address(address, city, zip);
			Phone ph = new Phone(phone);
			Person pe = new Person(fname, lname, a, ph);
			Entry e = new Entry(pe);
			entries.add(e);
		}
	}
	
	/**
	 * @return the list of entries in the address book
	 */
	public ArrayList<Entry> getEntries() {
		return entries;
	}
	
	/**
	 * @param e a new entry to the address book
	 */
	public void addAPerson(Entry e) {
		entries.add(e);
	}

	/**
	 * @param oldIndex the index of the old entry
	 * @param newEntry the new entry to replace the old one
	 */
	public void editAPerson(int oldIndex, Entry newEntry) {
		entries.set(oldIndex, newEntry);
	}

	/**
	 * @param index the index of the person to be deleted
	 */
	public void deleteAPerson(int index) {
		entries.remove(index);
	}
} //end of class
