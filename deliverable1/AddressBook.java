package deliverable1;

import java.io.IOException;

import javax.json.JsonArray;
import javax.swing.DefaultListModel;

/**
 * @description The address book
 * @author Louie Kert Basay
 * @date 12-1-13
 * 
 */
public final class AddressBook {
	
	private Parser p;
	private DefaultListModel<Entry> entries = new DefaultListModel<Entry> ();
	
	public AddressBook() { }
	
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
			entries.addElement(e);
		}
	}

	/**
	 * @param e the new entry
	 */
	public void addPerson(Entry e) {
		entries.addElement(e);
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
	 * @param i the index of the entry to be edited
	 * @param e the new entry
	 */
	public void editPerson(int i, Entry e) {
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
	public DefaultListModel<Entry> getEntries() {
		return entries;
	}

	/**
	 * @param name sort by this type -- NAME or ZIP
	 */
	public void sort(SortType name) {
		switch(name) {
		case NAME:
			insertionSortByName();
			break;
		case ZIP:
			insertionSortByZip();
			break;
		}
		
	}

	/**
	 * Sorts the entries by zip number
	 */
	private void insertionSortByZip() {
		for(int j = 1; j < entries.size(); j++) {
			Entry key = entries.get(j);
			int zip = Integer.parseInt(key.getPerson().getAddress().getZip());
			int i = j - 1;
			int tmp = Integer.parseInt(entries.get(i).getPerson().getAddress().getZip());
			while(i >= 0 && tmp > zip) {
				entries.set(i + 1, entries.get(i));
				i = i - 1;
			}
			entries.set(i + 1, key);
		} 
		
	}

	/**
	 * Sorts the entries by name
	 */
	private void insertionSortByName() {
		for(int j = 1; j < entries.size(); j++) {
			Entry key = entries.get(j);
			String name = key.getPerson().getFname() + " " + key.getPerson().getLname();
			int i = j - 1;
			String cfname = entries.get(i).getPerson().getFname();
			String clname = entries.get(i).getPerson().getLname();
			String cname = cfname + " " + clname;
			while(i >= 0 && cname.compareTo(name) > 0) {
				entries.set(i + 1, entries.get(i));
				i = i - 1;
			}
			entries.set(i + 1, key);
		}
		
	}

	
} //end of class
