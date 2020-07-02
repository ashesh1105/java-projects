package com.algorithms.arrays;

/*
 * First all occurrences of an element inside a sorted array
 * Note** sort the array if it is not sorted.
 */
public class Occurrences {

	public static void main(String[] args) {

		int[] array = { 2, 5, 8, 11, 11, 11, 11, 11, 15, 21, 21, 21};
		int data = 21;
		int firstIndexOfData = FirstOccurrence.firstIndexOf(array, data);
		int lastIndexOfData = LastOccurrence.lastIndexOf(array, data);

		System.out.println("Number of occurrences of " + data + ": "
				+ (lastIndexOfData - firstIndexOfData + 1));

	}

}
