package com.datastructures.tree.binarytree.binarysearchtree;

import lombok.Getter;

public class MaxPathSum extends BinarySearchTree {

	/**
	 * Geeksforgeeks top 10 https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
	 *
	 * Given a binary tree (not BST!), find the maximum path sum. The path may start and end at any node in the tree.
	 * Note: It is not about computing sum of all the nodes, it is about summing all the nodes with max results, start
	 * from where you want and end where you want, as long as you don't bypass a node to get to next one.
	 *
	 * Example1:
	 * Input: Root of below tree
	 *        1
	 *       / \
	 *      2   3
	 * Output: 6
	 *
	 * So in this case, max path sum will have to include all the nodes: 1+2+3
	 *
	 * Above may be not be the case all the time!
	 * Example 2:
	 *        1
	 *       / \
	 *      2  -13
	 *     / \   \
	 * 	 -4   3   3
	 * Output: 3 + 2 + 1 = 6, since you include nodes will -4 or -13 or since 3 comes after -13, your path sum will go lower
	 *
	 * Note: if we change the right most node from 3 to 14, then the max path will be 3+2+1-13+14 since now the max path
	 * of node -13 becomes +1 (-13 + 14), currently it is -10 (-13 + 3)
	 *
	 * Another good test case in above binary tree could be that if for a node, both left and right nodes have negative
	 * max paths, then do not take either of the children, just take node's own data as max path for that node.
	 * For example, if we replace left child of root, 2 to -4, then for root, max paths of both the children will be
	 * negative, so max path of root will be its own data, without considering any child, i.e. 3.
	 *
	 * Hence, for Root:
	 * Max Path for Root Node = max of max paths of its children + data + max path of lower child if it is positive
	 * If both children have negative max paths, do not take either of them.
	 *
	 * Max path for other nodes = max of max paths of its child, unless both of them are negative + nodes's own data.
	 *
	 */

	// Need to do this for root node since path might include root + (max of max paths among left & right node)
	// plus the lower max path child node, as long as it is positive. If other child max path is negative, we don't
	// include them in max path for root. So root is special, this can be part of the max path
	public int maxPathSum(Node n) {
		if (n == null) {
			return 0;
		}
		int maxPathLeft = maxPathSumForNode(n.getLeftNode());
		int maxPathRight = maxPathSumForNode(n.getRightNode());

		// Max Path for Root Node = max of max paths of its children + data + max path of lower child if it is positive
		// If both children have negative max paths, do not take either of them.
		if (maxPathLeft <= 0 && maxPathRight <= 0) {
			return n.getData();
		}
		return maxPathLeft > maxPathRight ?
				maxPathLeft + n.getData() + (maxPathRight > 0 ? maxPathRight : 0)
				: maxPathRight + n.getData() + (maxPathLeft > 0 ? maxPathLeft : 0);
	}

	private int maxPathSumForNode(Node n) {

		if (n == null) {
			return 0;
		}

		int maxPathLeft = maxPathSumForNode(n.getLeftNode());
		int maxPathRight = maxPathSumForNode(n.getRightNode());

		// Max path for non-root nodes = max of max paths of its child (unless both of them are negative) + nodes's own data.
		if  (maxPathLeft <=0 && maxPathRight <= 0) return n.getData();
		return Math.max(maxPathLeft, maxPathRight) + n.getData();
	}

	static class BinaryTree {
		@Getter
		private Node root;

		public BinaryTree(int data) {
			this.root = new Node(data);
		}
	}

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree(1);
		bt.root.setLeftNode(new Node(-4));
		bt.root.getLeftNode().setLeftNode(new Node(-4));
		bt.root.getLeftNode().setRightNode(new Node(3));
		bt.root.setRightNode(new Node(-13));
		bt.root.getRightNode().setRightNode(new Node(3));

		System.out.println("Printing Binary Tree In Order with Root = " + bt.root.getData());
		bt.root.printInOrder(bt.root);
		System.out.println("Max Path Sum for above Binary Tree: " + new MaxPathSum().maxPathSum(bt.root));

		// Try another example:
		BinaryTree bt1 = new BinaryTree(1);
		bt1.root.setLeftNode(new Node(2));
		bt1.root.setRightNode(new Node(3));

		System.out.println("\nPrinting Binary Tree In Order with Root = " + bt1.root.getData());
		bt1.root.printInOrder(bt1.root);
		System.out.println("Max Path Sum for above Binary Tree: " + new MaxPathSum().maxPathSum(bt1.root));

		BinaryTree bt2 = new BinaryTree(10);
		bt2.root.setLeftNode(new Node(2));
		bt2.root.getLeftNode().setLeftNode(new Node(20));
		bt2.root.getLeftNode().setRightNode(new Node(1));
		bt2.root.setRightNode(new Node(10));
		bt2.root.getRightNode().setRightNode(new Node(-25));
		bt2.root.getRightNode().getRightNode().setLeftNode(new Node(3));
		bt2.root.getRightNode().getRightNode().setRightNode(new Node(4));

		System.out.println("Printing Binary Tree In Order with Root = " + bt2.root.getData());
		bt2.root.printInOrder(bt2.root);
		System.out.println("Max Path Sum for above Binary Tree: " + new MaxPathSum().maxPathSum(bt2.root));


	}
}
