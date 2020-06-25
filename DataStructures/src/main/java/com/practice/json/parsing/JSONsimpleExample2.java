package com.practice.json.parsing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONsimpleExample2 {

	public static void main(String[] args) {

		JSONParser parser = new JSONParser();

		String jsonString = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";

		try {
			Object obj = parser.parse(jsonString);
			JSONArray array = (JSONArray) obj;

			System.out.println("The 2nd element of array");
			System.out.println(array.get(1));
			System.out.println();
			
			// Note, you can't get it as array[1], you need to do array.get(<index>) here
			JSONObject jsonObject1 = (JSONObject)array.get(1);
			System.out.println("Second array, key \"1\": "+ jsonObject1.get("1"));
			
			String s = "{}";
	         obj = parser.parse(s);
	         System.out.println(obj);

	         s = "[5,]";
	         obj = parser.parse(s);
	         System.out.println(obj);

	         s = "[5,,2]";
	         obj = parser.parse(s);
	         System.out.println(obj);

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
