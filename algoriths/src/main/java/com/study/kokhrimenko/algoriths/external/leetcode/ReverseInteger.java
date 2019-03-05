package com.study.kokhrimenko.algoriths.external.leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger executor = new ReverseInteger();
		int toReverse = -2147483648;
		System.out.println(executor.reverse(toReverse));
	}
	
	public int reverse(int x) {
        if(x == 0) {
        	return x;
        }
        
        int sign = x < 0 ? -1 : 1;
        String reversedValue = new StringBuilder(String.valueOf(Math.abs((long) x))).reverse().toString();
        long reversedValueAsLong = Long.parseLong(reversedValue);
        return reversedValueAsLong > Integer.MAX_VALUE || reversedValueAsLong < Integer.MIN_VALUE ? 0 : (int) (sign * reversedValueAsLong);
    }
}
