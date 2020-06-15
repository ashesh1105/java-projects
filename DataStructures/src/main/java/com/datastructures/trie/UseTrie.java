package com.datastructures.trie;

/*
Trie is an efficient information reTrieval data structure. Using Trie, search complexities can be brought to optimal
limit (key length). If we store keys in binary search tree, a well balanced BST will need time proportional to
M * log N, where M is maximum string length and N is number of keys in tree. Using Trie, we can search the
key in O(M) time.

https://www.geeksforgeeks.org/trie-insert-and-search/
https://www.youtube.com/watch?v=zIjfhVPRZCg&list=PLR7m0RnS3OT6LomiCCN5XhA-cRCvShxKY&index=30&t=0s

It is often used to look up a string and see which known words get formed from a sequence of characters. Here a node
consists of a map of Character and another instance of node of same class. So that way a tree can be formed. Node also
consists of a boolean argument like endOfWord, indicating a full word, like
C -> A -> R -> D (A, R and D can have multiple children (please see pictorial representation of Trie on internet)
In above, Node R can have the endOfWord flag as true since CAR is a full word, same goes for D (CARD is full word).
 */

public class UseTrie {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("catter");
        System.out.println("word cat is in Trie? " + trie.search("cat"));
        System.out.println("word ca is in Trie? " + trie.search("ca"));
        System.out.println("word catter is in Trie? " + trie.search("catter"));


    }

}
