package com.datastructures.tree.binarytree.binarysearchtree;

import lombok.Getter;
import lombok.Setter;

public class Node {
	@Getter
	@Setter
	private int data;
	@Getter
	@Setter
	private Node leftNode;
	@Getter
	@Setter
	private Node rightNode;

	public Node(int data) {
		this.data = data;
		leftNode = null;
		rightNode = null;
	}

	public Node() {
		leftNode = null;
		rightNode = null;
	}

	public Node find(int data) {

		if (data == this.data) {
			return this;
		}

		if (data < this.data) {
			if (leftNode == null) {
				return null;
			} else {
				return leftNode.find(data);
			}
		} else {
			if (rightNode == null) {
				return null;
			} else {
				return rightNode.find(data);
			}
		}
	}

	// Insert data - implementation using recursion
	public void insertData(int data) {

		if (data < this.data) {
			// if left node is null, add it there otherwise add the data recursively
			if (leftNode == null) {
				leftNode = new Node(data);
			} else {
				leftNode.insertData(data);
			}
		} else {
			// if right node is null, add it there otherwise add the data recursively
			if (rightNode == null) {
				rightNode = new Node(data);
			} else {
				rightNode.insertData(data);
			}
		}

	}
	
	// Count Number of Leaves - Raghavendra Dixit (Udemy) method
	public long numLeaves() {
		// If current instance of node in this recursion is leaf node, return 1
		if (isLeaf()) return 1;
		long numLeftLeaves = 0;
		long numRightLeaves = 0;
		
		if (this.leftNode != null) {
			numLeftLeaves = leftNode.numLeaves();
		}
		if (this.rightNode != null) {
			numRightLeaves = rightNode.numLeaves();
		}
		return numLeftLeaves + numRightLeaves;
	}
	
	private boolean isLeaf() {
		return this.leftNode == null && this.rightNode == null;
	}
	
	// Height of binary sort tree
	public int height() {
		if (isLeaf()) return 1;
		int left = 0;
		int right = 0;
		if (this.leftNode != null)
			left = this.leftNode.height();
		if (this.rightNode != null)
			right = this.rightNode.height();
		return Math.max(left, right) + 1;	// + 1 is for height due to root node
	}
	
	// Create binary sort tree with a sorted array
	public static Node addSorted(int[] data, int start, int end) {
		if (end >= start) {
			int mid = (start+end)/2;
			Node newNode = new Node(data[mid]);
			newNode.leftNode = addSorted(data, start, mid-1);
			newNode.rightNode = addSorted(data, mid+1, end);
			return newNode;
		}
		return null;
	}

	// Adding print functionality in Node itself
	public void printInOrder(Node n) {
		if (n != null) {
			printInOrder(n.getLeftNode());
			System.out.println(n.getData());
			printInOrder(n.getRightNode());
		}
	}

}
