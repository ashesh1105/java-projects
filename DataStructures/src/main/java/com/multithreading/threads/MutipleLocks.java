package com.multithreading.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class demonstrates how using multiple locks can help threads run faster.
 * In this case, one thread using using lock1 and so another thread can use available lock lock2 to run another method
 * that called by process() method.
 *
 */

public class MutipleLocks {

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
		 * order of method calls don't matter and threads can switch between them based on which locks are available?
		 */

		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public static void main(String[] args) {

		MutipleLocks obj = new MutipleLocks();

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
