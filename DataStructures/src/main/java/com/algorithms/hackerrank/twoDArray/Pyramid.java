package com.algorithms.hackerrank.twoDArray;

public class Pyramid {
	
	// --- Directions
	// Write a function that accepts a positive number N.
	// The function should console log a pyramid shape
	// with N levels using the # character.  Make sure the
	// pyramid has spaces on both the left *and* right hand sides
	// --- Examples
	//   pyramid(1)
	//	       '#'
	//   pyramid(2)
	//	       ' # '
	//	       '###'
	//   pyramid(3)
	//	       '  #  '
	//	       ' ### '
	//	       '#####'

	public static void main(String[] args) {
		
		Pyramid pyramid = new Pyramid();
		int height = 5;
		String myPyramid = pyramid.getPyramid(height);
		System.out.println(myPyramid);

	}
	
	/**
	 * 
	 * @param i -> height of pyramid you need
	 * Solution:
	 * (Please check the class HourGlass before this one)
	 * a) Iterate n times equal to how many pyramids you need. Start with 1 for first pyramid.
	 * b) For each pyramid, height, h = h(n), iterate row times, r -> 0 to h (not inclusive).
	 * c) For each row, iterate numColumns times, c -> 0 to cMax(2*h -1) times (as 1, 3, 5.. for height = 1, 2, 3..)
	 * d) Before iterating for columns, compute mid column for a given pyramid as Math.floor((0+cMax)/2)
	 * e) In the iteration for columns, check if c >= cMax-r && c <= cMax+r, add "#" there, else add a space
	 * f) At beginning and end of iteration for every row, add single quote and "\n" at end of each row
	 * g) Return the resulting string and you're done!
	 */
	private String getPyramid(int height) {
		StringBuilder sb = new StringBuilder();
		
		for (int h=1; h<=height; h++) {
			int rMax = h;	// max # of rows for a given pyramid of height h
			int cMax = 2*h - 1;	// max # of columns in a given pyramid of height h
			int cMid = Math.floorDiv(cMax, 2);
			for(int r=0; r<rMax; r++) {
				sb.append("'");
				for (int c=0; c<cMax; c++) {
					if (c >= (cMid - r) && c <= (cMid + r)) {
						sb.append('#');
					} else {
						sb.append(' ');
					}
				}
				sb.append("'");
				sb.append("\n");
			}
		}
		return sb.toString();
	}

}
