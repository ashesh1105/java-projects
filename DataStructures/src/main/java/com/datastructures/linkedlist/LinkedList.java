package com.datastructures.linkedlist;

import lombok.Getter;
import lombok.Setter;

public class LinkedList<T> {

	@Getter
	@Setter
	private Node<T> head;

	public void addAtStart(T data) {
		Node<T> newNode = new Node<T>(data);
		// if head is null, add the new node right there
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.setNextNode(this.head);
		this.head = newNode;
	}

	// Append node to tail
	public void appendToTail(T data) {
		Node<T> current = head;
		if (current == null) {
			head = new Node<T>(data);
			return;
		}
		Node<T> end = new Node<>(data);

		while (current.getNextNode() != null) {
			current = current.getNextNode();
		}
		current.setNextNode(end);
	}

	public Node<T> deleteAtStart() {
		Node<T> toDel = this.head;
		this.head = this.head.getNextNode();
		toDel.setNextNode(null);
		return toDel;
	}

	public Node<T> find(T data) {
		Node<T> curr = this.head;
		while (curr != null) {
			if (curr.getClass().equals(data)) {
				return curr;
			}
			curr = curr.getNextNode();
		}
		return null;
	}

	public int length() {
		if (head == null)
			return 0;
		int length = 0;
		Node<T> curr = this.head;
		while (curr != null) {
			length += 1;
			curr = curr.getNextNode();
		}
		return length;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	// Practice - remove duplicates without using any storage
	public void removeDuplicates() {

		// return right away if head is null or list has only one element
		if (head == null || head.getNextNode() == null)
			return;

		Node<T> current = head.getNextNode();
		Node<T> previous = head;
		Node<T> runner = null;
		while (current != null) {
			runner = head;
			while (runner != current) {
				if (runner.getData() == current.getData()) {
					Node<T> temp = current.getNextNode();
					previous.setNextNode(temp);
					current = temp;
					break;	// You want to restart the
				}
				runner = runner.getNextNode();
			}
			if (runner == current) {
				previous = current;
				current = current.getNextNode();
			}
		}
	}

	// get nth node from the last
	public Node<T> getNthNodeFromLast(int n) {
		/*
		 * Get the size of list first and return an error if n > size. Also, if n == size, then nothing needs
		 * to be done. Let the user know.
		 */
		Node<T> current = head;
		Node<T> result = head;
		int counter = 0;
		while ((current != null) && (counter < n)) {
			current = current.getNextNode();
			counter++;
		}

		// Check if argument n is equal or more than size of list
		if (current == null) {
			if (n == counter) {
				System.out
						.println("WARNING: Argument n supplied is equal to size of list. Returning head..");
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

	// Append last n nodes to head
	public void appendLastNNodesToHead(int n) {
		// Check for all the boundary conditions, i.e., 1 <= n <= size of list.
		// Done in the next method we are calling below
		Node<T> nodeBeforeNthOne = getNthNodeFromLast(n + 1);
		if (nodeBeforeNthOne == null) {
			System.out
					.println("WARNING: 'n' is equal to or more than the size of list. Nothing needs to be done here.");
			return;
		}
		Node<T> headForsubListToBeAppendedToCurrentHead = nodeBeforeNthOne.getNextNode();
		nodeBeforeNthOne.setNextNode(null);
		Node<T> current = headForsubListToBeAppendedToCurrentHead;

		// Get last node of current list
		Node<T> currentLastNode = null;
		while (current.getNextNode() != null) {
			current = current.getNextNode();
		}
		currentLastNode = current;

		// Append last node to current head
		currentLastNode.setNextNode(head);

		// Finally, don't forget to change the head of the list!
		head = headForsubListToBeAppendedToCurrentHead;

	}

	// Reverse the linkedlist
	public void reverse() {

		// if empty list or list has just one element, there is nothing to do
		if (head == null || head.getNextNode() == null) {
			System.out.println("List is empty or has just one element. There is nothing to do.");
		}

		Node<T> previous = null;
		Node<T> current = head;

		// Iterate through the list to reverse all the links and get last element into previous variable
		while (current != null) {
			Node<T> nextNode = current.getNextNode();
			current.setNextNode(previous);
			previous = current;
			current = nextNode;
		}

		// Finally, don't forget to change the head of the list to earlier list's last element
		head = previous;
	}

	@Override
	public String toString() {
		String res = "";
		Node<T> curr = this.head;
		while (curr != null) {
			// Don't print comma after data if this is the last node
			if (curr.getNextNode() == null) {
				res += curr;
			} else {
				res += curr + ", ";
			}
			curr = curr.getNextNode();
		}
		return res;
	}

}
