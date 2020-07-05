package com.multithreading.threads;

public class SynchronizedDemo {
	
	private int counter = 0;
	
	// Once we make this method synchronized, final counter value as seen in test: TestSynchronizedDemo
	// is always 20000. Try removing this keyword and test the output from test. That test will fail!
	private synchronized void incrementCounter() {
		counter++;
	}
	
	public void doWork() {
		for(int i=0; i<10000; i++) {
			incrementCounter();
		}
	}
	public int getCounter() {
		return counter;
	}

}
