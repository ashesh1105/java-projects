package com.multithreading.test;

import java.util.Scanner;

import org.junit.Test;

import com.multithreading.threads.VolatileDemo;

public class TestVolatileDemo {

	@Test
	public void testVolatileDemo() {
		
		VolatileDemo demoThread = new VolatileDemo();
		demoThread.start();
		
        // Get user input to stop the thread
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press any key to stop the thread..");
		scanner.nextLine();
		demoThread.stopThread();
		
	}

}
