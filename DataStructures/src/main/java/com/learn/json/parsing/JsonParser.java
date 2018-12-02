package com.learn.json.parsing;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * This class attempts to take Json data and flatten it all the way and write data as:
 *  a_b_c_d : e
	a_b_c_d_d1_foo : bar
	
	Check src/main/resources/json_data.txt for sample json data.
	
	Note** Jackson was not allowing to use a Json Array as mentioned in json_data file
	on same directory. Need to find a way to do that using Jackson. Or do we need to use
	Gson or java json for that?
	
	Check: https://www.tutorialspoint.com/json/json_java_example.htm
 *
 */
public class JsonParser {
	
	public static void main(String[] args) {

		JsonFactory factory = new JsonFactory();

//		String jsonString = "[\n" + "{\"a\":\n" + "    {\"b\":\n" + "        {\"c\":\n" + "            {\n"
//				+ "            \"d\":\"e\",\n" + "            \"d1\":{\"foo\":\"bar\"}\n" + "            }\n"
//				+ "        }\n" + "    }\n" + "}, \n" + "{\"a\":{\"b\":{\"c\":{\"d\":{\"e\":\"f\"}}}}}\n" + "]\n" + "";

		ObjectMapper mapper = new ObjectMapper(factory);
		JsonNode rootNode = null;
		
		try {
			// You can use string value of Json above (commented out) or a file with Json data
			rootNode = mapper.readTree(new File("src/main/resources/json_data.txt"));
			Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
			
			List<String> keys = new ArrayList<>();
			
			while (fieldsIterator.hasNext()) {
				
				Map.Entry<String, JsonNode> field = fieldsIterator.next();
				String key = field.getKey();
				JsonNode value = field.getValue();
				boolean foundLeafNode = false;
				
				// add key to list of keys since we need to concatenate them for leaf node
				keys.add(key);
				
				if (value != null && value.textValue()!= null && !(value.textValue().contains("{"))) {
					foundLeafNode = true;
				}
				
				// Once done with outer key, traverse inside it to get more key-value pairs
				if (!(fieldsIterator.hasNext())) {
					
					// field.getValue gives JsonNode anyway, so we can leverage that
					rootNode = field.getValue();
					fieldsIterator = rootNode.fields();
				}
				if (foundLeafNode) {
					StringBuilder sb = new StringBuilder();
					keys.forEach(x -> sb.append(x + "_"));
					System.out.println(sb.substring(0, sb.length() - 1) + " : " + value.textValue());
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
