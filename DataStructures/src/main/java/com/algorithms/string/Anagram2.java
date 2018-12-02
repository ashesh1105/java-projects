package com.algorithms.string;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class Anagram2 {

	public static void main(String[] args) {

		String str1 = "1234567891011121314151617181920";
		String str2 = "2019181716151413121110987654321";

		// String str1 = "abcd";
		// String str2 = "dbac";

		// String str1 = "aaab";
		// String str2 = "bbba";

		System.out.println("Checking if str1 " + str1 + " str2 " + str2
				+ " are anagrams");

		// Start the timer for Anagram1
		long start1 = System.nanoTime();

		System.out.println("Result: " + new Anagram1().isAnagram(str1, str2));

		// End the timer for Anagram2
		long end1 = System.nanoTime();

		// Start the timer for Anagram2
		long start2 = System.nanoTime();

		System.out.println("Result: " + new Anagram2().isAnagram(str1, str2));

		// End the timer
		long end2 = System.nanoTime();

		// Print time taken in 2 ways of checking Anagrams and compare them!

		System.out.println("Time taken to compute Anagram1 method: "
				+ (end1 - start1));
		System.out.println("Time taken to compute Anagram2 method: "
				+ (end2 - start2));
	}

	/*
	 * Below method can be further improvised by using a integer array of size equal
	 * to pure ASCII chars (128) or extended ASCII chars (256)
	 */
	public boolean isAnagram(String str1, String str2) {

		// If either of 2 strings are null or empty, return false
		if (StringUtils.isEmpty(str1) || StringUtils.isEmpty(str2)) {
			System.out
					.println("Both strings need to be not null or empty. They are not anagrams.");
			return false;
		}

		// If both strings are not of same lengths, return false
		int len1 = str1.length();
		int len2 = str2.length();
		if (len1 != len2) {
			System.out
					.println("Both strings need to be of same lengths. They are not anagrams.");
			return false;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		// Add chars of str1 into map
		for (int i = 0; i < len1; i++) {
			char ch = str1.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		// Iterate through characters of str2, return false if str2 characters
		// are not in map. If they are, decrement the count if count > 2, else remove them
		for (int i = 0; i < len2; i++) {
			char ch = str2.charAt(i);
			if (!map.containsKey(ch)) {
				return false;
			} else {
				int val = map.get(ch);
				if (val == 1) map.remove(ch);
				else map.put(ch, map.get(ch) -1);
			}
		}
		
		if (map.size() != 0) {
			return false;
		}
		return true;
	}

}
