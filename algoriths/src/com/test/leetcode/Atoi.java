package com.test.leetcode;

public class Atoi {

	public static void main(String[] args) {
		String inputStr = "9223372036854775808";
		System.out.println(Atoi.myAtoi(inputStr));
	}
	
	public static int myAtoi(String str) {
		if(str == null || str.isEmpty()) {
			return 0;
		}
		
		str = str.trim();
		if(str.isEmpty()) {
			return 0;
		}
		
		int pos = 0;
		boolean isPositive = true;
		if (str.charAt(pos) == '-') {
			isPositive = false;
			pos++;
		} else if ((str.charAt(pos) == '+')) {
			pos++;
		}
		
		double result = 0;
		
		while (str.length() > pos && str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
			result = result * 10 + (str.charAt(pos) - '0');
			pos++;
		}
		
		if (!isPositive) {
			result *= -1;
		}
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		return (int) result;
	}
}
