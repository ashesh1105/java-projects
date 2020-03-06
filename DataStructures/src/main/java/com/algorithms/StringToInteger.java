package main.java.com.algorithms;

public class StringToInteger {

	/*
	 * You’re given a string of ASCII characters, convert them into the integer
	 * equivalent. "12345" = 12,345 "987" "-474" = -474 47-4 "5858-37835" =
	 * 37,835 "8-9" = 9 8ab7 ,&,% 123e10
	 */
	// return 0 means there was '-' character in input string after 1st position
	public int convertStringToInteger(String input) {
		
		/*
		 * Check for all boundary conditions:
		 * 1) String can not be null or empty
		 * 2) String can not have non numeric value or '-' char in the middle
		 */

		char[] charArrInput = input.toCharArray();
		int len = charArrInput.length;
		int result = 0;
		int multiplier = 1;

		for (int i = (len - 1); i >= 0; i--) {

			char ch = charArrInput[i];
			if (ch != '-') {
				result += (ch - '0') * multiplier;
				multiplier *= 10;
			} else if ((ch == '-') && (i == 0)) {
				result = 0 - result;
			} else {
				break; // break to return the results so far
			}
		}
		return result;
	}

}
