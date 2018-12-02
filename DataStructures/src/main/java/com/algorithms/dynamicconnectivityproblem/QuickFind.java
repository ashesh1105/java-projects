package com.algorithms.dynamicconnectivityproblem;

public class QuickFind {
	
	/*
	 * Dynamic Connectivity problem is about if there are N objects, finding out if an object1 out of them is connected to another object2
	 * and also connected them (if situation be) if they are not connected.
	 * 
	 * This class demos an eager approach of solving the problem which will yield into O(n^2) performance. See other classes in this package
	 * for better algorithms.
	 */
	
	private int[] ids;
	
	public QuickFind(int size) {
		
		// Initialize operation will take O(n)
		if (size > 0) {
			ids = new int[size];
			for (int i=0; i<size; i++) {
				ids[i] = i;
			}
		}
		
	}

	// Main method
	public static void main(String[] args) {
		
		// With fail with 1 Billion elements since O(n^2) will 10^18 operation. N union operaton with N numbers.
		QuickFind qf = new QuickFind(10);
		
		int elem1 = 4;
		int elem2 = 8;
		
		// Use isConnected() function
		System.out.println("Elements " + elem1 + " and " + elem2 + " are " + (qf.connected(4, 8) ? "connected." : "not connected."));
		
		// Use connect() function
		System.out.println("Connected elements " + elem1 + " and " + elem2 + ": " + qf.union(elem1, elem2));
		
		System.out.println("Check if " + elem1 + " and " + elem2 + " are now connected: " + (qf.connected(4, 8) ? "they are." : "they are still not!"));

		System.out.println("Lets now check if elements 1 and 4 are connected? " + (qf.connected(1, 4)));
		
		System.out.println("Lets connect 1 and 4 now: " + qf.union(1, 4));
		
		System.out.println("Now lets check if 1 and 8 are connected? " + qf.connected(1, 8));
		
		System.out.println("Lets check if 1 and 3 are connected? " + qf.connected(1, 3));
		
		System.out.println("Lets connect 3 and 8 now: " + qf.union(3, 8));
		
		System.out.println("Now lets check if 1 and 3 are connected? " + qf.connected(1, 3));
		
	}

	private boolean union(int elem1, int elem2) {
		
		int id1 = findId(elem1);
		int id2 = findId(elem2);
		
		if (id1 == id2) {
			//Log and return false since the elements are already connected
			System.out.println(elem1 + " " + elem2 + " are already connected.");
			return false;
		} else {
			// iterate through entire array and change all elements with id as id2 to id1 => O(n) operation!
			for (int i=0; i<ids.length; i++) {
				if (ids[i] == id2) ids[i] = id1;
			}
			return true;
		}
	}

	// isConnected is O(1) operation since find is O(n) operation
	public boolean connected(int elem1, int elem2) {
		
		if ((elem1 < 0 || elem1 > ids.length) || (elem2 < 0 || elem2 > ids.length)) {
			System.out.println("Elements supplied aren't in the range.");
			return false;
		}
		
		return ids[elem1] == ids[elem2];
	}

	// find will be O(1) operation
	private int findId(int elem) {
		
		return ids[elem];
	}

}
