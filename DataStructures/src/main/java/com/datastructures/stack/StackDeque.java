package com.datastructures.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackDeque {

	public static void main(String[] args) {
		
		Deque<Student> stack = new ArrayDeque<Student>();
		
		stack.push(new Student("Sanath"));
		stack.push(new Student("Duc"));
		stack.push(new Student("Guru"));
		stack.push(new Student("Boon"));
		stack.push(new Student("Makesh"));
		
		System.out.println("Stack size is: " + stack.size() + "\n");
		
		System.out.println("Students popped from Deque (stack) in LIFO order: ");
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().getName());
			//stack.pop();
		}

	}

}

class Student {
	private String name;
	
	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
