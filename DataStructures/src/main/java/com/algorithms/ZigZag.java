package com.algorithms;

/*
https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/

Convert array into Zig-Zag fashion
Given an array of DISTINCT elements, rearrange the elements of array in zig-zag fashion in O(n) time.
The converted array should be in form a < b > c < d > e < f.

Example:
Input: arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: arr[] = {3, 7, 4, 8, 2, 6, 1}
 */

import java.util.Arrays;

public class ZigZag {

    public static void main(String[] args) {

        int [] arr = {4, 3, 7, 8, 6, 2, 1};
        System.out.println("Original array:");
        Arrays.stream(arr).forEach(elem -> System.out.print(elem + " "));
        System.out.println();
        zigzag(arr);
        System.out.println("Array in zigzag fashion:");
        Arrays.stream(arr).forEach(elem -> System.out.print(elem + " "));

    }

    private static void zigzag(int[] arr) {

        int len = arr.length;
        boolean flag = true;

        for (int i=0; i<len-1; i++) {

            if (flag) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                }
            } else {
                if (arr[i] < arr[i+1]) {
                    swap(arr, i, i+1);
                }
            }
            flag = !flag;   // flip flag
        }
    }

    private static void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
