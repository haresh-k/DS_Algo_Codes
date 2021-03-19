package com.fr.application;

class MaxHeap{
	int [] heap;
	int maxSize;
	int size;
	
	MaxHeap(int maxSize) {
		this.maxSize = maxSize;
		this.size  = 0;
		heap = new int[this.maxSize];
		heap[0] = Integer.MAX_VALUE;
	}
	
	private int getParent(int pos) {
		return pos/2;
	}
	
	private int getLeftChild(int pos) {
		return 2*pos;
	}
	
	private int getRightChild(int pos) {
		return 2*pos + 1;
	}
	
	private boolean isLeaf(int pos) {
		if(pos >= size/2 && pos <=size) {
			return true;
		}
		return false;
	}
	
	private void swap(int pos1,int pos2) {
		int temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}
	
	private void maxHeapify(int pos) {
		if(isLeaf(pos))
			return;
		if(heap[pos] < heap[getLeftChild(pos)] || heap[pos] < heap[getRightChild(pos)]) {
			if(heap[getLeftChild(pos)] > heap[getRightChild(pos)]) {
				swap(pos, getLeftChild(pos));
				maxHeapify(getLeftChild(pos));
			}
			else {
				swap(pos, getRightChild(pos));
				maxHeapify(getRightChild(pos));
			}
		}
	}
	
	public void insert(int val) {
		heap[++size] = val;
		int current = size;
		while(heap[current] > heap[getParent(current)]) {
			swap(current, getParent(current));
			current = getParent(current);
		}
	}
	
	public int extractMax() {
		int max = heap[1];
		heap[1] = heap[size--];
		maxHeapify(1);
		return max;
	}
	
	public void printHeap() {
		for(int i=1;i<=size/2;i++) {
			System.out.println("P:" + heap[i] + ",L:" + heap[getLeftChild(i)] + ",R:" + heap[getRightChild(i)]);
		}
	}
}

public class FirstRound {

	public static void main(String[] args) {
		System.out.println("The Max Heap is "); 
        MaxHeap maxHeap = new MaxHeap(15); 
        maxHeap.insert(5); 
        maxHeap.insert(3); 
        maxHeap.insert(17); 
        maxHeap.insert(10); 
        maxHeap.insert(84); 
        maxHeap.insert(19); 
        maxHeap.insert(6); 
        maxHeap.insert(22); 
        maxHeap.insert(9); 
  
        maxHeap.printHeap(); 
        System.out.println("The max val is " + maxHeap.extractMax());
        maxHeap.insert(83);
        maxHeap.printHeap(); 
        System.out.println("The max val is " + maxHeap.extractMax());
	}
}
