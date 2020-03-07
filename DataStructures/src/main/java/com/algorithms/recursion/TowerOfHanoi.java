package main.java.com.algorithms.recursion;

public class TowerOfHanoi {

	/*
	 * Discs can only be moved one at a time. Disc size varies from 1 being smallest to higher up in the order. Larger disc can not be kept
	 * on smaller one.
	 */

	public static void main(String[] args) {

		move(3, 'A', 'C', 'B');

	}

	private static void move(int n, char from, char to, char using) {
		if (n == 1) {
			System.out.println("Move disc " + n + " from tower " + from + " to tower " + to);
			return;
		}
		move(n - 1, from, using, to);
		System.out.println("Move disc " + n + " from tower " + from + " to tower " + to);
		move(n - 1, using, to, from);

	}

}
