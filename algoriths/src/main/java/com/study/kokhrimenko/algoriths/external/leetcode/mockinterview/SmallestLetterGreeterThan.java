package com.study.kokhrimenko.algoriths.external.leetcode.mockinterview;

public class SmallestLetterGreeterThan {
	public static void main(String[] args) {
		char[] letters = new char[] {'c', 'f', 'j'};
		
		SmallestLetterGreeterThan executor = new SmallestLetterGreeterThan();
		System.out.println(executor.nextGreatestLetter(letters, 'a'));
	}
	public char nextGreatestLetter(char[] letters, char target) {
		if(letters == null || letters.length ==0) {
			return Character.MIN_VALUE;
		}
		
		int i=0;
		while(i<letters.length && (letters[i] <= target)) {
			i++;
		}
		
		return i<letters.length ? letters[i] : letters[0];
	}
}
