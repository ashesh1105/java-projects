package com.algorithms.string;

import org.apache.commons.lang3.StringUtils;

public class InputAndOrderingString {

	/*
	 * Given an input string and ordering string, need to return true if the ordering string is present in Input string.
	 * 
	 * Example: Input: "hello world!", ordering: "hlo!", result: false, since 'l' comes after o (as well) in string.
	 * 
	 * Another example: Input: "hello world!", ordering: "!od", result: false, since "!" appears after 'o' and 'd' in string.
	 * 
	 * Last example: Input: "hello world!", ordering: "he!", result true
	 */

	public static void main(String[] args) {

		String str = "hello! world!";
		String ordering1 = "hel!";

		System.out.println("String " + str
				+ (followsOrdering(str, ordering1) ? " follows ordering " : " does not follow ordering ")
				+ "per string: " + ordering1);

	}

	private static boolean followsOrdering(String str, String ordering) {
		
		// Return if either of the strings are null or empty. StringUtils does null and empty checks, both
		if (StringUtils.isEmpty(str) || StringUtils.isEmpty(ordering)) {
			System.out.println("Either of the passed strings are null.");
			return false;
		}
		
		// If ordering has just one character, there is nothing to do
		if (ordering.length() == 1) return true;
		
		// Finally, iterate ordering and check if first index of character (in given string) is less than
		// last index of preceding characters
		for (int i=0; i<ordering.length()-1; i++) {
			if (!(str.lastIndexOf(ordering.charAt(i)) < str.indexOf(ordering.charAt(i+1)))) return false;
		}
		
		return true;
	}

}
