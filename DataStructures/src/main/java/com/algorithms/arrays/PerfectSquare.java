package com.algorithms.arrays;

public class PerfectSquare {

	/*
	 * Given a number N, find out if this is a perfect square
	 */

	public static void main(String[] args) {

		int n = 49;
		System.out.println("Number " + n + " is "
				+ (new PerfectSquare().isPerfectSquare2(n) ? "a perfect square." : "not a perfect square."));
	}

	/*
	 * Performance will be O(sqrt(n)), which is not bad.
	 */
	public boolean isPerfectSquare1(int n) {

		boolean result = false;

		if (n < 0) {
			System.out.println("ERROR: Invalid argument as negative number.");
			return false;
		}

		if (n == 1 || n == 0) {
			System.out.println("There is no point checking 1 or 0 as perfect square.");
			return false;
		}

		for (int i = 2; i * i <= n; i++) {
			if (i * i == n) {
				result = true;
				break;
			}
		}

		return result;
	}

	/*
	 * if we keep adding next odd number to 1 incrementally, we will continue getting the next perfect square! Its like 1 + 3 = 4; 4 + 5 =
	 * 9; 9 + 7 = 16 and so on! Performance will be O(sqrt(n)), which is not bad.
	 */
	public boolean isPerfectSquare2(int n) {

		if (n < 0) {
			System.out.println("ERROR: Invalid argument as negative number.");
			return false;
		}

		if (n == 1 || n == 0) {
			System.out.println("There is no point checking 1 or 0 as perfect square.");
			return false;
		}

		boolean result = false;

		int increment = 2;
		int nextOddNumber = 1;
		int numberToCompare = 1;

		while (numberToCompare <= n) {

			nextOddNumber += increment;
			numberToCompare += nextOddNumber;
			if (numberToCompare == n) {
				result = true;
			}
		}

		return result;
	}
}
