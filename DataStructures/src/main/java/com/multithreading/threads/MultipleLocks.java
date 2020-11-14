package com.multithreading.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class demonstrates how using multiple locks can help threads run faster.
 * In this case, one thread using using lock1 and so another thread can use available lock lock2 to run another method
 * that called by process() method.
 *
 * This is a demo of the thread interlocking issues and how to avoid that. Two threads try to work on two lists but
 * they are processed in two different methods. We can either synchronize StageOne and StageTwo methods but that will
 * cost 4+ seconds since both the threads in that case will try to hold the lock on entire object. For this reason,
 * it is better to create two separate locks as lock1 and lock2 and synchronize the blocks of code which we need based
 * on those locks. Please also note that the intent should be to allow threads holding locks for least amount of time
 * and give chance for other threads to work on that block of code. If we do the for loop inside of StageOne and
 * StageTwo, for example, we see 4+ seconds taken in overall processing since thread1 will hold lock1 for entire
 * 1000 sec which will make thread2 wait that long to update just the list1. Hence it is better to add the for loop
 * in processLists method as there thread t1 gets lock1 for 1 ms in StageOne, releases it, gets to StageTwo and that
 * allows thread t2 to acquire lock1 for StageOne. By the time t1 is done with lock2 in StageTwo (~1 ms), thread t2
 * gets the chance to acquire lock2 in StageTwo and so on. So the tasks really executes in parallel here this way!
 */

public class MultipleLocks {

	private Random random = new Random();

	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	// Getters for above lists
	public List<Integer> getList1() {
		return list1;
	}

	public List<Integer> getList2() {
		return list2;
	}

	private void stageOne() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			list1.add(random.nextInt(100));
		}
	}

	private void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			list2.add(random.nextInt(100));
		}
	}

	public void process() {
		
		/**
		 * TODO: Find out more!!
		 * If I am thread1 and I am executing stageOne on lock1, so thread2 can not get lock1, can thread2 really work
		 * on stageTwo which needs lock2 and once done and I release lock1, thread2 can come back to stageOne to execute it?
		 * 
		 * Order of methods calls don't matter in this case??
		 * 
		 * If you run this, results prove that it is indeed working in above way. Weird multi-threading issues with
		 * Exceptions, timing, sizes lists get filed, are gone with this arrangement, but still find out why
		 * order of method calls don't matter and threads can switch between them based on locks that are available?
		 */

		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public static void main(String[] args) {

		MultipleLocks obj = new MultipleLocks();

		Thread t1 = new Thread(() -> {
			obj.process();
		});

		Thread t2 = new Thread(() -> {
			obj.process();
		});

		long start = System.currentTimeMillis();

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start) + ", List1 size: " + obj.getList1().size() + ", List2 size: "
				+ obj.getList2().size());
	}

}
