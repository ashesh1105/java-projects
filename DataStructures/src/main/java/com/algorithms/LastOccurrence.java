package main.java.com.algorithms;

public class LastOccurrence {

	public static void main(String[] args) {

		int[] array = { 2, 5, 8, 11, 11, 11, 15, 21 };
		int data = 11;
		int lastIndexOfData = lastIndexOf(array, data);
		System.out
				.println("Last occurrent of " + data + ": " + lastIndexOfData);

	}

	/*
	 * Find first occurrence of an element in a sorted array. Note** if the
	 * array is not sorted, merge sort it in O(logn) time
	 */
	public static int lastIndexOf(int[] array, int data) {

		int result = -1;

		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == data) {
				result = mid;
				// Found the data but now lets check right array for more
				// occurrences
				low = mid + 1;
			} else if (data > array[mid] && data <= array[high]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return result;
	}
}