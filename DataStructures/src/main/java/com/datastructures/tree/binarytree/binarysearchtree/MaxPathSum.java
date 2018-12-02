package com.datastructures.tree.binarytree.binarysearchtree;

public class MaxPathSum extends BinarySearchTree {

	/**
	 * Geeksforgeeks top 10 https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
	 */

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(1);
		bst.insert(2);
		bst.insert(3);

		MaxPathSum maxPathSum = new MaxPathSum();
		maxPathSum.insert(10);
		maxPathSum.insert(5);
		maxPathSum.insert(2);
		maxPathSum.insert(3);
		maxPathSum.insert(15);
		maxPathSum.insert(12);
		maxPathSum.insert(17);

		System.out.println("The Binary Search Tree:");
		maxPathSum.printInOrder();
		System.out.println("Sum of all nodes:");
		System.out.println(maxPathSum.sum());

	}

	public int sum() {
		return doSum(this.getRoot());
	}

	private int doSum(Node n) {

		if (n == null) {
			return 0;
		}

		int leftSum = 0;
		int rightSum = 0;

		leftSum = doSum(n.getLeftNode());
		rightSum = doSum(n.getRightNode());
		return n.getData() + leftSum + rightSum;

	}

}
