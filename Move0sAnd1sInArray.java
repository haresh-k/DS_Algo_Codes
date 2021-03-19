package com.fr.application;

public class FirstRound {
	public static void main(String[] args) {
		int arr[] = {0,1,1,0,1,0,0};
		int j = 0;
        for (int i=0; i<arr.length; i++) {
        	while(j < arr.length && arr[j] == 0) {
        		j++;
        	}
        	if(arr[i] == 0 && j != arr.length && j<i) {
        		int temp = arr[i];
        		arr[i] = arr[j];
        		arr[j] = temp;
        	}
        }
        System.out.println("Output:");
        for (int i=0; i<arr.length; i++) {
        	System.out.println(arr[i]);
        }
	}
}
