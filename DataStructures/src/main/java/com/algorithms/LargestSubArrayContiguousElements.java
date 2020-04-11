package com.algorithms;

/*
https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/
https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/

Given an array of distinct integers, find length of the longest subarray which contains numbers that can be arranged
in a continuous sequence. Note: elements of a sub array can be in any order, they will, however, be contiguous,
i.e., together.

Examples:
Input:  arr[] = {10, 12, 11};
Output: Length of the longest contiguous subarray is 3

Input:  arr[] = {14, 12, 11, 20};
Output: Length of the longest contiguous subarray is 2

Input:  arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
Output: Length of the longest contiguous subarray is 5

Approach 1 (Using List and Map as additional data structure, also sorting of array needed, list of lists returned)
1) Sort the array - BigO -> nlog(n)
2) Define a variable, maxSubArrayLength (say), iterate through array, check if A[i] + 1 == A[i], increment sub array
max if this is max so far.
3) If we also need the max sub array elements, define a map of Integer and List<Integer>, on else part of above step
add the temporary list with its size to the map.
4) Finally, use maxSubArrayLength as key and extract the List from the map, if we need the sub array elements too, else,
just return the maxSubArrayLength.
Time complexity from Iteration: O(n). Overall: nlog(n) + O(n) = O(n)

Approach 2: (No additional data structure needed, no sorting of array needed and also sub array can be returned)
The important thing to note in question is, it is given that all elements are distinct.
If all elements are distinct, then a subarray has contiguous elements if and only if the difference between
maximum and minimum elements in subarray is equal to the difference between last and first indexes of subarray.
So the idea is to keep track of minimum and maximum element in every subarray.
Steps:
1) define startElem and maxLength variables
2) Iterate through array, for every element, define mn and mx to be that element to start with.
3) Start another loop with i+1, keep computing min and max from A[i] till next elements.
4) Once we hit the contiguous sub array sector, diff between indices at start and beginning will become same as
   difference between min and max elements in that sector since numbers will be together there. Use this property
   and save maxLength and the start of the subarray, which will be A[i].
5) Finally, use the maxLength and startElem to compute a new contiguous integer array and return it.

 */

import java.util.*;

public class LargestSubArrayContiguousElements {

    public static void main(String[] args) {

        int[] A1 = {14, 12, 10, 11, 18, 21};
        int[] A2 = {14, 12, 11, 20};
        int[] A3 = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};

        int[] maxSubArray = findMaxSubArrayOptimized(A3);

        if (maxSubArray != null) {
            System.out.println("Largest Subarray size: " + maxSubArray.length);
            System.out.print("[");
            Arrays.stream(maxSubArray).forEach(elem -> System.out.print(elem + " "));
            System.out.print("]");
        } else {
            System.out.println("No continuous sub array found in given array!");
        }
    }

    // Use this one!
    private static int [] findMaxSubArrayOptimized(int[] A) {

        int [] result = null;

        // null check
        if (A == null || A.length < 2) return result;

        int len = A.length;
        int maxLength = 0;
        int startElem = 0;

        for (int i = 0; i < len - 1; i++) {

            int mn = A[i], mx = A[i];

            for (int j = i + 1; j < len; j++) {
                mn = min(mn, A[j]);
                mx = max(mx, A[j]);
                int diff = mx - mn;

                if (diff == j - i) {
                    // Found a subarray situation here!
                    int subArrayLen = diff + 1;
                    if (subArrayLen > maxLength) {

                        // Update and save the maxLength and first element of subArray
                        maxLength = subArrayLen;
                        startElem = mn;
                    }
                }
            }

        }

        // Construct an array now with maxLength and first element of the sub array and return it
        if (maxLength > 0) {
            int elem = startElem;
            result = new int[maxLength];
            for (int i=0; i<maxLength; i++) {
                result[i] = elem;
                elem++;
            }
        }
        return result;
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    // This returns a list for simplicity but you can construct an array as well and return it
    private static List<Integer> findMaxSubArray(int[] A) {

        if (A == null || A.length < 2) return new ArrayList<>();

        // Let's sort the array
        Arrays.sort(A);

        // Let's find the sub arrays and their length
        int maxSubArrayLength = 0;
        int len = A.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> temp = null;
        int startElem;

        for (int i = 0; i < len - 1; i++) {

            if (A[i] + 1 == A[i + 1]) {
                if (temp == null) {
                    temp = new ArrayList<>();
                }
                temp.add(A[i]);
                // Need to include last element if it is part of sub array
                if (i == len - 2) {
                    temp.add(A[i + 1]);
                    int size = temp.size();
                    if (size > maxSubArrayLength) {
                        maxSubArrayLength = size;
                    }
                    map.put(size, temp);
                    temp = null;
                }
            } else if (i > 0 && (A[i] - A[i - 1] == 1)) {
                // Add A[i] to temp
                if (temp != null) {
                    temp.add(A[i]);
                    int size = temp.size();
                    if (size > maxSubArrayLength) {
                        maxSubArrayLength = size;
                    }
                    map.put(size, temp);
                    // Set temp to null again
                    temp = null;
                }
            }
        }
        return map.get(maxSubArrayLength);
    }
}
