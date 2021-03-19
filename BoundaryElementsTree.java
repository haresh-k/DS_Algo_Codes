package com.fr.application;

class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.left = null;
		this.right = null;
		this.data = data;
	}
}

class Bt {
	Node root;
	
	private void printLeftElements(Node node) {
		if(node == null)
			return;
		if(node.left != null) {
			System.out.print(node.data + " ");
			printLeftElements(node.left);
		}
		else if(node.right != null) {
			System.out.print(node.data + " ");
			printLeftElements(node.right);
		}
	}
	
	private void printRightElements(Node node) {
		if(node == null)
			return;
		if(node.right != null) {
			System.out.print(node.data + " ");
			printRightElements(node.right);
		}
		else if(node.left != null) {
			System.out.print(node.data + " ");
			printRightElements(node.left);
		}
	}
	public void printLeaves(Node node) {
		if(node == null)
			return;
		if(node.left == null && node.right == null)
			System.out.print(node.data + " ");
		printLeaves(node.left);
		printLeaves(node.right);
	}
	
	public void printBoundaryElements() {
		if(root != null) {
			System.out.print(root.data + " ");
			printLeftElements(root.left);
			printLeaves(root.left);
			printLeaves(root.right);
			printRightElements(root.right);
		}
	}
	
}

public class FirstRound {

	public static void main(String[] args) {
		Bt tree = new Bt();
		tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right.right = new Node(25); 
        System.out.println("Boundary elements:");
        tree.printBoundaryElements();
        System.out.println();
        System.out.println("Leaves:");
        tree.printLeaves(tree.root);
	}
}
