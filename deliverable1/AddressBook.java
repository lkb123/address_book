package deliverable1;

import java.util.ArrayList;

/**
 * @description The address book
 * @author Louie Kert Basay
 * @date 12-1-13
 * 
 */
public class AddressBook {
	private ArrayList<Entry> entries = new ArrayList<Entry> ();
	
	/**
	 * @param e a new entry to the address book
	 */
	public void addEntry(Entry e) {
		entries.add(e);
	}

	/**
	 * @return the list of entries in the address book
	 */
	public ArrayList<Entry> getEntries() {
		return entries;
	}

	/**
	 * @param oldIndex the index of the old entry
	 * @param newEntry the new entry to replace the old one
	 */
	public void editEntry(int oldIndex, Entry newEntry) {
		ArrayList<Entry> l = getEntries();
		l.add(oldIndex, newEntry);
	}
} //end of class
