package com.algorithms.hackerrank.twoDArray;

public class SearchInSortedMatrix {

	/**
	 * Write an algorithm to find a number from an n*n metrics of numbers which is
	 * sorted row-wise and column-wise?
	 * 
	 * Solution:
	 * We can solve it via 3 ways:
	 * A) Brute Force, i.e., iterate each row and in it, each column and find the number. Time Complexity O(n^2), so bad!
	 * B) Binary search the number in each row. Here, time complexity will be O(nlogn) since n times binary search involved.
	 * C) Best Approach: "Step Search":
	 * 1) Start with top row, right most column, i.e., row=0, col=n-1.
	 * 2) Compare num with element at above location, say elem. 
	 * if num is more than elem, move down on same column (to next row), else, move left on same row.
	 * Worst case of this will be if we have to move all the way to left corner (same row) and then all the way down (left col), so O(n).
	 */

	public static void main(String[] args) {

		int[][] A = { 
				{ 11, 12, 13, 15 }, 
				{ 18, 21, 22, 26 }, 
				{ 29, 34, 45, 66 }, 
				{ 78, 83, 91, 99 } 
		};
		
		int num = 91;
		// m x n array
		boolean found = searchNumberIn2DArray(A, 4, 4, num);
		
		System.out.println("The num " + num + " was found in the 2D Array? " + found);

	}

	private static boolean searchNumberIn2DArray(int[][] A, int m, int n, int num) {
		
		// m x n array
		int row = 0;
		int col = n-1;
		
		while (row < m && col < n) {
			int elem = A[row][col];
			if (elem == num) {
				return true;
			} else if(elem > num) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}

}
