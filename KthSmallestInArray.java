package com.fr.application;

import java.util.Arrays;

public class FirstRound {

	/**
	 * @param args
	 * Added if else based on array length, if k less than half array length use insertion sort or arrays.sort technique
	 */
	public static void main(String[] args) {
		int k=3;
		int []arr = {6,4,9,3,1};
		if(k <= arr.length/2) {
			int j = 0;
			while(j<arr.length-1) {
				for(int i=j; i<arr.length; i++) {
					if(j == k) {
						System.out.println("Checkout1 - "+arr[k-1]);
						break;
					}
					if(arr[j] > arr[i]) {
						int temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
					}
				}
				j++;
			}
			
		}
		else {
			Arrays.sort(arr);
			System.out.println("Checkout2 - "+arr[k-1]);
		}	
	}

}
