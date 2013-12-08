package deliverable1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 * Parser for Address Book using Json
 * @author Louie Kert Basay
 * @date 12-04-13
 * 
 */
public class Parser {
	
	private JsonObject jobj;
	
	/**
	 * @param jSON_PATH the path to the json file
	 * @throws IOException 
	 */
	public Parser(String file) throws IOException {
		InputStream in = new FileInputStream(file);
		JsonReader jreader = Json.createReader(in);
		jobj = jreader.readObject();
		jreader.close();
		in.close();
	}

	/**
	 * @return an array of all the entries in the json file
	 */
	public JsonArray getEntries() {
		JsonArray jarray = jobj.getJsonArray("entries");
		return jarray;
	}

	/**
	 * @param i the index of the desired object
	 * @return the object in the entries
	 */
	public JsonObject getEntry(int i) {
		JsonArray jarray = this.getEntries();
		JsonObject obj = jarray.getJsonObject(i);
		return obj;
	}

	/**
	 * @param index index of the entry you are concerned
	 * @param name name of the value's key you want to retrieve 
	 * @return the value of the index and key
	 */
	public String getEntryInfo(int index, String name) {
		JsonObject obj = getEntry(index);
		String value = obj.getString(name);
		return value;
	}
	
}
