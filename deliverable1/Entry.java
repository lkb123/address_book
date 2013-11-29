package deliverable1;

/**
 * @author Louie Kert Basay
 * @date
 * 
 */
public class Entry {
	
	public String fname;
	public String lname;
	
	public Entry(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	
	public Entry() {
		this(null, null);
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
}
