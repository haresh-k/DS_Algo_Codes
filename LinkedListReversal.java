package com.fr.application;

class Node {
	Node next;
	int data;
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	Node head;
	
	public void insert (int data) {
		Node dataNode = new Node(data);
		Node temp = head;
		if(head == null) {
			head = dataNode;
		}
		else {
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next = dataNode;
		}
	}
	
	public void reverse() {
		Node prev = null;
		Node next = null;
		Node curr = head;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	
	public void printList() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
			
	}
}

public class FirstRound {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(18);
		list.insert(12);
		list.insert(31);
		list.insert(24);
		list.insert(5);
		list.insert(61);
		System.out.println("Before Reversing: ");
		list.printList();
		list.reverse();
		System.out.println();
		System.out.println("After Reversing: ");
		list.printList();
	}
}
