package com.datastructures.linkedlist;

import com.datastructures.linkedlist.geeksforgeekstop10.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CyclicList<T> {

	/*
	 * 1) Find out if a linkedlist is cyclic, i.e., it has a loop at some point. 2) Also, if list is cyclic,
	 * determine the node at which loop begins.
	 */

	public static void main(String[] args) {

		// create a non-cyclic list each to test
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.appendToTail(11);
		list1.appendToTail(12);
		list1.appendToTail(13);
		list1.appendToTail(14);

		// Also create a cyclic list. Here we need to manually create nodes and assign to list
		// as List implementation does not (and should not) make it easy to create list with loops!
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		Node<Integer> head = new Node<Integer>(11);
		list2.setHead(head);
		Node<Integer> current = head;
		current.setNextNode(new Node<Integer>(12));
		current = current.getNextNode();
		/*
		 * Never use a while loop to traverse a likely cyclic loop to avoid java.lang.OutOfMemory error!
		 */
		Node<Integer> cyclic = new Node<Integer>(13);
		current.setNextNode(cyclic);
		current = current.getNextNode();

		current.setNextNode(new Node<Integer>(14));
		current = current.getNextNode();

		current.setNextNode(new Node<Integer>(15));
		current = current.getNextNode();

		current.setNextNode(new Node<Integer>(16));
		current = current.getNextNode();

		// finally point the last node for now to one of the previous nodes. That node will be start of loop
		current.setNextNode(cyclic);

		// Never attempt to print a cyclic loop
		// System.out.println(list2 + " cyclic: " + cyclic + " current: " + current);

		System.out.println("The list is "
				+ (new CyclicList<Integer>().isCyclic(list2) ? "cyclic." : "not cyclic."));

		Map<Node<Integer>, Integer> map = new CyclicList<Integer>().getStartOfLoop(list2);
		int pos = -1;
		Node<Integer> node = null;
		for (Entry<Node<Integer>, Integer> entry : map.entrySet()) {
			node = entry.getKey();
			pos = entry.getValue();
		}
		System.out.println("Loop starts for list2 at node position: " + pos + " and Node is: "
				+ node);

	}

	public boolean isCyclic(LinkedList<T> list) {

		boolean result = false;

		Node<T> head = list.getHead();

		if (head == null) {
			System.out.println("List is empty.");
			return result;
		}

		Node<T> fast = head;
		Node<T> slow = head;

		while (fast != null && fast.getNextNode() != null) {
			fast = fast.getNextNode().getNextNode();
			slow = slow.getNextNode();
			if (fast == slow) {
				result = true;
				break;
			}
		}
		return result;
	}

	/*
	 * Maintain a map with key as nodes visited and value as position of node, like 1, 2, 3. Once a node is
	 * found as already in the map, that will be the start of loop we need.
	 */
	public Map<Node<T>, Integer> getStartOfLoop(LinkedList<T> list) {

		Map<Node<T>, Integer> result = new HashMap<Node<T>, Integer>();
		Map<Node<T>, Integer> startOfLoopNodeAndPositionMap = new HashMap<Node<T>, Integer>();

		Node<T> head = list.getHead();
		Node<T> current = head;
		if (current == null) {
			// log & return
			System.out
					.println("ERROR: List is empty so can not be cyclic. Start of loop will be null.");
			return null;
		}
		int nodePosition = 1;
		while (current != null) {

			if (startOfLoopNodeAndPositionMap.containsKey(current)) {
				result.put(current, startOfLoopNodeAndPositionMap.get(current));
				break;
			}
			startOfLoopNodeAndPositionMap.put(current, nodePosition);
			nodePosition++;
			current = current.getNextNode();
		}
		return result;

	}
	
	// There can be another better way to detect a loop, i.e., define two pointers, fast and slow
	// Move fast by 2 positions at a time and slow by one. If fast and slow meets at any point,
	// List is cyclic and that point will be start of the loop (Feasible to find start of the loop this way? Check it!)

}
