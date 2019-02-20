package com.study.kokhrimenko.algoriths.array.missing_element;

/**
 * TASK: You are given a list of n-1 integers and these integers are in the
 * range of 1 to n. There are no duplicates in list. One of the integers is
 * missing in the list. Write an efficient code to find the missing integer.
 * 
 * Algorithm:
 *
 * An efficient solution is based on the divide and conquer algorithm that we have seen in binary search, the concept behind this solution is that 
 * the elements appearing before the missing element will have ar[i] – i = 1 and those appearing after the missing element will have ar[i] – i = 2.
 * 
 * Time Complexity : 
 * 		This solution has a time complexity of O(log n).
 * 
 * @author kostic
 *
 */
public class MissingElementIntoOrderedArray {
	// Function to find missing number
	static int getMissingNo(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("You've provided vrong array");
		}

		int a = 0, b = arr.length - 1; 
	    int mid = 0; 
	    while ((b - a) > 1) 
	    { 
	        mid = (a + b) / 2; 
	        if ((arr[a] - a) != (arr[mid] - mid)) 
	            b = mid; 
	        else if ((arr[b] - b) != (arr[mid] - mid)) 
	            a = mid; 
	    } 
	    return (arr[mid]); 
	}

	/* program to test above function */
	public static void main(String args[]) {
		int[] inputArray = { 1, 2, 3, 4, 5, 6, 8, 9};
		int miss = getMissingNo(inputArray);
		System.out.println(miss);
	}
}
