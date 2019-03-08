package com.study.kokhrimenko.algoriths.external.leetcode.mockinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Algorithm:
 * 
 * There are only 4 cards and only 4 operations that can be performed. Even when
 * all operations do not commute, that gives us an upper bound of 12 * 6 * 2 * 4
 * * 4 * 4 = 921612∗6∗2∗4∗4∗4=9216 possibilities, which makes it feasible to
 * just try them all. Specifically, we choose two numbers (with order) in 12
 * ways and perform one of 4 operations (12 * 4). Then, with 3 remaining
 * numbers, we choose 2 of them and perform one of 4 operations (6 * 4). Finally
 * we have two numbers left and make a final choice of 2 * 4 possibilities.
 * 
 * We will perform 3 binary operations (+, -, *, / are the operations) on either
 * our numbers or resulting numbers. Because - and / do not commute, we must be
 * careful to consider both a / b and b / a.
 * 
 * For every way to remove two numbers a, b in our list, and for each possible
 * result they can make, like a+b, a/b, etc., we will recursively solve the
 * problem on this smaller list of numbers.
 * 
 * 
 * 
 * Time Complexity: O(1)O(1). There is a hard limit of 9216 possibilities, and
 * we do O(1)O(1) work for each of them.
 * 
 * Space Complexity: O(1)O(1). Our intermediate arrays are at most 4 elements,
 * and the number made is bounded by an O(1)O(1) factor.
 * 
 * @author kostic
 *
 */
public class Game24 {
	public static void main(String[] args) {
		int[] nums = new int[] {4, 1, 8, 7};
		//int[] nums = new int[] { 8, 1, 6, 6 };
		int expectedValue = 24;
		Game24 executor = new Game24();
		boolean result = executor.judgePoint24(nums, expectedValue);

		System.out.println(result);
	}

	public boolean judgePoint24(int[] nums, int expectedResult) {
		if (nums == null || nums.length == 0) {
			return false;
		}

		List<Double> items = Arrays.stream(nums).mapToObj(Double::valueOf).collect(Collectors.toList());

		return this.solve(items, expectedResult);
	}

	private boolean solve(List<Double> nums, int expectedResult) {
		if (nums.size() == 0)
			return false;
		if (nums.size() == 1)
			return Math.abs(nums.get(0) - expectedResult) < 1e-6;

		for (int i = 0; i < nums.size(); i++) {
			for (int j = 0; j < nums.size(); j++) {
				if (i != j) {
					List<Double> nums2 = new ArrayList<>();
					for (int k = 0; k < nums.size(); k++)
						if (k != i && k != j) {
							nums2.add(nums.get(k));
						}
					for (int k = 0; k < 4; k++) {
						if (k < 2 && j > i)
							continue;
						if (k == 0)
							nums2.add(nums.get(i) + nums.get(j));
						if (k == 1)
							nums2.add(nums.get(i) * nums.get(j));
						if (k == 2)
							nums2.add(nums.get(i) - nums.get(j));
						if (k == 3) {
							if (nums.get(j) != 0) {
								nums2.add(nums.get(i) / nums.get(j));
							} else {
								continue;
							}
						}
						if (solve(nums2, expectedResult))
							return true;
						nums2.remove(nums2.size() - 1);
					}
				}
			}
		}
		return false;
	}
}