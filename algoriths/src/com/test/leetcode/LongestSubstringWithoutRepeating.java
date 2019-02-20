package com.test.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

	public static void main(String[] args) {
		String inputString = "pwwkew";
		System.out.println(lengthOfLongestSubstring(inputString));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		if(s == null || s.isEmpty()) {
			return 0;
		}
		
		int result = 0,
				lastRepeated = 0;
		Set<Character> alreadyExistsCharacters = new HashSet<>();
		for(int i = 0; i<s.length(); i++) {
			char currentChar = s.charAt(i);
			if(alreadyExistsCharacters.add(currentChar)) {
				result = result > alreadyExistsCharacters.size() ? result : alreadyExistsCharacters.size();
			} else {
				while(lastRepeated < i) {
					if(s.charAt(lastRepeated) == currentChar) {
						lastRepeated ++;
						break;
					} else {
						alreadyExistsCharacters.remove(s.charAt(lastRepeated));
						lastRepeated ++;
					}
				}
			}
		}
		return result;
	}
	
}
