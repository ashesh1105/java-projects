package main.java.com.string;

import org.apache.commons.lang3.StringUtils;

public class ReverseStringButSpecialChars {

	/**
	 * Given a string, that contains special character together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’), reverse the 
	 * string in a way that special characters are not affected.
	 * Example:
	 * Input:   str = "a,b$c"
	 * Output:  str = "c,b$a"
	 * Note that $ and , are not moved anywhere.  
	 * Only subsequence "abc" is reversed
     *
	 * Input:   str = "Ab,c,de!$"
	 * Output:  str = "ed,c,bA!$"
	 */

	public static void main(String[] args) {
		
		ReverseStringButSpecialChars reverseStringButSpecialChars = new ReverseStringButSpecialChars();
		
		String str1 = "a,b$c";
		System.out.println("Reverse of string " + str1 + ": " + reverseStringButSpecialChars.reverse(str1));
		
		String str2 = "Ab,c,de!$";
		System.out.println("Reverse of string " + str2 + ": " + reverseStringButSpecialChars.reverse(str2));
		
		String str3 = "a!!!b.c.d,e'f,ghi";
		System.out.println("Reverse of string " + str3 + ": " + reverseStringButSpecialChars.reverse(str3));
	}

	private String reverse(String str) {
		
		if (StringUtils.isEmpty(str)) {
			System.out.println();
			throw new RuntimeException("Please pass a non null and non empty string.");
		}
		char [] arr = str.toCharArray();
		int len = arr.length;
		int i=0;
		int j = len-1;
		
		while (i<j) {
			// Check if character is an alphabet, skip that one otherwise
//			while (!('A' <= arr[i] && arr[i] <= 'Z') && !('a' <= arr[i] && arr[i] <= 'z')) {
//				i++;
//			}
//			while (!('A' <= arr[j] && arr[j] <= 'Z') && !('a' <= arr[j] && arr[j] <= 'z')) {
//				j--;
//			}
			// Above commented line is good but can be simplified by this
			while(!Character.isAlphabetic(arr[i])) {
				i++;
			}
			while (!Character.isAlphabetic(arr[j])) {
				j--;
			}
			// Now you can swap if i still is less than j
			if (i<j) {
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			// Don't forget to move i & j
			i++;
			j--;
		}
		
		return new String(arr);
	}

}
