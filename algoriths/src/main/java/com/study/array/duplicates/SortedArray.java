package com.study.array.duplicates;

import java.util.Arrays;

/**
 * Time Complexity: O(n * log(n))
 * Auxiliary Space: O(1)
 * 
 * @author kostic
 *
 */
public class SortedArray {

	private static int repeatedNumber(final int[] arr) {
		if (arr.length <= 1) {
			return -1;
		}

		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				return arr[i];
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {3, 4, 1, 4, 1};
		
		System.out.println("First duplicate is: "  + repeatedNumber(arr));
	}
}
