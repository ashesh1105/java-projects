package com.multithreading;

import org.junit.Test;

import com.multithreading.synchronizers.countdownlatch.CountDownLatchDemo;

public class TestCountDownLatch {

	@Test
	public void testCountDownLatchDemo() {
		CountDownLatchDemo latchDemo = new CountDownLatchDemo();
		latchDemo.bootStrapSystem();
	}
	
	@Test
	public void testTestHarness() {
		
	}

}
