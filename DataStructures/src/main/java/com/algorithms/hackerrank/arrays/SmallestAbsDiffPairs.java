package com.algorithms.hackerrank.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given an Integer array, find the pair of elements with smallest absolute difference. If there are more of them with
 same smallest absolute difference, find all of them.

 Example:
 arr = [5, 2, 3, 4, 1]
 Output:
 result_arr = [1, 2, 2, 3, 3, 4, 4, 5] since we got 4 pairs with same and smallest abs difference here:
 (1, 2), (2, 3), (3, 4), (4, 5)
 */

public class SmallestAbsDiffPairs {

    public static void main(String[] args) {

        int [] arr = {-20, -3916237, -357920, -3620601, -520, 7374819, -7330761, 30, 6246457, -6461594, 266854, -470};
        int [] smallestPairs = closestNumbers(arr);
        for (int elem : smallestPairs) {
            System.out.print(elem + " ");
        }

    }


    static int[] closestNumbers(int[] arr) {

        // Null and Empty array checks
        if (arr == null || arr.length == 0) return null;

        int smallestAbsDiff = Integer.MAX_VALUE;
        List<List<Integer>> smallestPairs = new ArrayList<>();

        Arrays.sort(arr);

        for (int i=1; i<arr.length; i++) {
            int absDiff = Math.abs(arr[i] - arr[i-1]);

            if (absDiff > smallestAbsDiff) continue;

            if (absDiff < smallestAbsDiff) {
                smallestAbsDiff = absDiff;
                smallestPairs = new ArrayList<>();
            }
            List<Integer> pair = new ArrayList<>();
            pair.add(arr[i-1]);
            pair.add(arr[i]);
            smallestPairs.add(pair);
        }


        // Get size of smallest pairs list
        int size = smallestPairs.size() * 2; // since each list element will have pairs
        int [] result = new int[size];

        // Pupulate the result array and return it
        int idx = 0;
         for (List<Integer> list : smallestPairs) {
             result[idx++] = list.get(0);
             result[idx++] = list.get(1);
         }

         return result;
    }

}
