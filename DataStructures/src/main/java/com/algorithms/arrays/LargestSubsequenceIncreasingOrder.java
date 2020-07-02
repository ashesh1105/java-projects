package com.algorithms.arrays;

import java.util.Stack;

/**
 Given a set of integers, write an algorithm, to find the largest sequence, meaning in increasing order.
 For example,
 Input: {1, 9, 3, 10, 4, 20, 2}
 Output: 2
 Explanation:
 1 -> 9
 3 -> 10
 4 -> 20
 So largest subsequence where next element(s) is/are in increasing is 2
 */
public class LargestSubsequenceIncreasingOrder {

	public static void main(String[] args) {
		
		int [] arr = {1, 9, 3, 10, 4, 20, 23, 2};
		
		System.out.println("Largest subsequence for given array: " + largestSubsequence(arr));

	}

	private static int largestSubsequence(int[] arr) {
		
		int len = arr.length;
	
		Stack<Integer> stack = new Stack<>();
		
		int largestSubsequeceSize = 0;
		
		stack.push(arr[0]);

		// If an element is more than last element in stack, add to stack, else take stack size, clear stack and add that element into it
		for (int i=1; i<len; i++) {
			
			int elem = arr[i];
			
			if (elem > stack.peek()) {
				stack.push(elem);
			} else {
				int temp = stack.size();
				if (temp > largestSubsequeceSize) {
					largestSubsequeceSize = temp;
				}
				stack.clear();
				stack.push(elem);
			}
			
		}
		
		return largestSubsequeceSize;
	}

}
