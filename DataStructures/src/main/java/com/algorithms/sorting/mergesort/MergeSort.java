package main.java.com.algorithms.sorting.mergesort;

public class MergeSort {

	public static void main(String[] args) {

		int[] data = { 22, 9, 4, 55, 16, 29, 11, 3 };
		
		int n = data.length;
		System.out.print("Unsorted Array: ");
		print(data);
		mergeSort(data, 0, n-1);
		System.out.print("\nSorted Array: ");
		print(data);

	}

	public static void mergeSort(int[] data, int start, int end) {
		
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(data, start, mid);
			mergeSort(data, mid + 1, end);
			merge(data, start, mid, end);
		}
		
	}

	private static void merge(int[] data, int start, int mid, int end) {
		
		int sizeOfLeftArray = mid - start + 1;
		int sizeOfRightArray = end - mid;
		
		int[] left = new int[sizeOfLeftArray];
		int[] right = new int[sizeOfRightArray];
		
		for (int i=0; i < sizeOfLeftArray; i++) {
			left[i] = data[start + i];	// Be careful here
		}
		
		for (int j=0; j < sizeOfRightArray; j++) {
			right[j] = data[mid + 1 + j];	// Be careful here
		}
		
		int i=0, j=0;
		for (int k = start; k <= end; k++) {
			if ((j >= right.length) || (i < left.length && left[i] < right[j])) {
				data[k] = left[i];
				i++;
			}
			else {
				data[k] = right[j];
				j++;
			}
		}
		
	}

	private static void print(int[] data) {

		for (int i : data) {
			System.out.print(i);
			System.out.print(" ");
		}

	}

}
