package com.fr.application;

public class FirstRound {
	public static void main(String[] args) {
		String s = "()()(()))(";
		int count =0;
		int wrongIndex = -1;
		for (int i=0; i<s.length();i++) {
			if(s.charAt(i) == '(')
				count++;
			else
				count--;
			if(count < 0) {
				wrongIndex = i;
				break;
			}
		}
		if(wrongIndex != -1) {
			System.out.println("Index value:"+wrongIndex);
		}
	}
}