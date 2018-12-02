package com.algorithms.string;

public class LongestCommonSubstring {

	/**
	 * Given two strings ‘X’ and ‘Y’, find the length of the longest common
	 * substring. For example, if the given strings are “inyahooisthebest” and
	 * “Iworkinyahoo”, the output should be 5 as longest common substring is
	 * “yahoo” .
	 */

	public static void main(String[] args) {

		String str1 = "inyahooisthebest";
		String str2 = "Iworkinyahoo";

		System.out
				.println("Length of largest common substrings of \"inyahooisthebest\" and \"Iworkinyahoo\" is: "
						+ new LongestCommonSubstring()
								.largestCommonSubstringOptimized1(str1, str2));
	}

	/**
	 * Below method is a brute force solution. Time complexity will be O(n^2).
	 * Use the optimized one below.
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	private String largestCommonSubstring(String str1, String str2) {

		int len1 = str1.length();
		int len2 = str2.length();
		String result = null;
		int lenSubstring = 0;

		for (int i = 0; i < len1; i++) {
			if (str2.contains(Character.toString(str1.charAt(i)))) {
				int endIndex = i + 1;
				while (endIndex <= len1) {
					if (str2.contains(str1.substring(i, endIndex))) {
						endIndex++;
						continue;
					} else
						break;
				}
				endIndex--;
				String temp = str1.substring(i, endIndex);
				int tempLen = temp.length();
				if (lenSubstring < tempLen) {
					lenSubstring = tempLen;
					result = temp;
				}
			}

		}
		return result;
	}

	/**
	 * Here, time complexity will be of O(n). We need a storage of 256
	 * characters but that should not be the big deal
	 * Solution: 
	 * a) Define an int array of size 256. It can be 128 if pure ascii is contained by strings 
	 * b) Initialize array by -1 for each elements. You can avoid this step if can come with
	 *    special index for index 0 for str1 
	 * c) loop through each chars of str1 and store their indices in array. Index of array will
	 *    be ascii values of str1 chars 
	 * d) Loop through str2 chars, check if a char is present in str1, if not continue checking
	 * e) If chars match, save the position of char position and define another variable to check subsequent substrings 
	 * f) Do a while loop to keep checking how far we can go, i.e., how large of substring is common from position we saved 
	 * g) when while loop exits, check length of substring found, get to max one
	 *    and store the resulting string to return
	 */
	private String largestCommonSubstringOptimized1(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		String result = null;
		int lenSubstring = 0;

		int[] arr = new int[256];
		for (int elem : arr) {
			elem = -1;
		}

		for (int i = 0; i < len1; i++) {
			arr[str1.charAt(i)] = i;
		}

		for (int j = 0; j < len2; j++) {
			int beginIndex = -1;
			if (arr[str2.charAt(j)] == -1) {
				continue;
			} else {
				beginIndex = j;
				int endIndex = j + 1;
				while (endIndex <= len2) {
					if (str1.contains(str2.substring(beginIndex, endIndex))) {
						endIndex++;
					} else {
						break;
					}
				}
				endIndex--;
				String temp = str2.substring(beginIndex, endIndex);
				int tempLen = temp.length();
				if (lenSubstring < tempLen) {
					lenSubstring = tempLen;
					result = temp;
				}
			}
		}
		return result;
	}

}
