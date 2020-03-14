package com.algorithms.hackerrank.arrays;

import java.util.Scanner;

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
