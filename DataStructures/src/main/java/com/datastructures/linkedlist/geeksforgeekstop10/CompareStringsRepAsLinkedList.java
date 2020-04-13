package com.datastructures.linkedlist.geeksforgeekstop10;

import lombok.Getter;
import lombok.Setter;

/**
 https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/
 https://www.geeksforgeeks.org/compare-two-strings-represented-as-linked-lists/

 Compare two strings represented as linked lists
 Given two strings, represented as linked lists (every character is a node in a linked list). Write a function
 compare() that works similar to strcmp(), i.e., it returns 0 if both strings are same, 1 if first linked list is
 lexicographically greater, and -1 if the second string is lexicographically greater.

 Examples:
 Input: list1 = g->e->e->k->s->a
 list2 = g->e->e->k->s->b
 Output: -1

 Input: list1 = g->e->e->k->s->a
 list2 = g->e->e->k->s
 Output: 1

 Input: list1 = g->e->e->k->s
 list2 = g->e->e->k->s
 Output: 0
 */

public class CompareStringsRepAsLinkedList {

    @Getter
    @Setter
    private Node<Character> head;

    public CompareStringsRepAsLinkedList(Node head) {
        this.head = head;
    }

    public String print() {
        String result = "";

        Node curr = head;

        while (curr != null) {
            result += curr.getData();
            curr = curr.getNextNode();
        }

        return result;
    }

    public int compareTo(CompareStringsRepAsLinkedList list) {

        if (!(list instanceof CompareStringsRepAsLinkedList) || this.head == null || list.head == null) {
            System.out.println("Please send lists that are an instance of CompareStringsRepAsLinkedList an aren't null!");
            return 0;
        }

        Node head1 = this.getHead();
        Node curr1 = head1;

        Node head2 = list.getHead();
        Node curr2 = head2;

        while (curr1 != null && curr2 != null) {
            char ch1 = (char) curr1.getData();
            char ch2 = (char) curr2.getData();

            // If ch1 and ch2 aren't same, return 1 or -1 based on their comparision, else just proceed to next nodes
            if (ch1 != ch2) {
                return ch1 > ch2 ? 1 : -1;
            }

            // Increment curr1 and curr2
            curr1 = curr1.getNextNode();
            curr2 = curr2.getNextNode();
        }

        // After above loop, either curr1 and curr2, both are null or just one of them. Return the result accordingly
        if (curr1 == null && curr2 == null) return 0;
        else if (curr1 != null && curr2 == null) return 1;
        else return -1;
    }

    public static void main(String[] args) {

        // Create first linked list and populate it
        String str1 = "geeks";
        Node head1 = new Node(str1.charAt(0));
        Node curr = head1;

        for (int i=1; i<str1.length(); i++) {
            curr.setNextNode(new Node(str1.charAt(i)));
            curr = curr.getNextNode();
        }
        CompareStringsRepAsLinkedList list1 = new CompareStringsRepAsLinkedList(head1);

        // Create second linked list and populate it
        String str2 = "geet";
        Node head2 = new Node(str2.charAt(0));
        curr = head2;

        for (int i=1; i<str2.length(); i++) {
            curr.setNextNode(new Node(str2.charAt(i)));
            curr = curr.getNextNode();
        }
        CompareStringsRepAsLinkedList list2 = new CompareStringsRepAsLinkedList(head2);

        System.out.println("list1: " + list1.print());
        System.out.println("list2: " + list2.print());

        int result = list1.compareTo(list2);

        if (result == 0) {
            System.out.println("Lists are equal!");
        } else if (result > 0){
            System.out.println("list1 is greater.");
        } else {
            System.out.print("list2 is greater.");
        }

    }

}
