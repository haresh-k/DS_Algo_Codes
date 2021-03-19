package com.fr.application;

public class FirstRound {
	public static void main(String[] args) {
		int a = 23;
		String binaryString = Integer.toBinaryString(a);
		int i=0;
		int count= 0;
		while(i<binaryString.length()) {
			if(binaryString.charAt(i) == '1')
				count+=1;
			i+=1;
		}
		System.out.println(binaryString);
		System.out.println(count);
	}
}
