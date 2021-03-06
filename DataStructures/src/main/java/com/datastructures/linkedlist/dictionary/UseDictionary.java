package com.datastructures.linkedlist.dictionary;

public class UseDictionary {

	/*
	 * Develop a Dictionary supporting one implementation. This implementation can only use List interface. A
	 * Dictionary maps a String term to a String definition; duplicate terms are allowed but must be in
	 * stored/displayed in alphabetical order. Dictionary must have printTermsInLexOrder(), among other
	 * methods. This method displays the term -> definition; this mapping is displayed in alphabetical order.
	 * List interface only -> you can't use other Collections classes.
	 * 
	 * Approach:
	 * 1) Design a class with attributes as "term" and "definition".
	 * 2) This class will implement Comparable with "term" attribute in overridden equals method.
	 * 3) Create a sorted linked list of type as above class. Data at Nodes will be an object of above.
	 * 4) Add a method in LinkedList class as "printTermsInLexOrder()" which simply prints all the nodes.
	 */

	public static void main(String[] args) {

		Dictionary dictionary = new Dictionary();

		dictionary.insert("NodeJS", "Pretty nice programming language!");
		dictionary.insert("Java", "A great programming language!");
		dictionary.insert("Ruby", "Powerful, but I am not a huge fan of it");
		dictionary.insert("Golang", "Great potential, although available libraries are maturing now");
		dictionary.insert("Ashesh", "Curious to learn, all the time!");

		dictionary.printTermsInLexOrder();


	}

}
