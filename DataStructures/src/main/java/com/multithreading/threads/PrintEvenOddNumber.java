package com.multithreading.threads;

/*
 * wait() and notify() demo. One thread prints odd and another even number till 100
 * Remember two rules:
 * 1) Both wait() and notify() need to be called from synchronized block
 * 2) Both should be called on the common lock to get the results!
 */
public class PrintEvenOddNumber {

	private volatile int count = 1;
	private final int MAX_COUNT = 100;
	private Object lock = new Object();

	public static void main(String[] args) {

		final PrintEvenOddNumber peon = new PrintEvenOddNumber();

		Thread t1 = new Thread(() -> peon.printOdd());
		Thread t2 = new Thread(() -> peon.printEven());
		
		t1.start();
		t2.start();

		try {
			// Let the threads finish
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Final count: " + peon.getCount());

	}

	private void printOdd() {

		while (count < MAX_COUNT) {
			synchronized (lock) {
				// If a num & 1 == 1 then it is odd, (its first bit was set, else result would be 0)
				if ((count & 1) == 1) {
					System.out.println(Thread.currentThread().getName() + " "
							+ count);
					count++;
				}
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void printEven() {

		while (count < MAX_COUNT) {
			synchronized (lock) {
				if ((count & 1) == 0) {
					System.out.println(Thread.currentThread().getName() + " "
							+ count);
					count++;
				}
				lock.notify();
			}
		}
		count--;
	}

	public int getCount() {
		return this.count;
	}
}
