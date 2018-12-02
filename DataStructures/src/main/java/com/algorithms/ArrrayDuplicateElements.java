package com.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an integer array, print the duplicate elements including how many times
 * they appear in the array. Variation: Do this without using any extra storage,
 * like Map, Set, etc.
 * 
 * Soluton: A) Using a Map: 1) Fill the map with array elements as key and
 * number of occurrences as value. 2) Iterate through map using forEach((key,
 * value) -> { }) and print the duplicate element with their # of occurrences.
 * 
 * B) Without using any map or set: 1) Use "Tail Based Approach" as used in
 * removing duplicates from an array. 2) Define variables, i=1, j=0 and tail =
 * 1. 3) Start a for loop with i = 1 to len-1. 4) In above loop, start another
 * loop with j = 0 to tail - 1 (condition: j < tail). 5) Inside second loop,
 * check if A[j] == A[i], break from this loop. 6) Outside of inside loop (and
 * still inside the outer loop), check if j == tail (i.e. j could reach all the
 * way till tail), increment tail in that case. You're done!
 * 
 */

public class ArrrayDuplicateElements {

	public static void main(String[] args) {

		int[] A = { 15, 8, 9, 8, 12, 15, 66, 34, 9, 24, 76, 8 };

		long start = System.nanoTime();

		findDuplicateElementsWithMap(A);

//		findDuplicateElementsWithoutAnyStorage(A);

		long end = System.nanoTime();

		System.out.println("\nTime taken: " + (end - start) + " Nano time.");

	}

	// Find Array duplicate elements without any extra storage
	private static void findDuplicateElementsWithoutAnyStorage(int[] A) {

		int len = A.length;
		int i = 1;
		int j = 0;
		int tail = 1;

		for (i = 1; i < len; i++) {

			for (j = 0; j < tail; j++) {
				if (A[j] == A[i]) {
					System.out.println("Duplicate found! Element: " + A[j] + " at index: " + i);
					break;
				}
			}
			if (j == tail) {
				tail++;
			}
		}

	}

	// Find Array duplicate elements using a Map, terminal output
	private static void findDuplicateElementsWithMap(int[] A) {

		// TODO: Null checks and if array has only one element

		Map<Integer, Integer> map = new HashMap<>();

		// Populate the map
		for (int elem : A) {
			if (map.containsKey(elem)) {
				map.put(elem, map.get(elem) + 1);
			} else {
				map.put(elem, 1);
			}
		}

		// Print array duplicate elements
		System.out.println("Array Duplicates:");

		map.forEach((key, value) -> {
			if (value > 1) {
				System.out.println(key + ", appears " + value + " times");
			}
		});
	}

}
