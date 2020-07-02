package com.algorithms.arrays;

public class NumberSystemConversion {

	public static void main(String[] args) {

		int binary = 101;
		int decimal = 10;

		System.out.println("Binary to decimal for 101 is "
				+ binaryToDecimal(binary));
		System.out.println("Decimal from Binary for integer 10 is: "
				+ Integer.toBinaryString(decimal));
	}

	// Convert decimal to binary
	// In production code you should not use your own algorithm but use
	// standard Java library methods instead, like for this case
	// Integer.toBinaryString(int decimal)
	private static int binaryToDecimal(int binary) {
		int decimal = 0;
		int power = 0;

		while (binary != 0) {
			int lastDigit = binary % 10;
			decimal += lastDigit * Math.pow(2, power);
			power++;
			binary /= 10;
		}
		return decimal;
	}

}
