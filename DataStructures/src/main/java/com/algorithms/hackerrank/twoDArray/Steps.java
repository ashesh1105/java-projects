package com.algorithms.hackerrank.twoDArray;

public class Steps {

	/**
	 * Directions Write a function that accepts a positive number N. The function should console log a step shape with N
	 * levels using the # character. Make sure the step has spaces on the right hand side!
	 */
	// --- Examples
	// steps(2)
	// '# '
	// '##'
	// steps(3)
	// '# '
	// '## '
	// '###'
	// steps(4)
	// '# '
	// '## '
	// '### '
	// '####'

	public static void main(String[] args) {
		Steps steps = new Steps();
		steps.printSteps(5);
	}

	/**
	 * Solution: 
	 * a) Define a String as "steps(", let's say named as steps. 
	 * b) Define another string as "    '" (4 spaces + single quote) to match the pattern. Call it leftPad 
	 * c) Iterate (#1) on n from 2 to n (inclusive) - say with i
	 * d) On each #1 iteration, print steps String with System.out.print method (not println!) 
	 * e) Println i + ")" 
	 * f) Now we need another iteration with j (i times) and k (i times) within j's iteration f) on j's iteration, print
	 * leftPad and start k's iteration 
	 * g) In j's iteration, you basically get j x k metrics (2D array of j by k) 
	 * h) In k's iteration, if k <= j, print '#', else print space. This is based on above pattern 
	 * i) Once k's iteration is done, close that row by println ("'" + "\n") right before j's one iteration is done. 
	 * k) You're done!
	 */
	private void printSteps(int n) {
		String border = "steps(";
		String leftPad = "    '";
		StringBuilder sb = new StringBuilder();

		for (int i = 2; i <= n; i++) {
			sb.append(border);
			sb.append(i + ")" + "\n");

			for (int j = 1; j <= i; j++) {
				sb.append(leftPad);
				for (int k = 1; k <= i; k++) {
					if (k <= j)
						sb.append('#');
					else
						sb.append(' ');
				}
				sb.append("'" + "\n");
			}
		}
		System.out.println(sb.toString());
	}

	/**
	 * Alternate Solution (prefer above solution): 
	 * a) Define a String as "steps(", let's say named as steps. 
	 * b) Define another string as "    '" (4 spaces + single quote) to match the pattern. Call it leftPad 
	 * c) Iterate (#1) on n from 2 to n (inclusive) - say with i 
	 * d) On each #1 iteration, print String steps with System.out.print method (not println) e) Println i + ")" 
	 * f) Print (not println) string leftPad 
	 * g) Iterate on i with variable j from 1 to i (inclusive) - Iteration #2 
	 * h) With this iteration, iterate on j from 1 to j (inclusive) and print char '#' that many times 
	 * i) Another iteration, in parallel to above, from 1 to i-j inclusive and print spaces j) Finally
	 * Println "'" and you're done!
	 */
	private void printStepsAlternate(int n) {
		String border = "steps(";
		String leftPad = "    '";
		for (int i = 2; i <= n; i++) {
			System.out.print(border);
			System.out.println(i + ")");
			for (int j = 1; j <= i; j++) {
				System.out.print(leftPad);
				for (int k = 1; k <= j; k++) {
					System.out.print("#");
				}
				for (int l = 1; l <= i - j; l++) {
					System.out.print(" ");
				}
				System.out.println("'");
			}
		}
	}
}
