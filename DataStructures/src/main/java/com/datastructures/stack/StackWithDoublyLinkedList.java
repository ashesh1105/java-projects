package com.datastructures.stack;

import com.datastructures.linkedlist.DoublyLinkedList;
import com.datastructures.linkedlist.DoublyLinkedNode;

public class StackWithDoublyLinkedList {
	
	private DoublyLinkedList list;
	private int top;
	private int size;
	
	public StackWithDoublyLinkedList() {
		this.list = new DoublyLinkedList();
		this.top = -1;
		this.size = 0;
	}

	public int getSize() {
		return size;
	}

	public void push(Integer data) {
		list.insertAtHead(data);
		top++;
		size++;
	}
	
	public Integer pop() {
		DoublyLinkedNode node, next;
		node = list.getHead();
		if (node == null) {
			return 0;
		}
		next = node.getNextNode();
		list.setHead(next);
		next.setPreviousNode(null);
		top--;
		size--;
		return node.getData();
	}
	
	public Integer peek() {
		if (size == 0) {
			return 0;
		}
		return list.getHead().getData();
	}
	
	public String toString() {
		return list.toString();
	}
}
