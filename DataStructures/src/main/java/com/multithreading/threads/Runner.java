package com.multithreading.threads;

import java.util.Scanner;

public class Runner implements Runnable {
	
	private volatile boolean running = true;
	
	@Override
	public void run() {
		
		while (running) {
			System.out.println("Hello ");
			try {
				Thread.sleep(1000
						);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void stopRun() {
		running = false;
	}
	
	public static void main(String[] args) {
		
		Runner runner = new Runner();
		Thread t = new Thread(runner);
		t.start();
		
		System.out.println("Press enter to stop..");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		runner.stopRun();
		
		
	}

}
