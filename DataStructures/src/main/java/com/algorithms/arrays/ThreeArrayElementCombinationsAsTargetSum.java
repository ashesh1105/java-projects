package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeArrayElementCombinationsAsTargetSum {
	
	/*
	 * Given 3 integer arrays, find combinations of 1 element each from 3 arrays whose sum is equal to target sum.
	 * 
	 * Example: A = {1, 2, 3}, B = {2, 4, 4}, C = {1, 2, 4}, targetSum = 5, Result = [[1, 2, 2], [2, 2, 1]]
	 */

	public static void main(String[] args) {
		
		int [] A = {1, 2, 3};
		int [] B = {2, 4, 4};
		int [] C = {2, 1, 4};
		int targetSum = 5;
		
		List<List<Integer>> result = new ThreeArrayElementCombinationsAsTargetSum().getThreeSome(A, B, C, targetSum);
		
		System.out.print("Result: " + result);
		
	}

	// O(n^2) for Array A & B iterating, find target sum - sum (elements from A&B) -> Do binary search on Array C
	private List<List<Integer>> getThreeSome(int[] a, int[] b, int[] c, int targetSum) {
		
		// TBD: Do null checks for 3 arrays, log and return if null
		
		// Result list of lists
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		// Sort the third array
		Arrays.sort(c);
		int lenA = a.length;
		int lenB = b.length;
		
		for (int i=0; i<lenA; i++) {
			for (int j=0; j<lenB; j++) {
				int subSum = a[i] + b[j];
				if (isPresent(c, targetSum - subSum)) {
					// Using Arrays.asList(T...t) method here. You can use as many instances of T to get the List<T>
					result.add(Arrays.asList(a[i], b[j], targetSum-subSum));
				}
			}
		}
		
		return result;
	}

	private boolean isPresent(int[] c, int target) {
		
		// Remember, array c is already sorted, so we will do a binary search
		int left = 0;
		int right = c.length - 1;
		
		while (left <= right) {
			int mid = left + (right-left) / 2;
			
			if (target == c[mid]) return true;
			else if (target < c[mid]) right = mid-1;
			else left = mid+1;
		}
		return false;
	}

}
