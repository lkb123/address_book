package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.json.JsonArray;
import javax.json.JsonObject;

import org.junit.BeforeClass;
import org.junit.Test;

import deliverable1.*;
import static org.junit.Assert.*;


/**
 * @author Louie Kert Basay
 * @date 12/04/13
 * 
 */
public class ParserTest {
	static Parser p;
	
	@BeforeClass
	public static void buildParser() throws IOException {
		final String JSON_PATH = "json_files/sample_json.json";
		p = new Parser(JSON_PATH);
	}
	
	@Test
	public void checkJsonFileTest() {
		assertNotNull(p);
	}
	
	@Test
	public void getEntriesTest() {
		JsonArray jarray = p.getEntries();
		assertNotNull(jarray);
	}
	
	@Test
	public void getEntriesSizeTest() {
		JsonArray jarray = p.getEntries();
		assertEquals(1, jarray.size());
	}
	
	@Test
	public void getEntryTest() {
		JsonObject obj = p.getEntry(0);
		assertNotNull(obj);
	}
	
	@Test
	public void getFnameTest() {
		String fname = p.getEntryInfo(0, "firstname");
		assertEquals("Louie", fname);
	}
	
	@Test
	public void getLnameTest() {
		String lname = p.getEntryInfo(0, "lastname");
		assertEquals("Basay", lname);
	}
	
	@Test
	public void getAddressTest() {
		String address = p.getEntryInfo(0, "address");
		assertEquals("Gensanville Subdivision", address);
	}
	
	@Test
	public void getCityTest() {
		String city = p.getEntryInfo(0, "city");
		assertEquals("General Santos City", city);
	}
	
	@Test
	public void getZipTest() {
		String zip = p.getEntryInfo(0, "zip");
		assertEquals("9200", zip);
	}
	
	@Test
	public void getPhoneTest() {
		String phone = p.getEntryInfo(0, "phone");
		assertEquals("09268940965", phone);
	}
	
} //end of class
