package com.multithreading;

import org.junit.Test;

import com.multithreading.threadpool.ThreadPoolDemo;

public class TestThreadPoolDemo {
	
	@Test
	public void testThreadPoolDemo() {
		ThreadPoolDemo poolDemo = new ThreadPoolDemo();
		poolDemo.submitTasks();
	}

}
