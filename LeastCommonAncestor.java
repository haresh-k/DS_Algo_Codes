package com.fr.application;

import java.util.ArrayList;
import java.util.List;

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
	private List<Integer> path1 = new ArrayList<>(); 
    private List<Integer> path2 = new ArrayList<>();
    
	public int findLeastCommonAncestor(int n1, int n2) {
		path1 = getPathList(root, n1);
		path2 = getPathList(root, n2);
		int i=0;
		while(true) {
			if(!path1.get(i).equals(path2.get(i)))
				break;
			i++;
		}
		return path1.get(i-1);
	} 
	private List<Integer> getPathList(Node root, int n) {
		List<Integer> path = new ArrayList<>();
		findPath(root, n, path);
		return path;
	}
	private boolean findPath(Node node, int n, List<Integer> path) {
		if (node == null) {
			return false;
		}
		path.add(node.data);
		if (node.data == n) { 
			System.out.println("Found");
            return true; 
        }
		if(node.left != null && findPath(node.left, n, path)) {
			return true;
		}
		if(node.right != null && findPath(node.right, n, path)) {
			return true;
		}
		path.remove(path.size()-1);
		return false;
	}
}

public class FirstRound {
	public static void main(String[] args) {
		Bt tree = new Bt();
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7);
	}
}
