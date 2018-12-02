package com.datastructures.tree;

public class Node {
	/**
	 * A Tree has a root node and each node has a) data, b) a number of children
	 * Children can be an array or linkedList that can contain references to its child nodes
	 * A Tree can have as many children at any level
	 * BreathFirst Traversal: where you traverse through all the nodes at same level first (root -> all of its children
	 * -> all of its grand children, and so on.
	 * DepthFirst Traversal: you get to bottom of the Tree as soon as possible by getting to left most nodes, then go up
	 * as you hit the rock bottom to its parent, get to its next child and so on.
	 * 
	 * Approach for Breath First Traversing:
	 * a) Define a data structure, like array, for example
	 * b) Add Root Node to it.
	 * c) get first element from array, which is root in this case, get all its children and add them to end of data structure 
	 *    defined above (array, in this case. Can be a linked list as well.
	 * d) Process the extracted node, root in this case (depending on what you intend to do with tree elements, say print by 
	 * 	  hierarchy, etc) and move on
	 * e) Repeat step c) above
	 * This way, you will process all nodes of Tree in Breath First manner. Example, print an Org chart by hierarchy
	 * 
	 * Approach for Depth First Traversing:
	 * Good news here is, every steps is similar to above, except in step c), we add the children of extracted node to the
	 * beginning of the data structure we defined (array, in this case)
	 */
	
	private int data;
	private int [] children;
	private int size;
	private int currentLastIndex;	// to add new data faster
	
	public Node(int data) {
		this.data = data;
		// start with size 5, double it every time max is reached
		children = new int[5];
		if (currentLastIndex == size - 1) {
			resize();
		}
	}

	private void resize() {
		
		int newSize = size * 2;
		int [] newChildren = new int[newSize];
		int newLastIndex = -1;
		for (int elem : children) {
			newChildren[newLastIndex] = elem;
			newLastIndex++;
		}
		this.children = newChildren;
		this.size = newSize;
		this.currentLastIndex = newLastIndex;
		
	}

}
