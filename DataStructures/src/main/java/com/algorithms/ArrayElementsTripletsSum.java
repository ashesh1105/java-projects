package main.java.com.algorithms;

import java.util.Arrays;

public class ArrayElementsTripletsSum {

	/**
	 * Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value. 
	 * Expected Time Complexity is O(n2). 
	 * Example: Input : arr[] = {-2, 0, 1, 3} 
	 * Sum = 2 Output: 2 
	 * Explanation: (-2, 0, 1) and (-2, 0, 3)
	 * 
	 * Solution:
	 * A) Brute Force: You have 3 nested loops and compare arr[i] + arr[j] + arr[k] to given sum, when less, increment the count
	 *    Time Complexity will be O(n^3) but we need O(n^2) here
	 * B) Implemented method below "triplets":
	 * 		1) Loop n times with i = 0 to len-3 index (i < len-2). This is to allow j 2nd nd 3rd number at the end.
	 * 		2) Declare variables j = i+1, k = len-1
	 * 		3) Compare arr[i], arr[j] and arr[k] for their sum less than given one, increment result by k-j, since then all
	 * 			current values of i, j and any lower values of k will give the desired results. Also increment j to try i=0, j=2 and
	 * 			current value of k or less.
	 * 		4) If 3) above is not the case, decrement k. 3) and 4) can be done in a while loop inside of ith current iteration.
	 * 		5) Once ith iteration finishes, you'll have count variable contain the desired result that you can return!
	 */

	public static void main(String[] args) {

		ArrayElementsTripletsSum arrayElementsTripletsSum = new ArrayElementsTripletsSum();

		int arr[] = { -2, 0, 1, 3 };
		int sum = 2;
		System.out.println("Count of triplets with sum less than 2 in array is: " + arrayElementsTripletsSum.triplets(arr, sum));
		
		int arr1[] = { 1, 3, 7, 9, 10, 11, 12, 18 };
		int sum1 = 22;
		System.out.println("Count of triplets with sum less than 22 in array is: " + arrayElementsTripletsSum.triplets(arr1, sum1));

	}

	private int triplets(int[] arr, int sum) {
		
		// TODO: Input validations
		
		// Sort the array if it is not already sorted
		Arrays.sort(arr);
		
		
		int count = 0;
		int len = arr.length;
		
		for (int i=0; i<len-2; i++) {
			int j = i+1, k = len-1;
			while (j<k) {
				if (arr[i] + arr[j] + arr[k] >= sum) {
					k--;
				} else {
					count += k-j;
					j++;
				}
			}
		}
		return count;
	}

}
