package com.study.kokhrimenko.algoriths.array.sort;

/**
 * MergeSort(arr[], l,  r)
 * If r > l
 *    1. Find the middle point to divide the array into two halves:  
 *            middle m = (l+r)/2
 *    2. Call mergeSort for first half:   
 *            Call mergeSort(arr, l, m)
 *    3. Call mergeSort for second half:
 *            Call mergeSort(arr, m+1, r)
 *    4. Merge the two halves sorted in step 2 and 3:
 *            Call merge(arr, l, m, r)
 *
 * Time Complexity: Sorting arrays on different machines. Merge Sort is a recursive algorithm and time complexity can be expressed as following recurrence relation.
 * T(n) = 2T(n/2) + \Theta(n)
 * The above recurrence can be solved either using Recurrence Tree method or Master method. It falls in case II of Master Method and solution of the recurrence is \Theta(nLogn).
 * Time complexity of Merge Sort is \Theta(nLogn) in all 3 cases (worst, average and best) as merge sort always divides the array in two halves and take linear time to merge two halves.

 * Auxiliary Space: O(n)

 * Algorithmic Paradigm: Divide and Conquer
 
 * Sorting In Place: No in a typical implementation           
 *            
 * @author kostic
 *
 */
public class MergeSorter {

	private void merge(int arr[], int start, int middle, int last) {
		int n1 = middle - start + 1;
		int n2 = last - middle;

		int leftTempArray[] = new int[n1];
		int rigthTempArray[] = new int[n2];
	
		/* Copy data to temp arrays */
		System.arraycopy(arr, start, leftTempArray, 0, n1);
		System.arraycopy(arr, middle+1, rigthTempArray, 0, n2);	
		
		int i = 0,
			j = 0;

		int k = start;
		while (i < n1 && j < n2) {
			if (leftTempArray[i] <= rigthTempArray[j]) {
				arr[k] = leftTempArray[i];
				i++;
			} else {
				arr[k] = rigthTempArray[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = leftTempArray[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = rigthTempArray[j];
			j++;
			k++;
		}
	}

	void sort(int arr[], int start, int end) {
		if (start < end) {
			int m = (start + end) / 2;

			sort(arr, start, m);
			sort(arr, m + 1, end);

			merge(arr, start, m, end);
		}
	}

	private static void print(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		int arr[] = { 3, 11, 18, 2, 16, 7, 1, 33, 90, 70, 43 };

		System.out.println("Original array:");
		print(arr);

		MergeSorter sorter = new MergeSorter();
		sorter.sort(arr, 0, arr.length - 1);

		System.out.println("Sorted array:");
		print(arr);
	}

}