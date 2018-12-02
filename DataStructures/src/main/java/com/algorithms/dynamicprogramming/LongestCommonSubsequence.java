package com.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

	private static int numCalls_recursive;
	private static int numCalls_memoized;

	public static void main(String[] args) {

		String str1 = "aabdcrtiissf";
		String str2 = "adcrtubd";
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		System.out.println("Longest common subsequence of strings " + str1 + " " + str2 + " from recursive approach is: "
				+ lcs.lcmRecursive(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));

		System.out.println("Recursive approach involved " + numCalls_recursive + " times method calls.");

		System.out.println("Longest common subsequence of strings " + str1 + " " + str2 + " from memoization is: "
				+ lcs.lcmRecursiveOptimized(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));
		
		System.out.println("Recursive with memoization approach involved " + numCalls_memoized + " times method calls.");

	}

	// Recursive solution, can be expensive as O(2^len1*len2)
	// Check Recursive with Memoization (Dynamic Programming) added to it with
	// method below this
	private int lcmRecursive(char[] arr1, char[] arr2, int len1, int len2) {
		int result = 0;
		if (len1 == 0 || len2 == 0) {
			result = 0;
		} else if (arr1[len1 - 1] == arr2[len2 - 1]) {
			result = 1 + lcmRecursive(arr1, arr2, len1 - 1, len2 - 1);
		} else {
			int temp1 = lcmRecursive(arr1, arr2, len1, len2 - 1);
			int temp2 = lcmRecursive(arr1, arr2, len1 - 1, len2);
			result = Math.max(temp1, temp2);
		}
		numCalls_recursive++;
		return result;
	}

	// This is a variation of recursive approach where a cache is used to memoize the calls made
	// earlier. So # of times method is called gets drastically reduced.
	private int lcmRecursiveOptimized(char[] arr1, char[] arr2, int len1, int len2) {
		// Declare a cache to store precomputed results
		Map<String, Integer> cache = new HashMap<>();
		return doLcmRecursiveOptimized(arr1, arr2, len1, len2, cache);
	}

	private int doLcmRecursiveOptimized(char[] arr1, char[] arr2, int m, int n, Map<String, Integer> cache) {
		int result = 0;
		if (m == 0 || n == 0) {
			result = 0;
		} else if (arr1[m - 1] == arr2[n - 1]) {
			String key = Integer.toString(m - 1) + Integer.toString(n - 1);
			if (cache.containsKey(key)) {
				result = 1 + cache.get(key);
			} else {
				result = 1 + doLcmRecursiveOptimized(arr1, arr2, m - 1, n - 1, cache);
			}
		} else {
			String key1 = Integer.toString(m) + Integer.toString(n - 1);
			String key2 = Integer.toString(m - 1) + Integer.toString(n);
			int temp1 = cache.containsKey(key1) ? cache.get(key1) : doLcmRecursiveOptimized(arr1, arr2, m, n - 1, cache);
			int temp2 = cache.containsKey(key2) ? cache.get(key2) : doLcmRecursiveOptimized(arr1, arr2, m - 1, n, cache);
			result = Math.max(temp1, temp2);
		}
		cache.put(Integer.toString(m) + Integer.toString(n), result);
		numCalls_memoized++;
		return result;
	}

}
