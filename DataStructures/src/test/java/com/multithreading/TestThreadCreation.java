package com.multithreading;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.multithreading.threads.Runner;

public class TestThreadCreation {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		Thread t1 = new Thread(new Runner());
		Thread t2 = new Thread(new Runner());
		// Start the threads
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}
