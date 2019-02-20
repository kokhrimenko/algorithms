package com.study.kokhrimenko.algoriths.array.duplicates;

/**
 * Time Complexity: O(n)
 * Auxiliary Space: O(n)
 * 
 * @author kostic
 *
 */
public class CountIteration {

	private static int repeatedNumber(final int[] arr) {
		if (arr.length <= 1) {
			return -1;
		}

		int[] count = new int[arr.length - 1];

		for (int i = 0; i < arr.length; i++) {
			int n = arr[i] - 1;
			count[n]++;

			if (count[n] > 1) {
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
