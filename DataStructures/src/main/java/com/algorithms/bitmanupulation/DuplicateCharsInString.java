package main.java.com.algorithms.bitmanupulation;

public class DuplicateCharsInString {

	/*
	 * Great way to find if a string has duplicate characters or even remove the duplicate characters
	 */

	public static void main(String[] args) {

		String str = "abcdefabcdxyza";

		System.out.println("String " + str + " has duplicate characters? : "
				+ new DuplicateCharsInString().hasDuplicateChars(str));

		System.out.println("String " + str
				+ " with its duplicate characters removed, will become: "
				+ new DuplicateCharsInString().removeDuplicateChars(str));

	}

	public boolean hasDuplicateChars(String str) {

		int checker = 0;
		for (int i = 0; i < str.length(); i++) {

			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) != 0)
				return true;
			checker |= 1 << val;
		}

		return false;
	}

	/*
	 * This is good from O(n) perspective but check StringManipulation.removeDuplicatesWithTail() method in
	 * com.datastructures.string package, that has better performance by order of magnitude! Why so??
	 */
	public String removeDuplicateChars(String str) {

		int checker = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int val = ch - 'a';
			if ((checker & (1 << val)) == 0) {
				sb.append(ch);
				checker |= 1 << val;
			} else {
				continue;
			}
		}

		return sb.toString();
	}

}
