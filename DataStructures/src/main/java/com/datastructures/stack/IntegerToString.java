package com.datastructures.stack;

import java.util.Stack;

public class IntegerToString {

	public static void main(String[] args) {
		
		int n = 100;
		IntegerToString intToStr = new IntegerToString();
		String s = intToStr.integerToString(n);
		System.out.println("Integer: " + n);
		System.out.println("String: " + s);

	}

	private String integerToString(int n) {
		String s = "";
//		Stack<Integer> stack = new Stack<>();
//		while (n != 0) {
//		     stack.push(n % 10);
//		     System.out.println(n);
//		     n = n / 10;
//		}
//		System.out.println("Stack is: " );
//		stack.forEach(elem -> System.out.println(elem));
//		while (!stack.isEmpty()) {
//		    s = s + stack.pop();
//		}
		return s;
	}

}
