package tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;

import org.junit.Before;
import org.junit.Test;

import javax.json.stream.*;

/**
 * @author Louie Kert Basay
 * @date 12/04/13
 * 
 */
public class ParserTest {
	JsonParser parser = Json.createParser(new BufferedReader("../../json_files/sample_json.json"));
	
	@Before
	public void buildParser() {
		
	}
	
	@Test
	public void getPerson() {
		
	}
}
