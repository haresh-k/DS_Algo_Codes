package com.fr.application;

import java.util.ArrayList;
import java.util.List;
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

class Bst {
	Node root;
	
	public void insert(int data) {
		if(root == null) {
			root = new Node(data);
		}
		else {
			Node temp = root;
			while(temp != null) {
				if(data<temp.data && temp.left != null)
					temp = temp.left;
				else if(data>temp.data && temp.right != null)
					temp = temp.right;
				else
					break;
			}
			if(data<temp.data) {
				temp.left = new Node(data);
			}
			else if(data>temp.data) {
				temp.right = new Node(data);
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
	
	public List<Integer> getInorderArray() {
		List<Integer> result = new ArrayList<Integer>();
		Stack<Node> node = new Stack<Node>();
		Node temp = root;
		while(!node.isEmpty()|| temp!=null) {
			while(temp!=null) {
				node.push(temp);
				temp = temp.left;
			}
			temp = node.pop();
			result.add(temp.data);
			temp = temp.right;
		}
		return result;
	}
	
	public boolean isBalanced(Node node) {
		if(node == null)
			return true;
		int lh = height(node.left);
		int rh = height(node.right);
		if(Math.abs(lh-rh)<=1 && isBalanced(node.left) && isBalanced(node.right)) {
			return true;
		}
		return false;
	}
	
	public int height(Node node) {
		if(node == null)
			return 0;
		return 1+Math.max(height(node.left), height(node.right));
	}
}

public class FirstRound {
	public static void main(String[] args) {
		Bst bst = new Bst();
		bst.insert(50);
		bst.insert(24);
		bst.insert(73);
		bst.insert(47);
		bst.insert(67);
		bst.insert(2);
		bst.insert(3);
		System.out.println(bst.isBalanced(bst.root));
List<Integer> inorderList = bst.getInorderArray();
		int i=0;
		int j=inorderList.size()-1;		
		int sum = 91;
		while(i<j) {
			if(inorderList.get(i) + inorderList.get(j) < sum) {
				System.out.println("I++" + inorderList.get(i) + " and " + inorderList.get(j));
				i++;
			}
			else if(inorderList.get(i) + inorderList.get(j) > sum) {
				System.out.println("J--" + inorderList.get(i) + " and " + inorderList.get(j));
				j--;
			}
			else {
				System.out.println("Values are" + inorderList.get(i) + " and " + inorderList.get(j));
				break;
			}
		}
	}
}
