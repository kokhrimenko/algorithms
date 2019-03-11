package com.study.kokhrimenko.algoriths.external.leetcode.retursion;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Time complexity : O(2^n). Size of recursion tree will be 2^n.
 * Space complexity : O(n)O(n). 
 * The depth of the recursion tree can go up to n.
 * 
 * @author kostic
 *
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		int input = 43;

		ClimbingStairs executor = new ClimbingStairs();
		System.out.println(executor.climbStairs(input));
	}

	public int climbStairs(int n) {
		return climbStairs(0, n);
	}

	private int climbStairs(int curr, int n) {
		if (curr > n) {
			return 0;
		}
		if (curr == n) {
			return 1;
		}
		return climbStairs(curr + 1, n) + climbStairs(curr + 2, n);
	}

}
