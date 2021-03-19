package com.fr.application;

class Node {
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	private Node head;

	LinkedList() {
		head = null;
	}
	void insert(int data) {
		if(head == null)
			head = new Node(data);
		else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(data);
		}
	}
	
	Node getHead() {
		return head;
	}
}

public class FirstRound {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		Node p1 = list.getHead();
		Node p2 = p1;
		
		while(p1.next!=null) {
			if(p1.next.next != null) {
				p1 = p1.next.next;
				p2 = p2.next;
			}
			else {
				break;
			}
		}
		System.out.println(p1.data);
		System.out.println(p2.data);
			
	}
}
