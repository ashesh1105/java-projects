package main.java.com.algorithms;

import main.java.com.algorithms.interfaces.ReverseIntegerAlgo;

public class ReverseIntegerClient {

	/*
	 * Notice Strategy pattern being used here where we are managing various algorithm implementations of reversing an integer and client
	 * has the flexibility of choosing one implementation and can plug in any more optimized one once ready. This is ideal for gaming algos
	 * as well where algos can be changed at run time based on difficultly levels one needs.
	 */

	ReverseIntegerAlgo reverseIntegerAlgo;

	public void setReverseIntegerAlgo(ReverseIntegerAlgo revInt) {
		reverseIntegerAlgo = revInt;
	}

	public ReverseIntegerAlgo getReverseIntegerAlgo() {
		return reverseIntegerAlgo;
	}

	public static void main(String[] args) {

		int num = -123;
		ReverseIntegerClient rvClient = new ReverseIntegerClient();
		rvClient.setReverseIntegerAlgo(new ReverseInteger2());

		System.out.println("Reverse of num " + num + " is: " + rvClient.reverseIntegerAlgo.reverseInteger(num));
	}
}

class ReverseInteger1 implements ReverseIntegerAlgo {

	@Override
	/*
	 * I needed a temp string in this method, which I then converted to number. See next method below for better one.
	 */
	public int reverseInteger(int num) {

		if (num == 0)
			return 0;
		int result = 0;
		boolean isNegative = num < 0 ? true : false;
		if (isNegative)
			num *= -1;
		int multiplier = 1;

		// Get the reversed number as string first
		String temp = "";
		while (num != 0) {
			temp = temp + num % 10;
			num /= 10;
		}

		// Now convert string to integer
		int len = temp.length();
		for (int i = len - 1; i >= 0; i--) {
			char ch = temp.charAt(i);
			int digit = ch - 48;
			result += digit * multiplier;
			multiplier *= 10;
		}

		if (isNegative)
			result = result * -1;
		return result;
	}

}

class ReverseInteger2 implements ReverseIntegerAlgo {

	@Override
	/*
	 * Optimized one as this does not need temporary storage of reverse of number. This directly converts number to reverse number.
	 * Underlying theory is, say you have a number 23, how will you add an extra digit at the end, say 4? You'll multiply it by 10 (i.e.,
	 * promote the current unit digit to 10th place) and then add the new digit to it. That'll be 23 * 10 + 4 = 234!
	 */
	public int reverseInteger(int num) {
		if (num == 0)
			return 0;
		int result = 0;
		boolean isNegative = num < 0 ? true : false;
		if (isNegative)
			num *= -1;
		int lastDigit = 0;

		while (num != 0) {
			lastDigit = num % 10;
			result = result * 10 + lastDigit;
			num /= 10;
		}

		if (isNegative)
			result = result * -1;
		return result;
	}

}
