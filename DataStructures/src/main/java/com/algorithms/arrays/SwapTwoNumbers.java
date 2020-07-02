package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class SwapTwoNumbers {

	/*
	 * Swap two variables without using any temporary variable
	 */

	public static void main(String[] args) {

		int a = 3;
		int b = 6;
		System.out.println("Originally a was " + a + " and b was " + b);

		List<Integer> resultList = new SwapTwoNumbers().swapTwoNumbersWithoutUsingTempVariable3(a,
				b);
		System.out
				.println("After swap, a = " + resultList.get(0) + " and b = " + resultList.get(1));

	}

	/*
	 * Swap two numbers without using temp variable by addition and subtractions
	 */
	public List<Integer> swapTwoNumbersWithoutUsingTempVariable1(int a, int b) {

		List<Integer> result = new ArrayList<Integer>();

		a = a + b; // a becomes 30 if it was 10 and b was 20
		b = a - b; // b now becomes 10
		a = a - b; // a becomes 20

		result.add(a);
		result.add(b);

		return result;
	}

	/*
	 * Swap two numbers without using temp variable by multiplication and divisions
	 */
	public List<Integer> swapTwoNumbersWithoutUsingTempVariable2(int a, int b) {

		List<Integer> result = new ArrayList<Integer>();

		a = a * b; // a becomes 200 if it was 10 and b was 20
		b = a / b; // b now becomes 10
		a = a / b; // a becomes 20

		result.add(a);
		result.add(b);

		return result;
	}

	/*
	 * Most efficient method to swap two numbers without temp variable by using bit wise OR operator if a = 2
	 * and b = 4, bits for a and b will be: 0010 and 0100, so a^b = 0110 (Remember, 0 ^ 1 will be 1, 1 ^ 0
	 * will be 1 but 1 ^ 1 will be 0 and 0 ^ 0 will be 0. This is how bit wise or exclusive Or (Xor) works.
	 */
	public List<Integer> swapTwoNumbersWithoutUsingTempVariable3(int a, int b) {

		List<Integer> result = new ArrayList<Integer>();

		a = a ^ b; // a becomes 6 if it was 2 and b was 4 (0010 ^ 0100 = 0110)
		b = a ^ b; // b now becomes 2 (0110 ^ 0100 = 0010)
		a = a ^ b; // a becomes 4 (0110 ^ 0010 = 0100)

		result.add(a);
		result.add(b);

		return result;
	}
}
