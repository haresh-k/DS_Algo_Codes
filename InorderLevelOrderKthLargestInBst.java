package com.fr.application;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	Node left;
	Node right;
	int data;
	Node(int data){
		this.data = data;
		this.left = this.right = null;
	}
}

class Tree {
	Node root;
	
	public void insert(int data) {
		Node dataNode = new Node(data);
		Node temp = root;
		if(temp == null) {
			root = dataNode;
		}
		else {
			while(temp != null) {
				if(temp.data > data && temp.left!=null)
					temp = temp.left;
				else if(temp.data < data && temp.right!=null)
					temp = temp.right;
				else
					break;
			}
			if(temp.data != data) {
				if(temp.data > data)
					temp.left = dataNode;
				else
					temp.right = dataNode;
			}
			
		}
	}
	
	public void inorder(Node node) {
		if(node == null)
			return;
		else {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}
	
	public void levelOrder(Node root) {
		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.add(root);
		while(!nodeQueue.isEmpty()) {
			Node temp = nodeQueue.poll();
			System.out.print(temp.data + " ");
			if(temp.left != null)
				nodeQueue.add(temp.left);
			if(temp.right != null)
				nodeQueue.add(temp.right);
		}
	}
	
	public int getKLargest(int k) {
		int val = getKLargestUtil(root, k);
		return val;
	}
	
	private int getKLargestUtil(Node node, int k) {
		int currentLevel = 0;
		Stack<Node> nodeStack = new Stack<Node>();
		
		Node temp = node;

		while(temp != null || !nodeStack.isEmpty()) {
			while(temp != null) {
				nodeStack.push(temp);
				temp = temp.right;
			}
			temp = nodeStack.pop();
			currentLevel += 1;
			if(currentLevel == k)
				return temp.data;
			temp = temp.left;
		}
		return -1;
	}
}

public class FirstRound {
	public static void main(String[] args) {
		Tree bst = new Tree();
		bst.insert(50);
		bst.insert(24);
		bst.insert(73);
		bst.insert(47);
		bst.insert(67);
		bst.insert(2);
		bst.insert(3);
		System.out.println("Inorder output:");
		bst.inorder(bst.root);
		System.out.println();
		System.out.println("Levelorder output:");
		bst.levelOrder(bst.root);
		System.out.println();
		System.out.println("2nd Largest element" + bst.getKLargest(2));
		System.out.println("5th Largest element" + bst.getKLargest(5));
	}
}
