package com.datastructures.linkedlist;

public class MySortedLinkedList {

	private MyNode head;
	

	public MySortedLinkedList(MyNode head) {
		this.head = head;
	}

	public MySortedLinkedList() {
		this.head = null;
	}

	public MyNode getHead() {
		return head;
	}

	public void setHead(MyNode head) {
		this.head = head;
	}

	public void insertAtTail(int data) {
		MyNode current = head;
		MyNode previous = head;
		MyNode newNode = new MyNode(data);

		// Add the new node at head if head is null
		if (head == null) {
			head = newNode;
			return;
		}

		// Increment current to node next to head. Previous still points to head
		current = current.getNextNode();

		// If data is smaller than head or next node to head, add it here first
		if (current == null || data <= current.getData()) {

			// If data is less than previous, which is head, make it a new head
			if (data <= previous.getData()) {
				newNode.setNextNode(previous);
				head = newNode;
				return;
			} else {
				newNode.setNextNode(current);
				previous.setNextNode(newNode);
				return;
			}
		}

		// Iterate the list to find the right place for newNode, which will be after previous
		while (current != null) {

			if (data <= current.getData()) {
				break;
			}
			current = current.getNextNode();
			previous = previous.getNextNode();
		}
		newNode.setNextNode(current);
		previous.setNextNode(newNode);
	}

	// toString
	public String toString() {
		StringBuilder sb = new StringBuilder();
		MyNode current = head;
		// Return an empty string if head itself is null
		if (current == null)
			return "";
		while (current != null) {
			sb.append(current.getData());
			current = current.getNextNode();
			if (current != null) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

}
