package com.multithreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* ExecutorService is used to create pool of threads based on number specified inside of
 * Executors.newFixedThreadPool(int n) method, if we want fixed number of threads. It schedules the required number
 * of threads to get the job done. shutdown() method on ExecutorService allows enough time to all the running threads to
 * complete the job and then shuts them down. We can shutdown all the threads right there by
 * using method shutdownNow(). submit method of Executors takes a Runnable implementation.
 * awaitTermination method takes the number and unit of time when we want the tasks to timeout. In this
 * case the unit is very big (1, DAYS), basically meaning no timeout given the trial tasks we have,
 * but we can specify other units like SECONDS, MILLISECONDS, etc.
 *
 * Apart from newFixedThreadPool, you can also use many other methods available on Executors, like newCachedThreadPool
 * where number of threads created will be unbounded. There are in-between options too.
 * 
 */
public class ThreadPoolDemo {

	private ExecutorService pool = Executors.newFixedThreadPool(5);

	public void submitTasks() {
		
		System.out.println("Submitting tasks..\n");
		
		Long startTimer = System.currentTimeMillis();
		
		for (int i = 1; i <= 20; i++) {
			pool.submit(new Processor(i));
		}

		pool.shutdown();

		System.out.println("All tasks submitted");

		try {
			// So main threads wait for pool to execute all running threads and gets gracefully shutdown before exiting
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Long endTimer = System.currentTimeMillis();
		
		System.out.println("All tasks completed or timed out");
		System.out.println("Total time taken: " + (endTimer - startTimer));
	}

	public static void main(String[] args) {

		new ThreadPoolDemo().submitTasks();

	}

}

class Processor implements Runnable {
	int id;

	public Processor(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println("Starting thread " + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done executing thread + " + id);
	}
}
