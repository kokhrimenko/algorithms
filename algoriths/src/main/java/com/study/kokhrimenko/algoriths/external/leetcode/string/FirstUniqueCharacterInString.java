package com.study.kokhrimenko.algoriths.external.leetcode.string;

public class FirstUniqueCharacterInString {
	public static void main(String[] args) {
		String inputString = "loveleetcodevtdc";
		FirstUniqueCharacterInString executor = new FirstUniqueCharacterInString();
		System.out.println(executor.firstUniqChar(inputString));
	}

	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}
		
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
			
			if((s.substring(0, i) + s.substring(i+1)).indexOf(currChar) == -1) {
				return i;
			}
		}
		
		return -1;
	}
}
