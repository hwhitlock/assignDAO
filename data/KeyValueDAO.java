package data;

import java.io.*;
import java.util.StringTokenizer;
import beans.KeyValue;

public class KeyValueDAO {

	public KeyValue get(String key) throws IOException {
		String rec;
		StringTokenizer tok;
		String keys;
		String value;
		KeyValue keyValue = null;
		
		BufferedReader br = new BufferedReader(new FileReader("key-value.txt"));
		
		while((rec = br.readLine()) != null) {
			tok = new StringTokenizer(rec, ",");
			keys = tok.nextToken();
			value = tok.nextToken();
			
			if(key.equals(keys)) {
				keyValue = new KeyValue();
				keyValue.setKey(keys);
				keyValue.setValue(value);
			}
		}
		
		
		br.close();
		return keyValue;
	}
	public int put(KeyValue kvObject) {
		int success = 0;
		
		try {
			FileWriter file = new FileWriter("key-value.txt");
			file.write(kvObject.getKey()+","+kvObject.getValue()+"\n");
			success = 1;
			file.close();
		} catch (IOException e) {
			success=0;
			e.printStackTrace();
		}
		
		return success;	
	}
}
