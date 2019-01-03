package com.study.bool.xor;

/**
 * 
 * @author kostic
 *
 * Conclusion:
 * 		This method doesn't have any impact on performance!
 */
public class StringReverse {
	public static final String reverseWithXOR(String string) {
		char[] array = string.toCharArray();
		int length = array.length;
		int half = (int) Math.floor(array.length / 2);
		for (int i = 0; i < half; i++) {
			array[i] ^= array[length - i - 1];
			array[length - i - 1] ^= array[i];
			array[i] ^= array[length - i - 1];
		}
		return String.valueOf(array);
	}
	
	public static void main(String[] args) {
		String inputStr = "Kostya just for fun string!";
		System.out.println("Input string: " + inputStr);
		
		String outputStr = reverseWithXOR(inputStr);
		System.out.println("Output string: " + outputStr);
	}
}
