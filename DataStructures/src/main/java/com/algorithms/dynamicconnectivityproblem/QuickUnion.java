package com.algorithms.dynamicconnectivityproblem;

import java.util.HashMap;
import java.util.Map;

public class QuickUnion {

	/*
	 * QuickUnion is an improvisation of QuickFind (eager) algorithm while solving the Dynamic Connectivity Problem. Here root of an element
	 * is an element that points to itself, i.e., id[elem] == elem. We find root by continuing going up in the tree till the parent points
	 * to itself. We do union by making one element's root simply point to other element's root. Two elements are considered part of
	 * connected components if their roots are the same.
	 * 
	 * This works much faster compared to QuickFind algo but find operation might need work if the tree gets really unbalanced with many
	 * levels in it. See another algo as root_alternative as a solution to that. Basically we need to compare the levels of two elements
	 * and make the smaller subtree point to root of another.
	 */

	int[] id;

	public QuickUnion(int N) {
		if (N > 0) {
			id = new int[N];

			for (int i = 0; i < N; i++) {
				id[i] = i;
			}
		}
	}

	public static void main(String[] args) {

		int N = 10;

		QuickUnion qu = new QuickUnion(N);

		// Print all elements with their ids
		System.out.print("Elements: ");
		for (int i = 0; i < N; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\n      Id: ");
		for (int i = 0; i < N; i++) {
			System.out.print(qu.id(i) + " ");
		}

		// Union two elements: 1 and 5
		int elem1 = 1;
		int elem2 = 5;
		System.out.println("\n\nCheck if " + elem1 + " and " + elem2 + " are connected? " + qu.connected(elem1, elem2));

		// System.out.println("\n\nRoot of element " + 2 + " is: " + qu.root(2));

		System.out.println("Lets connect " + elem1 + " and " + elem2 + ": " + qu.union(elem1, elem2));
		System.out.println("Check if " + elem1 + " and " + elem2 + " are now connected? " + qu.connected(elem1, elem2));

		// Union two elements: 3 and 8
		elem1 = 3;
		elem2 = 8;
		System.out.println("\n\nCheck if " + elem1 + " and " + elem2 + " are connected? " + qu.connected(elem1, elem2));

		System.out.println("Lets connect " + elem1 + " and " + elem2 + ": " + qu.union(elem1, elem2));
		System.out.println("Check if " + elem1 + " and " + elem2 + " are now connected? " + qu.connected(elem1, elem2));

		elem1 = 5;
		elem2 = 8;
		System.out.println("\n\nCheck if " + elem1 + " and " + elem2 + " are connected? " + qu.connected(elem1, elem2));

		System.out.println("Lets connect " + elem1 + " and " + elem2 + ": " + qu.union(elem1, elem2));
		System.out.println("Check if " + elem1 + " and " + elem2 + " are now connected? " + qu.connected(elem1, elem2));
		
		elem1 = 1;
		elem2 = 8;
		
		System.out.println("Check if " + elem1 + " and " + elem2 + " are connected? " + qu.connected(elem1, elem2));
		
		elem1 = 1;
		elem2 = 3;
		
		System.out.println("Check if " + elem1 + " and " + elem2 + " are connected? " + qu.connected(elem1, elem2));
		

	}

	/*
	 * The approach here is to make the root of one element point to root of another. This works faster than greedy algo in QuickFind
	 * but some subtrees can really grow making the overall structure completely unbalanced. Hence the find operation (to get root)
	 * of an element can take long time since we have to traverse the entire linked list.
	 * 
	 * Remedy for this is to keep the tree balanced by pointing smaller subtree to larger subtree's root.
	 */
	public boolean union(int elem1, int elem2) {

		int root_elem1 = root(elem1);
		int root_elem2 = root(elem2);

		if (root_elem1 == root_elem2) {
			System.out.println("Elements " + elem1 + " and " + elem2 + " are already connected. Returning false.");
			return false;
		}

		id[root_elem2] = root_elem1;
		return true;
	}

	public boolean connected(int elem1, int elem2) {
		// TODO Auto-generated method stub
		return root(elem1) == root(elem2);
	}

	private int root(int elem) {

		int result = 0;

		if (elem < 0 || elem > id.length) {
			System.out.println("Element sent is out of range.");
			return result;
		}

		// Go up on tree as long as element itself is its root, i.e., it does not point to itself
		while (!(elem == id[elem])) {
			elem = id[elem];
		}
		result = elem;

		return result;
	}
	
	private Map<String, Integer> root_alternative(int elem) {

		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		int root = 0;
		int levels = 0;

		if (elem < 0 || elem > id.length) {
			System.out.println("Element sent is out of range.");
			return resultMap;
		}

		// Go up on tree as long as element itself is its root, i.e., it does not point to itself
		while (!(elem == id[elem])) {
			elem = id[elem];
			// Increment the level every time
			levels++;
		}
		root = elem;

		resultMap.put("root", root);
		resultMap.put("level", levels);
		
		return resultMap;
	}

	public int id(int elem) {
		// TODO Auto-generated method stub
		return id[elem];
	}

}
