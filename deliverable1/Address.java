package deliverable1;

/**
 * @description Used to store the address of a person that is an entry of the address book
 * @author Louie Kert Basay
 * @date 11-30-13
 * 
 */
public class Address {
	String address;
	String city;
	String zip;
	
	/**
	 * 
	 * @param address address where the person reside
	 * @param city  city where the person reside
	 * @param zip zip code of the city where the person reside
	 */
	public Address(String address, String city, String zip) {
		this.address = address;
		this.city = city;
		this.zip = zip;
	}
	
	/**
	 * 
	 * @return address where the person reside
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * 
	 * @return city where the person reside
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * 
	 * @return zip code of the city where the person reside
	 */
	public String getZip() {
		return zip;
	}
	
	/**
	 * 
	 * @param address new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 
	 * @param city new city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * 
	 * @param zip new zip code
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(address + " ");
		sb.append(city + " ");
		sb.append(zip + " ");
		return sb.toString();
	}
}	//end of class
