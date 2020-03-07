package main.java.com.string;

import org.apache.commons.lang3.StringUtils;

public class ValidInput {
	/**
	 * You're getting string inputs from a source in a way that strings have a number at the end that
	 * represents the length of the string. In some cases this may not be true and those will be invalid inputs
	 * Take an input and state whether it is valid or not
	 * Example:
	 * Valid inputs: abcd4, xyz3, tombmon7, abcdefghijklmnopqrstuvwxyz26
	 * Invalid Inputs: abcd5, abcde, tomb543, etc.
	 */

	public static void main(String[] args) {
		
		String input = "abc3";
		
		System.out.println("The input " + input + (isValidInput(input) ? " is valid." : " is invalid"));

	}

	private static boolean isValidInput(String input) {
		
		boolean result = false;
		
		if (StringUtils.isEmpty(input)) {
			System.out.println("Input is either null or empty.");
			return false;
		}
		// Length 1 for input will mean an invalid string (it'll have a char, no number or vice versa)
		if (input.length() == 1) {
			return false;
		}
		
		// If input is of length 2, check if there's "1" at the end
		// *** We don't need to do it since associatedNumber will become 1 which we check at the end
//		if (input.length() == 2) {
//			if (Integer.valueOf(input.substring(1)) == 1) return true;
//			else return false;
//		}
		
		int associatedNumber = 0;
		int multiplier = 1;
		
		for (int i=input.length()-1; i>=0; i--) {
			char ch = input.charAt(i);
			// For this character to be numeric
			// Taking advantage of ascii value for '0' and '9' as 48 and 57 respectively
			if (48 <= ch && ch <= 57) {
				associatedNumber += (ch - 48) * multiplier;
				multiplier *= 10;
			} else {
				break;
			}
		}
		
		System.out.println("associatedNumber " + associatedNumber);
		
		if (associatedNumber != 0) {
			if (associatedNumber == (input.length() - Integer.toString(associatedNumber).length())) {
				result = true;
			}
		}
		return result;
	}

}
