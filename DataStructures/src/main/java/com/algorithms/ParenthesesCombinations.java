package com.algorithms;

import java.util.ArrayList;
import java.util.List;

public class ParenthesesCombinations {

	/*
	 * Given a number, print all valid parentheses combination for that number.
	 * Like for n = 3 output would be ()()(), (())(), ()(()), (()()), ((()))
	 * 
	 * Check Resources folder for a white board on call stack from below code!
	 * 
	 * Also, try caching (memoization) to reduce call stack and improve performance.
	 */

	public static void main(String[] args) {
		int n = 4;
		List<String> combinations = new ParenthesesCombinations()
				.getCombinations(n);
		System.out.println("With n = " + n + ", " + combinations.size()
				+ " combinations are possible:");
		for (String combination : combinations) {
			System.out.println(combination);
		}
	}

	public List<String> getCombinations(int n) {
		List<String> result = new ArrayList<String>();
		getCombinations(n, 0, "", result);
		return result;
	}

	private void getCombinations(int available, int currentlyOpen,
			String prefix, List<String> acc) {
		// First possibility: add opening parenthesis (only if parentheses are
		// still available)
		if (available > 0) {
			getCombinations(available - 1, currentlyOpen + 1, prefix + "(", acc);
		}
		// Second possibility: add closing parenthesis (only if at least one is
		// open)
		if (currentlyOpen > 0) {
			getCombinations(available, currentlyOpen - 1, prefix + ")", acc);
		}
		// If no parentheses are left and all of them are closed, we're done for one combination
		if (available == 0 && currentlyOpen == 0) {
			acc.add(prefix);
		}
	}

}
