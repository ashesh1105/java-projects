package com.algorithms.sorting.countingsort;

/**
 * Hackerrank problem

 This sorting algorithm takes more space, depending on max element in input array but it is faster than any
 other soring algorithm and Big O from this is Big O(n) instead of Big O(nlogn) from merge sort or quick sort!

 Steps:
 1) Find max element in input array and create a Frequency Array with size same as max element in input array + 1
 2) All the elements if Frequency Array will automatically be initialized to 0.
 3) Iterate input array and for each of its elements, go increment the value of frequency array of index same as element
 of input array. I.e., for element 3 of input array, increment the Frequency Array element at index 3 by 1.
 4) Create a result array with size same as input array and populate it from Frequency Array:
    4A) Iterate through Frequency Array, skip the elements with 0 as value.
    4B) Start populating result array from its index 0 with index of Frequency Table and repeat that further in result
    array based on frequency, which will be determined by value of Frequency Array elements

 */

public class CountingSort {

    public static void main(String[] args) {

        int [] data = {8, 2, 9, 10, 5};
        int [] sortedArr = countingSort(data);
        System.out.println("Sorted Array: ");
        for (int elem : sortedArr) {
            System.out.print(elem + " ");
        }

    }

    public static int[] countingSort(int[] arr) {

        // Null and empty checks
        if (arr == null || arr.length == 0) return arr;

        int [] result = new int[arr.length];

        // Find max element in input array. This operation: Big O(n)
        int maxVal = 0;
        for (int elem : arr) {
            if (elem > maxVal) {
                maxVal = elem;
            }
        }

        // Create and populate frequency array. This operation: Big O(n)
        int [] frequencyArr = new int[maxVal + 1];
        for (int elem : arr) {
            frequencyArr[elem] = frequencyArr[elem] + 1;
        }

        // Now, populate result array using index and frequency of non-zero values in frequency array
        // This operation: Big O(n)
        int resultIdx = 0;  // Index for result array

        for (int idx=0; idx<frequencyArr.length; idx++) {

            // Element with 0 in frequencyArray means original array did not has element same as idx
            if (frequencyArr[idx] != 0) {

                // For frequency more than 1, we want to repeatedly add same idx in result array
                for (int j=0; j<frequencyArr[idx]; j++) {
                    result[resultIdx++] = idx;
                }
            }
        }

        return result;
    }

}
