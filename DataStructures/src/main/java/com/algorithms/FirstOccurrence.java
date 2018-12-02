package com.algorithms;

public class FirstOccurrence {

	public static void main(String[] args) {

		int[] array = { 2, 5, 8, 11, 11, 11, 15, 21 };
		int data = 11;
		int firstIndexOfData = firstIndexOf(array, data);
		System.out.println("First occurrent of " + data + ": "
				+ firstIndexOfData);

	}

	/*
	 * Find first occurrence of an element in a sorted array. Note** if the
	 * array is not sorted, sort it using Arrays.sort(arr)
	 */
	public static int firstIndexOf(int[] array, int data) {

		// TODO: Null checks
		
		int result = -1;

		int low = 0;
		int high = array.length - 1;
		
		// Do boundary condition checks
		if (data > array[high] || data < array[low]) {
			System.out.println("Data not present in given array.");
			return -1;
		}

		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == data) {
				result = mid;
				// Found the data but now lets check left array
				high = mid - 1;
			} else if (data > array[mid] && data <= array[high]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return result;
	}
}
