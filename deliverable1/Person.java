package deliverable1;

/**
 * @description Used to store information about a person for an entry
 * to the address book application
 * @author Louie Kert Basay
 * @date 11-30-13
 * 
 */
public class Person {
	String fname;
	String lname;
	Address address;
	Phone phone;
	
	/**
	 * 
	 * @param fname person's first name
	 * @param lname person's last name
	 */
	public Person(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	
	/**
	 * 
	 * @param fname person's first name
	 * @param lname person's last name
	 * @param addr person's address
	 */
	public Person(String fname, String lname, Address addr) {
		this(fname, lname);
		this.address = addr;
	}
	
	/**
	 * 
	 * @param fname person's first name
	 * @param lname person's last name
	 * @param addr person's address
	 * @param phone person's phone
	 */
	public Person(String fname, String lname, Address addr, Phone phone) {
		this(fname, lname, addr);
		this.phone = phone;
	}
	
	/**
	 * @return person's first name
	 */
	public String getFname() {
		return fname;
	}
	
	/**
	 * @return person's last name
	 */
	public String getLname() {
		return lname;
	}
	
	/**
	 * 
	 * @return person's address
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * 
	 * @return person's phone
	 */
	public Phone getPhone() {
		return phone;
	}
	
	/**
	 * 
	 * @param fname person's new first name
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	/**
	 * 
	 * @param lname person's new last name
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	/**
	 * 
	 * @param addr person's new address
	 */
	public void setAddress(Address addr) {
		this.address = addr;
	}
	
	/**
	 * 
	 * @param phone person's new phone
	 */
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(lname + ", ");
		sb.append(fname + "         ");
		sb.append(address);
		sb.append(phone);
		return sb.toString();
	}
} //end of class
