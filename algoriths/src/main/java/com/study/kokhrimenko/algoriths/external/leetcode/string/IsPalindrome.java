package com.study.kokhrimenko.algoriths.external.leetcode.string;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * @author kostic
 *
 */
public class IsPalindrome {

	public static void main(String[] args) {
		String inputString = "race a car";
		IsPalindrome executor = new IsPalindrome();
		System.out.println(executor.isPalindrome(inputString));
	}
	
	public boolean isPalindrome(String s) {
		if(s == null || s.isEmpty()) {
			return true;
		}
		s= s.trim().replaceAll("[\\W]|_", "").toLowerCase();
		if(s.isEmpty()) {
			return true;
		}
		int i = 0,
				length = s.length();
		while (i < length / 2 && s.charAt(i) == s.charAt(length - i - 1)) {
			i++;
		}
		return i == length / 2;
	}

}
