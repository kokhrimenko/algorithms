package com.study.kokhrimenko.algoriths.external.leetcode.string;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] inputString = new String[] {"flower", "flow", "flight"};
		LongestCommonPrefix executor = new LongestCommonPrefix();
		System.out.println(executor.longestCommonPrefix(inputString));
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		Arrays.sort(strs, (str1, str2) -> Integer.compare(str1.length(), str2.length()));
		
		String shortestString = strs[0];
		String resultesString = "";
		for(int i=0; i<shortestString.length(); i++) {
			String testedString = resultesString + shortestString.charAt(i);
			if(!allMatch(testedString, strs)) {
				break;
			}
			resultesString = testedString;
		}
		return resultesString;
	}
	
	private boolean allMatch(String prefix, String[] strs) {
		return Arrays.stream(strs).allMatch(str -> str.startsWith(prefix));
	}

}
