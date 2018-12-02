package com.datastructures.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonElementsSortedSet {

	/**
	 * Find common elements in two sorted HashSets.
	 * 
	 * HashSet does not maintain the order, so computing like class CommonElementsFromSortedArray is getting difficult.
	 */

	public static void main(String[] args) {

		Set<Integer> set1 = new HashSet<>(Arrays.asList(3, 5, 9, 14, 19, 23));
		Set<Integer> set2 = new HashSet<>(Arrays.asList(5, 7, 11, 14, 23, 29, 37));

		Set<Integer> resultSet = getCommonElementsFromSortedSets(set1, set2);

		resultSet.forEach(x -> System.out.println(x));

	}

	private static Set<Integer> getCommonElementsFromSortedSets(Set<Integer> set1, Set<Integer> set2) {

		if (set1.size() > set2.size()) {
			set1.retainAll(set2);
			return set1;
		} else {
			set2.retainAll(set1);
			return set2;
		}
	}

}
