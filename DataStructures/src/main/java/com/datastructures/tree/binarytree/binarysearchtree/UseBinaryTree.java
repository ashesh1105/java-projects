package com.datastructures.tree.binarytree.binarysearchtree;

public class UseBinaryTree {

	public static void main(String[] args) {
		
		BinarySearchTree newTree = new BinarySearchTree();
		newTree.countLeafNodes();
		
		BinarySearchTree btree = new BinarySearchTree();

		btree.insert(52);
		btree.insert(35);
		btree.insert(61);
		btree.insert(22);
		btree.insert(46);
		btree.insert(12);
		btree.insert(29);
		btree.insert(42);
		btree.insert(49);
		btree.insert(61);
		btree.insert(58);
		btree.insert(65);
		btree.insert(53);
		btree.insert(60);
		btree.insert(63);
		btree.insert(79);
		btree.insert(19);
		btree.insert(24);
		btree.insert(31);
		btree.insert(39);
		btree.insert(44);
		btree.insert(47);
		btree.insert(51);
		btree.insert(55);
		btree.insert(61);
		btree.insert(62);
		btree.insert(64);
		btree.insert(72);
		btree.insert(85);
		
		
		// Use insertData which uses recursion to add data
		//btree.insertData(5);

		System.out.println("Let's print the tree:");

		// Print the tree using inOrder method
		btree.printInOrder();
		// Return node with minimum value
		System.out.println("Minimum value of the tree is: "
				+ btree.min().getData());

		// Return node with maximum value
		System.out.println("Maximum value of the tree is: "
				+ btree.max().getData());
		
		Node node = btree.find(3);
		
		System.out.println("Tried to find 3 in btree: " + (node == null ? null : node.getData()));
		
		System.out.println("Delete the Root Node and Print the Tree again.");
		btree.deleteRootNode();
		btree.printInOrder();
		System.out.println("New Root Node is: " + btree.getRoot().getData());
		System.out.println("Is 29 a leaf node? " + btree.isLeafNode(29));
		System.out.println(btree.countLeafNodes());
		System.out.println("Height of tree: " + btree.height());
		
		// Add a sorted array to new BST
		
		int [] data = {2, 5, 7, 11, 19};
		
		Node root = Node.addSorted(data, 0, data.length-1);
		
		print (root);
		
		BinarySearchTree bst = new BinarySearchTree(10);
		
		System.out.println("\nRoot of new node: ");
		print(bst.getRoot());
		bst.insert(6);
		//bst.insert(12);
		System.out.println("Print BST:");
		print(bst.getRoot());
		bst.deleteRootNode();
		System.out.println("Print BST again:");
		print(bst.getRoot());
		
		// Let's test a case when leftNode has both left and right child
		bst.deleteRootNode();
		bst.insert(10);
		bst.insert(6);
		bst.insert(12);
		bst.insert(2);
		bst.insert(8);
		bst.insert(7);
		
		System.out.println("Print BST again:");
		print(bst.getRoot());
		
		bst.deleteRootNode();
		System.out.println("Print BST again:");
		print(bst.getRoot());
		System.out.println("New Root: " + bst.getRoot().getData());
		
	}

	private static void print(Node node) {
		if (node != null) {
			print(node.getLeftNode());
			System.out.println(node.getData());
			print(node.getRightNode());
		}
	}

}
