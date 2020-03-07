package main.java.com.algorithms;

import java.util.Stack;

/**
 * Given a set of integers, write an algorithm, to find the largest sequence, meaning in increasing order.
 * 
 * Solution:
 * 
 *
 */
public class LargestSubsequence {

	public static void main(String[] args) {
		
		int [] arr = {1, 9, 3, 10, 4, 20, 2};
		
		System.out.println("Largest subsequence for given array: " + largestSubsequence(arr));

	}

	private static int largestSubsequence(int[] arr) {
		
		int len = arr.length;
	
		Stack<Integer> stack = new Stack<>();
		
		int largestSubsequeceSize = 0;
		
		stack.push(arr[0]);
		
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
