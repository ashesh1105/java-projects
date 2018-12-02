package com.practice.genericprogramming;

public class LinkedList {
	public static void main(String[] args) {
		Node<String> node1 = new Node("David");
		Node<String> node2 = new Node("Sue");
		Node<String> node3 = new Node("Harry");
		Node<String> footer = new Node("Footer");
		Node<String> dummy;

		node1.next = node2;
		node2.next = node3;
		node3.next = footer;
		dummy = node1;

		while (dummy.next != null) {
			System.out.println(dummy.getData());
			dummy = dummy.next;
		}

	}
}
