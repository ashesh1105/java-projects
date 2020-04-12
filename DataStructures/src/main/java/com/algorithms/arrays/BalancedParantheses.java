package com.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParantheses {

	public static void main(String[] args) {

		String str1 = "[(5+6)*{6*7}[(7+9)]]";
		String str2 = "[(5+6)*{6*7}}[(7+9)]]";
		System.out.println("String "
				+ str1
				+ (isBalancedParantheses(str1) ? " is balanced."
						: " is not balanced."));
		System.out.println("String "
				+ str2
				+ (isBalancedParantheses(str2) ? " is balanced."
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

	// Another way of doing it without using map or stack, leveraging regex
	// TODO: Check why this always gave same results! May be bug lies towards the end where we ensure no paranthesis left
//	private static boolean isBalancedParanthesesRegex(String input) {
//
//		// Replace every pair of (), {} or [] by "", meaning remove them from input string
//		// In regex, \\(\\) is one pair of ( and ), first occurrence of ) after first occurrence of (, and so on
//		while(input.length() != (input = input.replaceAll("\\(\\)|\\[\\]|\\{\\}", "")).length());
//
//		System.out.println(input);
//
//		// Now, input should not contain any of (, ), {, }, [ or ] characters!
//		Pattern pattern = Pattern.compile("\\(\\)|\\{\\}|\\[\\]");
//		Matcher matcher = pattern.matcher(input);
//
//		System.out.println(input.matches("\\(\\)|\\{\\}|\\[\\]"));
//
//		return !matcher.matches();
//	}

}
