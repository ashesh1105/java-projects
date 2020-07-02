package com.algorithms.arrays;

public class TopPageVisitedSquence {

	/*
	 * You are given a file which contains the following information about users visiting the eBay website:
	 * <user id> <type of page visited> <time stamp>. <user id> is a unique key assigned to every user <type of
	 * page> is one of these "home", "search results", "check out", "payment". The file contains this
	 * information sorted according to the time stamp. A sequence is defined as a continuous set of three
	 * types of pages visited by a user. Example: if a user visits the following pages. "home" -> "search" ->
	 * "search" -> "check out" {home, search, search} is one sequence for the user, {search, search, checkout}
	 * is another sequence for the user. Design and code to determine which sequence occurs the maximum number
	 * of times (for all users).
	 * 
	 * Approach: 
	   This is a TopK Problem. See:
https://github.com/ashesh1105/java-projects/blob/master/DataStructures/src/main/java/com/datastructures/heaps/TopKHeavyHitters.java
	   1) Define a Map of String and Integer. Key will be combination of 3 pages visited, like home -> search -> checkout
	      value will be frequency of them.
	   2) Populate this map for the time range we are interested. Bigger time ranges will need offline data pipeline.
	   3) Define a Min PriorityQueue of size k (if k==1, just iterate through map and get the max one.
	   4) On PriorityQueue, whenever k+1th element comes, pool the queue, which will remove the minimum element from it.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
