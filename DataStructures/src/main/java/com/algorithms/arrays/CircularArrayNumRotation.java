package com.algorithms;

/*
 * Find how many times a circular array is rotated
 * Hint** it will be the index of pivot point, i.e., min element
 * 
 * Notice that in rotated array, to find previous index, we should subtract 1, add the array length and then get a modulo 
 * with array length. This will help if index was 0, then (0 - 1 + length) % length will give us length - 1 as resulting 
 * index, which will be the last index of array, which makes perfect sense in case of rotated array. This will help us 
 * avoid ArrayOutOfBounds Exception.
 * 
 * Also note that above was useful to get previous index. For next index, we still get modulo with length but don't need to add
 * length on top since there is no risk of getting a negative number as index. So next = (mid + 1) % len works fine and will yield
 * next as index 0 (first element) in worst case if mid = len-1, i.e., mid is last index itself.
 * 
 * ******Note*****: At the beginning of while loop, make sure to check if this (sub) array is already sorted, if so, simply return the
 * low and that will be your pivot point:
 * // If first element is lower then last element of this (sub) array, first index is the pivot
	if (array[low] <= array[high]) {
	  result = low;
	  return result;
    }
 */
public class CircularArrayNumRotation {

	public static void main(String[] args) {

		// int[] array = { 21, 28, 2, 11, 16, 18, 19, 20 };
		
		int[] array = { 3, 5, 9, 14, 0, 1, 2 };

		System.out.println("The array is rotated " + findNumRotated(array) + " times");

	}

	private static int findNumRotated(int[] array) {

		int low = 0;
		int len = array.length;
		int high = len - 1;
		int result = 0;

		while (low <= high) {
			
			// If first element is lower then last element of the (sub) array, return the first index
			if (array[low] <= array[high]) {
				result = low;
				return result;
			}
			
			int mid = (low + high) / 2;
			int prev = (mid - 1 + len) % len;
			int next = (mid + 1) % len;
			if (array[mid] < array[prev] && array[mid] < array[next]) {
				return mid;
			}
			if (array[low] <= array[mid]) {
				// This means left array is sorted, pivot can't be here, check
				// right array
				low = next;
			} else if (array[mid] <= array[high]) {
				// right part is sorted, check on left
				high = prev;
			}
		}

		return result;
	}

}
