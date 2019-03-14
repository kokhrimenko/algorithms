package com.study.kokhrimenko.algoriths.external.leetcode.recursion;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Time complexity : O(2^n). Size of recursion tree will be 2^n. .Space
 * complexity : O(n)O(n). The depth of the recursion tree can go up to n.
 * 
 * In the previous approach we are redundantly calculating the result for every
 * step. Instead, we can store the result at each step in memo array and
 * directly returning the result from the memo array whenever that function is
 * called again.
 * 
 * In this way we are pruning recursion tree with the help of memo array and
 * reducing the size of recursion tree up to n.
 * 
 * Time complexity : O(n). Size of recursion tree can go up to n.
 * Space complexity : O(n). The depth of recursion tree can go up to n.
 * 
 * @author kostic
 *
 */
public class ClimbingStairsWithCache {

	public static void main(String[] args) {
		int input = 43;

		ClimbingStairsWithCache executor = new ClimbingStairsWithCache();
		System.out.println(executor.climbStairs(input));
	}

	public int climbStairs(int n) {
		int[] cache = new int[n + 1];
		return climbStairs(0, n, cache);
	}

	private int climbStairs(int curr, int n, int[] cache) {
		if (curr > n) {
			return 0;
		}
		if (curr == n) {
			return 1;
		}
		if (cache[curr] > 0) {
			return cache[curr];
		}
		cache[curr] = climbStairs(curr + 1, n, cache) + climbStairs(curr + 2, n, cache);
		return cache[curr];
	}

}
