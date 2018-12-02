package com.eclipse.shortcuts;

import java.util.ArrayList;
import java.util.List;

public class EclipseShortcuts {

	public static void main(String[] args) {

		System.out.println("Hello");
		System.err.println("Pay attention to details!");

		List<String> myList;
		myList = new ArrayList();

		// Test the StringBuilder
		StringBuilder sb = new StringBuilder();
		String key = "David";
		int value = 90;

		sb.append("Key: ").append(key).append(" , Value: ").append(value)
				.append("\n");

		System.out.println(sb.toString());

	}

}
