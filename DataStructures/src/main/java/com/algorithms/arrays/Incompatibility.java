package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class Incompatibility {

	/*
	 Two friends Kohli and Dhoni want to test their friendship to check how compatible they are. Given a list of n movies numbered
	 1,2,3....n and asked both of them to rank the movies. Design an algorithm to find compatibility difference between them.
	 Compatibility difference is the number of mis-matches in the relative rankings of the same movie given by them i.e. if Kohli ranks
	 Movie 3 before Movie 2 and Dhoni ranks Movie 2 before Movie 3 then its a relative ranking mis-match Compatibility difference is the
	 maximum number of mis- matches Sample Input: 31245 and 32415 Sample Output: 2. 
	 
	 Explanation: Movies are 1,2,3,4,5. Kohli ranks them 3,1,2,4,5, Dhoni ranks them 3,2,4,1,5. Compatibility difference is 2 because
	 Kohli ranks movie 1 before 2,4 but Dhoni ranks it after.
	 */

	public static void main(String[] args) {

		List<Integer> first = new ArrayList<Integer>();
		first.add(3);
		first.add(1);
		first.add(2);
		first.add(4);
		first.add(5);

		List<Integer> second = new ArrayList<Integer>();
		second.add(3);
		second.add(2);
		second.add(4);
		second.add(1);
		second.add(5);

		System.out.print("First list: ");
		for (int i : first) {
			System.out.print(i + " ");
		}

		System.out.print("\nSecond list: ");
		for (int i : second) {
			System.out.print(i + " ");
		}

		System.out.print("\nIncompatibility: " + findIncompatibility(first, second));

	}

	private static int findIncompatibility(List<Integer> first, List<Integer> second) {
		
		// TODO: Input validations

		int incompatibility = 0;

		for (int i = 0; i < first.size(); i++) {

			if (first.get(i) != second.get(i)) {

				int j = i + 1;
				while (first.get(i) != second.get(j)) {
					j++;
				}
				while (i != j) {
					// Ensure to swap only between 2 adjacent positions and count each swap as incompatibility++
					swap(second, j - 1, j);
					j--;
					incompatibility++;
				}
			}

		}

		return incompatibility;
	}

	private static void swap(List<Integer> second, int i, int j) {
		
		int temp = second.get(i);
		second.set(i, second.get(j));
		second.set(j, temp);
		
	}
}
