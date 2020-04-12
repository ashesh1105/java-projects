package com.algorithms.arrays.geeksforgeekstop10;

/*
https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/
https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/

Smallest sub array with sum greater than a given value. Remember, sub arrays are contiguous elements.
Given an array of integers and a number x, find the smallest length of sub array with sum greater than the given value.

Examples:
arr[] = {1, 4, 45, 6, 0, 19}
   x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}

arr[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Minimum length subarray is {10}

arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
    x = 280
Output: 4
Minimum length subarray is {100, 1, 0, 200}

arr[] = {1, 2, 4}
    x = 8
Output : Not Possible
Whole array sum is smaller than 8.

Approach:
Simple Approach: O(n^2)
1) Iterate through each element, have nested loop, check every possible sub array sum.
2) For sub arrays with some more than given number, maintain minLength and finally return that.
Time complexity: O(n^2)

Efficient Approach: O(n)
1) Maintain variables: start=0, minLength=length of array + 1, sum = 0
2) Iterate through array, for each A[i], add it to sum, check if sum > given number.
3) If so, change min length to min of earlier and i-start+1, basically the sub array from start to i
4) Have a while loop with sum > given number and each increment start by 1 and adjust minLength if:
   sum - A[start] > given number. Basically, see if lower sub array will still give the sum we need.
5) Finally, return minLength
Time complexity with this: O(n)
 */

public class SmallestSubArrLengthSumGreaterThanNum {

    public static void main(String[] args) {

        int [] A1 = {1, 4, 45, 6, 0, 19};
        int x1 = 51;
        int [] A2 = {1, 10, 5, 2, 7};
        int x2 = 9;
        int [] A3 = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        int x3 = 280;

        int minLenSubArrayWithSumGreaterThanNum = efficientApproach(A1, x1);

        if (minLenSubArrayWithSumGreaterThanNum == -1 || minLenSubArrayWithSumGreaterThanNum == A1.length + 1) {
            System.out.println("Not found!");
        } else {
            System.out.println(minLenSubArrayWithSumGreaterThanNum);
        }
    }

    private static int efficientApproach(int[] A, int num) {

        // null check
        if (A == null || A.length < 1) return -1;

        int len = A.length;
        int minLength = A.length + 1;
        int start = 0;
        int sum = 0;

        for (int i=0; i<len; i++) {

            sum += A[i];

            if (sum > num) {

                // Change the minLength, found a new minimum
                minLength = reCalcMinLength(start, i, minLength);

                // Now check if we can be okay with smaller sub array, i.e., can we move start?
                while (sum > num) {
                    if (sum - A[start] > num) {
                        sum -= A[start];
                        start++;
                        // Change the minLength, found a new minimum
                        minLength = reCalcMinLength(start, i, minLength);
                    } else break;
                }
            }
        }

        return minLength;
    }

    private static int reCalcMinLength(int start, int currIdx, int minLength) {
        return currIdx - start + 1 < minLength ? currIdx - start : minLength;
    }

    private static int simpleApproach(int[] A, int sum) {

        if (A == null || A.length == 0) return -1;

        int minLength = A.length + 1;
        int len = A.length;

        for (int i=0; i<len; i++) {

            if (A[i] > sum) return 1;
            int curr_sum = A[i];

            for (int j=i+1; j<len; j++) {
                curr_sum += A[j];
                if (curr_sum > sum) {
                    int temp = j-i+1;
                    if (temp < minLength) {
                        minLength = temp;
                    }
                }
            }
        }

        return minLength;
    }
}
