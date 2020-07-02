package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ArrayCommonElements {

    public static void main(String[] args) {

        int[] arr1 = {0, 201, 45, 56, 34, 98, 202, 68, 13, 40, 200};
        int[] arr2 = {5, 11, 22, 200, 34, 99, 55, 66, 79, 209, 111, 1};

        long start = System.nanoTime();
        // TODO: Write an Efficient method for it!!!!
//        List<Integer> duplicates = getCommonElementsAlgo2(arr1, arr2);
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
    private static Integer[] getCommonElementsAlgo1(int[] arr1, int[] arr2) {

        Integer[] emptyArr;

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
            emptyArr = new Integer[list1.size()];
            return list1.toArray(emptyArr);
        } else {
            list2.retainAll(list1);
            emptyArr = new Integer[list2.size()];
            return list2.toArray(emptyArr);
        }

    }

    // Another Algo, does not seem faster than iterative one of O(n^2)
    private static Integer[] getCommonElementsAlgo2(int[] arr1, int[] arr2) {

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
