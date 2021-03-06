package com.algorithms.arrays;

import java.math.BigInteger;

public class PrimeNumber {

	public static void main(String[] args) {

		int num = 100;

		// System.out.println("The number " + num + " is "
		// + (new PrimeNumber().isPrime1(num) ? "prime." : "not prime."));

		System.out.println("Printing prime numbers till " + num + ":");
		System.out.println(2);
		int num_primes = 0;

		if (num >= 2) num_primes++;

		for (int i = 3; i <= num; i += 2) {
			if (new PrimeNumber().isPrime1(i)) {
				num_primes++;
				System.out.println(i);
			}
		}

		System.out.println("Number of prime numbers till " + num + ": " + num_primes);

		int num2 = 17;
		System.out.println("Let's check isPrime2 method!");
		System.out.println("Is " + num2 + " prime? " + new PrimeNumber().isPrime2(num2));


		// This is how to check a super large number, like with 100 digits to be prime or not!
		String num3 = "1111111111111111111111111111111111111111111111111111111111117";
		System.out.println("Let's check isPrimeBigInteger method!");
		System.out.println("Is " + num3 + " prime? " + new PrimeNumber().isPrimeBigInteger(new BigInteger(num3)));

		String num4 = "669483106578092405936560831017556154622901950048903016651285";
		System.out.println("Is " + num4 + " prime? " + new PrimeNumber().isPrimeBigInteger(new BigInteger(num4)));

	}

	public boolean isPrime1(int num) {

		if (num <= 1) {
			System.out.println("Please enter a number more than 1.");
			return false;
		}

		if (num == 2 || num == 3) {
			return true;
		}

		if (num % 2 == 0) {
			System.out.println("Even numbers can never be prime.");
			return false;
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

	public boolean isPrimeBigInteger(BigInteger bigInt) {

		boolean isPrime = false;

		if (
				// 1, by definition, is not prime
				bigInt.compareTo(BigInteger.ONE) == 0
				|| !bigInt.isProbablePrime(1)) {
			// keep isPrime as false
		} else if (
				// numbers 2 & 3 are prime
				bigInt.compareTo(BigInteger.valueOf(2)) == 0
				|| bigInt.compareTo(BigInteger.valueOf(3)) == 0
				// If (num * num -1) % 24 == 0, it is a prime number
				|| (bigInt.multiply(bigInt).subtract(BigInteger.ONE)
				.remainder(BigInteger.valueOf(24)).equals(BigInteger.ZERO))) {
			isPrime = true;
		}

		return isPrime;

	}

}
