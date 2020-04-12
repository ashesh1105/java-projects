package com.datastructures.linkedlist;

public class MergeNSortedLinkedLists {

	/*
	 * Merge 'n' number of sorted linked lists. Use no extra memory and minimum comparisons.
	 * Approach: 
	 * 1) Chose one of the lists to which all the other lists are to be merged -> call it chosenList
	 * 2) Come up with a merge routine, taking chosenList and one list at a time -> list
	 * 3) Check for roots of two lists being null, return and log appropriate message in case.
	 * 4) Compute last nodes of two lists.
	 * 5) If last node of list is less than root of chosenList, add the new list at root of chosenList
	 * 6) If last node of chosenList is less than root of list, add list at end of chosenList
	 * 7) Else, take each nodes of list, iterate through chosenList and add where list remain sorted.
	 * 8) Repeat above steps for all the other sorted lists 3 to n.
	 */

	public static void main(String[] args) {

	}

}
