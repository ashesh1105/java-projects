package com.practice.genericprogramming;

public class UseGenericProgramming {

	public static void main(String[] args) {

		GenericMapInterface<Integer, String> genericData = new GenericMapClass<Integer, String>(
				DataType.HashMap);
		genericData.add(1, "David");
		genericData.add(2, "Sue");
		genericData.add(3, "Ram");

		System.out.println(genericData);

		GenericMapInterface<String, String> genericData2 = new GenericMapClass<String, String>(
				DataType.TreeMap);
		genericData2.add("Mark", "408-999-2343");
		genericData2.add("Partha", "987-222-4444");
		genericData2.add("Shekhar", "732-888-2222");

		System.out.println(genericData2);

	}
}
