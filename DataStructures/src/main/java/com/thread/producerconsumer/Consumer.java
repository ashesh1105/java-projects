package com.thread.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable {

	private BlockingQueue<String> sharedQueue;
	Logger logger = Logger.getLogger(Consumer.class.getName());

	public Consumer(BlockingQueue<String> queue) {
		this.sharedQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumed " + sharedQueue.take());
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Issue is with consuming!");
			}
		}
	}

	public static void main(String args[]) {
		BlockingQueue<String> sharedQueue = new LinkedBlockingQueue<String>();

		Thread t1 = new Thread(new Producer(sharedQueue));
		Thread t2 = new Thread(new Consumer(sharedQueue));

		t1.start();
		t2.start();
	}

}
