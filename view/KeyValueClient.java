package view;

import java.io.IOException;

import beans.KeyValue;
import data.KeyValueDAO;

public class KeyValueClient {

	public static void main(String[] args) throws IOException {
		
		KeyValueDAO object = new KeyValueDAO();
		KeyValue kvObject = new KeyValue();
		KeyValue find;
		int results;
		String k;
		String v;
		
		kvObject.setKey("5");
		kvObject.setValue("Five");
		results = object.put(kvObject);
		System.out.println(results);
		
		find = object.get("5");
		k = find.getKey();
		v = find.getValue();
		System.out.println(k+" "+v);
		
	}

}
