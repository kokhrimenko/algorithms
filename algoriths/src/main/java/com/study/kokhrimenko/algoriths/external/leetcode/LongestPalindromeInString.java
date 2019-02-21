package com.study.kokhrimenko.algoriths.external.leetcode;

/**
 * Time O(n^2)
 * Space O(1)
 * @author kostic
 *
 */
public class LongestPalindromeInString {
	
	public String longestPalindrome(String s) {
		if (s == null) {
			return null;
		}

		if(s.isEmpty()) {
			return "";
		}
		
		if (s.length() == 1) {
			return s;
		}
		
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// get longest palindrome with center of i
			String tmp = defineLongestByCenter(s, i, i);
			if (tmp.length() >= longest.length()) {
				longest = tmp;
			}

			// get longest palindrome with center of i, i+1
			tmp = defineLongestByCenter(s, i, i + 1);
			if (tmp.length() >= longest.length()) {
				longest = tmp;
			}
		}
	 
		return longest;
	}

	private String defineLongestByCenter(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}

}
