package com.algorithms.arrays;

import java.util.*;

// Essentially Algo 1 or Algo 2 methods look similar to Algo 3 which is O(n^2) where we check each elements of arr1
// with each element of arr2 anyway. So, I would use the built in way of Java, which is list1.retainAll(list2) -
// the Algo1 when it comes to finding common elements between two arrays
public class ArrayCommonElements {

    public static void main(String[] args) {

        int[] arr1 = {34, 98, 202, 68, 13, 40, 200};
        int[] arr2 = {5, 11, 22, 40, 200, 34, 68, 99, 55, 66, 79, 209, 111, 1};

        long start = System.nanoTime();
        Integer [] duplicates = getCommonElementsAlgo2(arr1, arr2);
        long end = System.nanoTime();

        if (duplicates.length != 0) {
            System.out.println("Found duplicates!");
        } else {
            System.out.println("Found no duplicate elements.");
        }
        for (Integer i : duplicates) {
            System.out.println(i);
        }

        System.out.println("Time taken: " + (end - start) + " Nano time.");
    }

    // Using collection, but does not seem faster than iterative method of O(n^2)
    private static int [] getCommonElementsAlgo1(int[] arr1, int[] arr2) {

        int [] result;

		List<Integer> list1 = new ArrayList<Integer>();
		for (int i : arr1) {
			list1.add(i);
		}

        List<Integer> list2 = new ArrayList<Integer>();
        for (int i : arr2) {
            list2.add(i);
        }

        list1.retainAll(list2);
        result = new int[list1.size()];
        for (int i=0; i< list1.size(); i++) {
            result[i] = list1.get(i);
        }

        return result;
    }

    // Another Algo, does not seem faster than iterative one of O(n^2)
    private static Integer[] getCommonElementsAlgo2(int[] arr1, int[] arr2) {

        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i : arr1) {
            set.add(i);
        }

        for (int j : arr2) {
            if (set.contains(j)) {
                duplicates.add(j);
            }
        }

        // Notice how you convert a list to an array!
        // To avoid getting Object[], you need to:
        // 1) Make an empty array of data type and size same as list
        // 2) Pass the empty array as argument when you do list.toArray
        Integer [] result = new Integer[duplicates.size()];
        return duplicates.toArray(result);
    }

    // Iterative method. Not efficient since O(n^2)
    private static List<Integer> getCommonElementsIterativeMethod(int[] arr1, int[] arr2) {
        List<Integer> duplicates = new ArrayList<Integer>();

        // Iterate through both arrays and find common elements. (O(n2) steps!)
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    duplicates.add(arr1[i]);
                }
            }
        }
        return duplicates;

    }

}
