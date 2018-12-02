package com.algorithms.string;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/*
 * This cool algo to check if characters of this string can be rearranged as palindrome. Basically make sure 
 * every character is repeated even number of times and no more than one character appears in the string for 
 * odd number of time.
 */

public class PalindromePermutations {

	public static void main(String[] args) {
		
		String str = "aabbccc";
		
		System.out.println("The string " + str + (isPermutationsOfPalindrome(str) ? " can be" : " can not be") + " rearranged as palindrome.");

	}

	private static boolean isPermutationsOfPalindrome(String str) {
		
			// Check for quick return cases
			if (StringUtils.isEmpty(str)) {
				System.out.println("String is null.");
				return false;
			}
			
			// One character can always be a palindrome
			if (str.length() == 1) {
				return true;
			}
			
			Map<Character, Boolean> map = new HashMap<Character, Boolean>();
			
			// Populate the map with characters of string and value as false
			for (int i=0; i<str.length(); i++) {
				map.put(str.charAt(i), false);
			}
			
			// Now iterate through string again and flip the value of keys from false to true or vice versa
			for (int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				map.put(ch, !map.get(ch));
			}
			
			// Iterate through map and find out how many characters are repeated odd number of times, i.e., has value as true here
			// Example, if 'c' is repeated 3 times, its value became: 1) false -> true 2) true -> false 3) false -> true (finally true)
			int count = 0;
			for (Boolean value : map.values()) {
				if (value) count++;
			}
		
		// Check if more than one character is repeated odd number of times, string is a permutation of palindrome otherwise
		if (count > 1) return false;
		else return true;
	}

}
