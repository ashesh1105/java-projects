package com.multithreading.synchronizers.countdownlatch;

import java.util.concurrent.CountDownLatch;

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
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All the services completed and the system is up!");
	}
}
