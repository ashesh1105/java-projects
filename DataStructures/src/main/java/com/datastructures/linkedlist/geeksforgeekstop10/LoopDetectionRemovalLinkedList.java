package com.datastructures.linkedlist.geeksforgeekstop10;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/
 https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/

 Approach:
 If we just need to detect loop, we can do it by having a slow and a fast pointer. Slow moves one node at a time and
 fast one moves 2 nodes at a time. Interate through list, if pointers meet at a point, there is a loop, else not.

 In this case, we need to not only detect the loop but also fix it. Define a set, keep on adding nodes to it as you
 iterate over, while also checking if node was visited earlier. If it was, remove the link and point to null.
 Return true or false accordingly.
 */

public class LoopDetectionRemovalLinkedList {

    @Getter
    @Setter
    private Node head;

    public LoopDetectionRemovalLinkedList() {
        this.head = null;
    }

    public LoopDetectionRemovalLinkedList(int data) {
        this.head = new Node(data);
    }

    // Detect and fix loop, return true if it had a loop, else return false
    private boolean detectAndRemoveLoop() {

        // No loop possible if list has no node or just one node
        if (head == null || head.getNextNode() == null) return false;

        Set<Node> visited = new HashSet<>();

        Node curr = head;
        Node prev = null;

        while (curr != null) {

            if (visited.contains(curr)) {
                break;
            }

            visited.add(curr);
            prev = curr;
            curr = curr.getNextNode();
        }

        if (curr != null) {
            prev.setNextNode(null);
            return true;
        }

        return false;
    }

    private void insert(Node node) {
        if (this.head == null) {
            this.head = node;
            return; // Don't forget this
        }

        Node curr = head;
        while (curr.getNextNode() != null) {
            curr = curr.getNextNode();
        }

        curr.setNextNode(node);
    }

    public void insert(int data) {

        if (this.head == null) {
            this.head = new Node(data);
            return; // Don't forget this
        }

        Node curr = head;
        while (curr.getNextNode() != null) {
            curr = curr.getNextNode();
        }

        curr.setNextNode(new Node(data));
    }

    public String toString() {
        String result = "";
        Node curr = head;
        if (curr == null) {
            result = "Empty List!";
            return result;
        }

        while (curr != null && curr.getNextNode() != null) {
            result += curr.toString() + " -> ";
            curr = curr.getNextNode();
        }

        return result + curr.toString();
    }

    public void clear() {
        this.setHead(null);
    }

    public static void main(String[] args) {

        LoopDetectionRemovalLinkedList list = new LoopDetectionRemovalLinkedList();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        // Insert nodes
        list.insert(n1);
        list.insert(n2);
        list.insert(n3);
        list.insert(n4);
        list.insert(n5);

        // Create a loop in the list
        n5.setNextNode(n2);

        // Detect and fix the the loop
        System.out.println("List had a loop? " + list.detectAndRemoveLoop());
        System.out.println("Fixed loop: " + list.toString());
    }

}
