package com.algorithms.recursion;

public class Factorial {

	public static void main(String[] args) {
		
		System.out.println(factorial(6));

	}
	
	private static int factorial(int n) {
		
		if (n == 0) {
			return 1;
		}
		
		return n * factorial(n-1);
	}

}
