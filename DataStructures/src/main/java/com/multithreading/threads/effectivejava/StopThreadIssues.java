package com.multithreading.threads.effectivejava;

import java.util.concurrent.TimeUnit;

public class StopThreadIssues {

	private static volatile boolean stopThread;
	
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (!stopThread) {
					System.out.println(++i);	
				}
			}
		}).start();
		
		try {
			TimeUnit.MILLISECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stopThread = true;
	}

}
