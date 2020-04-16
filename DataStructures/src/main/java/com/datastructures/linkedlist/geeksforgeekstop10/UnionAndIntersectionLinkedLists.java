package com.datastructures.linkedlist.geeksforgeekstop10;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/
 https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/

 Union and Intersection of two Linked Lists
 Given two Linked Lists, create union and intersection lists that contain union and intersection of the elements
 present in the given lists. Order of elments in output lists doesn’t matter.

 Example:

 Input:
 List1: 10->15->4->20
 lsit2:  8->4->2->10

 Output:
 Intersection List: 4->10
 Union List: 2->8->20->4->15->10

 Approaches:
 1) Traverse through each node on list1 and check in list2, accordingly populate result list for union or intersection.
 Time complexity: O(n^2)
 2) Merge sort both the lists and then iterate both lists together in O(n) time and build the result list.
 3) Use a map to build result for union or intersection. In Map, use data as key and node as value.
 */

public class UnionAndIntersectionLinkedLists {

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

    // Union
    public UnionAndIntersectionLinkedLists union(UnionAndIntersectionLinkedLists list) {

        Map<Integer, Node> map = new HashMap<>();
        UnionAndIntersectionLinkedLists result = new UnionAndIntersectionLinkedLists();

        Node current = this.head;

        while (current != null) {
            int data = (int) current.getData();
            if (!map.containsKey(data)) {
                map.put(data, current);
            }
            current = current.getNextNode();
        }

        current = list.getHead();

        while (current != null) {
            int data = (int) current.getData();
            if (!map.containsKey(data)) {
                map.put(data, current);
            }
            current = current.getNextNode();
        }

        map.forEach((k, v) -> {
            result.insert(k);
        });

        return result;
    }

    // Intersection
    public UnionAndIntersectionLinkedLists intersection(UnionAndIntersectionLinkedLists list) {

        Map<Integer, Node> map = new HashMap<>();
        UnionAndIntersectionLinkedLists result = new UnionAndIntersectionLinkedLists();

        Node current = this.head;

        while (current != null) {
            int data = (int) current.getData();
            if (!map.containsKey(data)) {
                map.put(data, current);
            }
            current = current.getNextNode();
        }

        current = list.getHead();

        while (current != null) {
            int data = (int) current.getData();
            if (map.containsKey(data)) {
                result.insert(data);
            }
            current = current.getNextNode();
        }

        return result;
    }

    public static void main(String[] args) {

        UnionAndIntersectionLinkedLists list1 = new UnionAndIntersectionLinkedLists();
        UnionAndIntersectionLinkedLists list2 = new UnionAndIntersectionLinkedLists();

        // Populate list
        list1.insert(10);
        list1.insert(15);
        list1.insert(4);
        list1.insert(20);

        list2.insert(8);
        list2.insert(4);
        list2.insert(2);
        list2.insert(10);

        // Print lists
        System.out.println("List1: " + list1.toString());
        System.out.println("List2: " + list2.toString());

        // Union and Intersection
        System.out.println("Union: " + list1.union(list2).toString());
        System.out.println("Intersection: " + list1.intersection(list2).toString());
    }
}
