package com.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParantheses {

	public static void main(String[] args) {

		String str = "[(5+6)*{6*7}[(7+9)]]";
		System.out.println("String "
				+ str
				+ (isBalancedParantheses(str) ? " is balanced."
						: " is not balanced."));

	}

	/*
	 * The approach is, for every closing parentheses there has to be an opening pair as last closed
	 * one right before this Ignore numbers and operators (+, -, *, etc)
	 */
	private static boolean isBalancedParantheses(String str) {

		int len = str.length();
		Stack<Character> stack = new Stack<Character>();
		Map<Character, Character> matchingParanthesesMap = new HashMap<Character, Character>();
		matchingParanthesesMap.put(']', '[');
		matchingParanthesesMap.put('}', '{');
		matchingParanthesesMap.put(')', '(');

		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			if (ch == ']' || ch == '}' || ch == ')') {
				if (stack.isEmpty()) {
					return false;
				} else {
					char topOfStack = stack.pop();
					char matchingOpeningPair = matchingParanthesesMap.get(ch);
					if (!(topOfStack == matchingOpeningPair)) {
						return false;
					}
				}
			} else {
				if (ch == '[' || ch == '{' || ch == '(') {
					stack.push(ch);
				}
			}
		}
		if (!stack.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
