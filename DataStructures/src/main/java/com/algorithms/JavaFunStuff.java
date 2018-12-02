package com.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class JavaFunStuff {

	public static void main(String[] args) {
		
		Queue<String> list = new LinkedList<String>();
		
		String str = "abcd";
		str.indexOf('d');
		
		// Singleton Pattern Example from Java Library
		Runtime runtime = Runtime.getRuntime();
		int availableProcessors = runtime.availableProcessors();
		System.out.println("Runtime available processors: " + availableProcessors);
		System.out.println("JVM Free Memory from Runtime: " + runtime.freeMemory());
		System.out.println("JVM Total Memory from Runtime: " + runtime.totalMemory());
		System.out.println("JVM Max Memory from Runtime: " + runtime.maxMemory());
		
		

	}

}
