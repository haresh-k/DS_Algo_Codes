package com.fr.application;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FirstRound {
	public static void main(String[] args) {
		String s = "hareshkannan";
		List<Character> charSet = new LinkedList<Character>();
		for(int i=0;i<s.length();i++) {
			charSet.add(s.charAt(i));
		}
		String m = "hk";
		for(int i=0;i<m.length();i++) {
			char check1 = m.charAt(i);
			for(int j=0; j<charSet.size();j++) {
				if(charSet.get(j)==check1) {
					charSet.remove(j);
				}
			}
		}
		System.out.println(charSet.stream().map(String::valueOf).collect(Collectors.joining()));
	}
}
