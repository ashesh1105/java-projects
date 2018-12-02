package com.algorithms.sorting.insertionsort;

public class InsertionSortAnother {

	public static void main(String[] args) {

		int[] data = { 23, 5, 9, 22, 6, 13, 2 };

		System.out.println("Array before insertionSort:");
		for (int i : data) {
			System.out.println(i + " ");
		}

		insertionSort(data);

		System.out.println("Array after insertionSort:");
		for (int i : data) {
			System.out.print(i + " ");
		}

	}

	public static void insertionSort(int[] data) {

		int length = data.length;

		for (int i = 0; i < length; i++) {
			int current = data[i];
			int j = i - 1;

			while (j >= 0 && data[j] > current) {
				data[j + 1] = data[j];
				j = j - 1;
			}

			data[j + 1] = current;
		}
	}

}
