package com.algorithms.hackerrank.twoDArray;

/*
 * Print elements of a 2D Array (m x n) in spiral order
 */
public class Print2DArraySpiralOrder {

	public static void main(String[] args) {

		int[][] twoDArray = {

				{ 11, 12, 13, 14 }, 
				{ 15, 16, 17, 18 }, 
				{ 19, 20, 21, 22 },
				{ 23, 24, 25, 26 }, 
				{ 27, 28, 29, 30 }
				
		};

		int m = twoDArray.length;
		int n = twoDArray[0].length;

		print2DArraySpiralOrder(twoDArray, m, n);

	}

	private static void print2DArraySpiralOrder(int[][] twoDArray, int m, int n) {

		int topRow = 0, bottomRow = m - 1, leftCol = 0, rightCol = n - 1;

		// direction code will be 0 for left to right, 1 for top to bottom, 2
		// for right to left and 3 for bottom to top
		int dir = 0;

		while (topRow <= bottomRow && leftCol <= rightCol) {

			if (dir == 0) {
				for (int i = leftCol; i <= rightCol; i++) {
					System.out.print(twoDArray[topRow][i] + " ");
					if (i == rightCol)
						topRow++;
				}
			}
			if (dir == 1) {
				for (int i = topRow; i <= bottomRow; i++) {
					System.out.print(twoDArray[i][rightCol] + " ");
					if (i == bottomRow)
						rightCol--;
				}
			}
			if (dir == 2) {
				for (int i = rightCol; i >= leftCol; i--) {
					System.out.print(twoDArray[bottomRow][i] + " ");
					if (i == leftCol)
						bottomRow--;
				}
			}
			if (dir == 3) {
				for (int i = bottomRow; i >= topRow; i--) {
					System.out.print(twoDArray[i][leftCol] + " ");
					if (i == topRow)
						leftCol++;
				}
			}
			dir = (dir + 1) % 4;

		}

	}
}
