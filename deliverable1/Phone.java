package deliverable1;

/**
 * @description Used to store the phone numbers of a person
 * @author Louie Kert Basay
 * @date 11-30-13
 * 
 */
public class Phone {
	private String number;
	
	/**
	 * 
	 * @param number phone number of the person
	 */
	public Phone(String number) {
		this.number = number;
	}
	
	/**
	 * 
	 * @return phone number of the person
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * 
	 * @param number phone number of the person
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return number;
	}
} //end of class
