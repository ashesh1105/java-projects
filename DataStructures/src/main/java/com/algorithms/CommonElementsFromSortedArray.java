package com.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Find common elements in 3 sorted arrays
 * Time Complexity of this solution: O(n).
 * 
 * Solution:
 * 1) Do one while loop with condition as no array should not go out of bounds.
 * 2) Grab elements from 3 arrays at their corresponding indices as e1 = arr1[i], e2 = arr2[j], etc.
 * 3) We now have following cases here:
 * 	 a) All elements are same: (e1 == e2 && e2 == e3). Add this element to result list.
 * 	 b) e1 > e2 -> increase j and within this check if e2 > e3 -> increase k. if e2 < e3 -> increase j.
 * 	 c) e1 < e2 -> increase i and within this check if e2 < e3 -> increase j. if e2 > e3 -> increase k.
 * Note** With above, there is no need to check e1 with e3 since that is taken care in above conditions. if e1 > e2 && e2 > e3, then e1 > e3.
 * Note** For > or < comparisons, don't rely on doing else only, add the conditions explicitly like e1 > e2 else e2 > e1. This will help
 * to not increment the indices when elements are equal and then capture them as part of your result with case a) above!
 */

public class CommonElementsFromSortedArray {

	public static void main(String[] args) {
		
		int [] arr1 = {1, 5, 5, 6, 9};
		int [] arr2 = {3, 4, 5, 5, 9, 10};
		int [] arr3 = {5, 5, 9, 10, 20};
		
		List<Integer> result = findSortedArrayCommonElements(arr1, arr2, arr3);
		result.forEach(x -> System.out.println(x));

	}

	private static List<Integer> findSortedArrayCommonElements(int[] arr1, int[] arr2, int[] arr3) {
		
		// Do boundary condition checks
		
		List<Integer> result = new ArrayList<>();
		
		int len1 = arr1.length;
		int len2 = arr2.length;
		int len3 = arr3.length;
		
		int i=0, j=0, k=0;
		
		while (i<len1 && j<len2 && k<len3) {
			
			int e1 = arr1[i];
			int e2 = arr2[j];
			int e3 = arr3[k];
			
			if (e1 == e2 && e2 == e3) {
				result.add(e1);
				i++;
				j++;
				k++;
			} 
			
			if (e1 < e2) {
				i++;
				if (e2 < e3) {
					j++;
				} else if (e2 > e3) {	// Don't increase indices if elements are equal 
					k++;
				}
			} else if (e1 > e2) {	// Don't increase indices if elements are equal
				j++;
				if (e2 < e3) {
					j++;
				} else if (e2 > e3) {
					k++;
				}
			}
		}
		return result;
	}

}
