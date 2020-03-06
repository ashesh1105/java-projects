package main.java.com.algorithms.dynamicprogramming;

import lombok.Getter;

public class StepsProblem {

	/**
	 * Reference: https://www.youtube.com/watch?v=5o-kdjv7FD0 Given number of steps and you're allowed to take 1 or 2 steps at a time, find
	 * out the combinations of steps you can climb up to get to the top Example: N = 2 Result: 2. You can either climb up one step at a time
	 * or two, so number ways = 2
	 * 
	 * A variation of this problem is, an arrays specifies how many steps you can take. Example: N = 4. Steps can be taken from {1, 3, 5}
	 * Result: 2. Either 1 step at a time or 1 step and then 3 steps (its actually 3: 1+1+1+1, 1+3, 3+1. Check!!
	 */

	@Getter
	private int numCalls;

	public static void main(String[] args) {

		StepsProblem sp = new StepsProblem();
		int steps = 30;
		// System.out.println(steps + " Steps, can be climed in " + sp.findWays(steps) + " ways.");
		// System.out.println("Recursive function was called " + sp.getNumCalls() + " times");

		System.out.println(steps + " Steps, can be climed in " + sp.findWaysOptimized(steps) + " ways.");
	}

	private int findWays(int steps) {
		numCalls++;
		int result = 0;
		if (steps == 1 || steps == 0) {
			result = 1;
		} else if (steps < 0) {
			result = 0;
		} else {
			result = findWays(steps - 1) + findWays(steps - 2);
		}
		return result;
	}

	// Steps problem comes down to Fibonacci problem where way for n steps = ways(n-1) + ways(n-2)
	// So we just need to memoize last 2 results and not all of them!
	private int findWaysOptimized(int steps) {
		
		int previous = 1, lastElement = 1, current = 0;
		
		for (int i=2; i<=steps; i++) {
			current = lastElement + previous;
			previous = lastElement;
			lastElement = current;
		}
		return current;
	}

}
