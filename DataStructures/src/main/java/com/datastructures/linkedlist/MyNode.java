package com.datastructures.linkedlist;

public class MyNode {
	
	private int data;
	private MyNode nextNode;

	public MyNode(int data) {
		this.data = data;
	}

	public MyNode() {

	}

	// Getters and setters
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public MyNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(MyNode next) {
		this.nextNode = next;
	}

}
