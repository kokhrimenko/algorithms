package com.study.array.duplicates;

/**
 * Time Complexity: O(n) Auxiliary Space: O(1)
 * 
 * @author kostic
 *
 */
public class Runner {

	private static int repeatedNumber(final int[] arr) {
		if (arr.length <= 1) {
			return -1;
		}

		int slow = arr[0];
		int fast = arr[arr[0]];

		while (fast != slow) {
			slow = arr[slow];
			fast = arr[arr[fast]];
		}

		slow = 0;
		while (fast != slow) {
			slow = arr[slow];
			fast = arr[fast];
		}
		return slow;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 1, 4, 1 };

		System.out.println("First duplicate is: " + repeatedNumber(arr));
	}
}
