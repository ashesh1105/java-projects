package com.algorithms.arrays;

import java.util.Stack;

public class ParanthesesCombinationsByReplacingAstrisks {
	
	/*
	 * find the number of distinct balanced parentheses expressions you can make by replacing the ‘*’ with either 
	 * ‘(‘ or ‘)’ or removing the ‘*’
	 * 
	 * Sample Input: 
	 * (*(*)*)
	 * 
	 * Sample Output: 5
	 * 
	 * Explanation: ((())), ()(()), ()()(), (())(), (())
	 * 
	 * This is not solved yet! Find ways to solve it!!
	 * 
	 */

	public static void main(String[] args) {
		
		String data = "(*(*)*)";
		
		new ParanthesesCombinationsByReplacingAstrisks().getParanthesesCombinations(data);

	}

	public long getParanthesesCombinations(String data) {
		
		long result = 0;
		
		Stack stack = new Stack();
		
		for (int i=0; i<data.length(); i++) {
			char ch = data.charAt(i);
			if (ch == '(') {
				stack.push(ch);
			} else {
				
			}
		}
		
		return result;
		
	}

}
