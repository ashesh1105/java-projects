package main.java.com.algorithms.trie;

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
