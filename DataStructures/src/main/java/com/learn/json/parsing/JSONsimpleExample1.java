package com.learn.json.parsing;

import org.json.simple.JSONObject;

public class JSONsimpleExample1 {

	public static void main(String[] args) {

		JSONObject jsonObj = new JSONObject();

		jsonObj.put("name", "foo");
		jsonObj.put("num", new Integer(100));
		jsonObj.put("balance", new Double(1000.21));
		jsonObj.put("is_vip", new Boolean(true));

		System.out.print(jsonObj);

		/**
		 * JSON.simple also support writing data stream out:
		 * 
		 * StringWriter out = new StringWriter(); 
		 * obj.writeJSONString(out);
		 * String jsonText = out.toString();
		 * System.out.print(jsonText);
		 */
		
		

	}

}
