package com.multithreading.synchronizers.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class TestHarness {

	public void beginTest(final CountDownLatch latch1, final CountDownLatch latch2, int numThreads) {

		for (int i = 0; i < numThreads; i++) {

			final int threadCount = i;
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						latch2.await();
						Thread.sleep(500);
						System.out.println("Thread " + threadCount + " Done.");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					latch1.countDown();
				}
			}).start();
		}
	}

	public static void main(String[] args) {
		
		int numThreads = 3;
		CountDownLatch threadLatch = new CountDownLatch(numThreads);
		CountDownLatch mainLatch = new CountDownLatch(1);
		
		TestHarness testHarness = new TestHarness();
		
		testHarness.beginTest(threadLatch, mainLatch, numThreads);
		
		long start = System.nanoTime();
		System.out.println("Begin executing threads..");
		mainLatch.countDown();
		try {
			threadLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.nanoTime();
		System.out.println("End executing threads.. total time taken: " + (end - start)/1000000 + " seconds.");

	}

}
