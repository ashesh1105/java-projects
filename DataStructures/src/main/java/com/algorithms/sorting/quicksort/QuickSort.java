package main.java.com.algorithms.sorting.quicksort;

public class QuickSort {

	public static void main(String[] args) {
		
		int [] data = {8, 2, 9, 10, 5};
		
		System.out.println("Array before quickSort:");
		for (int i : data) {
			System.out.print(i + " ");
		}
		
		System.out.println("");
		
		quickSort(data, 0, data.length - 1);
		
		System.out.println("Array after quickSort:");
		for (int i : data) {
			System.out.print(i + " ");
		}

	}
	
	public static void quickSort(int [] data, int start, int end) {
		
		if (start < end) {
			int pivot = partition(data, start, end);
			quickSort(data, start, pivot - 1);
			quickSort(data, pivot + 1, end);
		}
	}

	private static int partition(int [] data, int start, int end) {
		
		int pivot = data[end];
		int i = start;
		for (int j = i; j < end; j++) {
			if (data[j] < pivot) {
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				i++;
			}
		}
		int temp = data[i];
		data[i] = pivot;
		data[end] = temp;
		return i;
	}

}
