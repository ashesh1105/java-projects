package main.java.com.algorithms.hackerrank;

import java.util.Scanner;

/**
 * Sample Input: 2 34567 -134
 * 
 * Output: 
 * 34567 can be fitted in: int long
 * -134 can be fitted in: short int long
 */

class DataTypes {
	public static void main(String[] argh) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		if (t <= 0) {
			System.out.println("Number of inputs not valid on first line. Returning..");
			return;
		}

		for (int i = 0; i < t; i++) {
			try {
				long x = sc.nextLong();
				System.out.println(x + " can be fitted in:");
				if (x >= -128 && x <= 127)
					System.out.println("* byte");
				if (x >= ((-1) * Math.pow(2, 15)) && x <= (Math.pow(2, 15) - 1)) {
					System.out.println("* short");
				}
				if (x >= (-1) * Math.pow(2, 31) && x <= (Math.pow(2, 31) - 1)) {
					System.out.println("* int");
				}
				if (x >= (-1) * Math.pow(2, 63) && x <= (Math.pow(2, 63) - 1)) {
					System.out.println("* long");
				}
			} catch (Exception e) {
				System.out.println(sc.next() + " can't be fitted anywhere.");
			}

		}

	}
}
