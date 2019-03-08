package com.study.kokhrimenko.algoriths.external.leetcode.string;

/**
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * @author kostic
 *
 */
public class ReverseString {

	public static void main(String[] args) {
		char[] inputArr = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
		ReverseString executor = new ReverseString();
		executor.reverseString(inputArr);

		System.out.println(new String(inputArr));
	}

	public void reverseString(char[] s) {
		if (s == null || s.length < 2) {
			return;
		}

		int length = s.length;
		for (int i = 0; i < length / 2; i++) {
			char tmp = s[i];
			s[i] = s[length - i - 1];
			s[length - i - 1] = tmp;
		}
	}

}
