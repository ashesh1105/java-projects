package com.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;

public class KnapsackProblem {

	@Getter
	private long numCalls;

	@Getter
	Map<String, Integer> cache = new HashMap<>();
	
	@Getter
	List<Integer> knapsack = new ArrayList<>();

	/**
	 * 0-1 Knapsack Problem Given weight and values of n items, put these items in Knapsack of capacity c to get the maximum total value of
	 * knapsack Weight (kg) 1 | 2 | 4 | 2 | 5 Value($) 5 | 3 | 5 | 3 | 2
	 * Note** You can not take a fraction of an item. Either you take the whole or not at all
	 * 
	 * TODO: Solution below is based on recursion + memoization: https://www.youtube.com/watch?v=xOlhR_2QCXY
	 * and it returns max value knapsack can carry. Find out how we can get actual items??
	 * that need to be put into knapsack from recursive (+ memoization) approach. May be we need a bottom-up approach for it
	 * which is described here: https://www.youtube.com/watch?v=8LusJS5-AGo&t=127s
	 */

	public static void main(String[] args) {

		KnapsackProblem kp = new KnapsackProblem();

		// int[] weight = { 10, 20, 30, 10, 5, 2, 25 };
		// int[] value = { 60, 100, 120, 100, 10, 35, 40 };

//		int[] weight = { 20, 30, 40, 70 };
//		int[] value = { 70, 80, 90, 200 };
		
//		int[] weight = { 10, 20, 30 };
//		int[] value = { 60, 100, 120 };
		
		int[] weight = { 1, 3, 4, 5 };
		int[] value = { 1, 4, 5, 7 };
		
		int capacity = 7;
		int numItems = weight.length;

		System.out.println("Max value from knapsack: " + kp.getMaxValueInKnapsack(weight, value, numItems, capacity));
		System.out.println("Number of method calls from Recursive approach " + kp.getNumCalls());
		
		System.out.println("Knapsack Entry:");
		for (Map.Entry<String, Integer> entry : kp.cache.entrySet()) {
			System.out.print(entry.getKey() + " -> " + entry.getValue());
			System.out.println("");
		}

	}

	/**
	 * Here we are using recursion with memoization so number of method calls don't get too high.
	 * 
	 * @param weight
	 *            : array containing weight of items
	 * @param value
	 *            : array containing value of items on respective index of weight array
	 * @param numItems
	 *            : remaining number of items (total number of items on first method call and it comes down)
	 * @param capacity
	 *            : remaining capacity of knapsack (starts with max capacity and then it comes down
	 * @return
	 */
	private int getMaxValueInKnapsack(int[] weight, int[] value, int numItems, int capacity) {

		// Input validations
		// If arrays passed are empty or null
		// What if lengths of arrays passed are not same as numItems?
		// Can't do this check in recursive method. Either get this checked by caller or create a new method for recursion calls

		int result = 0;

		if (numItems <= 0 || capacity <= 0) {
			result = 0;
		} else if (weight[numItems-1] > capacity) {
			// TODO: Check cache here as well
			String key = Integer.toString(numItems-1) + Integer.toString(capacity);
			if (cache.containsKey(key)) {
				result = cache.get(key);
			} else {
				result = getMaxValueInKnapsack(weight, value, numItems - 1, capacity);
			}
		} else {
			String key1 = Integer.toString(numItems - 1) + Integer.toString(capacity - weight[numItems - 1]);
			String key2 = Integer.toString(numItems - 1) + Integer.toString(capacity);
			
			int temp1 = cache.containsKey(key1) ? value[numItems - 1] + cache.get(key1) : value[numItems - 1]
					+ getMaxValueInKnapsack(weight, value, numItems - 1, capacity - weight[numItems - 1]);
			int temp2 = cache.containsKey(key2) ? cache.get(key2) : getMaxValueInKnapsack(weight, value, numItems - 1, capacity);

			if (temp1 > temp2) {
				this.getKnapsack().add(numItems);
				result = temp1;
			} else {
				result = temp2;
			}
			result = Math.max(temp1, temp2);
		}
		numCalls++;
		cache.put(Integer.toString(numItems) + Integer.toString(capacity), result);
		return result;
	}
}
