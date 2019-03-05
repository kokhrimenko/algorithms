package com.study.kokhrimenko.algoriths.external.leetcode;

public class ClosestPalindrome {

	public static void main(String[] args) {
		System.out.println(nearestPalindromic("123"));
	}
	
	public static String nearestPalindromic(String n) {
		if(n == null || n.isEmpty()) {
			return null;
		}
		if(n.equals(new StringBuffer(n).reverse().toString()) && n.length() > 1) {
			return "0";
		}
		String firstPart = n.substring(0, (n.length() +1) / 2);
		String palindrom = firstPart + new StringBuffer(firstPart).reverse().toString();
		return palindrom;
		/*String operatedN = new String(n);
		while(!operatedN.equals(new StringBuffer(operatedN).reverse().toString()) && Long.valueOf(operatedN) > 0) {
			operatedN = String.valueOf((Long.valueOf(operatedN)-1l));
		}
		Long longN = Long.valueOf(operatedN);
		Long originLongN = Long.valueOf(n);
		
		return !longN.equals(originLongN) ? operatedN : String.valueOf(--originLongN);*/	
	}
}
