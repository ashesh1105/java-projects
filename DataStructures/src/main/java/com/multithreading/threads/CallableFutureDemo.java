package com.multithreading.threads;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

/**
 * You can pass a Callable<?> to a thread pool's execute method (executor.submit(new Callable<?>(){}) which returns
 * a Future object. When you call get() method on that, it waits till callable does the job and returns.
 *
 * Difference between Runnable and Callable are:
 * 1) Callable returns an object, Runnable doesn't and uses void in method signature.
 * 2) Callable can throw an exception.
 */

public class CallableFutureDemo {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();
		/*
		 * When don't need to return anything from Callable and still wait to
		 * use it for say, through an exception from it, etc., use it as:
		 * Future<?> and new Callable<Void>() .. and public Void call() .. Also
		 * return null in that case.
		 */
		Future<Integer> future = executor.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {

				Random random = new Random();
				int waitTime = random.nextInt(4001);

				if (waitTime > 2000) {
					// Say this thread handled an IO and got exception
					throw new IOException("Wait time more than 2 seconds.");
				}

				Thread.sleep(waitTime);

				return waitTime;
			}

		});

		executor.shutdown();

		// add this method for threads to complete or use future to wait for
		// result to come:
		// executor.awaitTermination(4000, TimeUnit.MILLISECONDS);

		try {
			// future.get() will wait till Callable thread returns or
			// throws exception
			System.out.println("Result from callable: " + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {

			// Way to handle exceptions from Callable threads
			if (e.getCause() instanceof IOException) {
				IOException io = (IOException) e.getCause();
				System.out.println("Received IOException from Future:");
				System.out.println(io.getMessage());
			}
		}

	}

}
