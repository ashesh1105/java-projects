package com.datastructures.linkedlist.geeksforgeekstop10;

import lombok.Getter;
import lombok.Setter;

/**
 https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/
 https://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/

 Merge a linked list into another linked list at alternate positions
 Given two linked lists, insert nodes of second list into first list at alternate positions of first list.

 For example, if first list is:
 5->7->17->13->11
 and second is:
 12->10->2->4->6,
 the first list should become:
 5->12->7->10->17->2->13->4->11->6
 and second list should become empty.

 The nodes of second list should only be
 inserted when there are positions available.

 For example, if the first list is:
 1->2->3
 and second list is:
 4->5->6->7->8,
 then first list should become:
 1->4->2->5->3->6
 and second list to;
 7->8.

 Use of extra space is not allowed (Not allowed to create additional nodes), i.e., insertion must be done in-place.
 Expected time complexity is O(n) where n is number of nodes in first list.

 */

public class MergeLinkedListToAnotherAlternatePosition {

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

    // Merge list to this.list
    public void merge(MergeLinkedListToAnotherAlternatePosition list) {

        if (list.head == null) return;

        Node curr1 = this.head;
        Node curr2 = list.head;
        Node temp1 = null;
        Node temp2 = null;

        while (curr1 != null && curr2 != null) {
            temp1 = curr1.getNextNode();
            curr1.setNextNode(curr2);
            temp2 = curr2.getNextNode();
            curr2.setNextNode(temp1);
            curr1 = temp1;
            curr2 = temp2;
        }

        list.setHead(curr2);


    }

    public static void main(String[] args) {

        MergeLinkedListToAnotherAlternatePosition list1 = new MergeLinkedListToAnotherAlternatePosition();
        MergeLinkedListToAnotherAlternatePosition list2 = new MergeLinkedListToAnotherAlternatePosition();

        // Populate lists - Test Case1
        list1.insert(5);
        list1.insert(7);
        list1.insert(17);
        list1.insert(13);
        list1.insert(11);

        list2.insert(12);
        list2.insert(10);
        list2.insert(2);
        list2.insert(4);
        list2.insert(6);

        System.out.println("Test Case 1:");
        System.out.println("Original list1: " + list1.toString());
        System.out.println("Original list2: " + list2.toString());

        list1.merge(list2);

        System.out.println("New list1 after merging to list2: " + list1.toString());
        System.out.println("New list2 after it was merged to list1: " + list2.toString());

        // Populate List again for Test Case 2
        list1.clear();
        list2.clear();

        list1.insert(1);
        list1.insert(2);
        list1.insert(3);

        list2.insert(4);
        list2.insert(5);
        list2.insert(6);
        list2.insert(7);
        list2.insert(8);

        System.out.println("\nTest Case 2:");
        System.out.println("Original list1: " + list1.toString());
        System.out.println("Original list2: " + list2.toString());

        list1.merge(list2);

        System.out.println("New list1 after merging to list2: " + list1.toString());
        System.out.println("New list2 after it was merged to list1: " + list2.toString());



    }

}
