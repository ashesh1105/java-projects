package com.multithreading.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocalizedLocks {
	/*
	 * This is a demo of the thread interlocking issues and how to avoid that.
	 * Two threads try to work on two lists but they are processed in two
	 * different methods. We can either synchronize StageOne and StageTwo
	 * methods but that will cost 4+ seconds since both the threads in that case
	 * will try to hold the lock on entire object. For this reason, it is better
	 * to create two separate locks as lock1 and lock2 and synchronize the
	 * blocks of code which we need based on those locks. Please also note that
	 * the intent should be to allow threads holding locks for least amount of
	 * time and give chance for other threads to work on that block of code. If
	 * we do the for loop inside of StageOne and StageTwo, for example, we see
	 * 4+ seconds taken in overall processing since thread1 will hold lock1 for
	 * entire 1000 sec which will make thread2 wait that long to update just the
	 * list1. Hence it is better to add the for loop in processLists method as
	 * there thread t1 gets lock1 for 1 ms in StageOne, releases it, gets to
	 * StageTwo and that allows thread t2 to acquire lock1 for StageOne. By the
	 * time t1 is done with lock2 in StageTwo (~1 ms), thread t2 gets the chance
	 * to acquire lock2 in StageTwo and so on. So the tasks really executes in
	 * parallel here this way!
	 */
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	private Random random = new Random();

	// Create two locks so we do not need to lock the entire object with method
	// level locking
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	private void StageOne() {
		// Do not synchronize on entire method, do it on block of code instead
		// with custom lock object
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			list1.add(random.nextInt(100));
		}
	}

	private void StageTwo() {
		// Same as above
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			list2.add(random.nextInt(100));
		}

	}

	public void processLists() {
		for (int i = 0; i < 1000; i++) {
			StageOne();
			StageTwo();
		}
	}

}
