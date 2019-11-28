package com.study.kokhrimenko.algoriths.external.epam.interview.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Merge together 2 sorted arrays.
 * Complexity:
 *      O (n + m)
 *
 * @author kostic
 *
 */
public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		List<Integer> firstArray1 = null;
		List<Integer> secondArray1 = null;
		System.out.println(String.format("TestCase1: Merged together two arrays, first:[%s] and second:[%s] is: [%s]",
				StringUtils.join(firstArray1, ","), StringUtils.join(secondArray1, ","),
				StringUtils.join(combine(firstArray1, secondArray1), ",")));
		System.out.println("------------------------------------------");

		List<Integer> firstArray2 = null;
		List<Integer> secondArray2 = Arrays.asList(4, 7);
		System.out.println(String.format("TestCase2: Merged together two arrays, first:[%s] and second:[%s] is: [%s]",
				StringUtils.join(firstArray2, ","), StringUtils.join(secondArray2, ","),
				StringUtils.join(combine(firstArray2, secondArray2), ",")));
		System.out.println("------------------------------------------");

		List<Integer> firstArray3 = Arrays.asList(1);
		List<Integer> secondArray3 = null;
		System.out.println(String.format("TestCase3: Merged together two arrays, first:[%s] and second:[%s] is: [%s]",
				StringUtils.join(firstArray3, ","), StringUtils.join(secondArray3, ","),
				StringUtils.join(combine(firstArray3, secondArray3), ",")));
		System.out.println("------------------------------------------");

		List<Integer> firstArray4 = Arrays.asList(1);
		List<Integer> secondArray4 = Arrays.asList(4, 7);
		System.out.println(String.format("TestCase4: Merged together two arrays, first:[%s] and second:[%s] is: [%s]",
				StringUtils.join(firstArray4, ","), StringUtils.join(secondArray4, ","),
				StringUtils.join(combine(firstArray4, secondArray4), ",")));
		System.out.println("------------------------------------------");

		List<Integer> firstArray5 = Arrays.asList(1, 2, 5, 8, 9, 10, 11);
		List<Integer> secondArray5 = Arrays.asList(4, 7);
		System.out.println(String.format("TestCase4: Merged together two arrays, first:[%s] and second:[%s] is: [%s]",
				StringUtils.join(firstArray5, ","), StringUtils.join(secondArray5, ","),
				StringUtils.join(combine(firstArray5, secondArray5), ",")));
		System.out.println("------------------------------------------");
	}
	
	public static List<Integer> combine(List<Integer> sortedA, List<Integer> sortedB) {
		if (sortedA == null || sortedA.isEmpty()) {
			return sortedB;
		}

		if (sortedB == null || sortedB.isEmpty()) {
			return sortedA;
		}

		// sortedA = Arrays.sort(sortedA);
		// sortedA.sortedB = Arrays.sort(sortedB);

		List<Integer> result = new ArrayList<>();
		int arrayBIndex = 0;
		int arrayAIndex = 0;

		while (arrayBIndex <= sortedB.size() && arrayAIndex < sortedA.size()) {
			while ((arrayBIndex >= sortedB.size() && arrayAIndex < sortedA.size())
					|| (arrayAIndex < sortedA.size() && sortedA.get(arrayAIndex) < sortedB.get(arrayBIndex))) {
				result.add(sortedA.get(arrayAIndex));

				arrayAIndex++;
			}
			if (arrayBIndex < sortedB.size()) {
				result.add(sortedB.get(arrayBIndex));
				arrayBIndex++;
			}
		}

		return result;
	}
	
}
