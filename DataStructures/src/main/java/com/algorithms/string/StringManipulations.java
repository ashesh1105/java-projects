package main.java.com.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import main.java.com.algorithms.bitmanupulation.DuplicateCharsInString;

public class StringManipulations {

	public static void main(String[] args) {

		System.out.println("Enter a string to begin with:\n");
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		scanner.close();
		System.out.println("The string has unique characters? : "
				+ hasAllUniqueCharsOptimized(text));
		System.out.println("Your entered String was: " + text);
		System.out.println("Reverse of entered string is: " + reverse(text));

		System.out.println("Is this string a palindrome? " + isPalindrome(text));

		// Tried removing duplicates from String using 4 methods below.
		// Conclusion seems to be that String based method is fastest among 4 of
		// them below.
		// To be checked more..

		long start1 = System.nanoTime();

		// Remove duplicates using String based method
		System.out.println("\nRemoved duplicates using String based method: "
				+ removeDuplicates(text));
		long end1 = System.nanoTime();

		System.out.println("Time taken to remove duplicates with String based method: "
				+ (end1 - start1));

		long start2 = System.nanoTime();

		// Remove duplicates using StringBuilder based method
		System.out.println("\nRemoved duplicates using StringBuilder based method: "
				+ removeDuplicatesWithStringBuilder(text));

		long end2 = System.nanoTime();

		System.out.println("Time taken to remove duplicates with StringBuilder based method: "
				+ (end2 - start2));

		long start3 = System.nanoTime();

		// Remove duplicates using Set based method
		System.out.println("\nRemoved duplicates using Set based method: "
				+ removeDuplicatesWithSet(text));

		long end3 = System.nanoTime();

		System.out.println("Time taken to remove duplicates with Set based method: "
				+ (end3 - start3));

		// Remove duplicates using Map based method
		long start4 = System.nanoTime();
		System.out.println("\nRemoved duplicates using Map based method: "
				+ removeDuplicatesWithMap(text));
		long end4 = System.nanoTime();
		System.out.println("Time taken to remove duplicates with Map based method: "
				+ (end4 - start4));

		// Remove duplicates using "tail" based method
		long start5 = System.nanoTime();
		System.out.println("\nRemoved duplicates using 'tail' based method: "
				+ removeDuplicatesWithTail(text));
		long end5 = System.nanoTime();
		System.out.println("Time taken to remove duplicates with 'tail' based method: "
				+ (end5 - start5));

		// Remove duplicates using bit manipulation based method
		long start6 = System.nanoTime();
		System.out.println("\nRemoved duplicates using bit manipulation based method: "
				+ new DuplicateCharsInString().removeDuplicateChars(text));
		long end6 = System.nanoTime();
		System.out.println("Time taken to remove duplicates with bit manipulation based method: "
				+ (end6 - start6));

		// Sort the characters of a string and hence create an anagram
		System.out.println("\nSorted entered string is: " + sortString(text));

		// Check if two strings are anagrams, one from program and another one
		// entered by user
		String text1 = "acdbfe";
		if (sortString(text).equalsIgnoreCase(sortString(text1))) {
			System.out.println("\nStrings are equal");
		} else
			System.out.println("\nStrings are not equal");

		// Replace spaces in a string by %20
		System.out.println("\nNew String with spaecs replaced by %20 is: "
				+ replaceSpaceByPercent20(text));

		// Check if Strin2 is a rotation of String1:
		String text2 = "apple";
		String text3 = "pleapp";
		System.out.println("\nString " + text2 + " is a rotation of String " + text3 + " : "
				+ isRotation(text2, text3));

		/*
		 * boolean [] charSet = new boolean[256];
		 * System.out.println("Default of boolean as initiatilized in an array is: " + charSet[10]);
		 */
	}

	// find if String is unique or not
	private static boolean hasAllUniqueChars(String text) {
		char[] ch = text.toCharArray();
		int size = ch.length;

		for (int i = 0; i < size; i++) {
			for (int k = 1; k < size; k++) {
				if (ch[i] == ch[k] && (i != k)) {
					return false;
				}
			}
		}

		return true;
	}

