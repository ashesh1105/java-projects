package com.algorithms;

/*
https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/
https://www.geeksforgeeks.org/generate-all-possible-sorted-arrays-from-alternate-elements-of-two-given-arrays/

Generate all possible sorted arrays from alternate elements of two given sorted arrays.
Given two sorted arrays A and B, generate all possible arrays such that first element is taken from A then from B
then from A and so on in increasing order till the arrays exhausted.
The generated arrays should end with an element from B.

For Example:
A = {10, 15, 25}
B = {1, 5, 20, 30}
The resulting arrays are:
  10 20
  10 20 25 30
  10 30
  15 20
  15 20 25 30
  15 30
  25 30

  ** Trick here is to iterate through A, look for first greater number in B, add that array to result list but
  continue looking for more possible elements to form a bigger (new) array off that. Save that index from B,
  look for next greater number in A, but add that as new array and to earlier array only if you can find the next
  greater number in B. If you can't, then start from same element in A (original one in this iteration) and look
  for B element after we found first in this iteration (the saved one), hence form a new set of arrays and keep adding
  to list and clearing the temp list each time new array gets added to list.

  You'll have to define a new method to find next greater number in B or A, same method will be called alternatively.
  Since arrays are sorted, we can do binary search. Check out the method: findFirstGreaterElementIndex for that.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateArraysFromSortedArrays {

    public static void main(String[] args) {

        int[] A = {10, 15, 25};
        int[] B = {1, 5, 20, 30};

        List<int[]> result = getArrays(A, B);
        for (int[] arr : result) {
            System.out.print("[");
            Arrays.stream(arr).forEach(elem -> System.out.print(elem + " "));
            System.out.println("]");
        }

    }

    private static List<int[]> getArrays(int[] A, int[] B) {

        List<int[]> result = new ArrayList<>();

        // Null checks
        if (A == null || B == null) return result;

        int lenA = A.length;
        int lenB = B.length;
        List<Integer> temp = new ArrayList<>();
        int nextIdxA = 0;
        int nextIdxB = 0;
        boolean doneWithB;
        int nextGreaterElementIdxB = -1;

        for (int i = 0; i < lenA; i++) {

            nextIdxA = i;
            nextIdxB = -1;
            doneWithB = true;

            while (nextIdxA < lenA && nextIdxB < lenB) {

                nextIdxB = A[nextIdxA] > B[lenB - 1] ? -1 : findFirstGreaterElementIndex(B, A[nextIdxA], ++nextIdxB);

                if (nextIdxB == -1) break;

                temp.add(A[nextIdxA]);
                temp.add(B[nextIdxB]);
                addArrayToResult(temp, result);

                // We need to find more arrays at index i in A and with higher indices in B
                // Save the last index in B we are already working on
                if (nextIdxA == i && nextIdxB < (lenB - 1)) {
                    doneWithB = false;
                    nextGreaterElementIdxB = nextIdxB;
                }

                nextIdxA = B[nextIdxB] > A[lenA - 1] ? -1 : findFirstGreaterElementIndex(A, B[nextIdxB], ++nextIdxA);

                // No more elements found in A?
                if (nextIdxA == -1) {

                    if (doneWithB) break;

                    // Reset index of A to i and set index of B to index of first greater element in B we worked on
                    nextIdxA = i;
                    nextIdxB = nextGreaterElementIdxB;

                    // clear the temp list since we will be creating a new array now
                    temp.clear();

                    // Set doneWithB to true so this can be checked again on next iteration
                    doneWithB = true;
                    continue;
                }
            }
            temp.clear();
        }
        return result;
    }

    private static void addArrayToResult(List<Integer> temp, List<int[]> result) {

        int size = temp.size();
        int[] tempArr = new int[size];
        for (int j = 0; j < size; j++) {
            tempArr[j] = temp.get(j);
        }
        result.add(tempArr);
    }

    private static int findFirstGreaterElementIndex(int[] arr, int element, int startIndex) {

        int endIndex = arr.length - 1;
        int result = -1;

        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (arr[mid] >= element) {
                result = mid;
                // found one result, let's look on left array to find the first one
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return result;
    }

}
