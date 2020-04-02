package com.datastructures.stack;

import java.util.Stack;

public class DecimalToBinary {

	public static void main(String[] args) {
		
		int a = 368;
		int b = 1;
		
		DecimalToBinary dtb = new DecimalToBinary();
		
		System.out.println("a (" + a + ") in binary = " + dtb.toBinary(a));
		System.out.println("b (" + b + ") in binary = " + dtb.toBinary(b));


		System.out.println("a & (bitwise And) b = " + (a & b));
		
		/**
		 * Above can be used as a check for even / odd number which can run the check with negative number
		 * as well. a & b where a is any number (including negative) and b is 1 (with binary equivalent
		 * as 1, will yield 0 for even numbers and 1 for odd number since "&" is bitwise And operator which
		 * executes And at bit level and for decimal 1, binary equivalent is also 1. Binary eqivalent
		 * of an even number will always have a 0 and for odd number, a 1 at right most digit.
		 * e.g., 17 & 1 = 1 (in binary) and 322 & 1 = 0 (in binary)
		 */

	}

	public String toBinary(int number) {
		Stack digits = new Stack();
		int base = 2;
		do {
			digits.push(number % base);
			number /= base;
			
		} while (number != 0);
		
		int size = digits.size();
		
		while (size < 4) {
			digits.push(0);
			size++;
		}

		StringBuilder binaryDigit = new StringBuilder();
		while (!digits.empty()) {
			binaryDigit.append(digits.peek());
			digits.pop();
		}
		
		return binaryDigit.toString();
	}
}
