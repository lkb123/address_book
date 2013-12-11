package deliverable1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.swing.DefaultListModel;

/**
 * @author Louie Kert Basay
 * @date 12-04-13
 * 
 */
public final class Writer {
	private JsonWriter jwriter;
	
	/**
	 * @param file the file to be written into 
	 * @throws FileNotFoundException 
	 */
	public Writer(String file) throws FileNotFoundException {
		OutputStream os = new FileOutputStream(file);
		jwriter = Json.createWriter(os);
		AddressBook a = Interface.getAddressBook();
		JsonObjectBuilder jsonObject = Json.createObjectBuilder();
		JsonArrayBuilder entriesArray = Json.createArrayBuilder();
		JsonObjectBuilder  entryObject = Json.createObjectBuilder();
		DefaultListModel<Entry> tmp = a.getEntries();
		
		for(int i = 0; i < tmp.size(); i++) {
			Person p = tmp.get(i).getPerson();
			entryObject.add("firstname", p.getFname())
							.add("lastname", p.getLname())
								.add("address", p.getAddress().getAddress())
									.add("city", p.getAddress().getCity())
										.add("zip", p.getAddress().getZip())
											.add("phone", p.getPhone().getNumber());
			entriesArray.add(entryObject);
		}
		jsonObject.add("entries", entriesArray);
		JsonObject result = jsonObject.build();
		jwriter.writeObject(result);
		jwriter.close();
	}
	
}
