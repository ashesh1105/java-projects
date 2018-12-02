package com.multithreading.test;

import org.junit.Test;

import com.multithreading.threads.LocalizedLocks;

public class TestLocalizedLocks {
	
	@Test
	public void testLocalizedLocks() {
		
		final LocalizedLocks localizedLocks = new LocalizedLocks();
		
		System.out.println("Begin populating the lists..");
		
		// Begin the timer
		Long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(() -> localizedLocks.processLists());
		Thread t2 = new Thread(() -> localizedLocks.processLists());
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// End the timer
		Long end = System.currentTimeMillis();
		// Print the time taken to pupulate the lists by two thread
		System.out.println("Time taken to populate lists: " + (end - start));
		
		
	}

}
