package com.datastructures.linkedlist.geeksforgeekstop10;

import com.datastructures.linkedlist.LinkedList;

import java.util.Arrays;

/**
 https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/
 https://www.geeksforgeeks.org/merge-sort-for-linked-list/

 Approach:
 Define an array of Nodes with size as the size of linked list and then do merge sort. Once done, clear the
 head of linkedlist (set to null) and repopulate the list (appendToTail method comes handy here)
 Time complexityL nlogn with extra storage cost of an array equal to n
 */

public class MergeSortLinkedList  extends LinkedList {

    public static void main(String[] args) {

        MergeSortLinkedList list = new MergeSortLinkedList();

        list.appendToTail(40);
        list.appendToTail(20);
        list.appendToTail(60);
        list.appendToTail(10);
        list.appendToTail(50);
        list.appendToTail(30);


        System.out.println("Original List: " + list.toString());

        list.setHead(list.mergeSortLinkedList(list.getHead()));

        System.out.println("Sorted List: " + list.toString());
    }

    // Merge Sort a linkedList without using arrays. It return new head
    public Node mergeSortLinkedList(Node h) {

        // Base case : if head is null
        if (h == null || h.getNextNode() == null) {
            return h;
        }

        // get the middle of the list
        Node middle = middleNode();
        Node nextOfMiddle = middle.getNextNode();

        // set the next of middle node to null
        middle.setNextNode(null);

        // Apply mergeSort on left list
        Node left = mergeSortLinkedList(h);

        // Apply mergeSort on right list
        Node right = mergeSortLinkedList(nextOfMiddle);

        // Merge the left and right lists
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    private Node sortedMerge(Node a, Node b) {

        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if ((int) a.getData() <= (int) b.getData()) {
            result = a;
            result.setNextNode(sortedMerge(a.getNextNode(), b));
        }
        else {
            result = b;
            result.setNextNode(sortedMerge(a, b.getNextNode()));
        }
        return result;
    }


    // Another way to merge sort a LinkedList by using arrays and do merge sort in regular way
    public void mergeSort() {

        // Null check or if list has only one node
        if (this.getHead() == null || this.getHead().getNextNode() == null) {
            System.out.println("List is empty or has only one element!");
            return;
        }

        // Let's get the size of the list
        int size = 0;
        Node current = this.getHead();

        while (current != null) {
            size++;
            current = current.getNextNode();
        }

        // Let's create an array of type Node
        Node [] arr = new Node[size];

        // Populate the array
        current = this.getHead();
        int i=0;
        while (current != null) {
            arr[i] = current;
            i++;
            current = current.getNextNode();
        }

        int start = 0;
        int end = size - 1;
        mergeSortList(arr, start, end);

        // Repopulate list with sorted data nodes
        this.setHead(null); // clear the list
        Arrays.stream(arr).forEach(elem -> appendToTail(elem));
    }

    private void mergeSortList(Node[] arr, int start, int end) {

        if (start < end) {
            int mid = (start + end) / 2;
            mergeSortList(arr, start, mid);
            mergeSortList(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    private void merge(Node[] arr, int start, int mid, int end) {

        int sizeLeft = mid - start + 1;
        int sizeRight = end - mid;
        Node[] left = new Node[sizeLeft];
        Node[] right = new Node[sizeRight];

        // Populate two Node arrays
        for (int i=0; i<sizeLeft; i++) {
            left[i] = arr[start+i]; // Be careful here!
        }
        for (int j=0; j<sizeRight; j++) {
            right[j] = arr[mid+1+j];    // Be careful here as well!
        }

        int i=0;
        int j=0;

        for (int k=start; k<=end; k++) {
            if (j>=sizeRight || (i<sizeLeft && (int) left[i].getData() < (int) right[j].getData())) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
        }
    }

}
