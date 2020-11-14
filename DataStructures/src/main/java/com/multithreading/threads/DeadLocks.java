package com.multithreading.threads;

/**
 * A perfect Thread Deadlock situation demonstrated below! One thread can not release lock lock1, since it needs another
 * lock lock2 held by another thread before first thread can release lock1. Second thread in same situation, waiting
 * for lock1 before it can release lock2!
 * 
 * Fix this by keeping lock seeking and releasing in same order.
 *
 */

public class DeadLocks {

	public static Object lock1 = new Object();
	public static Object lock2 = new Object();

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			
			synchronized (lock1) {

				System.out.println("Thread 1 acquired lock1...");
				System.out.println("Thread 1 will now wait for lock2 before it can release lock1...");

				synchronized (lock2) {
					System.out.println("Thread 1 got lock2 now! Soon it can release lock1 as well!");
				}
			}

		});

		Thread t2 = new Thread(() -> {

			// Fix deadlock by changing below to synchronized(lock1) and similar change below too!
			synchronized (lock2) {

				System.out.println("Thread 2 aquired lock2...");

				System.out.println("Thread 2 will now wait for lock1 before it can release lock2...");
				System.out.println("\nHence, you've got a deadlock situation here!");
				// Fix deadlock by changing below to synchronized(lock2)
				// Basically, both the thread should acquire and release the locks in same order!
				synchronized (lock1) {
					System.out.println("Thread 2 got lock1 now! Soon it can release lock2 as well!");
					System.out.println("\nHence, you've got a deadlock situation here!");
				}
			}

		});

		t1.start();
		t2.start();

		// You need to do below to actually see the deadlock situation since with join on threads we are spinning off,
		// we will make the main thread wait till both t1 and t2 threads finish
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
