package com.algorithms.string;

public class Anagram1 {

	/**
	 * Anagrams are where characters of a string can be rearranged to form another one.
	 *
	 * We convert string to char array, we can sort them in nlogn time and check if both the strings are equal (easy)
	 * We will consider that characters of the string are all ASCII.
	 *
	 * The implementation in this class uses an int array of size 128 / 256 to find all the characters of first
	 * string with number of occurrences and then compares that with second string. int arrays get initialized to
	 * zero for all its elements.
	 *
	 * So, approach with this class will take Big O(n).
	 *
	 * Note:: If you want to check for case insensitive anagrams, change char to Character.toLowerCase(char) and proceed
	 */
	public boolean isAnagram(String str1, String str2) {
		// if the lengths are not equal, they definitely cannot be anagrams
		if (str1.length() != str2.length())
			return false;

		int[] charSet = new int[128];
		int numOfUniqueChars = 0;
		int numCompletedInStr2 = 0;
		char[] chars = str1.toCharArray();

		for (char c : chars) { // count number of each char in str1
			if (charSet[c] == 0)
				++numOfUniqueChars;
			++charSet[c];
		}
		// The basic idea here is to go through all the characters of
		// str2 now, and if this char is not present (count in charSet is zero), it is not an anagram
		// otherwise we reduce the count for that character in the charSet array.
		// If you don't understand the code below, I suggest that you step through it using a debugger.
		// It's not very difficult to understand if you do that.
		for (int i = 0; i < str2.length(); i++) {

			// If you want to find case insensitive anagrams, simple do c = Character.toLowerCase(c); after below line!
			int c = str2.charAt(i);
			if (charSet[c] == 0) { // More of character 'c' in str2 than in str1
				return false;
			}
			--charSet[c]; // reduce the count
			// You can pretty much end the loop here and return true at the end. Below part is for more efficiency.
			if (charSet[c] == 0) {
				++numCompletedInStr2;
				if (numCompletedInStr2 == numOfUniqueChars) {
					// it's a match if str2 has been processed completely
					return i == str2.length() - 1;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
//		System.out.println(isAnagram("ABABABC", "BABABADDP"));
		System.out.println(new Anagram1().isAnagram("daniel clowes", "enid coleslaw"));
		System.out.println(new Anagram1().isAnagram("Hello", "hello"));
	}

}
