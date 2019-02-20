package com.study.bool.xor;

/**
 * Without 3-party valiable.
 * 
 * @author kostic
 *
 */
public class ExchangeVariablesValue {

	public static void main(String[] args) {
		int x = 5, y = 7; 
		
		System.out.println("Input: ");
		System.out.println("X: " + x);
		System.out.println("Y: " + y);
		
		y ^= (x ^= y);
		x ^= y;
		
		System.out.println("Output: ");
		System.out.println("X: " + x);
		System.out.println("Y: " + y);
	}

}
