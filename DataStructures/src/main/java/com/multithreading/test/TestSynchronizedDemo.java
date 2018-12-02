package com.multithreading.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.multithreading.threads.SynchronizedDemo;

public class TestSynchronizedDemo {
	
	@Test
	public void testSynchronizedDemo() {
		final SynchronizedDemo demo = new SynchronizedDemo();
		
		// Create threads
		Thread t1 = new Thread(() -> {
			demo.doWork();
		});
		
		Thread t2 = new Thread(() -> {
			demo.doWork();
		});
		// start the threads
		t1.start();
		t2.start();
		
		// allow threads to complete
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// print the final value of counter
		System.out.println("Count is: " + demo.getCounter());
		
		// Add the test
		int finalCounter = demo.getCounter();
		assertEquals("Final counter value must be 20,000!", 20000, finalCounter);
		
		
		
	}

}
