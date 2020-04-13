package com.datastructures.linkedlist;

import com.datastructures.linkedlist.geeksforgeekstop10.MyNode;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {

    MyLinkedList myList;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Before class");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("After class");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Before..");
        myList = new MyLinkedList(new MyNode(5));
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After..");
    }

    @Test
    public void testListConstructor() {
        int headData = myList.getHead().getData();
        assertEquals("Head of the list should be: 5", headData, 5);
    }

    @Test
    public void testAppendToTail() {

        myList.appendToTail(7);

        assertEquals("The added node should be 7", myList.getHead()
                .getNextNode().getData(), 7);
        // populate myList with odd numbers till 27
        for (int i = 9; i < 29; i += 2) {
            myList.appendToTail(i);
        }
        MyNode n = myList.getHead();
        while (n.getNextNode() != null) {
            n = n.getNextNode();
        }
        int tailData = n.getData();
        assertEquals("tail data should be 27", tailData, 27);
    }

    @Test
    public void testSearchANode() {
        // populate myList with odd numbers from 7 to 27. Head is 5 already from
        // @Before method
        for (int i = 7; i < 29; i += 2) {
            myList.appendToTail(i);
        }
        // Search for a node
        int searchData = 21;
        boolean foundIt = myList.contains(searchData);
        assertEquals("Data " + searchData + " is not in the list.", foundIt,
                true);
    }

    @Test
    public void testDeleteNode() {

        // populate myList with odd numbers till 27
        for (int i = 7; i < 29; i += 2) {
            myList.appendToTail(i);
        }
        // Print the entire list
        System.out.println("Printing from testDeleteNode:");
        System.out.println(myList.toString());

        // Delete a node
        int data = 21;
        myList.deleteNode(data);

        // Print the list to see if the data is no more
        System.out.println("Printing from testDeleteNode after removing "
                + data + ":");
        System.out.println(myList.toString());

        // Search for same data in the list again and add the test
        boolean foundIt = myList.contains(data);
        assertEquals("Data " + data + " should not be in the list but it is.",
                foundIt, false);

        // Delete another node
        int anotherData = 27;
        myList.deleteNode(anotherData);

        System.out.println("Printing from testDeleteNode after removing "
                + anotherData + ":");
        System.out.println(myList.toString());

        boolean foundData = myList.contains(anotherData);
        assertEquals("Data " + anotherData
                + " should not be in the list but it is.", foundData, false);
    }

    @Test
    public void testRemoveDuplicatesWithSameList() {

        // populate myList with odd numbers till 27. Head is already 5 from
        // @Before
        for (int i = 7; i < 29; i += 2) {
            myList.appendToTail(i);
        }
        // Add some duplicate nodes
        myList.appendToTail(7);
        myList.appendToTail(11);
        myList.appendToTail(13);
        myList.appendToTail(13);
        myList.appendToTail(17);
        myList.appendToTail(17);
        myList.appendToTail(17);
        // Print the list with duplicates
        System.out
                .println("Printing myList with duplicate nodes from testRemoveDuplicatesWithSameList test:");
        System.out.println(myList.toString());
        // Remove duplicates and print
        myList.removeDuplicatesWithSameList();
        System.out.println("Printing myList after removing duplicate nodes "
                + "from testRemoveDuplicatesWithSameList test:");
        System.out.println(myList.toString());
    }

    @Test
    public void testGetNthNodeFromLast() {

        myList = new MyLinkedList(new MyNode(29));
        // populate myList with odd numbers till 27
        for (int i = 31; i < 49; i += 2) {
            myList.appendToTail(i);
        }
        System.out.println("Printing from testGetNthNodeFromLast:");
        System.out.println(myList.toString());

        // Get nth node form the last and print it
        int n = 3;
        String spell = "";
        switch (n) {
            case 1:
                spell = "st";
                break;
            case 2:
                spell = "nd";
                break;
            case 3:
                spell = "rd";
                break;
            default:
                spell = "th";
        }
        System.out.println("Printing the " + n + spell
                + " node from the last inside testGetNthNodeFromLast:");
        MyNode resultNode = myList.getNthNodeFromLast(n);
        int result = resultNode == null ? 0 : resultNode.getData();
        System.out.println(result == 0 ? "null result found, returnng 0"
                : result);
        System.out.println(" ");

        // Real Test
        assertEquals("", (resultNode == null ? result : resultNode.getData()),
                43);
    }

    @Test
    public void testGetNthNodeFromLastWithNGreaterThanListSize() {

        myList = new MyLinkedList(new MyNode(29));
        // populate myList with odd numbers till 27
        for (int i = 31; i < 49; i += 2) {
            myList.appendToTail(i);
        }
        System.out
                .println("Printing from testGetNthNodeFromLastWithNGreaterThanListSize:");
        System.out.println(myList.toString());

        // Get nth node form the last and print it
        int n = 11;
        String spell = "";
        switch (n) {
            case 1:
                spell = "st";
                break;
            case 2:
                spell = "nd";
                break;
            case 3:
                spell = "rd";
                break;
            default:
                spell = "th";
        }
        System.out
                .println("Printing the "
                        + n
                        + spell
                        + " node from the last inside testGetNthNodeFromLastWithNGreaterThanListSize:");
        MyNode resultNode = myList.getNthNodeFromLast(n);
        int result = resultNode == null ? -1 : resultNode.getData();
        System.out.println(result == 0 ? "null result found, returnng -1"
                : result);
        System.out.println(" ");

        // Real Test - returned
        assertEquals("", (resultNode == null ? result : resultNode.getData()), -1);
    }

    // Below is a test of deleting the middle node of a linked list given only
    // the middle node
    @Test
    public void testDeleteMiddleNode() {
        // populate myList with numbers from 6 to 19
        for (int i = 6; i < 20; i++) {
            myList.appendToTail(i);
        }
        // Print the list with middle element
        System.out
                .println("Printing from testDeleteMiddleNode before deleting middle node:");
        System.out.println(myList.toString());

        // Delete the middle node for above list
        MyNode n = myList.getHead();
        MyNode middleNode = null;
        while (n != null) {
            if (n.getData() == 7) {
                middleNode = n;
                break;
            }
            n = n.getNextNode();
        }
        /*
         * if (middleNode != null) {
         * myList.deleteMiddleNodeWithMiddleNode(middleNode); }
         */
        myList.deleteMiddleNode();
        System.out
                .println("Printing from testDeleteMiddleNode after deleting middle node:");
        System.out.println(myList.toString());
    }

    @Test
    public void testAddNumsAsLinkedList() {
        int num = 10;
        int ones, tens, hundreds;

        hundreds = num / 100;
        tens = (num % 100) / 10;
        ones = num % 10;

        System.out.println("from addNumsAsLinkedList:\n");
        System.out.println("hundreds: " + hundreds + ", tens: " + tens
                + ", ones: " + ones);
        System.out.println(" ");
    }

    @Test
    public void testAppendLastNNodesToHead() {

        // populate myList with numbers from 6 to 19
        for (int i = 6; i < 20; i++) {
            myList.appendToTail(i);
        }
        // Print the list
        System.out
                .println("Printing from testAppendLastNNodesToHead before appending last n nodes to head:");
        System.out.println(myList.toString());

        // Append last n nodes to head
        int n = 13;
        System.out.println(myList.appendLastNNodesToHead(n));

        // Print the list again
        System.out
                .println("Printing from testAppendLastNNodesToHead after appending last "
                        + n + " nodes to head:");
        System.out.println(myList.toString());

    }

    @Test
    public void testReverseWithStack() {

        // populate myList with numbers from 6 to 19
        for (int i = 6; i < 20; i++) {
            myList.appendToTail(i);
        }
        // Print the list
        System.out
                .println("Printing from testReverse before appending last n nodes to head:");
        System.out.println(myList.toString());

        long start = System.nanoTime();

        myList.reverseWithStack();

        long end = System.nanoTime();

        System.out
                .println("\nTime taken to reverse the string with stack based algo: "
                        + (end - start) + "\n");
        System.out
                .println("Too bad, never use this algo, use reverse() method in MyLinkenList.java instead !!!");
        System.out.println("\nReversed list:" + myList.toString());

    }

    @Test
    public void testReverse() {

        // populate myList with numbers from 6 to 19
        for (int i = 6; i < 20; i++) {
            myList.appendToTail(i);
        }
        // Print the list
        System.out
                .println("Printing from testReverse before appending last n nodes to head:");
        System.out.println(myList.toString());

        long start = System.nanoTime();

        myList.reverse();

        long end = System.nanoTime();

        System.out.println("\nTime taken to reverse the string: "
                + (end - start) + "\n");
        System.out.println(myList.toString());

    }

}
