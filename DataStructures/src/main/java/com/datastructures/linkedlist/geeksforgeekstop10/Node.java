package com.datastructures.linkedlist.geeksforgeekstop10;


import lombok.Getter;
import lombok.Setter;

public class Node<T> {

	@Getter
	@Setter
	private T data;

	@Getter
	@Setter
	private Node<T> nextNode;
	
	public Node(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.data.toString();
	}
	
}
