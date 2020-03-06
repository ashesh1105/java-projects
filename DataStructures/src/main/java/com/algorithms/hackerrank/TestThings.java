package main.java.com.algorithms.hackerrank;

import java.text.NumberFormat;

import org.apache.commons.lang3.math.NumberUtils;

public class TestThings {

	public static void main(String[] args) throws Exception {

		// double dbl = Double.parseDouble("a");
		// System.out.println(dbl);

		String input = "2";
		// int intValue = Integer.parseInt(input);
		// System.out.println(intValue);

		/**
		 * One way to avoid above error situation is to use try catch block and catch on exception NumberFormatException
		 * or throw your own.
		 * 
		 * Other way could be to use NumberUtils.isNumber to check before parsing. You'll still need to throw exception
		 * to let the caller know.
		 */

		if (NumberUtils.isDigits(input)) {
			int intValue = Integer.parseInt(input);
			System.out.println(intValue);
		} else {
			throw new Exception("Please pass a number!");
		}

		String str = "abcbc";
		System.out.println(str.indexOf('c', str.indexOf('c') + 1));
		System.out.println(str.lastIndexOf('c', str.lastIndexOf('c') - 1));
		System.out.println(String.valueOf(50) instanceof String);
		System.out.println(Integer.valueOf("10") instanceof Integer);
		StringBuilder sb = new StringBuilder();
		char[] charArr = { 'x', 'y', 'z' };
		sb.append(charArr);
		System.out.println(sb.toString());
		sb.delete(0, 1);
		System.out.println(sb.toString());
		char ch = '5';
		System.out.println("Character.isDigit('5') returns: " + Character.isDigit(ch));
		System.out.println("48 <= ch && ch <= 57 for ch = 5 gives: " + (48 <= ch && ch <= 57));

		System.out.println(Character.isSpaceChar(' '));
		System.out.println(Character.isLowerCase('d'));

		System.out.println("Character.isAlphabetic('*') should return false: " + Character.isAlphabetic('*'));

		// Computes Map Tiles needed to represent entire earth surface
		long numTiles = (long) Math.pow(4, 24);
		long surfaceAreaEarth = 510100000000000L; // in square meters: 510.1 trillion square meters

		System.out.println("Number of Tiles possible with 23 layers: " + numTiles);// Math.pow(4, 24));
		System.out.println("With " + NumberFormat.getInstance().format(numTiles)
				+ " vector map tiles, at zoom level 23 (begining from 0), area represented by 1 map tile: " + surfaceAreaEarth / numTiles
				+ " square meter.");

	}

}
