package com.datastructures.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StackTest {
	
	StackWithDoublyLinkedList stack;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		stack = new StackWithDoublyLinkedList();
	}

	@Test
	public void testPush() {
		stack.push(5);
		stack.push(51);
		stack.push(23);
		stack.push(10);
		
		System.out.println(stack.toString());
	}
	
	@Test
	public void testPeek() {
		stack.push(45);
		System.out.println(stack.peek());
	}
	
	@Test
	public void pop() {
		stack.push(5);
		stack.push(51);
		stack.push(23);
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.toString());
	}

}
