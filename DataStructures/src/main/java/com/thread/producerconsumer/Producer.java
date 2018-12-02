package com.thread.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

class Producer implements Runnable {

	private BlockingQueue<String> sharedQueue;

	Logger logger = Logger.getLogger(Producer.class.getName());

	public Producer(BlockingQueue<String> queue) {
		this.sharedQueue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			try {
				System.out.println("Producing " + i);
				sharedQueue.put("" + i);
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Error is while producing!");
			}
		}
	}
}
