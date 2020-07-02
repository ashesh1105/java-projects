package com.algorithms.arrays;

import java.util.Arrays;

/**
 Remove duplicates from an int array without using any extra storage (map, etc). The algorithm needs to be very efficient.
 * 
 Solution:
 This is same approach as "tail based duplicate removal for Strings", check StringManipulations.removeDuplicatesWithTail(String word)
 for it. Approach:
 1) Define j and tail, initialize them to 0 and 1 respectively.
 2) Start a for loop with i from 1 to len-1.
 3) Inside above loop, start another one with j=0 to j < tail.
 4) if A[j] == A[i], break from inner loop.
 5) Outside the inner loop, check if j could go uninterrupted all the way to tail before the inner loop broke.
 6) If above is true, swap A[tail] with A[i] because A[i] is first no duplicate element after tail position. Increment tail by one.
 7) Outside of the loop, grab the array elements from A[0] A[tail - 1] and return.
 Note** the resulting array will be of length tail, so last element will be at index tail - 1.
 */

public class RemoveDuplicatesIntArray {

	public static void main(String[] args) {
		
		int [] A = {2, 5, 9, 2, 5, 10};
		
		int [] arrWithNoDuplicates = removeDuplicatesIntArray(A);
		
		Arrays.stream(arrWithNoDuplicates)
			.forEach(System.out::println);

	}

	private static int[] removeDuplicatesIntArray(int [] A) {
		
		int len = A.length;
		int tail = 1;
		int j = 0;
		
		for (int i=1; i<len; i++) {

			j = 0;
			while (j < tail) {
				if (A[j] == A[i]) {
					break;
				}
				j++;
			}
			// If j can reach all the way till tail, A[i] deserves its place on non duplicate elements
			if (tail == j) {
				A[tail] = A[i];
				tail++;
			}
		}

		// Now, array elements from index 0 to tail-1 will be non duplicate elements
		int [] result = new int[tail];
		for (int k=0; k<result.length; k++) {
			result[k] = A[k];
		}
		return result;
	}
}
