package main.java.com.string;

import org.apache.commons.lang3.StringUtils;

public class Palindrome {

	/*
	 * A palindrome is a string which when reversed, reads the same. E.g. "aba", "11211"
	 */

	public static void main(String[] args) {

		String str = "ababa";
		String str1 = "rats live on no evil star";
		System.out.println("The string \"" + str1 + "\" is "
				+ (new Palindrome().isPalindrome1(str1) ? "palindrome." : "not palindrome."));

	}

	/*
	 * Compare the characters equi-distant from both ends and if you reach the middle, string is a palindrome.
	 */
	public boolean isPalindrome1(String str) {

		// Check for quick return cases
		if (StringUtils.isEmpty(str)) {
			System.out.println("String is null.");
			return false;
		}

		if (str.length() == 1) {
			return true;
		}
		
		int len = str.length();

		for (int i = 0, j = len - 1; i <= j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}

		return true;
	}

}
