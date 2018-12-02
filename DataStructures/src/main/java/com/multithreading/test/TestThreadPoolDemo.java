package com.multithreading.test;

import org.junit.Test;

import com.multithreading.threads.ThreadPoolDemo;

public class TestThreadPoolDemo {
	
	@Test
	public void testThreadPoolDemo() {
		ThreadPoolDemo poolDemo = new ThreadPoolDemo();
		poolDemo.submitTasks();
	}

}
