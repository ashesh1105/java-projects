package com.multithreading.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreDemo {

	public static void main(String[] args) {

		ExecutorService executors = Executors.newCachedThreadPool();

		for (int i = 0; i < 100; i++) {
			executors.execute(new Runnable() {

				@Override
				public void run() {
					Connection conn = Connection.getConnection();
					conn.connect();
				}

			});
		}

		executors.shutdown();
		try {
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
			
			// Sleep the thread for 2 sec before calling semaphore release
			Thread.sleep(100);
			
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

}
