package main.java.com.algorithms.dynamicprogramming;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GreaterNumbersAhead {

	Logger logger = Logger.getLogger(GreaterNumbersAhead.class.getName());

	/*
	 * How to find total number of greater number after all number in an array ?
	 * 
	 * Eg. Given array is, 5 3 9 8 2 6, the output will be 3 3 0 0 1 0
	 * 
	 * The implemented method takes n^2 time. Find a better one!!
	 * 
	 * Note: Adding an optimized solution below which has a bit different
	 * meaning of NGE to Right. Here, its like jumps to next greater elements
	 * and count the hops. Method findNGNToRightOptimized does this.
	 * 
	 * TODO: Find a solution for this actual problem where we need count of all
	 * numbers to the right which is larger than current element at index i
	 */

	public static void main(String[] args) {

		int[] arr = { 5, 3, 9, 8, 2, 6 };

		System.out.println("Array: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("");

		int[] result = new GreaterNumbersAhead().findNumGreaterNumbersAheadBruteForce(arr);
		System.out.println("Result from Brute Force method: ");
		for (int i : result) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nResult from Optimized method which is wrong! Fix it!!!: ");
		int [] betterResult = new GreaterNumbersAhead().findNGNToRightOptimized(arr);
		
		for (int i : betterResult) {
			System.out.print(i + " ");
		}

	}

	// Brute force method with Big(O) as n^2! Find better algo with Big(O) as
	// O(n)
	public int[] findNumGreaterNumbersAheadBruteForce(int[] arr) {

		// if input array is null, return null
		if (arr == null)
			return null;

		int len = arr.length;
		int[] result = new int[len];

		// if input array length is 0, return array with zero length
		if (len == 0)
			return result;

		// if size is 1, return result array with 0 in it
		if (len == 1) {
			result[0] = 0;
			return result;
		}

		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[i] < arr[j]) {
					result[i] += 1;
				}
			}
		}
		result[len - 1] = 0;

		return result;
	}

	public int[] findNGNToRightOptimized(int[] arr) {

		int len = arr.length;
		int next[] = new int[len];
		int optimizedResult[] = new int[len];

		// create two arrays, one to store the index of next greater element for
		// each elements of arr,
		// other one to store the actual result, which is how many next greater
		// numbers one has to jump
		// to get past the array.
		fillNextGreaterNumber(arr, next);
		
		// Check next array if it is filled up
		if (next[0] == 0) {
			System.out.println("next array could not be filled.");
		}

		// For last element count of NGE to right will be zero
		optimizedResult[len - 1] = 0;

		// Iterate from last -1 element
		for (int i = len - 2; i >= 0; i--) {
			// if no NGE to right, result will be zero for that element
			if (next[i] == -1) {
				optimizedResult[i] = 0;
			} else {
				optimizedResult[i] = optimizedResult[next[i]] + 1;
			}
		}
		return optimizedResult;
	}

	public void fillNextGreaterNumber(int[] arr, int[] next) {

		// Boundary conditions checks
		if (arr == null || arr.length == 0) {
			logger.log(Level.WARNING, "Array is either null or empty.");
		}
		int len = arr.length;

		// If array has only one element then it will have no next greater
		// element
		if (arr.length == 1) {
			next[0] = -1;
		}

		Stack<Integer> stack = new Stack<>();

		// Push first index to stack
		stack.push(0);

		for (int i = 1; i < len; i++) {

			while (!stack.isEmpty()) {
				// check if current element is less than arr[i] then next array
				// gets i at current position. If so, pop the current index
				// else, stop this iteration of stack
				int cur = stack.peek();
				if (arr[cur] < arr[i]) {
					next[cur] = i;
					stack.pop();
				} else {
					break;
				}
			}
			// push next to stack so it's pair can also be found
			stack.push(i);
		}

		// Add -1 to remaining elements since they don't have next greater
		// element
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			next[cur] = -1;
		}
	}
}
