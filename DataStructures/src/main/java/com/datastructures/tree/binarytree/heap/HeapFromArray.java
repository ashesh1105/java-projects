package com.datastructures.tree.binarytree.heap;

import java.util.Arrays;

public class HeapFromArray {

	public static void main(String[] args) {
		
		int [] A = {12, 2, 34, 5, 13, 4, 19, 28, 11, 16};
		
		buildMinHeapFromArray(A);
		
		Arrays.stream(A).forEach(System.out::println);
		
		for (int i=0; i<= A.length / 2; i++) {
			int left = 2*i + 1;
			int right = 2*i + 2;
			System.out.println(A[i] + " -> " + (left < A.length ? A[left] : "No left child ") 
					+ " and " + (right < A.length ? A[right] : "No right child."));
		}

	}

	private static void buildMinHeapFromArray(int[] A) {
		
		int len = A.length;
		
		for (int i=len/2; i>=0; i--) {
			
			minHeapify(A, i);
			
		}
		
		
	}

	private static void minHeapify(int[] A, int i) {
		
		int len = A.length;
		int smallest = 0;
		int leftChildIndex = 2 * i + 1;
		int rightChildIndex = 2 * i + 2;
		
		if (leftChildIndex <= len-1 && A[i] > A[leftChildIndex]) {
			smallest = leftChildIndex;
		} else {
			smallest = i;
		}
		
		if (rightChildIndex <= len-1 && A[rightChildIndex] < A[smallest]) {
			smallest = rightChildIndex;
		}
		
		if (smallest != i) {
			int temp = A[i];
			A[i] = A[smallest];
			A[smallest] = temp;
			
			i = smallest;
			minHeapify(A, i);
		}
		
	}

}
