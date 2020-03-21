package com.algorithms.puzzles;

public class OddityCheck {

	public static void main(String[] args) {

		int i = -121;
		System.out.println("Number " + i
				+ (isOdd(i) ? " is odd number" : " is not an odd number"));

	}

	private static boolean isOdd(int i) {

		/*
		 * Don't do the commented out return as for negative number i % 2 will
		 * be -1, so method will never return true!
		 */
		// return i % 2 == 1;
		return i % 2 != 0;

		/*
		 * For performance critical operations, use below:
		 * 
		 * return (i & 1) != 0;
		 * 
		 * 0; Bitwise And will compare last digit of binary form of i with
		 * binary 1, so for i as even, it will give false ( 0 & 1) and for odd
		 * number i, it will give 1 & 1 (true and true), so true.
		 */

		/*
		 * The second version may run much faster than the first, depending on
		 * what platform and virtual machine you are using, and is unlikely to
		 * run slower. As a general rule, the divide and remainder operations
		 * are slow compared to other arithmetic and logical operations. It's a
		 * bad idea to optimize prematurely, but in this case, the faster
		 * version is as clear as the original, so there is no reason to prefer
		 * the original. In summary, think about the signs of the operands and
		 * of the result whenever you use the remainder operator. The behavior
		 * of this operator is obvious when its operands are nonnegative, but it
		 * isn't so obvious when one or both operands are negative.
		 */
	}

}
