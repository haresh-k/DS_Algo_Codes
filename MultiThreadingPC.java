package com.fr.application;

import java.util.LinkedList;

class PC {
	LinkedList<Integer> valueList;
	int capacity;
	PC(){
		valueList = new LinkedList<Integer>();
		capacity = 10;
	}
	
	void produce() throws InterruptedException{
		int value = 0;
		while(true) {
			synchronized (this) {
				while(valueList.size() == capacity)
					wait();
				System.out.println("Produced: " +value);
				valueList.add(value++);
				notify();
				Thread.sleep(100);
			}
		}
	}
	
	void consume() throws InterruptedException{
		while(true) {
			synchronized(this) {
				while(valueList.size() == 0)
					wait();
				System.out.println("Consumed: "+ valueList.removeFirst());
				notify();
				Thread.sleep(100);
			}
		}
	}
}

public class FirstRound {

	public static void main(String[] args) throws InterruptedException {
		PC producerConsumer = new PC();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					producerConsumer.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					producerConsumer.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}
