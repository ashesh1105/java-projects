package main.java.com.algorithms.trie;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class TrieNode {
	
	@Getter
	private Map<Character, TrieNode> children;
	
	@Getter
	@Setter
	private boolean endOfWord;
	
	public TrieNode() {
		children = new HashMap<>();
	}
	
}
