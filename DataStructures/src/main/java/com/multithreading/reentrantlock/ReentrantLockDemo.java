package com.multithreading.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

	public static void main(String[] args) {

		// final Object lock = new Object();
		final Lock lock = new ReentrantLock();
		/*
		 * Condition is in Lock object and it has methods like await() and
		 * signal() which can be used as a replacement for wait() and notify()
		 * of Object class
		 */
//		Condition cond = lock.newCondition();
//		cond.await();
//		cond.notify();
//		cond.notifyAll();

		final Account acc1 = new Account(10000);
		final Account acc2 = new Account(10000);
		// acc1.transfer(acc1, acc2, 1000);

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				// synchronized(lock) {
				// acc1.transfer(acc1, acc2, 10);
				// }
				try {
					boolean tryLock = lock
							.tryLock(1, TimeUnit.MILLISECONDS);
					if (tryLock == true) {
						acc1.transfer(acc2, 10);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					// synchronized(lock) {
					// acc1.transfer(acc2, acc1, 10);
					// }
					try {
						lock.lock();
						acc1.transfer(acc2, 10);
					} finally {
						lock.unlock();
					}
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("New balance acc1: " + acc1.getBalance());
		System.out.println("New balance acc2: " + acc2.getBalance());

	}

}

class Account {

	private long balance;

	public Account(long balance) {
		this.balance = balance;
	}

	public long getBalance() {
		return balance;
	}

	public void transfer(Account acc2, long amount) {
		this.balance -= amount;
		acc2.balance += amount;
	}
}
