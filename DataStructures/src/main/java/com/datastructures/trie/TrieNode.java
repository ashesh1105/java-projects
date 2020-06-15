package com.datastructures.trie;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

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
