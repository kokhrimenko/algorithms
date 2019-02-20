package com.study.array.search;

/**
 * Binary Search: Search a sorted array by repeatedly dividing the search
 * interval in half. Begin with an interval covering the whole array. If the
 * value of the search key is less than the item in the middle of the interval,
 * narrow the interval to the lower half. Otherwise narrow it to the upper half.
 * Repeatedly check until the value is found or the interval is empty.
 * 
 * Time complexity to O(Log n).
 * 
 * @author kostic
 *
 */
public class BinarySearcher {

	int binarySearch(int arr[], int x) {
		int l = 0, r = arr.length-1;
		while (l <= r) {
			int m = l + (r - l) / 2;

			if (arr[m] == x)
				return m;

			if (arr[m] < x)
				l = m + 1;
			else
				r = m - 1;
		}

		return -1;
	}

	// Driver method to test above
	public static void main(String args[]) {
		BinarySearcher ob = new BinarySearcher();
		int arr[] = { 1, 2, 3, 7, 11, 16, 18, 33, 43, 70, 90 };
		int x = 16;
		int result = ob.binarySearch(arr, x);
		if (result == -1)
			System.out.println("Element not found");
		else
			System.out.println("Element found at index: " + result);
	}

}
