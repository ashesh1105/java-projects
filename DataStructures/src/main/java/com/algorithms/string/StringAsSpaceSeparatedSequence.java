package com.algorithms.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAsSpaceSeparatedSequence {

	/*
	 * Given a string s and a dictionary of words dict, determine if str can be segmented into a space separated
	 * sequence of one or more dictionary words.
	 * 
	 * Example: s = "leetcode", dict = ["mine", "leet", "code", "done"], return true because s can be segmented as
	 * "leet code"
	 */

	public static void main(String[] args) {

		String str = "abcdspdf";
		String[] dict = { "mn", "trp", "vkg", "ab", "cds", "pdf", "glmn", "olt" };
		// boolean result = new StringAsSpaceSeparatedSequence().areSubStringsPresentInSequence(str, dict);
		//
		// System.out.print("String " + str + (result ? " can " : " can not ")
		// + "be segmented as space separated sequence of one of more dictionary words from: ");
		// for (String dictWords : dict) {
		// System.out.print(dictWords + " ");
		// }

		new StringAsSpaceSeparatedSequence().subStringsPresentInSequenceAnotherWay(str, dict);

	}

	private boolean areSubStringsPresentInSequence(String str, String[] dict) {

		// TBD: Do null and other boundary condition checks

		boolean result = false;

		int nextIndexExpecteddInStr = 0;

		StringBuilder resultString = new StringBuilder();

		for (int i = 0; i < dict.length; i++) {

			String element = dict[i];
			int posInStr = str.indexOf(element);

			if (posInStr == -1)
				continue;

			if (posInStr != nextIndexExpecteddInStr)
				return result;

			nextIndexExpecteddInStr += element.length();

			// Save this element
			resultString.append(element).append(" ");
		}

		if (nextIndexExpecteddInStr == str.length())
			result = true;

		System.out.println("\"" + resultString.toString().trim() + "\"");
		return result;
	}

	public List<String> subStringsPresentInSequenceAnotherWay(String str, String[] arr) {

		// TODO: boundary condition checks: 1) null check, 2) Empty checks

		List<String> result = new ArrayList<>();
		for (String input : arr) {
			if (str.indexOf(input) != -1) {
				result.add(input);
			}
		}

		StringBuilder sb = new StringBuilder();
		if (result.size() == 0) {
			// log error
			System.out.println("No elements of the array are a substring of given String " + str);
			return null;
		} else {
			result.forEach(elem -> sb.append(elem));
			if (!(sb.toString().compareTo(str) == 0)) {
				// log error
				System.out.println("String " + str + " can not be " + "segmented based on 1 or more space separated elements of array:");
				return null;
			}
		}
		System.out.println("String " + str + " can be " + "segmented based on 1 or more space separated elements of array:");
		System.out.print("[");
		Arrays.asList(arr).forEach(elem -> System.out.print(elem + " "));
		System.out.print("]" + " as: \n");
		result.forEach(elem -> System.out.print(elem + " "));

		return result;
	}

}
