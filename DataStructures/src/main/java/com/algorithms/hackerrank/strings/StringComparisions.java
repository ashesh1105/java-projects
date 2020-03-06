package main.java.com.algorithms.hackerrank.strings;

import java.util.Scanner;

/**
 * Get inputs for 2 strings and print outputs like this:
 * 
Input:
hello
java

Output:
9	=> sum of lengths of string
No	=> No since hello is not greater than java lexicographically, else it would be Yes
Hello Java	=> Capitalize the words and print them one after another

** Note: When thinking about test case, following must be considered:
1) When A is same in length as B
2) When A is greater than B
3) When A is less than B

 Also check for if either A or B or both of them are empty or null
 *
 */

public class StringComparisions {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		/* Enter your code here. Print output to STDOUT. */
		System.out.println(A.length() + B.length());

		String message = "";
		int lenA = A.length();
		int lenB = B.length();
		int len = lenA > lenB ? lenB : lenA;
		for (int i = 0; i < len; i++) {
			char chA = A.charAt(i);
			char chB = B.charAt(i);
			if (chA > chB) {
				message = "Yes";
				break;
			} else if (chA < chB) {
				message = "No";
				break;
			} else if (i == len - 1) {
				if (lenA == lenB) {
					message = "No";
				} else if (lenA > lenB) {
					message = "Yes";
				} else {
					message = "No";
				}
			} else
				continue;
		}
		// Print Yes or No now
		System.out.println(message);
		
		String newA = A.substring(0, 1).toUpperCase() + A.substring(1);
		String newB = B.substring(0, 1).toUpperCase() + B.substring(1);
		System.out.println(newA + " " + newB);
	}

}
