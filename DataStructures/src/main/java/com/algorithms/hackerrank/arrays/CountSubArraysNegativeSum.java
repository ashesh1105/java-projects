package com.algorithms.hackerrank.arrays;

import java.util.Scanner;

/*
Find all sub arrays with sum of elements which are negative. Take two line inputs from user, 1st one will be number
of lines and second line will contain space separated integers for array elements. Print total number of sub arrays
which have overall negative count. Note: sub arrays are contiguous elements in forward direction.

Example:
Input:
3
1 -2 1
Output:
3
Explanation:
Sum of [1, -2] = -1
Sum of [-2] = -2
Sum of [-2, 1] = -1
Result: 3
 */

public class CountSubArraysNegativeSum {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String [] strArr = in.nextLine().split("\\s+");

        long result = 0;
        for (int i=0; i<n; i++) {
            int sum = 0;
            int j=i;
            while (j<n) {
                sum += Integer.parseInt(strArr[j]);
                if (sum < 0) result++;
                j++;
            }
        }
        System.out.println(result);
    }

}
