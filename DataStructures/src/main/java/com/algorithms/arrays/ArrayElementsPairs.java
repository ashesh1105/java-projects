package com.algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Check for pairs of elements such that their sum is X
 * Note*** Try improvising this method to return all set of 3 elements with sum as given sum. This is google question.
 * Clue**
 * Take another variable as k which can start somewhere from mid point between i and j and always check sum of
 * elements at i, k and j. Keep i and j fixed, move k to left or right depending on sum coming higher or lower than
 * given sum. If k becomes equal to i, decrement j by 1 and reset k to new mid point between i and j. If k touches j,
 * increment i and reset the position of k. Return data structure will then can not map and may be return 2 dimensional
 * array or list of lists.
 */
public class ArrayElementsPairs {

	public static void main(String[] args) {

		int[] array = { 8, 2, 9, 4, 5, 22, 7, 1, 21, 3, 28 };
		int sum = 30;
		long start = System.nanoTime();
		System.out.println("The element pairs found in array with sum as "
				+ sum + ":");
		long end = System.nanoTime();

		System.out.println("Time taken: " + (end-start));

		Map<Integer, Integer> pairsWithGivenSum = new ArrayElementsPairs().findPairsWithGivenSum(array, sum);
		printData(pairsWithGivenSum);

	}

	private static void printData(Map<Integer, Integer> pairsWithGivenSum) {
		pairsWithGivenSum.forEach((key, value) -> {
			System.out.println(key + ", " + value);
		});
	}

	public Map<Integer, Integer> findPairsWithGivenSum(int[] array, int sum) {

		Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();

		// Sort the array, if it is not already sorted
		Arrays.sort(array);

		int i = 0;
		int j = array.length - 1;

		while (i < j) {

			if (array[i] + array[j] > sum) {
				j--;
			} else {
				if (array[i] + array[j] == sum) {
					pairs.put(array[i], array[j]);
				}
				i++;
			}
		}
		if (pairs.isEmpty()) {
			// log the msg
			System.out
					.println("No pairs found in the array with sum as " + sum);
		}
		return pairs;
	}

}
