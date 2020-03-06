package main.java.com.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public class NumSetsWithGivenTotalNumber {
	/**
	 * Find total number of set of numbers from given array such that sum of them equal to given total. Reference:
	 * https://www.youtube.com/watch?v=nqlNzOcnCfs Example: {2, 4, 6, 1, 5, 10}, total: 6 Result: Number of sets = 3: {2, 4}, {6}, {1, 5}
	 * 
	 */
	@Getter
	private int numCalls;
	@Getter
	private Map<String, Integer> cache = new HashMap<>();

	public static void main(String[] args) {

		NumSetsWithGivenTotalNumber numSets = new NumSetsWithGivenTotalNumber();

		int arr[] = { 2, 4, 6, 10 };
		int total = 6;

		// System.out.println("Number of sets: " + numSets.countSets(arr, total));
		// System.out.println("Recursive function was called " + numSets.getNumCalls() + " times.");

		// Recursion with Memoization
		System.out.println("Number of sets: " + numSets.countSetsOptimized(arr, total));
		System.out.println("Recursive function was called " + numSets.getNumCalls() + " times.");

	}

	private int countSets(int[] arr, int total) {
		// TODO: Input validations

		return rec(arr, total, arr.length);
	}

	private int rec(int[] arr, int total, int n) {
		// To count number of times recursive function is called
		numCalls++;
		if (total == 0) {
			return 1;
		}
		int result = 0;
		if (total < 0 || n <= 0) {
			result = 0;
		} else if (arr[n - 1] > total) {
			result = rec(arr, total, n - 1);
		} else {
			// We may or many not include the current element, so need to add results from both routes
			result = rec(arr, total - arr[n - 1], n - 1) + rec(arr, total, n - 1);
		}
		return result;
	}

	private int countSetsOptimized(int[] arr, int total) {
		// TODO: Validate inputs!!
		return recOpt(arr, total, arr.length);
	}

	private int recOpt(int[] arr, int total, int n) {
		// To count number of times recursive function is called
		numCalls++;
		if (total == 0) {
			return 1;
		}
		int result = 0;
		if (total < 0 || n <= 0) {
			result = 0;
		} else if (arr[n - 1] > total) {
			String key1 = Integer.toString(total) + Integer.toString(n - 1);
			if (this.cache.containsKey(key1)) {
				result = this.cache.get(key1);
			} else {
				result = recOpt(arr, total, n - 1);
			}
		} else {
			// We may or many not include the current element, so need to add results from both routes
			String key2 = Integer.toString(total - arr[n - 1]) + Integer.toString(n - 1);
			String key3 = Integer.toString(total) + Integer.toString(n - 1);
			
			int temp1 = this.cache.containsKey(key2) ? this.cache.get(key2) : recOpt(arr, total - arr[n - 1], n - 1);
			int temp2 = this.cache.containsKey(key3) ? this.cache.get(key3) : recOpt(arr, total, n - 1);
			
			result = temp1 + temp2;
		}
		String key = Integer.toString(total) + Integer.toString(n);
		if (!this.cache.containsKey(key)) {
			this.cache.put(Integer.toString(total) + Integer.toString(n), result);
		}
		return result;
	}

}
