package com.algorithms;

import java.util.Stack;

public class NextGreaterNumberToTheRight {
	
	/*
	 * You are given a list of numbers. For each number, find the next bigger
	 * number that appears. When not found, print -1. 
	 * 
	 * Example:
	 * Input: 12, 1, 4, 3, 2, 8, 7 
	 * Output: 
	 * 12 -> -1 
	 * 1 -> 4 
	 * 4 -> 8
	 * 3 -> 8 
	 * 2 -> 8 
	 * 8 -> -1 
	 * 7 -> -1
	 */

	public String findNextBiggerNumberBruteForce(int [] arr) {

		int len = arr.length;
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for (int i = 0; i < len; i++) {
			sb.append(arr[i]);
			// For last number there is no need to compare and simply append "-" to sb
			if (i == len-1) {
				sb.append("-> " + "-1");
				break;
			}
			// Compare every digit with next digits to know if next higher number exists
			for (j = i + 1; j < len; j++) {
				if (arr[j] > arr[i]) {
					sb.append("-> " + arr[j] + "\n");
					break;
				}
				if (j == len-1) {
					sb.append("-> " + "-1" + "\n");
				}
			}
		}

		return sb.toString();

	}
	
	public String findNextBiggerNumberOptimized(int [] arr) {
		StringBuilder sb = new StringBuilder();
		
		// Boundary conditions check
		if (arr == null || arr.length == 0) {
			return sb.toString();
		}
		if (arr.length == 1) {
			sb.append(arr[0] + " -> " + "-1");
			return sb.toString();
		}
		
		Stack<Integer> stack = new Stack<>();
		int element, next, len = arr.length;
		
		stack.push(arr[0]);
		
		for (int i=1; i<len; i++) {
			next = arr[i];
			element = stack.pop();
			
			while (element < next) {
				sb.append(element + " -> " + next + "\n");
				if (stack.isEmpty()) {
					break;
				}
				element = stack.pop();
			}
			// if element is not lesser than next, push it back to stack
			// so it can be compared with next elements
			if (element > next) {
				stack.push(element);
			}
			// push next to stack so it's pair can also be found
			stack.push(next);
		}
		
		// Process the remaining elements in stack
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " -> " + -1 + "\n");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		int [] arr = {12, 11, 9, 7, 4, 3, 2, 24, 8, 32, 14, 22, 13, 6, 19, 29, 44, 27, 10};
		
		long start1 = System.nanoTime();
		String result1 = new NextGreaterNumberToTheRight().findNextBiggerNumberBruteForce(arr);
		long end1 = System.nanoTime();
		
		long start2 = System.nanoTime();
		String result2 = new NextGreaterNumberToTheRight().findNextBiggerNumberOptimized(arr);
		long end2 = System.nanoTime();
		
		System.out.println("Result from Brute Force Method:\n" + result1);
		System.out.println("Time taken: " + (end1-start1));
		
		System.out.println("\n" + "Result from Optimized Method:\n" + result2);
		System.out.println("Time taken: " + (end2-start2));

	}

}
