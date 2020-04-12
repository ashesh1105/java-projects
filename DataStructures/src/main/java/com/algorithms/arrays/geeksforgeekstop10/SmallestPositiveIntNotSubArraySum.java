package com.algorithms.arrays.geeksforgeekstop10;

/*
https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/
https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/

Find the smallest positive integer value that cannot be represented as sum of any subset of a given sorted array:

Given a sorted array (sorted in non-decreasing order) of positive numbers, find the smallest positive integer value
that cannot be represented as sum of elements of any subset of given set.
Expected time complexity is O(n).

Examples:
Input:  arr[] = {1, 3, 6, 10, 11, 15};
Output: 2

Input:  arr[] = {1, 1, 1, 1};
Output: 5

Input:  arr[] = {1, 1, 3, 4};
Output: 10

Input:  arr[] = {1, 2, 5, 10, 20, 40};
Output: 4

Input:  arr[] = {1, 2, 3, 4, 5, 6};
Output: 22

Solution:
Approach 1: Brute force: look for every possible sub arrays and check sum for min positive integer. Very expensive!
Approach 2:
1) Iterate through array from i=0 to length-1. Let's assume result is res.
2) At any i, we have following two possibilities:
2.1) A[i] > res, then result will be res.
2.2) A[i] is not greater than res, that means min positive integer will have to at least more by this element, so
     add A[i] to res and proceed to checking next elements.

** Note: elements are in non decreasing order!!
** Note: Sub arrays have to be continuous, not in any random order!
 */

public class SmallestPositiveIntNotSubArraySum {

    public static void main(String[] args) {

        int [] A1 = {1, 3, 6, 10, 11, 15};
        int [] A2 = {1, 1, 1, 1};
        int [] A3 = {1, 1, 3, 4};
        int [] A4 = {1, 2, 5, 10, 20, 40};
        int [] A5 = {1, 2, 3, 4, 5, 6};

        int result = smallestPositiveIntNotSubArraySum(A5);
        System.out.println("The smallest positive integer that can not be represented by sum of any subarrays of" +
                " given array: " + result);
    }

    private static int smallestPositiveIntNotSubArraySum(int[] A) {

        int result = 1;

        for (int i=0; i<A.length; i++) {
            if (A[i] > result) break;
            else result += A[i];
        }

        return result;
    }

}
