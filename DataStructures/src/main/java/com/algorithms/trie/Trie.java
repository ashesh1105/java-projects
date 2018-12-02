package com.algorithms.trie;

import java.util.Map;

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public boolean insert(String data) {
		
		boolean result = false;
		TrieNode current = root;
		
		for (int i=0; i<data.length(); i++) {
			char ch = data.charAt(i);
			Map<Character, TrieNode> children = current.getChildren();
			if (!children.containsKey(ch)) {
				children.put(ch, new TrieNode());
			} 
			current = children.get(ch);
		}
		// Finally set the end of word to true
		current.setEndOfWord(true);
		result = true;
		return result;
	}
	
	public boolean search(String data) {
		
		TrieNode current = root;
		
		for (int i=0; i<data.length(); i++) {
			char ch = data.charAt(i);
			Map<Character, TrieNode> children = current.getChildren();
			if (!children.containsKey(ch)) {
				return false;
			} else {
				current = children.get(ch);
			}
		}
		return current.isEndOfWord();
	}

}
