package com.study.array.duplicates;

/**
 * Time Complexity: O(n) 
 * Auxiliary Space: O(1)
 * 
 * @author kostic
 *
 */
public class Marker {

	private static int repeatedNumber(final int[] arr) {
		if (arr.length <= 1) {
			return -1;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i])] > 0) {
				arr[Math.abs(arr[i])] = -1 * arr[Math.abs(arr[i])];
			} else {
				return Math.abs(arr[i]);
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 1, 4, 1 };

		System.out.println("First duplicate is: " + repeatedNumber(arr));
	}
}
