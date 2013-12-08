package deliverable1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.json.Json;
import javax.json.JsonWriter;

/**
 * @author Louie Kert Basay
 * @date 12-04-13
 * 
 */
public final class Writer {
	private String file;
	
	/**
	 * @param file the file to be written into 
	 */
	public Writer(String file) {
		this.file = file;
	}
	
}
