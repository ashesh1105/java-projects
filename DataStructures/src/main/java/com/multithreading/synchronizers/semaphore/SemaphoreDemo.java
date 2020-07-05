package com.multithreading.synchronizers.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Counting Semaphore in Java is a synchronizer that allows imposing a bound on the resource is added in Java 5 along
 * with other popular concurrent utilities like CountDownLatch, CyclicBarrier, and Exchanger, etc. Counting Semaphore
 * in Java maintains a specified number of pass or permits, In order to access a shared resource, Current Thread must
 * acquire a permit. If a permit is already exhausted by other threads than it can wait until a permit is available due
 * to the release of permits from different threads. This concurrency utility can be very useful to implement a
 * producer-consumer design pattern or implement bounded pool or resources like Thread Pool, DB Connection pool, etc.
 *
 * The java.util.Semaphore class represents a Counting semaphore which is initialized with a number of permits.
 * Semaphore provides two main methods acquire() and release() for getting permits and releasing permits. acquire()
 * method blocks until permit is available.
 *
 * Semaphore provides both blocking methods as well as unblocking method to acquire permits. This Java concurrency
 * tutorial focuses on a very simple example of Binary Semaphore and demonstrates how mutual exclusion can be
 * achieved using Semaphore in Java.
 *
 * Read more: https://javarevisited.blogspot.com/2012/05/counting-semaphore-example-in-java-5.html#ixzz6RLNakfFM
 */

public class SemaphoreDemo {

	public static void main(String[] args) {

		ExecutorService executors = Executors.newCachedThreadPool();

		for (int i = 0; i < 100; i++) {
			executors.execute(() -> {
				Connection conn = Connection.getConnection();
				conn.connect();
			});
		}

		executors.shutdown();
		try {
			// So main thread waits till thread pool terminates
			executors.awaitTermination(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Connection {

	private static Connection instance = new Connection();
	Lock lock = new ReentrantLock();
	Semaphore sem = new Semaphore(10);

	private static int count = 0;

	private Connection() {

	}

	public static Connection getConnection() {
		return instance;
	}
	
	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doConnect();
		sem.release();
	}
	
	

	public void doConnect() {

		try {
			lock.lock();
			count++;
			System.out.println("Connections increased to " + count);
			
			// Sleep the thread for some time before calling semaphore release
			Thread.sleep(100);
			
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

}
