package com.datastructures.linkedlist;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<Integer> integers = new LinkedList<Integer>();

		integers.addAtStart(5);
		integers.addAtStart(10);
		integers.addAtStart(2);
		integers.addAtStart(12);
		integers.addAtStart(19);
		integers.addAtStart(20);
		
		System.out.println("Printing elements of integers list: " + integers.toString());

		// Middle node
		System.out.println("\nMiddle Node: " + integers.middleNode());

		// add some duplicate data
		integers.addAtStart(2);
		integers.addAtStart(10);
		integers.addAtStart(5);
		integers.addAtStart(20);


		System.out.println("Added some duplicate data at start. List integers now is: " + integers.toString());

		// remove duplicates
		integers.removeDuplicates();
		
		System.out.println("Removed duplicates from 'integers'. It not looks like: " + integers.toString() + "\n");

		System.out.println(integers.length());
		System.out.println(integers.find(120));
		System.out.println(integers.toString() + "\n");
	
		
		int n = 9;
		// Get last n element
		System.out.println("Get nth node from last: "
				+ integers.getNthNodeFromLast(n) + "\n");
		// Append last n elements to head
		integers.appendLastNNodesToHead(n);
		// Print the list again
		System.out.println("\n" + integers.toString() + "\n");
		// Reverse the list
		integers.reverse();
		// Print the list again
		System.out.println(integers.toString());


	}

}
