package com.datastructures.tree.binarytree.binarysearchtree;

import lombok.Getter;

import java.util.logging.Logger;

public class BinarySearchTree {

    Logger logger = Logger.getLogger(BinarySearchTree.class.getName());

    @Getter
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(int data) {
        this.root = new Node(data);
    }

    // Find data
    public Node find(int data) {
        if (root == null) {
            logger.warning("Root of this BST is null. find() will return null.");
            return null;
        }
        return root.find(data);
    }

    // Insert data
    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node current = root;
        Node parent;
        while (true) {
            parent = current;
            if (data < parent.getData()) {
                current = current.getLeftNode();
                if (current == null) {
                    parent.setLeftNode(new Node(data));
                    break;
                }
            } else {
                current = current.getRightNode();
                if (current == null) {
                    parent.setRightNode(new Node(data));
                    break;
                }
            }
        }
    }

    // Traverse through entire tree and print it via inOrder
    public void printInOrder() {
        inOrder(root);
    }

    private void inOrder(Node n) {
        if (n != null) {
            inOrder(n.getLeftNode());
            System.out.println(n.getData());
            inOrder(n.getRightNode());
        }
    }

    // Find min value
    public Node min() {
        Node current = root;
        while (current != null && current.getLeftNode() != null) {
            current = current.getLeftNode();
        }
        return current;
    }

    // Find the max value
    public Node max() {
        Node current = root;
        while (current != null && current.getRightNode() != null) {
            current = current.getRightNode();
        }
        return current;
    }

    /**
     * Delete a Root Node. Remember, if left child of the root is not null, the new root will be the right most leaf
     * node at left sub tree (to root), else it has to be the left most node at right sub tree.
     */
    public void deleteRootNode() {
        Node parent = root;
        Node current = parent;
        if (parent == null) {
            // empty binary search tree, log and return
            System.out.println("Tree is empty, root is already null.");
            return;
        }
        Node leftNodeToRoot = parent.getLeftNode();
        Node rightNodeToRoot = parent.getRightNode();

        // If both the child of root node are null, simply set root to null
        if (leftNodeToRoot == null && rightNodeToRoot == null) {
            root = null;
            System.out.println("Root is set to null now.");
            return;
        }

        // If leftNodeToRoot is not null, new root will be the right most child in left subtree
        // else, it will be the left most child in right sub tree
        if (leftNodeToRoot != null) {
            parent = leftNodeToRoot;
            current = parent.getRightNode();

            if (current != null) {
                while (current != null && current.getRightNode() != null) {
                    parent = current;
                    current = current.getRightNode();
                }
                // Now current points to right most node at left sub tree to root
                // This may has a left child. That, if not null, should now become the right most child of left sub tree
                if (current.getLeftNode() != null) {
                    parent.setRightNode(current.getLeftNode());
                } else {
                    parent.setRightNode(null);
                }
            } else {
                leftNodeToRoot.setRightNode(rightNodeToRoot);
                root.setLeftNode(null);
                root.setRightNode(null);
                root = leftNodeToRoot;
                return;
            }
        } else {
            parent = rightNodeToRoot;
            current = parent.getLeftNode();

            if (current != null) {
                while (current != null && current.getLeftNode() != null) {
                    parent = current;
                    current = current.getLeftNode();
                }
                // Like above, left most child of right subtree will become new root
                // if it had a right child, that should now before left most node of right sub tree
                if (current.getRightNode() != null) {
                    parent.setLeftNode(current.getRightNode());
                } else {
                    parent.setLeftNode(null);
                }
            } else {
                root.setLeftNode(null);
                root.setRightNode(null);
                root = rightNodeToRoot;
                return;
            }
        }

        // Make the current node the new root!
        current.setLeftNode(leftNodeToRoot);
        current.setRightNode(rightNodeToRoot);
        root.setLeftNode(null);
        root.setRightNode(null);
        root = current;
    }

    // Is it a leaf node?
    public boolean isLeafNode(int data) {

        Node current = root;
        Node dataNode = null;
        if (root == null) {
            // Log the info, tree is empty
            System.out.println("Tree is empty!");
            return false;
        }
        if (root.getData() == data) {
            if (isLeafNode(root)) {
                return true;
            } else {
                return false;
            }
        }

        while (true) {
            if (data < current.getData()) {
                current = current.getLeftNode();
            } else {
                current = current.getRightNode();
            }
            if (current == null) {
                // Log as data not found
                System.out.println("Data not found in the tree!");
                return false;
            } else {
                if (data == current.getData()) {
                    dataNode = current;
                    break;
                }
            }
        }
        if (dataNode != null) {
            if (isLeafNode(dataNode)) {
                return true;
            }
        }
        return false;
    }

    private boolean isLeafNode(Node n) {
        return n.getLeftNode() == null && n.getRightNode() == null;
    }

    // Uses Raghavendra Dixit (Udemy) method
    public long numLeafNodes() {
        return root.numLeaves();
    }

    // My own method. Equivalent to Raghavendra Dixit method
    // By definition, in n node BST, max number of leaf nodes possible is (n + 1)/2.
    // Above will be the case if BST is Complete (meaning all levels are full and last level has all nodes
    // to its left) and also Full (meaning all nodes either have exactly 2 children, else are a leaf node.
    public long countLeafNodes() {
        if (root == null) {
            // log and return zero
            System.out.println("Empty tree. Root is null!");
            return 0;
        }
        return countLeaves(root);
    }

    private long countLeaves(Node n) {

        // if this is a leaf node, return the count as 1
        if (isLeafNode(n))
            return 1;
        // number of nodes for left subtree
        long numLeftLeafNodes = 0;

        // number of nodes for right subtree
        long numRightLeafNodes = 0;

        // Traverse through left sub tree and count leaf nodes
        if (n != null && n.getLeftNode() != null) {
            numLeftLeafNodes = countLeaves(n.getLeftNode());
        }

        // Traverse through right sub tree and count leaf nodes
        if (n != null && n.getRightNode() != null) {
            numRightLeafNodes = countLeaves(n.getRightNode());
        }
        return numLeftLeafNodes + numRightLeafNodes;
    }

    // Height of binary sort tree
    public int height() {
        if (root == null) {
            return 0;
        } else {
            return root.height();
        }
    }

    // Create a new binary sort tree
    public static BinarySearchTree getInstance(int[] data, int start, int end) {

        BinarySearchTree bst = new BinarySearchTree();
        if (data != null && data.length != 0) {
            bst.root = Node.addSorted(data, start, end);
        }
        return bst;
    }

    public int sum(Node n) {

        if (n == null) {
            return 0;
        }

        int leftSum = 0;
        int rightSum = 0;

        leftSum = sum(n.getLeftNode());
        rightSum = sum(n.getRightNode());
        return n.getData() + leftSum + rightSum;

    }

    /*
     * You have a binary search tree and integer n, find out the most efficient way to locate two nodes of the three
     * whose summation is equals to "n" ?
     */

}
