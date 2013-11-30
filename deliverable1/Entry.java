package deliverable1;

/**
 * @description The entry for the address book
 * @author Louie Kert Basay
 * @date
 * 
 */
public class Entry {
	Person person;
	
	/**
	 * 
	 * @param person The person of the entry
	 */
	public Entry(Person person) {
		this.person = person;
	}
	
	/**
	 * 
	 * @return the person in the entry
	 */
	public Person getPerson() {
		return person;
	}
	
	/**
	 * 
	 * @param person to replace the old person in the entry
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
}