	// find if String us unique or not - more efficient method!
	private static boolean hasAllUniqueCharsOptimized(String text) {
		boolean[] charSet = new boolean[256];
		// get the chars from text, use them as index to set such elements of
		// charSet to true. If there are duplicates, condition will evaluate to
		// true and return false, else return true
		int len = text.length();
		for (int i = 0; i < len; i++) {
			int val = text.charAt(i);
			if (charSet[val])
				return false;
			charSet[val] = true;
		}
		return true;
	}

	// Reverse the characters of a String
	private static String reverse(String text) {
		int len = text.length();
		StringBuilder sb = new StringBuilder();
		for (int i = len - 1; i >= 0; i--) {
			sb.append(text.charAt(i));
		}
		return sb.toString();
	}

	// Remove duplicates from a string using a result string
	private static String removeDuplicates(String word) {
		String result = "";
		int len = word.length();
		char[] charArr = word.toCharArray();
		for (char ch : charArr) {
			if ((result.indexOf(ch) == -1)) {
				result = result + ch;
			}
		}
		return result;
	}

	// Remove duplicates using StringBuilder
	private static String removeDuplicatesWithStringBuilder(String word) {
		StringBuilder result = new StringBuilder();
		int len = word.length();
		for (int i = 0; i < len; i++) {
			// get character at index i in String form since StringBuilder.indexOf takes a String (below)
			String si = word.substring(i, i + 1);
			if (result.indexOf(si) == -1) {
				result.append(si);
			}
		}
		return result.toString();
	}

	// Remove duplicates using StringBuilder
	// This takes 10 times more time compared to above method!!! Never use it!!!
	private static String removeDuplicatesWithSet(String word) {
		Set<Character> set = new LinkedHashSet<Character>();
		StringBuilder sb = new StringBuilder();
		for (char ch : word.toCharArray()) {
			set.add(ch);
		}
		for (Character c : set) {
			sb.append(c);
		}
		return sb.toString();
	}

	// Remove duplicates using HashMap's containsValue(<T>) method
	private static String removeDuplicatesWithMap(String word) {
		Map<Integer, Character> map = new HashMap<Integer, Character>();
		StringBuilder sb = new StringBuilder();
		for (Character ch : word.toCharArray()) {
			if (!map.containsValue(ch)) {
				map.put(ch.hashCode(), ch);
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	// Remove duplicates using HashMap's containsValue(<T>) method
	// Note that here we aren't declaring any other buffer at all
	// and only declaring one fixed size character array
	private static String removeDuplicatesWithTail(String word) {
		char[] charArray = word.toCharArray();
		int len = word.length();
		int tail = 1;
		int j = 0;
		for (int i = 1; i < len; i++) {
			for (j = 0; j < tail; j++) {
				if (charArray[i] == charArray[j])
					break;
			}
			if (j == tail) {
				charArray[tail] = charArray[i];
				tail++;
			}
		}
		return new String(charArray, 0, tail);
	}

	// Conclusion seems to be that "tail" based method is fastest among above 5
	// above
	// And Set Based Method seems to be more than 10 times slow! Never use it!
	// Map based
	// duplicate removal seems to be next slowest in the line so avoid that
	// also.

	// Create an anagram by sorting the characters of a string
	private static String sortString(String text) {
		char[] charArray = text.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	// Replace spaces in a string by %20
	private static String replaceSpaceByPercent20(String text) {
		StringBuilder sb = new StringBuilder();

		for (char c : text.toCharArray()) {
			if (c == ' ')
				sb.append("%20");
			else
				sb.append(c);
		}
		return sb.toString();
	}

	// Test rotation of string, concat the string with itself and see if it contains the second one
	private static boolean isRotation(String str1, String str2) {

		return str1.concat(str1).contains(str2);

	}

	// Test for palindrome without declaring any other storage
	private static boolean isPalindrome(String str) {
		int n = str.length();
		for (int i = 0; i < n / 2; i++) {
			if (str.charAt(i) != str.charAt(n - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
