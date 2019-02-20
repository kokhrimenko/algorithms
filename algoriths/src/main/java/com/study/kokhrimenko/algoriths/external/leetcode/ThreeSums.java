package com.study.kokhrimenko.algoriths.external.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 3)
			return result;
		for (int i = 0; i < nums.length - 2; i++) {
			int first = nums[i];
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int second = nums[j];
				int third = nums[k];
				if (first + second + third == 0) {
					ArrayList<Integer> item = new ArrayList<Integer>();
					item.add(first);
					item.add(second);
					item.add(third);
					result.add(item);
					while (((j + 1) <= (nums.length - 1)) && (nums[j] == nums[j + 1]))
						j++;
					j++;
					while (((k - 1) >= 0) && (nums[k] == nums[k - 1]))
						k--;
					k--;
				}

				else if (second + third < -first) {
					while (((j + 1) <= (nums.length - 1)) && (nums[j] == nums[j + 1]))
						j++;
					j++;
				}

				else if (second + third > -first) {
					while (((k - 1) >= 0) && (nums[k] == nums[k - 1]))
						k--;
					k--;
				}
			}

			while (((i + 1) <= (nums.length - 1)) && (nums[i] == nums[i + 1]))
				i++;
			j++;
		}
		return new ArrayList<>(result);
	}
}
