package com.datastructures.trie;

import java.util.Map;

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public boolean insert(String data) {

		TrieNode current = root;
		TrieNode prev = null;
		
		for (int i=0; i<data.length(); i++) {
			char ch = data.charAt(i);
			Map<Character, TrieNode> children = current.getChildren();
			if (!children.containsKey(ch)) {
				children.put(ch, new TrieNode());
			}
			prev = current;
			current = children.get(ch);
		}
		// Finally set the end of word to true for last node
		if (prev != null) {
			prev.setEndOfWord(true);
		}
		return true;
	}
	
	public boolean search(String data) {
		
		TrieNode current = root;
		TrieNode prev = null;
		
		for (int i=0; i<data.length(); i++) {
			char ch = data.charAt(i);
			Map<Character, TrieNode> children = current.getChildren();
			if (!children.containsKey(ch)) {
				return false;
			} else {
				prev = current;
				current = children.get(ch);
			}
		}
		return prev.isEndOfWord();
	}

}
