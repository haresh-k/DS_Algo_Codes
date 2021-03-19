package com.fr.application;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRound {
	public static void main(String[] args) {
		String s = "hareshkannan";
		Map<Character, Integer> charCount = new LinkedHashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			if(charCount.get(s.charAt(i)) == null) {
				charCount.put(s.charAt(i), 1);
			}
			else {
				int value = charCount.get(s.charAt(i));
				charCount.replace(s.charAt(i), value+1);
			}
		}
		char maxChar = 0;
		int max = Integer.MIN_VALUE;
		for (Map.Entry<Character,Integer> entry : charCount.entrySet()) {
			Character key = entry.getKey();
			Integer value = entry.getValue();
			if(max < value) {
				max = value;
				maxChar = key;
			}
			System.out.println("("+key+", "+value+")");
		}
		
		System.out.println("Max Char occurence: " + maxChar);
	}
}
