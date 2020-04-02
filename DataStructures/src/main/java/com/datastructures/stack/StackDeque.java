package com.datastructures.stack;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.Deque;

/*
A dequeue is doubly ended queue and it can be used to exhibit both a queue (FIFO) or stack (LIFO) behaviour since it
has all sorts of methods in it.
 */

public class StackDeque {

	public static void main(String[] args) {
		
		Deque<Student> stack = new ArrayDeque<Student>();

		System.out.println("Add few students to Deque in this order: Sanath -> Duc -> Guru -> Boon -> Mukesh");
		
		stack.push(new Student("Sanath"));
		stack.push(new Student("Duc"));
		stack.push(new Student("Guru"));
		stack.push(new Student("Boon"));
		stack.push(new Student("Mukesh"));
		
		System.out.println("Stack size is: " + stack.size() + "\n");
		
		System.out.println("Students popped from Deque (stack) in LIFO order: ");
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().getName());
			//stack.pop();
		}

		// Add the elements again
		stack.push(new Student("Sanath"));
		stack.push(new Student("Duc"));
		stack.push(new Student("Guru"));
		stack.push(new Student("Boon"));
		stack.push(new Student("Makesh"));

		System.out.println("\nStudents popped from Deque (queue) in FIFO order: ");
		while(!stack.isEmpty()) {
			System.out.println(stack.pollLast().getName());
			//stack.pop();
		}

	}

}

class Student {

	@Getter
	@Setter
	private String name;
	
	public Student(String name) {
		this.name = name;
	}
}
