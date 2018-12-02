package com.datastructures.queue;

public class FindElementsInSortedCircularArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 16, 21, 25, 29, 1, 2, 5, 7, 9, 12, 21 };

		int element = 1;
		System.out.println("Element " + element + " found at index: "
				+ findElementIndexInCircularArray(array, element));

	}

	// Find out the fastest way to locate the largest element in a circular
	// sorted array ? (Google Interview Question)
	public static int findElementIndexInCircularArray(int[] array, int element) {

		int start = 0;
		int end = array.length - 1;

		while (start <= end) {

			int mid = (start + end) / 2;
			if (element == array[mid])
				return mid; // Case 1: mid itself is our index

			if (array[start] <= array[mid]) { // Case 2: left part is sorted

				if (array[start] <= element && element < array[mid]) {
					end = mid - 1; // element is on left array
				} else {
					start = mid + 1; // Check on right array
				}

			} else { // Case 3: right array is sorted

				if (array[mid] < element && element <= array[end]) {
					start = mid + 1; // element is on right array
				} else {
					end = mid - 1; // Check on left array
				}
			}

		}

		// If control reaches here, return "not found", i.e., -1
		return -1;
	}

}
