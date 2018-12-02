package com.multithreading.threads;

import static org.hamcrest.CoreMatchers.startsWith;

public class WaysOfCreatingThreads {

	public static void main(String[] args) {
		
		/*
		 * 1) Prior to Java8
		 */
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				
			}
			
		});
		
		// 2) From Java8. No reference to runnable, simply pass it in Thread constructor
		new Thread(() -> {
			System.out.println("From new thread...");
		}).start();
		
		// 3) Similar to upper one but here we have a reference to Runnable
		Runnable runnable = () -> {
			
		};
		new Thread(runnable);
		
		// 4) Create a class extending Thread and provide your run method in that. Takes longer but more modularized.

	}

}
