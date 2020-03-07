package main.java.com.algorithms.puzzles;

import java.math.BigDecimal;

public class DoubleStringMystery {

	public static void main(String[] args) {

		// Below will print 0.899999999999 instead of 0.9!
		System.out.println(2.00 - 1.10);

		/*
		 * You can do like below to get exactly 0.90, but this is not a generic
		 * solution
		 */
		System.out.printf("%.2f%n", 2.00 - 1.10);

		/*
		 * Explanation and solution: The problem with Double.toString conversion
		 * is that the number 1.1 can't be represented exactly as a double, so
		 * it is represented by the closest double value. The program subtracts
		 * this value from 2. Unfortunately, the result of this calculation is
		 * not the closest double value to 0.9. The shortest representation of
		 * the resulting double value is the hideous number that you see
		 * printed.
		 */

		/*
		 * Possible solution: use BigDecimal. Care must be taken to pass String
		 * arguments to BigDecimal, else it will again take the approximation
		 */
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal(
				"1.10")));

		final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
		final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;
		System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);

		System.out.println(12345 + 5432L);

		System.out.println(Long.toHexString(0x100000000L + 0xcafebabe));

		System.out.println((int) (char) (byte) -1);

		char c = 0x000A;
		System.out.println("Printing char for Line Feed 0x000A:");
		System.out.println(c);
		System.out.println("Done printing line feed.");

		// How the heck below is printing X88 ???
		/*
		 * It is because second operand takes the type of first, if it can. In
		 * first expression variable x is printed, so constant 0 doesn't even
		 * matter In second expression since type of first operant is char,
		 * i.e., x (char) and second one has to be printed, char x uses its
		 * ASCII value to send to print command, which is 88! Hence you see the
		 * output as X88 :) Key: never mix types in operands in a ternary
		 * operator!!!!
		 */
		char x = 'X';
		int i = 0;
		System.out.print(true ? x : 0);
		System.out.print(false ? i : x);

		System.out.println("");

		char ch = 0x000A;
		System.out.println(c);
		System.out.println("Done printing line feed again.");

	}

}
