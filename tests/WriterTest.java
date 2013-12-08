package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

import deliverable1.Writer;

/**
 * @author Louie Kert Basay
 * @date
 * 
 */
public class WriterTest {
	private static Writer w;
	
	@BeforeClass
	public static void initialize() throws FileNotFoundException {
		final String JSON_PATH = "json_files/sample_json.json";
		w = new Writer(JSON_PATH);
	}
	
	@Test
	public void checkFileTest() {
		assertNotNull(w);
	}
	
	@Test
	public void writeTest() {
		
	}
}
