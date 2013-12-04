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
