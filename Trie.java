package com.fr.application;

class TrieNode {
	TrieNode[] nodes;
	boolean isWord = false;
	public TrieNode() {
	        this.nodes = new TrieNode[26];
	}
}

class Trie {
	TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	public void insert(String word) {
		TrieNode p = root;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if(p.nodes[index] == null) {
				p.nodes[index] = new TrieNode();
			}
			p = p.nodes[index];
		}
		p.isWord = true;
	}
	
	public boolean search(String word) {
		TrieNode p = root;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if(p.nodes[index] == null)
				return false;
			p = p.nodes[index];
		}
		return p.isWord;
	}
}

public class FirstRound {
	public static void main(String[] args) {
		Trie animalDict = new Trie();
		animalDict.insert("camel");
		animalDict.insert("dog");
		System.out.println("Found"+animalDict.search("dog"));
		System.out.println("Found"+animalDict.search("camel"));
	}
}
