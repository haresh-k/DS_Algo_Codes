package com.fr.application;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FirstRound {
	public static void main(String[] args) {
		String s = "hareshkannan";
		Set<Character> charSet = new LinkedHashSet<Character>();
		for(int i=0;i<s.length();i++) {
			charSet.add(s.charAt(i));
		}
		System.out.println(charSet.stream().map(String::valueOf).collect(Collectors.joining()));
	}
}
