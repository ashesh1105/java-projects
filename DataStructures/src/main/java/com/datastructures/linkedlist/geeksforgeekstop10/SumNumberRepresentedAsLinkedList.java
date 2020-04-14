package com.datastructures.linkedlist.geeksforgeekstop10;

import com.datastructures.linkedlist.MyLinkedList;

/**
 https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/
 https://www.geeksforgeeks.org/sum-of-two-linked-lists/

 We have two large numbers represented as linked list as below:
 list1 => 1234 -> 5678 -> 9101 -> 2345
 list2 => 7564 -> 6762 -> 7619 -> 4675
 Sum the numbers and have them represented same way as above.
 Sum: 0001 -> 0799 -> 2441 -> 6721 -> 0920

 */

public class SumNumberRepresentedAsLinkedList {

	public static void main(String[] args) {

		// Test Data Preparation. Assuming both lists have same number of nodes
		int size = 4;
		
		// Create and populate list1
		MyLinkedList list1 = new MyLinkedList();
		int[] arr1 = new int[size];

		arr1[0] = 3234;
		arr1[1] = 5678;
		arr1[2] = 9101;
		arr1[3] = 6245;

		polulateLinkedListFromArray(list1, arr1);

		// Create and populate list2
		MyLinkedList list2 = new MyLinkedList();
		int[] arr2 = new int[size];

		arr2[0] = 7564;
		arr2[1] = 6762;
		arr2[2] = 7619;
		arr2[3] = 4675;

		polulateLinkedListFromArray(list2, arr2);

		// Print the lists to check test data
		printLinkedList(list1);
		printLinkedList(list2);
		
		// Now let's add the lists and represent the sum in similar format: node1 -> node2 -> with every node has 4 digits
		MyLinkedList result = sumNumbersRepresentedAsLinkedLists(list1, list2);
		
		// Test the result;
		System.out.println("Result:");
		printLinkedList(result);

	}

	public static MyLinkedList sumNumbersRepresentedAsLinkedLists(MyLinkedList list1, MyLinkedList list2) {
		
		MyLinkedList result = new MyLinkedList();
		
		// Compute size of lists, if it is not given
		// Assume sizes of both linkedLists are same
		int size = 0;
		MyNode head1 = list1.getHead();
		MyNode current1 = head1;
		
		while(current1 != null) {
			size++;
			current1 = current1.getNextNode();
		}
		
		// Create and populate arrays from lists:
		int [] arr1 = new int[size];
		int [] arr2 = new int[size];
		
		head1 = list1.getHead();
		MyNode head2 = list2.getHead();
		MyNode curr1 = head1;
		MyNode curr2 = head2;
		
		int i=0;
		while (curr1 != null && curr2 != null) {
			arr1[i] = curr1.getData();
			arr2[i] = curr2.getData();
			i++;
			curr1 = curr1.getNextNode();
			curr2 = curr2.getNextNode();
		}
		
		// Lets add the lists now!
		int carryOver = 0;
		
		for (int k=size-1; k>=0; k--) {
			
			int num1 = arr1[k];
			int num2 = arr2[k];
			int sum = num1 + num2 + carryOver;
			
			// Each result node will also contain upto 4 digits only.
			int resultNodeData = sum % 10000;
			MyNode resultNode = new MyNode(resultNodeData);
			if (result.getHead() == null) {
				result.setHead(resultNode);
			} else {
				MyNode head = result.getHead();
				resultNode.setNextNode(head);
				result.setHead(resultNode);
			}
			
			// Get overflow (carryOver) to be added to result node left from this one
			carryOver = sum / 10000;			
		}
		
		// If there is overflow after most significant digits (at head) got added, result will have size + 1 nodes
		if (carryOver != 0) {
			MyNode head = result.getHead();
			MyNode node = new MyNode(carryOver);
			node.setNextNode(head);
			result.setHead(node);
		}
		
		return result;
		
		
	}

	private static void polulateLinkedListFromArray(MyLinkedList list, int[] array) {

		int size = array.length;
		list.setHead(new MyNode(array[0]));
		MyNode current = list.getHead();

		for (int i = 1; i < size; i++) {
			MyNode node = new MyNode();
			node.setData(array[i]);
			current.setNextNode(node);
			current = current.getNextNode();
		}
	}

	private static void printLinkedList(MyLinkedList list) {

		MyNode curr = list.getHead();
		System.out.print("List: ");
		while (curr != null) {
			int data = curr.getData();
			if (curr.getNextNode() != null) {
				// Add trailing zero if data is less than 4 digits
				System.out.print(String.format("%04d", data) + " -> ");
			} else {
				System.out.println(String.format("%04d", data));
			}
			curr = curr.getNextNode();
		}

	}

}
