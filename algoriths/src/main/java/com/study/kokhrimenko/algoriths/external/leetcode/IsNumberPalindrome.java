package com.study.kokhrimenko.algoriths.external.leetcode;

public class IsNumberPalindrome {

	public static void main(String[] args) {
		IsNumberPalindrome executor = new IsNumberPalindrome();
		int inputValue = 1222;
		System.out.println(executor.isPalindrome(inputValue));
	}
	
	public boolean isPalindrome(int x) {
		if(x == 0 ) {
			return true;
		}
		
		String xAsString = String.valueOf(x);
		int median = xAsString.length() / 2,
				length = xAsString.length(),
				i = 0;;
		while(xAsString.charAt(i) == xAsString.charAt(length - i -1) && i < median) {
			i++;
		}
		return i == median;
    }
}
