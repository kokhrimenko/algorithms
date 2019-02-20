package com.study.kokhrimenko.algoriths.array.missing_element;

/**
 * TASK:
 * 		You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. 
 * 		One of the integers is missing in the list. Write an efficient code to find the missing integer.
 * 
 * Algorithm:
 *
 *	- XOR all the array elements, let the result of XOR be X1.
 *  - XOR all numbers from 1 to n, let XOR be X2.
 *  - XOR of X1 and X2 gives the missing number.
 *  
 *  Time Complexity : O(n)
 *		There can be overflow if n is large. In order to avoid Integer Overflow, we can pick one number from known numbers and subtract one number 
 *		from given numbers. This way we wont have Integer Overflow ever. Thanks to Sahil Rally for suggesting this improvement.
 *  
 * @author kostic
 *
 */
public class MissingElementIntoUnorderedArray_XOR {
	
	// Function to find missing number
	static int getMissingNo(int[] arr) {
		if(arr == null || arr.length == 0) {
			throw new IllegalArgumentException("You've provided vrong array");
		}

		int x1 = arr[0];
		int x2 = 1;
		int arrLength = arr.length;

		/*
		 * For xor of all the elements in array
		 */
		for (int i = 1; i < arrLength; i++)
			x1 = x1 ^ arr[i];

		/*
		 * For xor of all the elements from 1 to n+1
		 */
		for (int i = 2; i <= arrLength + 1; i++)
			x2 = x2 ^ i;

		return (x1 ^ x2);
	}
	
	/* program to test above function */
	public static void main(String args[]) {
		int[] inputArray = { 1, 2, 4, 6, 3, 7, 8 };
		int miss = getMissingNo(inputArray);
		System.out.println(miss);
	}
}
