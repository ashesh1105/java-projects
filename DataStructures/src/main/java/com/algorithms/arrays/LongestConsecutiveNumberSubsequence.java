package com.algorithms.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Input: arr[] = {1, 9, 3, 10, 4, 20, 2};
Output: 4
The subsequence 1, 3, 4, 2 is the longest subsequence
of consecutive elements

Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
Output: 5
The subsequence 36, 35, 33, 34, 32 is the longest subsequence
of consecutive elements. Element order is not important here as log as it can be rearranged as 32, 33, 34, 35, 36

StaticInnerClassDemo:
1) Create an empty hash.
2) Insert all array elements to hash.
3) Do following for every element arr[i]
....a) Check if this element is the starting point of a 
       subsequence.  To check this, we simply look for
       arr[i] - 1 in hash, if not found, then this is
       the first element a subsequence.  
    
       If this element is a first element, then count 
       number of elements in the consecutive starting 
       with this element.

       If count is more than current res, then update    
       res.
 */

public class LongestConsecutiveNumberSubsequence {

	public static void main(String[] args) {
		
		int [] arr = {1, 9, 3, 10, 4, 20, 2};
        System.out.println("Array Input: ");
        Arrays.stream(arr).forEach(elem -> System.out.print(elem + ", "));
		System.out.println("Longest consecutive subsequence length in this array is: " + find(arr));

        int [] arr1 = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
        System.out.println("\nArray Input: ");
        Arrays.stream(arr1).forEach(elem -> System.out.print(elem + ", "));
        System.out.println("Longest consecutive subsequence length in this array is: " + find(arr1));
	}
	
	// Returns length of the longest consecutive subsequence 
    static int find(int arr[]) {

	    int len = arr.length;
        HashSet<Integer> set = new HashSet<Integer>();
        int result = 0;
        StringBuilder subsequence = new StringBuilder();
        StringBuilder temp = new StringBuilder();
  
        // Hash all the array elements since we want to ignore dups and find availability of next number quickly
        for (int i=0; i<len; ++i)
            set.add(arr[i]);
  
        // check each possible sequence from the start then update optimal length
        for (int i=0; i<len; ++i) {
            // if current element is the starting element of a sequence, meaning its not part of another sequence
            // which will be obvious if this element - 1 is already present in the set
            if (!set.contains(arr[i]-1)) {
                // Then check for next elements in the 
                // sequence 
                int elem = arr[i];

                while (set.contains(elem)) {
                    temp.append(elem + " -> ");
                    elem++;
                }
  
                // update  optimal length if this length is more
                int subsequenceLength = elem - arr[i];  // elem is now one more than last one in subsequence
                if (result < subsequenceLength) {
                    result = subsequenceLength;
                    // Clear StringBuilder from earlier max subsequence and refill with new max
                    subsequence.delete(0, subsequence.length());
                    subsequence.append(temp.toString());
                }
                // Clear temp StringBuilder on every iteration
                temp.delete(0, temp.length());
            } 
        }
        System.out.println("\nLongest Consecutive Subsequence: " + subsequence.toString());
        return result;
    }

}
