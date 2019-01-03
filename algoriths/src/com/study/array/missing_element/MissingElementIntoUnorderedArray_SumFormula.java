package com.study.array.missing_element;

/**
 * TASK:
 * 		You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. 
 * 		One of the integers is missing in the list. Write an efficient code to find the missing integer.
 * 
 * Algorithm:
 *
 *	1. Get the sum of numbers 
 *      	total = n*(n+1)/2
 *	2  Subtract all the numbers from sum and
 *  		you will get the missing number.
 *  
 *  Time Complexity : O(n)
 *		There can be overflow if n is large. In order to avoid Integer Overflow, we can pick one number from known numbers and subtract one number 
 *		from given numbers. This way we wont have Integer Overflow ever. Thanks to Sahil Rally for suggesting this improvement.
 *  
 * @author kostic
 *
 */
public class MissingElementIntoUnorderedArray_SumFormula {
	// Function to find missing number
	static int getMissingNo(int[] arr) {
		if(arr == null || arr.length == 0) {
			throw new IllegalArgumentException("You've provided vrong array");
		}
		int i,
			total,
			arrLength = arr.length;
		total = (arrLength + 1) * (arrLength + 2) / 2;
		for (i = 0; i < arrLength; i++)
			total -= arr[i];
		return total;
	}

	/* program to test above function */
	public static void main(String args[]) {
		int[] inputArray = { 1, 2, 4, 6, 3, 7, 8 };
		int miss = getMissingNo(inputArray);
		System.out.println(miss);
	}
}
