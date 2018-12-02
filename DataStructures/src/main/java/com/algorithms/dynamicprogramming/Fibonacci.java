package com.algorithms.dynamicprogramming;

public class Fibonacci {

	// 1, 2, 3, 5, 8, 13. f(n) = f(n-1) + f(n-2)

	// private Map<Integer, Integer> map;
	//
	// public Map<Integer, Integer> getMap() {
	// return map;
	// }
	//
	// public void setMap(Map<Integer, Integer> map) {
	// this.map = new HashMap<Integer, Integer>();
	// }

	private int operationsCount = 0;
	private int recursiveRunCount = 0;

	public int getRecursiveRunCount() {
		return recursiveRunCount;
	}

	public void setRecursiveRunCount(int recursiveRunCount) {
		this.recursiveRunCount = recursiveRunCount;
	}

	public void setOperationsCount(int operationsCount) {
		this.operationsCount = operationsCount;
	}

	public int getOperationsCount() {
		return operationsCount;
	}

	public Fibonacci() {
		super();
		// map = new HashMap<Integer, Integer>();
		operationsCount = 0;
	}

	public static void main(String[] args) {

		int n = 20;

		Fibonacci fibonacci = new Fibonacci();

		System.out.println("Next fibonacci number for n=" + n + " with recursion: "
				+ fibonacci.computeFibonacci1(n));
		System.out.println("Big(O) - number of operations: " + fibonacci.getOperationsCount());
		System.out.println("Number of times Function was run recursively: "
				+ fibonacci.getRecursiveRunCount());

		fibonacci.setOperationsCount(0);
		fibonacci.setRecursiveRunCount(0);

		System.out.println("\nNext fibonacci number for n=" + n + " with dynamic programming: "
				+ fibonacci.computeFibonacci2(n));
		System.out.println("Big(O) - number of operations: " + fibonacci.getOperationsCount());

	}

	public int computeFibonacci1(int n) {

		// To count how many times this function is run recursively to reach the end result
		recursiveRunCount++;

		if (n <= 2) {
			operationsCount++;
			return n;
		} else {
			operationsCount++;
			return computeFibonacci1(n - 2) + computeFibonacci1(n - 1);
		}
	}

	/*
	 * Think over below in coming time
	 */
	// public int computeFibonacci2(int n) {
	//
	// if (map.containsKey(n)) {
	// operationsCount++; // for map.get below
	// return map.get(n);
	// }
	//
	// if (n <= 2) {
	// operationsCount++;
	// map.put(n, n);
	// return n;
	// } else {
	// operationsCount++; // for map.put below
	// map.put(n, computeFibonacci1(n - 2) + computeFibonacci1(n - 1));
	// return map.get(n);
	// }
	// }

	public int computeFibonacci2(int n) {

		if (n <= 2) {
			operationsCount++;
			return n;
		} else {
			int prevElement = 1, lastElement = 1, fibonacci = 1;
			// run till i < n-1 because lastElement is one place more than i during every iteration
			for (int i = 0; i < n - 1; i++) {
				operationsCount++;
				fibonacci = prevElement + lastElement;
				operationsCount++;
				prevElement = lastElement;
				operationsCount++;
				lastElement = fibonacci;
			}
			return lastElement;
		}
	}

}
