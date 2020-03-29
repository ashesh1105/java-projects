package com.datastructures.linkedlist.dictionary;

public class Dictionary {

    private DNode root;

    public void insert(String term, String definition) {

        DNode newNode = new DNode(term, definition);
        // If root is null, set root as newNode
        if (root == null) {
            root = new DNode(term, definition);
            return;
        }

        DNode current = root;
        DNode prev = current;
        current = current.getNext();

        // If newNode is less than root, point it to root and make it new root
        if (prev.compareTo(newNode) > 0) {
            newNode.setNext(prev);
            root = newNode;
            return;
        }

        while (current != null) {
            if (current.compareTo(newNode) > 0) {
                newNode.setNext(current);
                prev.setNext(newNode);
                break;
            }
            prev = current;
            current = current.getNext();
        }
        // Finally, if we reached to end of list, add the new node there
        if (current == null) {
            prev.setNext(newNode);
        }
    }

    public void printTermsInLexOrder() {
        DNode current = root;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

}
