package com.multithreading.synchronizers.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch in Java is a kind of synchronizer which allows one Thread to wait for one or more Threads before
 * starts processing. This is a very crucial requirement and often needed in server-side core Java application and
 * having this functionality built-in as CountDownLatch greatly simplifies the development. CountDownLatch in Java
 * is introduced on Java 5 along with other concurrent utilities like CyclicBarrier, Semaphore, ConcurrentHashMap
 * and BlockingQueue in java.util.concurrent package. In this demo we will see what is CountDownLatch
 * in Java, How CountDownLatch works in Java, an example of CountDownLatch in Java, and finally some worth noting points
 * about this concurrent utility.
 *
 * You can also implement the same functionality using wait and notify mechanism in Java but it requires a lot of
 * code and getting it to write in the first attempt is tricky,  With CountDownLatch it can be done in just a few lines.
 * CountDownLatch also allows flexibility on a number of threads for which the main thread should wait, It can wait for
 * one thread or n number of threads, there is not much change on code.
 *
 * One of the disadvantages of CountDownLatch is that it's not reusable once count reaches zero you can not use
 * CountDownLatch any more, but don't worry Java concurrency API has another concurrent utility called CyclicBarrier for
 * such requirements: https://javarevisited.blogspot.com/2012/07/cyclicbarrier-example-java-5-concurrency-tutorial.html
 *
 * Read more on CountDownLatch at: https://javarevisited.blogspot.com/2012/07/countdownlatch-example-in-java.html
 */

class Service implements Runnable {
	private String name;
	private int timeToStart;
	private CountDownLatch latch;

	public Service(String name, int timeToStart, CountDownLatch latch) {
		this.name = name;
		this.timeToStart = timeToStart;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeToStart);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("The service " + name + " is up and running.");

		// So one latch is "consumed" here by the thread running this task
		latch.countDown();
	}
}

public class CountDownLatchDemo {
	private CountDownLatch latch = new CountDownLatch(3);

	public void bootStrapSystem() {

		Thread t1 = new Thread(new Service("CacheService", 1000, latch));
		Thread t2 = new Thread(new Service("AlertService", 100, latch));
		Thread t3 = new Thread(new Service("ValidationService", 1500, latch));
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			// main threads waits will all the latches are done
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All the services completed and the system is up!");
	}
}
