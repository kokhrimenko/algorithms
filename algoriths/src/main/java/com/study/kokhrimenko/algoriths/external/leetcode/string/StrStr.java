package com.study.kokhrimenko.algoriths.external.leetcode.string;

public class StrStr {

	public static void main(String[] args) {
		String haystack = "hello",
				needle = "ll";
		
		StrStr executor = new StrStr();
		System.out.println(executor.strStr(haystack, needle));
	}

	public int strStr(String haystack, String needle) {
		if(needle == null || needle.isEmpty()) {
			return 0;
		}
		
		if(haystack == null || haystack.isEmpty()) {
			return -1;
		}
		
		return haystack.indexOf(needle);
	}

}
