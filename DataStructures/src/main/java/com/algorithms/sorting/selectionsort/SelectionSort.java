package com.algorithms.sorting.selectionsort;

public class SelectionSort {

	public static void main(String[] args) {
		
		int [] arr = {34, 5, 10, 111, 11, 21, 76, 17, 2};
		
		// Print the array before sorting
		System.out.println("Unsorted Array:");
		for (int i : arr) {
			System.out.print(i + " ");	
		}
		
		// Selection Sort the array
		selectionSort(arr);
		
		// Print the sorted array
		System.out.println("\n\nSorted Array:");
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	private static void selectionSort(int[] data) {
		
		int len = data.length;
		
		for (int i=0; i < len - 1; i++) {
			int minIndex = i;
			
			for (int j=minIndex+1; j<len; j++) {
				if (data[j] < data[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = data[i];
				data[i] = data[minIndex];
				data[minIndex] = temp;	
			}
		}
		
	}

}
