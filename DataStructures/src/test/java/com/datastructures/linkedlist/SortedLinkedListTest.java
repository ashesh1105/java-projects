package com.datastructures.linkedlist;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SortedLinkedListTest {

	MySortedLinkedList mySortedList;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		mySortedList = new MySortedLinkedList();
	}

	@Test
	public void testInsertAtTail() {
		
		mySortedList.insertAtTail(45);
		mySortedList.insertAtTail(5);
		mySortedList.insertAtTail(35);
		mySortedList.insertAtTail(25);
		mySortedList.insertAtTail(10);
		mySortedList.insertAtTail(55);
		mySortedList.insertAtTail(2);
		mySortedList.insertAtTail(-25);
		mySortedList.insertAtTail(-3);
		
		System.out.println(mySortedList.toString());
		
	}

}
