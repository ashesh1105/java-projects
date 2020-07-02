package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDips {

	/*
	 * Given an integer array, find all the dips on it. e.g, for array {2, 5, 6,
	 * 9, 3, 5, 7}, the dips will be 2, 3.
	 */

	public static void main(String[] args) {

		int[] array = { 20, 21, 23, 25, 22, 29, 36, 55, 56, 38, 41 };

		List<Integer> dips = new FindDips().findDips(array);
		
		System.out.println(dips);

	}

	public List<Integer> findDips(int[] array) {
		
		List<Integer> result = new ArrayList<Integer>();
		int len = array.length;
		
		for (int i=0; i<len; i++) {
			if((i == 0 || array[i] < array[i-1]) && (i == len-1 || array[i] < array[i+1])) {
				result.add(array[i]);
			}
		}
		return result;
	}

}
