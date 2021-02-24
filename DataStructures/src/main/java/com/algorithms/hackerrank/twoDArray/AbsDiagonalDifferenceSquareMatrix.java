package com.algorithms.hackerrank.twoDArray;

import java.util.ArrayList;
import java.util.List;

/**
 Given a square matrix, calculate the absolute difference between the sums of its diagonals.

 For example, the square matrix arr is shown below:
 1 2 3
 4 5 6
 9 8 9
 The left-to-right diagonal = 1+5+9 = 15. The right to left diagonal = 3+5+9 = 17. Their absolute difference is
 |15-17| = 2.

 Solution:
 Indices of a square matrix looks like below:

 0,0 0,1 0,2 0,3
 1,0 1,1 1,2 1,3
 2,0 2,1 2,2 2,3
 3,0 3,1 3,2 3,3

 Square Matrix might be of any size, so we can not hard code indices. We will have to understand property that is
 common in two diagonals.
 Notice, for diagonal left top to bottom right, i,j varies as 0,0 1,1 2,2 3,3
 For diagonal left bottom to right top, on i,j, i goes from max to min index (i.e.), 3 to 0 and j goes from min to max,
 i.e., from 0 to 3. Let's use these properties to solve this problem generically!
 */

public class AbsDiagonalDifferenceSquareMatrix {

    public static int diagonalDifference(List<List<Integer>> arr) {

        // Find the size of square matrix
        int maxIdx = arr.size();
        int minIdx = 0;
        int diagTopToBottomSum = 0;
        int diagBottomToTopSum = 0;

        // Calculate top to bottom diagonal sum
        for (int i=0; i<maxIdx; i++) {
            diagTopToBottomSum += arr.get(i).get(i);
        }

        // Calculate bottom to top diagonal sum
        for (int i=maxIdx-1,j=minIdx; i>=0 && j<maxIdx; i--, j++) {
            diagBottomToTopSum += arr.get(i).get(j);
        }
        // Finally compute absolute difference and return it
        return Math.abs(diagTopToBottomSum - diagBottomToTopSum);
    }

    public static void main(String[] args) {

        // Create a square matrix using List
        List<List<Integer>> arr = new ArrayList<>();
        int size = 4;

        // Populate the list
        List<Integer> list1 = new ArrayList<>();
        list1.add(11);
        list1.add(2);
        list1.add(4);
        list1.add(5);
        arr.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(5);
        arr.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(10);
        list3.add(8);
        list3.add(-12);
        list3.add(5);
        arr.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(10);
        list4.add(9);
        list4.add(5);
        list4.add(5);
        arr.add(list4);

        int diagDifference = diagonalDifference(arr);
        System.out.println("Diagonal Difference of square matrix is: " + diagDifference);

    }

}
