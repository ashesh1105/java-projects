package com.algorithms.string;

import org.apache.commons.lang3.StringUtils;

public class ReplaceSpacesByPercent20 {

	public static void main(String[] args) {

		String str = "abc def ghi";

		String result = new ReplaceSpacesByPercent20().replaceSpacesByPercent20UsingArray(str);

		System.out.println("Original string: " + str + "\nNew string: " + result);

	}

	// Using StringBuilder - I will prefer this in production environment
	public String replaceSpacesByPercent20(String str) {

		if (StringUtils.isEmpty(str)) {
			System.out.println("ERROR: String " + str + " is either empty or null.");
			return str;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == ' ') {
				sb.append("%20");
			} else {
				sb.append(ch);
			}
		}

		return sb.toString();
	}

	// What if Java libraries like StringBuilder are not allowed?
	public String replaceSpacesByPercent20UsingArray(String str) {

		if (StringUtils.isEmpty(str)) {
			System.out.println("ERROR: String " + str + " is either empty or null.");
			return str;
		}

		int len = str.length();

		// Parse the string once and count the number of spaces
		int numSpaces = 0;
		for (int i = 0; i < len; i++) {
			numSpaces++;
		}

		// Declare an array of size equal to length of string and number of %20 strings needed
		int resultArrSize = len + (numSpaces * 2); // discount the 1 space is replaced by 3 chars: %20
		char[] resultArr = new char[resultArrSize];

		// Parse the string again and populate the resultArray with spaces replaced by %20
		int i = 0;
		int j = 0;
		while (i < len) {
			char ch = str.charAt(i++);
			if (ch == ' ') {
				resultArr[j++] = '%';
				resultArr[j++] = '2';
				resultArr[j++] = '0';
			} else {
				resultArr[j++] = ch;
			}
		}
		return String.copyValueOf(resultArr);
	}
}
