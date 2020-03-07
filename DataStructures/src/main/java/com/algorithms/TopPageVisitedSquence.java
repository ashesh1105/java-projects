package main.java.com.algorithms;

public class TopPageVisitedSquence {

	/*
	 * You are given a file which contains the following information about users visiting the eBay website:
	 * <user id> <type of page visited> <time stamp> <user id> is a unique key assigned to every user <type of
	 * page> is one of these "home", "search results", "check out", "payment". The file contains this
	 * information sorted according to the time stamp. A sequence is defined as a continuous set of three
	 * types of pages visited by a user. Example: if a user visits the following pages. "home" -> "search" ->
	 * "search" -> "check out" {home, search, search} is one sequence for the user, {search, search, checkout}
	 * is another sequence for the user. Design and code to determine which sequence occurs the maximum number
	 * of times (for all users).
	 * 
	 * Approach: 
	 * 1) Design a method that takes ArrayList<String> with pages visited in the order of timestamp.
	 * 2) Use a HashTable<String, Integer> or map to store sequence of pages visited with occurrences
	 * 3) Key of above will be 3 continuous concatenated values from ArrayList, if they exist.
	 * 4) Check for i + 2 < length as condition before computing key and occurrences for map.
	 * 5) Use a max_value variable to store max occurrence and specific 3 pages of sequence
	 * Once reach till end of ArrayList, return the sequence with max occurrence.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
