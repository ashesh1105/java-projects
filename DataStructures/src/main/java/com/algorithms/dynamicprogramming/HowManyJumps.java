package main.java.com.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HowManyJumps {

	/*
	 * Given an integer array and all elements representing the jumps you can do
	 * in terms of passing number of elements, find a combination that will get
	 * you to last element of the array.
	 * Example:
	 * int [] arr = {1, 3, 5, 2, 1, 9, 3, 4}
	 * Shortest number of jumps: 3
	 * Jumps (indices): 0 -> 1 -> 2 -> 7
	 * 
	 * StaticInnerClassDemo described at: https://www.youtube.com/watch?v=cETfFsSTGJI
	 */

	public void findJumps(int [] arr) {
		// TODO: check boundary conditions (null, empty and single element array)
		
		int len = arr.length;
		// Declare two arrays to store number of jumps (nj) and actual jumps (aj)
		int [] numJumps = new int[len];
		int [] jumpFrom = new int[len];
		
		// No jump needed for first position, nj[0] is zero by default
		jumpFrom[0] = -1;
		/*
		 * Loop through array with two pointers, i from 1 to len-1 and j from 0 to i.
		 * Check for each value of j if one can jump from j to i,
		 * if so, update the numJumps array to jumps needed on previous step plus 1.
		 * Do above only if jumps needed from new value of j is lower than existing value of numJumps at i
		 */
		for (int i=1; i<len; i++) {
			int j = 0;
			while (j < i) {
				if (arr[j] >= (i-j)) {
					int jumpNeeded = numJumps[j] + 1;
					if ((numJumps[i] == 0) || (jumpNeeded < numJumps[i])) {
						numJumps[i] = numJumps[j] + 1;
						// Update actual jumps array too with position where jump is made from
						jumpFrom[i] = j;
					}
				}
				j++;
			}
		}
		
		System.out.println("Mimimum number of jumps needed to get to end of array: " + numJumps[len-1]);
		
		List<Integer> result = new ArrayList<>();
		int jumpIndex = len-1;
		// Add the last index of jumpFrom to result
		int k = len-1;
		result.add(k);
		
		while (k > 0) {
			k = jumpFrom[k];
			result.add(k);
		}
		// Reverse the result list so it is start to end
		Collections.reverse(result);
		
		// Print the path
		System.out.println("Actual jump: ");
		
		int size = result.size();
		for (int i=0; i<size; i++) {
			if (i < size-1) {
				System.out.print(result.get(i) + " -> ");
			} else {
				System.out.println(result.get(i));
			}
		}
	}
	
	public static void main(String[] args) {
		
		int [] arr = {1, 3, 5, 2, 1, 9, 3, 4};
		new HowManyJumps().findJumps(arr);

	}

}
