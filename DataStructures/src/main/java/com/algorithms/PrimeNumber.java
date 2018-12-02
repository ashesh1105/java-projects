package com.algorithms;

public class PrimeNumber {

	public static void main(String[] args) {

		int num = 11;

		// System.out.println("The number " + num + " is "
		// + (new PrimeNumber().isPrime1(num) ? "prime." : "not prime."));

		System.out.println("Printing prime numbers till 100:");
		System.out.println(2);

		for (int i = 3; i <= 1000; i += 2) {
			if (new PrimeNumber().isPrime1(i)) {
				System.out.println(i);
			}
		}
	}

	public boolean isPrime1(int num) {

		if (num <= 1) {
			System.out.println("Please enter a number more than 1.");
			return false;
		}

		if (num % 2 == 0) {
			System.out.println("Even numbers can never be prime.");
			return false;
		}

		if (num == 3) {
			return true;
		}

		int sqrt = (int) Math.sqrt(num);

		for (int i = 3; i <= sqrt; i += 2) {
			if (num % i == 0) {
				// System.out.println("Number " + num + " is divisible by " + i);
				return false;
			}
		}
		return true;
	}

	/*
	 * Most optimized way to check prime!
	 * if (num * num - 1) % 24 comes as 0, it is a prime number. Make sure to start num from 5!!
	 */
	public boolean isPrime2(int num) {
		if (num <= 1) {
			return false;
		}
		if (num == 2 || num == 3) {
			return true;
		}
		if ((num * num - 1) % 24 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
