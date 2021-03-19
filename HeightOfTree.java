package com.fr.application;

class Node {
	Node left;
	Node right;
	int data;
	
	Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

class Tree {
	Node root;
	
	public int findHeight() {
		if(root == null)
			return -1;
		return findHeightUtil(root, 0);
	}
	
	private int findHeightUtil(Node node, int currHeight) {
		if(node == null) {
			return currHeight;
		}
		
		int leftHeight = findHeightUtil(node.left, currHeight+1);
		int rightHeight = findHeightUtil(node.right, currHeight+1);
		
		return leftHeight>rightHeight?leftHeight:rightHeight;
	}
}

public class FirstRound {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7);
        tree.root.right.right.right = new Node(9);
        System.out.println(tree.findHeight());
	}
}
