package com.algorithms;

/**
 * Search a specific number in a sorted circular array.
 */

public class CircularArraySearch {

	public static void main(String[] args) {

		int A[] = { 12, 14, 18, 21, 3, 6, 8, 9 };
		int num = 3;

		int result = search(A, num);

		System.out.println("Number " + num + " appears in given sorted circular array? "
				+ (result == -1 ? false : true + ", at index: " + result));

	}

	private static int search(int[] A, int num) {

		int len = A.length;
		int low = 0;
		int high = len - 1;

		while (low <= high) {

			int mid = (low + high) / 2;

			// To avoid ArrayIndexOutOfBounds error in case of Circular Arrays
			int prev = (mid - 1 + len) % len;
			int next = (mid + 1) % len;

			if (A[mid] == num) {
				return mid;
			}

			/**
			 * We have following cases now: 
			 * Case 1: If array between low and high indexes is not circular at this point, i.e., everything is sorted,
			 * Case 1.a: Move high to right before mid or low to right after mid depending on how num compares with A[mid].
			 * 
			 * Case 2: if left array is sorted. This will allow us to check if num lies in that sub array. 
			 * Case 2.a: if num lies between two ends of left sub array, move high to right before mid, OR 
			 * Case 2.b: num has to be on right sub array, move low to right after mid.
			 * 
			 * Case 3: if right array is sorted, we will be able to check if num is present there 
			 * Case 3.a: if num lies between two ends of right sub array, move low to right after mid, OR 
			 * Case 3.b: if num has to be on left sub array, move high to right before mid.
			 */
			if (A[low] <= A[high]) {	// Case 1, everything is sorted
				if (num < A[mid]) {
					high = prev;
				} else {
					low = next;
				}
			} else if (A[low] <= A[prev]) {		// Case 2, left array is sorted

				if (A[low] <= num && num <= A[prev]) {
					high = prev;
				} else {
					low = next;
				}
			} else {		// Case 3, right array is sorted
				if (A[next] <= num && num <= A[high]) {
					low = next;
				} else {
					high = prev;
				}
			}

		}

		return -1;
	}

}
