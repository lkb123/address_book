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
	private SortType s;
	
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
	public ArrayList<Entry> getEntries() {
		return entries;
	}

	/**
	 * @param name sort by this name(valid values are NAME and ZIP only)
	 */
	public void sort(SortType name) {
		int n = entries.size() - 1;
		this.s = name;
		this.quickSort(0, n);
	}

	/**
	 * @param i first index
	 * @param n last index
	 */
	private void quickSort(int i, int n) {
		switch(this.s) {
		case NAME:
			if(i < n) {
				int j = partitionByName(i, n);
				quickSort(i, j - 1);
				quickSort(j + 1, n);
			}
			break;
		case ZIP:
			if(i < n) {
				int j = partitionByZip(i, n);
				quickSort(i, j - 1);
				quickSort(j + 1, n);
			}
			break;
		}
	}

	/**
	 *@param i first index
	 * @param n last index
	 * @return the partition index
	 */
	private int partitionByZip(int i, int n) {
		int pivot = Integer.parseInt(entries.get(i).getPerson().getAddress().getZip());
		int a = i + 1;
		for(int j = i + 1; j < n; j++) {
			int zip = Integer.parseInt(entries.get(j).getPerson().getAddress().getZip());
			if(zip <= pivot) {
				a = a + 1;
				swap(a, j);
			}
		}
		swap(i, a);
		return a;
	}

	/**
	 * @param i first index
	 * @param n last index
	 * @return the partition index
	 */
	private int partitionByName(int i, int n) {
		String fname = entries.get(i).getPerson().getFname();
		String lname = entries.get(i).getPerson().getLname();
		String pivot = fname + " " + lname;
		int a = i + 1;
		for(int j = i + 1; j < n; j++) {
			String innerFname = entries.get(j).getPerson().getFname();
			String innerLname = entries.get(j).getPerson().getLname();
			String name = innerFname + " " + innerLname;
			if(name.compareTo(pivot) <= 0) {
				a = a + 1;
				swap(a, j);
			}
		}
		swap(i, a);
		return a;
	}

	/**
	 * @param a the left index
	 * @param j the right index
	 */
	private void swap(int a, int j) {
		Entry tmp = entries.get(a);
		entries.set(a, entries.get(j));
		entries.set(j, tmp);
	}
	
} //end of class
