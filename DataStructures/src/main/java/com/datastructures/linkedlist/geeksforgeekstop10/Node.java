package com.datastructures.linkedlist.geeksforgeekstop10;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(of={"data"})
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
}
