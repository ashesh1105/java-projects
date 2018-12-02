package com.multithreading.threads;

import java.util.Random;

public class InterruptedExceptionDemo {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Starting thread ..");
		long start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				Random random = new Random();
				for (int i = 0; i < 1E8; i++) {

					// Interrupt just causes a flag on running threads and do
					// not cause the thread to stop. You can get the interrupted
					// status of a thread either below way or make the thread
					// sleep for small duration and catch InterruptedException,
					// print or log the message.
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Thread interrupted!");
						break;
					}

					Double angle = random.nextDouble();
					Math.sin(angle);
				}
			}
		});

		t1.start();

		Thread.sleep(500);

		t1.interrupt();

		t1.join();

		long end = System.currentTimeMillis();

		System.out.println("Thread finished after " + (end - start)
				+ " milliseconds.");

	}

}
