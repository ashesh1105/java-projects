package com.datastructures.linkedlist;

import com.datastructures.linkedlist.geeksforgeekstop10.MyNode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Refer to com.test.linkedlist.LinkedListTest.java for junits for this class
 */

public class MyLinkedList {

	@Getter
	@Setter
	private MyNode head;

	public MyLinkedList(MyNode head) {
		this.head = head;
	}

	public MyLinkedList() {
		this.head = null;
	}

	// Append node to tail
	public void appendToTail(int data) {
		MyNode current = head;
		if (current == null) {
			head = new MyNode(data);
			return;
		}
		MyNode end = new MyNode(data);

		while (current.getNextNode() != null) {
			current = current.getNextNode();
		}
		current.setNextNode(end);
	}

	// Search and delete a node
	public void deleteNode(int data) {

		if (head == null) return;

		MyNode current = head;
		MyNode previous = head; // in case data is found at last node
		current = current.getNextNode();
		MyNode dataNode = null; // Node to be deleted

		// Check if data is on first node itself
		if (head.getData() == data) {
			dataNode = head;
		}

		// Iterate from 2nd node to end and search for node
		if (dataNode == null) {
			while (current != null) {
				if (current.getData() == data) {
					dataNode = current;
					break;
				}
				current = current.getNextNode();
				previous = previous.getNextNode();
			}
		}
		/*
		 * Once found the node, replace its data from next node and make it
		 * point to node after next node. This is how we delete a current node.
		 * We will, however need pointer to previous node if data to be deleted
		 * is last node
		 */
		MyNode temp = dataNode.getNextNode();
		if (temp != null) { // meaning dataNode isn't the last node
			dataNode.setData(temp.getData());
			dataNode.setNextNode(temp.getNextNode());
		} else {
			previous.setNextNode(temp);
		}
	}

