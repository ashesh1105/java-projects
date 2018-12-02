package com.algorithms.recursion;

public class SumOfSquares {
	
	private static int getSumOfSquares(int n) {
		
		// Breaking condition is extremely important!
		if (n == 1) {
			return 1;
		}
		
		return n * n + getSumOfSquares(n - 1);
	}
	
	public static void main(String[] args) {
		
		int n = 3;
		
		System.out.println("Sum of squares of number " + n + " is: " + getSumOfSquares(5));
		
	}

}
