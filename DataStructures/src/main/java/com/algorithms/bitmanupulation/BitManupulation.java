package com.algorithms.bitmanupulation;

import com.datastructures.stack.DecimalToBinary;

public class BitManupulation {

	/*
	 * Bitwise AND: corresponding bits are multiplied to get resulting bit. 0 * 0 = 0; 1 * 0 = 0; 0 * 1 = 0; 1 * 1 = 1. Example: Decimal 3
	 * in binary: 0011 Decimal 5 in binary: 0101 3 & 5 = 0001, which is 1.
	 * 
	 * Usage of Bitwise AND:
	 * 
	 * a) To know if a specific bit is set in a a number, bitwise AND it with a number which has only that bit set. If that bit for result
	 * is set, you know this was set for the number too: 6 & 1 (0110 & 0001) = 0 (0000) => so last bit was not set for number 6.
	 * 
	 * b) Another usage can be to know if a number is even, bitwise AND the number with 1 (0001) and if result is 1, the number was
	 * odd, else even: 6 & 1 (0110 & 0001) = 0 (0000), so 6 is divisible by 2.
	 * 
	 * Bitwise OR: resulting bits will be 0 if neither of the corresponding bits are 1, 1 if either one or both are 1: 2 (0010) | 8 (1000) =
	 * 10 (1010).
	 * 
	 * Exclusive OR (XOR): resulting bits will be 1 if and only of just one of the 2 corresponding bits are 1 and 0 if either both or none
	 * are 1: 5 (0101) ^ 3 (0011) = 6 (0110)
	 * 
	 * Usage of XOR:
	 * 
	 * a) Flip a specific bit: Just XOR the number with a number with that bit as set: 6 (0110) ^ (1000) = (1110) => notice here the 4th bit
	 * got changed from 0 to 1! 8 (1000) ^ (0001) = 1001.
	 * 
	 * Left Shift (<<): 23 (00010111) << 1 = 46 (11101110).
	 * 
	 * Signed Right Shift(>>): Leftmost bit (MSB) being signed bit, this means 1 is used for extension for negative numbers and 0 for
	 * positive ones. Example: -105 (1001 0111) >> 1 = -53 (1100 1011).
	 * 
	 * Note that the way we compute binary to decimal for signed numbers is, ignore MSB (i.e., left most bit, compute decimal equivalent of
	 * remaining and add -128 to it. This is because for signed bytes, number goes from 0 to 127 (positive ones) and then from -128 to 0
	 * (for negative ones). So 10010111 will be computed as: -128 + (1*2^4 + 1*2^2 + 1*2^1 + 1*2^0) = -128 + (16 + 4 + 2 + 1) = -105.
	 * 
	 * Logical Right Shift (>>>): Uses 0 for extension regardless of signed bit (MSB). So -105 (1001 0111) >>> 1 = 75 (0100 1011).
	 */

	public static void main(String[] args) {

		DecimalToBinary dtb = new DecimalToBinary();

		int num = 3;
		System.out.println("number (decinal): " + num);
		System.out.println("number (binary): " + dtb.toBinary(num));

		// Know if number is even or odd
		System.out
				.println("\nHow to know if a number is even? Bitwise AND it with 1, if result is zero then even, else odd.");
		int result1 = num & 1;
		System.out.println("num " + num + " (" + dtb.toBinary(num) + ") & 1 (" + dtb.toBinary(1) + ") = " + result1
				+ ", result "
				+ (result1 == 0 ? "zero, so number divisible by 2" : "not zero, so number not divisible by 2"));

		// Bitwise AND (&) Operation
		int result = 3 & 5;
		System.out.println("\nBitwise AND Operation:");
		System.out.println("3 (" + dtb.toBinary(3) + ") & 5 (" + dtb.toBinary(5) + ") = " + result + " ("
				+ dtb.toBinary(result) + ")");

		// Bitwise OR Operation
		System.out.println("\nOR (|) Operaton:");
		System.out.println("2 (" + dtb.toBinary(2) + ") | 8 (" + dtb.toBinary(8) + ") = " + (2 | 8) + " ("
				+ dtb.toBinary(2 | 8) + ")");

		// XOR (^) opertion
		System.out.println("\nXOR (^) Operaton:");
		System.out.println("5 (" + dtb.toBinary(5) + ") ^ 3 (" + dtb.toBinary(3) + ") = " + (5 ^ 3) + " ("
				+ dtb.toBinary(5 ^ 3) + ")");

		// Flip a specific bit using XOR (^)
		System.out.println("\nFlip a specific bit using XOR (^), 3rd bit in this case:");
		result = 6 ^ 4;
		System.out.println("6 (" + dtb.toBinary(6) + ") ^ 4 (" + dtb.toBinary(4) + ") = " + result + " ("
				+ dtb.toBinary(result) + ")");

		// Signed Left Shift (<<)
		System.out.println("\nSigned Left Shift (a << b) where a gets multilied by 2^b");
		result = 13 << 2;
		System.out.println(13 + " (" + dtb.toBinary(13) + ") << 2 = " + result + " (" + dtb.toBinary(result) + ")");

		// Signed Right Shift (a >> b)
		System.out.println("\nSigned Right Shift (a >> b) where a gets (integer) divided by 2^b");
		result = 36 >> 2;
		System.out.println(36 + " (" + dtb.toBinary(36) + ") >> 2 = " + result + " (" + dtb.toBinary(result) + ")");

		// Logical Right Shift (a >>> b)
		System.out
				.println("\nLogical Right Shift (a >>> b) where a gets (integer) divided by 2^b. \nNegative numbers will become positive since MSB (1) gets pushed to right and new MSB will be 0.");
		result = 36 >>> 2;
		System.out.println(36 + " (" + dtb.toBinary(36) + ") >>> 2 = " + result + " (" + dtb.toBinary(result) + ")");

	}

}