	// Search for a node
	public boolean contains(int data) {
		MyNode current = head;

		while (current != null) {
			if (current.getData() == data) {
				return true;
			}
			current = current.getNextNode();
		}
		return false;
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

	// Remove duplicates - highly efficient method with no additional storage
	// needed!
	public void removeDuplicatesWithSameList() {
		MyNode previous, current = null;
		previous = head;
		if (previous != null) {
			current = previous.getNextNode();
		}

		MyNode runner = head;

		while (current != null) {
			runner = head;
			while (runner != current) {
				if (runner.getData() == current.getData()) {
					MyNode temp = current.getNextNode();
					previous.setNextNode(temp);
					current = temp;
					break;
				}
				runner = runner.getNextNode();
			}
			if (runner == current) {
				previous = previous.getNextNode();
				current = current.getNextNode();
			}
		}
	}

	// get nth node from the last
	public MyNode getNthNodeFromLast(int n) {
		/*
		 * Get the size of list first and return an error if n > size. Also, if
		 * n == size, then nothing needs to be done. Let the user know. Also
		 * check for other boundary conditions like n <= 0
		 */
		if (n <= 0) {
			System.out
					.println("ERROR: Argument n supplied needs to be a posiive number and less than the size of the list. Returning null.");
			return null;
		}
		MyNode current = head;
		MyNode result = head;
		int counter = 0;
		while ((current != null) && (counter < n)) {
			current = current.getNextNode();
			counter++;
		}

		// Check if argument n is equal or more than size of list
		if (current == null) {
			if (n == counter) {
				System.out
						.println("Argument n supplied is equal to size of list. Returning head..");
				return head;
			} else if (counter < n) {
				System.out
						.println("ERROR: Argument n supplied is more than size of the list. Returning null..");
				return current;
			}
		}

		while (current != null) {
			current = current.getNextNode();
			result = result.getNextNode();
		}
		return result;
	}

	/**
	 * Delete Middle Node by using head and return boolean
	 * Check middleNode() method in LinkedList class
	 */
	public boolean deleteMiddleNode() {
		if (head == null) {
			return false;
		}
		MyNode current = head, previous = head, middleNode = null;
		int size = 0;

		// Get the size of list
		while (current != null) {
			size++;
			current = current.getNextNode();
		}
		System.out.println("Size of the list computed as: " + size);
		// Get middle node
		current = head.getNextNode();
		int i = 1;
		while ((i < (size / 2)) && current != null) {
			current = current.getNextNode();
			previous = previous.getNextNode();
			i++;
		}
		middleNode = current;
		System.out.println("Middle node found as: " + middleNode.getData());
		/*
		 * Delete the middle node by copying next node's data to it and making
		 * it point to node after next node
		 */
		MyNode temp = middleNode.getNextNode();
		if (temp != null) {
			middleNode.setData(temp.getData());
			middleNode.setNextNode(temp.getNextNode());
		} else {
			previous.setNextNode(temp);
		}
		return true;
	}

	/*
	 * Delete middle node without using head of the LinkedList and return
	 * boolean
	 */
	public boolean deleteMiddleNodeWithMiddleNode(MyNode middleNode) {
		if (middleNode == null || middleNode.getNextNode() == null) {
			// Log the reason
			System.out.println("Middle Node or its next node is null.");
			return false;
		}
		middleNode.setData(middleNode.getNextNode().getData());
		middleNode.setNextNode(middleNode.getNextNode().getNextNode());
		return true;
	}

	/*
	 * Append the last n nodes of a linked list to the beginning of the list.
	 * Will keeping the length as a member variable inside the LinkedList class,
	 */
	public boolean appendLastNNodesToHead(int n) {
		MyNode current = head;
		MyNode previous = head;
		MyNode lastNodeOfCurrentList = null;
		int size = 0;

		// Get Size of the List
		MyNode temp = head;
		int i = 0;
		while (temp != null) {
			temp = temp.getNextNode();
			i++;
		}
		size = i;

		System.out.println("Size: " + size);

		// Return false if argument n is > size - 1
		if (!(n < size - 1)) {
			return false;
		}

		// Advance current node by one node
		current = current.getNextNode();

		// Get pointer to nth node from the last
		MyNode nthNodeFromLast = getNthNodeFromLast(n);

		System.out.println("nth node from last: " + nthNodeFromLast.getData());

		// Set last node of the current list
		MyNode runner = nthNodeFromLast;
		while (runner.getNextNode() != null) {
			runner = runner.getNextNode();
		}
		lastNodeOfCurrentList = runner;

		System.out.println("Last Node of current list: "
				+ lastNodeOfCurrentList.getData());

		// Get pointer to the node right before nth node from the last, which is
		// variable name "previous"
		while ((current != null) && (current != nthNodeFromLast)) {
			current = current.getNextNode();
			previous = previous.getNextNode();
		}

		System.out.println("Node previous to last n node of list: "
				+ previous.getData());

		/*
		 * Now current is same as nthNodeFromLast and previous points to its
		 * previous node Make the head point to nth node from last and last node
		 * point to (earlier) node next to head
		 */
		MyNode secondNode = head.getNextNode();
		head.setNextNode(nthNodeFromLast);
		lastNodeOfCurrentList.setNextNode(secondNode);

		// Make the node previous to nth node from last (earlier) the new last
		// node of the list
		previous.setNextNode(null);

		return true;
	}

	// Reverse a singly linkedlist. Very efficient algorithms. Never use the one
	// below!
	public boolean reverse() {
		// previous will be null if current is head
		MyNode previous = null, current = head;
		// if head itself is null, don't do anything and return false
		if (current == null) {
			return false;
		}

		// Initialize nextNode
		MyNode nextNode = null;
		/*
		 * Iterate through list, set nextNode of current node to previous at
		 * each step. Make sure to save the reference to nextNode before
		 * pointing the current to previous node!
		 */
		while (current != null) {
			nextNode = current.getNextNode();
			current.setNextNode(previous);
			previous = current;
			current = nextNode;
		}
		/*
		 * Finally, don't foreget to set the head of the LinkedList to point to
		 * last element. Note that current points to null now, i.e., after the
		 * tail.
		 */
		head = previous;

		return true;
	}

	/*
	 * Never use this algo to reverse a linkedlist. Above method "reverse()" is
	 * 100 times faster!
	 */
	public boolean reverseWithStack() {

		MyNode current = head;
		Deque<MyNode> stack = new ArrayDeque<MyNode>();
		if (head == null) {
			return false;
		}

		// Populate the stack
		while (current != null) {
			stack.push(current);
			current = current.getNextNode();
		}

		// Change the head to last node of the list and reverse rest of list
		head = stack.pop();

		// Create the reversed List. stack will return elements in LIFO order.
		MyNode temp = head;
		for (MyNode node : stack) {
			temp.setNextNode(node);
			temp = temp.getNextNode();
		}
		// Point the tail to null
		temp.setNextNode(null);

		return true;
	}

}
