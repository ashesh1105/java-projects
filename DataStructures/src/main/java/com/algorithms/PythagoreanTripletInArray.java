package com.algorithms;

/*
https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/
https://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/

Pythagorean Triplet in an array
Given an array of integers, write a function that returns true if there is a triplet (a, b, c)
that satisfies a2 + b2 = c2.

Expected BigO -> No worst than O(n^3)

Example:
Input: arr[] = {3, 1, 4, 6, 5}
Output: True
There is a Pythagorean triplet (3, 4, 5).

Solution:
Brute Force Solution can be to iterate through array in 3 nested loops, check if A[i]*A[i] + A[j]*A[j] = A[k]*A[k]
Time complexity here will be O(n^3) which is not a desired one.

Optimized Solution:
1) Iterate through array and get square of array elements. Takes O(n) time.
2) Sort the array. Takes nlog(n) time.
3) Start with last element in the array and find the pair of other two elements whose sum will be that element.
   If not found, move to left, which is last but one element and look for pair again and so on. Takes nlog(n) time
   since the array is sorted.
So, overall, this takes O(n) + nlog(n) + nlog(n) times. Can we say O(n) that way? Even better than BigO(n^2)? :)

 */

import java.util.ArrayList;
import java.util.List;

public class PythagoreanTripletInArray {

    public static void main(String[] args) {

        int[] A = {3, 1, 4, 6, 5};
        List<Integer> result = findPythagoreanTriplets(A);
        if (result != null && result.size() > 0) {
            System.out.println("Found triplet!");
            System.out.print("[");
            result.forEach(elem -> System.out.print(elem + " "));
            System.out.println("]");
        }
    }

    private static List<Integer> findPythagoreanTriplets(int [] A) {

        List<Integer> result = null;

        // Null check
        if (A == null || A.length < 3) return result;

        // Get square of array elements. Ask interviewer if we can change the array, else make a new one
        int len = A.length;
        for (int i=0; i<len; i++) {
            A[i] = A[i]*A[i];
        }

        // Let's find the triplet(s) now. "Fix" last element, look for pair, then move to left
        for (int i=len-1; i>=2; i--) {

            int sum = A[i];
            int j=0;
            int k=i-1;

            while (j<k) {
                if (A[j] + A[k] == A[i]) {
                    // Found the triplet! You can return a boolean or actual triplet in a list
                    // We can also return a list of lists with all possible triplets, instead of returning, we just continue to next iteration
                    result = new ArrayList<>(); // Change to List of Lists, if we need all the possible triplets
                    result.add((int) Math.sqrt(A[j]));
                    result.add((int) Math.sqrt(A[k]));
                    result.add((int) Math.sqrt(A[i]));
                    return result;  // continue instead of return if we need list of all potential triplets
                } else {
                    if (A[j] + A[k] < A[i]) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }

}
