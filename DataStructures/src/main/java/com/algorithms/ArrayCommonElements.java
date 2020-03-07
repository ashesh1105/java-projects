package main.java.com.algorithms;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ArrayCommonElements {

	public static void main(String[] args) {
		
		int [] arr1 = {0, 201, 45, 56, 34, 98, 202, 68, 13, 40, 200};
		int [] arr2 = {5, 11, 22, 200, 34, 99, 55, 66, 79, 209, 111, 1};
		
		long start = System.nanoTime();
		// TODO: Write an Efficient method for it!!!!
		List<Integer> duplicates = getCommonElementsAlgo2(arr1, arr2);
		long end = System.nanoTime();
		
		if (duplicates.size() != 0){
			System.out.println("Found duplicates!");
		}
		else {
			System.out.println("Found no duplicate elements.");
		}
		for (Integer i : duplicates) {
			System.out.println(i);
		}
		
		System.out.println("Time taken: " + (end - start) + " Nano time.");
	}
	
	// Using collection, but does not seem faster than iterative method of O(n^2)
	private static List<Integer> getCommonElementsAlgo1(int [] arr1, int [] arr2) {
		
		List<Integer> list1 = new ArrayList<Integer>();
		for (int i : arr1) {
			list1.add(i);
		}
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i : arr2) {
			list2.add(i);
		}
		if (list1.size() > list2.size()) {
			list1.retainAll(list2);
			return list1;
		}
		else {
			list2.retainAll(list1);
			return list2;
		}
		
	}
	
	// Another Algo, does not seem faster than iterative one of O(n^2)
	private static List<Integer> getCommonElementsAlgo2(int [] arr1, int [] arr2) {
		
		List<Integer> duplicates = new ArrayList<>();
		
		Hashtable<Integer, Integer> table = new Hashtable<>();
		
		for (int i : arr1) {
			if (table.containsKey(i)) {
				table.put(i, table.get(i) + 1);
			}
			table.put(i, 1);
		}
		
		for (int j : arr2) {
			if (table.containsKey(j)) {
				duplicates.add(j);
			}
		}
		
		return duplicates;
		
	}
	
	// Iterative method. Not efficient since O(n^2)
	private static List<Integer> getCommonElementsIterativeMethod(int [] arr1, int [] arr2) {
		List<Integer> duplicates = new ArrayList<Integer>();
		
		// Iterate through both arrays and find common elements. (O(n2) steps!)
		for (int i=0; i< arr1.length; i++) {
			for (int j=0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					duplicates.add(arr1[i]);
				}
			}
		}
		return duplicates;
		
	}

}
