package com.fr.application;

import java.util.Stack;

public class FirstRound {
	public static void main(String[] args) {
		String s = "hareshkannan";
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			stack.push(s.charAt(i));
		}
		StringBuilder str = new StringBuilder();
		while(!stack.isEmpty()) {
			str.append(stack.pop());
		}
		System.out.println(str.toString());
	}
}
