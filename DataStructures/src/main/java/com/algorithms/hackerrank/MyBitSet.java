package com.algorithms.hackerrank;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Java's BitSet class implements a vector of bit values (i.e.: false (0) or true (1)) that grows as needed, allowing us
 * to easily manipulate bits while optimizing space (when compared to other collections). Any element having a bit value
 * of is called a set bit. Given 2 BitSets, B1 and B2, of size N where all bits in both BitSets are initialized to 0,
 * perform a series of M operations. After each operation, print the number of set bits in the respective BitSets as two
 * space-separated integers on a new line.
 * 
 * Input Format: The first line contains 2 space-separated integers, N (the length of both BitSets and ) and M (the
 * number of operations to perform), respectively. The M subsequent lines each contain an operation in one of the
 * following forms: 
 * AND <set> <set> 
 * OR <set> <set> 
 * XOR <set> <set> 
 * FLIP <set> <index> 
 * SET <set> <index> 
 * In the list above, <set> is the integer 1 or 2, where 1 denotes B1 and 2 denotes B2. <index> is an integer denoting a bit's index
 * in the BitSet corresponding to <set>. For the binary operations AND, OR, and XOR, operands are read from left to
 * right and the BitSet resulting from the operation replaces the contents of the first operand. For example: AND 2 1
 * means you will do B2 ^ B1 to B2 (^ means AND).
 * 
 * Sample Input: 5 4 AND 1 2 SET 1 4 FLIP 2 2 OR 2 1
 * 
 * Output: 0 0 1 0 1 1 1 2
 *
 */

public class MyBitSet {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int numOperations = sc.nextInt();

		BitSet b1 = new BitSet(size);
		BitSet b2 = new BitSet(size);

		for (int i = 0; i < numOperations; i++) {
			String operation = sc.next();
			int firstArg = sc.nextInt();
			int secondArg = sc.nextInt();
			BitSet firstBitSet;
			BitSet secondBitSet;
			BitSet bitSet;
			if (operation.equalsIgnoreCase("AND")) {
				firstBitSet = (firstArg == 1) ? b1 : b2;
				secondBitSet = (secondArg == 1) ? b1 : b2;
				// Perform AND operation
				firstBitSet.and(secondBitSet);
			} else if (operation.equalsIgnoreCase("OR")) {
				firstBitSet = (firstArg == 1) ? b1 : b2;
				secondBitSet = (secondArg == 1) ? b1 : b2;
				// Perform OR operation
				firstBitSet.or(secondBitSet);
			} else if (operation.equalsIgnoreCase("XOR")) {
				firstBitSet = (firstArg == 1) ? b1 : b2;
				secondBitSet = (secondArg == 1) ? b1 : b2;
				// Perform XOR operation
				firstBitSet.xor(secondBitSet);
			} else if (operation.equalsIgnoreCase("FLIP")) {
				bitSet = (firstArg == 1) ? b1 : b2;
				// 2nd argument for FLIP operation has to be an index
				// Perform the FLIP Operation
				bitSet.flip(secondArg);
			} else if (operation.equalsIgnoreCase("SET")) {
				bitSet = (firstArg == 1) ? b1 : b2;
				// 2nd argument for SET operation has to be an index
				// Perform the SET Operation
				bitSet.set(secondArg);
			}

			System.out.println(b1.cardinality() + " " + b2.cardinality());
		}
	}
}
