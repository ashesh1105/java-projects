package main.java.com.algorithms;

public class PracticeAlgorithms {

	public static void main(String[] args) {
		
		String str = "-12356012";
		System.out.println("String data: " + str);
		System.out.println("integer data: " + new PracticeAlgorithms().stringToInteger(str));
		
		// Generally, you can do this too
		// System.out.println(Integer.parseInt(str));
		
//		char five = '5';
//		char zero = '0';
//		System.out.println(five - zero);

	}

	public int stringToInteger(String str) {
		
		/*
		 * Check for all boundary conditions:
		 * 1) String can not be null or empty
		 * 2) String can not have non numeric value or '-' char in the middle
		 */
		
		int len = str.length();
		char zero = 48;
		int multiplier = 1;
		int result = 0;
		boolean isNegativeNumber = false;
		
		for (int i = len-1; i>=0; i--) {
			char ch = str.charAt(i);
			if (ch == '-' && i == 0) {
				// Do check at the begining for '-' char in the middle and log an error
				// This will be part of all the boundary condition checks
				isNegativeNumber = true;
				continue;
			}
			int temp = ch - zero;
			result += (int) (temp * multiplier);
			multiplier *= 10;
		}
		if (isNegativeNumber) {
			result = 0 - result;
		}
		return result;
	}

}
