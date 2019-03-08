package com.study.kokhrimenko.algoriths.external.leetcode.string;

public class IsAnagram {

	public static void main(String[] args) {
		String t = "", s = "";
		IsAnagram executor = new IsAnagram();
		System.out.println(executor.isAnagram(s, t));
	}

	public boolean isAnagram(String s, String t) {
		if (s == null ) {
			return false;
		}

		if (t == null) {
			return true;
		}

		if(s.equals(t)) {
			return true;
		}
		
		if (s.length() != t.length()) {
			return false;
		}
		int i = 0;
		while (i < t.length()) {
			int index = s.indexOf(t.charAt(i));
			if (index == -1) {
				return false;
			}
			s = s.substring(0, index) + s.substring(index+1);
			i++;
		}
		return s.length() == 0;
	}

}
