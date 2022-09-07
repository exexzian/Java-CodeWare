package com.soft.dev.trie;

public class TrieNode {
	
	TrieNode[] children;
	boolean isLeaf;
	String str;
	
	TrieNode(){
		children = new TrieNode[26];
		for (int i = 0; i < 26; i++) {
			children[i] = null;
		}
	}

}
