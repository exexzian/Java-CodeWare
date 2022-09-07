package com.soft.dev.trie;

public class TrieUsingArray {

	TrieNode root = new TrieNode();
	
	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.toCharArray().length; i++) {
			char c = word.charAt(i);
			if(node.children[c - 'a'] == null) {
				node.children[c-'a'] = new TrieNode();
			}
			
			node = node.children[c-'a'];
			
		}
		
		node.isLeaf = true;
		node.str = word;
	}
	
	public boolean search(String word) {
		
		TrieNode node = root;
		
		
		return false;
	}
	
}
