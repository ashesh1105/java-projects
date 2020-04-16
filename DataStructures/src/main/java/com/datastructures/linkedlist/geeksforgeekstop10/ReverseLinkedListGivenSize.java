package com.datastructures.linkedlist.geeksforgeekstop10;

import lombok.Getter;
import lombok.Setter;

/**
 * https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/
 * https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 * <p>
 * Reverse a Linked List in groups of given size
 * Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 * <p>
 * Example:
 * Input: 1->2->3->4->5->6->7->8->NULL, K = 3
 * Output: 3->2->1->6->5->4->8->7->NULL
 * <p>
 * Input: 1->2->3->4->5->6->7->8->NULL, K = 5
 * Output: 5->4->3->2->1->8->7->6->NULL
 */

public class ReverseLinkedListGivenSize {

    @Getter
    @Setter
    private Node head;

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

    // Reverse list with given number of nodes at a time
    // Reverse list with given number of nodes at a time
    public void reverseNodes(int num) {

        this.head = reverse(head, num);

    }

    Node reverse(Node head, int k) {

        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null)
        {
            next = current.getNextNode();
            current.setNextNode(prev);
            prev = current;
            current = next;
            count++;
        }

       /* current (or next) is now a pointer to (k+1)th node
          Recursively call for the list starting from current and make rest of the list as next of first node
          Note that since this function returns prev, which is kth node from the beginning with node links reversed
          from kth node to 1st, if we skip the recursive call below with commented code below, we will see the list as:
          3->2->1->4>5->6->7->8... assuming k=3, so only first k nodes will be reversed:
          head.setNextNode(current);   // Note, head should become kth node now: 1<-2<-3, another list: 4->5>6...
          head = prev;  // prev will be 3, current will be 4

          But sine we do need to reverse every k nodes and not just one, we need to call recursively, setting the next
          node each time to another prev till current becomes null
          Visualize the call stack to understand below better, if needed
          */
        if (current != null)
            head.setNextNode(reverse(current, k));

        // prev is now head of input list
        return prev;
    }

    public static void main(String[] args) {

        ReverseLinkedListGivenSize list = new ReverseLinkedListGivenSize();

        // Populate list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);
        list.insert(10);
        list.insert(11);

        // Print original list
        System.out.println("Original List: " + list.toString());

        // Reverse the list with given number of nodes
        list.reverseNodes(3);

        // Print updated list
        System.out.println("Updated List: " + list.toString());
        System.out.println("New head: " + list.getHead());

    }
}
