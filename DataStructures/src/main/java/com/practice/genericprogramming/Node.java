package com.practice.genericprogramming;

public class Node<T> {

	private T data;
	public Node next;

	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

}
