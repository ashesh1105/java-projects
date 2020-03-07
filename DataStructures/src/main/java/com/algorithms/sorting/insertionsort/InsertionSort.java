package main.java.com.algorithms.sorting.insertionsort;

public class InsertionSort {

	public static void main(String[] args) {

		int size = 10;
		int[] data = new int[size];
		// Populate the array
		for (int i = 0; i < size; i++) {
			data[i] = (int) (Math.random() * 100);
		}
		// Print unsorted array
		System.out.print("Unsored array is: ");
		for (int i = 0; i < size; i++) {
			System.out.print(data[i] + " ");
		}
		// Sort the array using Insertion sort
		for (int i = 0; i < size; i++) {
			for (int j = i; j > 0; j--) {
				if (data[j - 1] > data[j]) {
					// swap data[j] with data [j-1]
					int temp = data[j];
					data[j] = data[j - 1];
					data[j - 1] = temp;
				}
			}
		}
		// Print the sorted array
		System.out.print("\nSored array is: ");
		for (int i = 0; i < size; i++) {
			System.out.print(data[i] + " ");
		}
	}

}
