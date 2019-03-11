package com.study.kokhrimenko.algoriths.external.leetcode.retursion;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Algorithm
 * 
 * As we can see this problem can be broken into subproblems, and it contains
 * the optimal substructure property i.e. its optimal solution can be
 * constructed efficiently from optimal solutions of its subproblems, we can use
 * dynamic programming to solve this problem.
 * 
 * One can reach i^th step in one of the two ways:
 * - Taking a single step from (i-1)^th step.
 * - Taking a step of 2 from (i-2)^th step.
 * 
 * So, the total number of ways to reach i^th is equal to sum of ways of
 * reaching (i-1)^th step and ways of reaching (i-2)^th step.
 * 
 * Let dp[i]dp[i] denotes the number of ways to reach on i^th step:
 * 			dp[i]=dp[i-1]+dp[i-2] dp[i]=dp[i−1]+dp[i−2]
 * 
 * @author kostic
 *
 */
public class ClimbingStairsDynamicProgramming {

	public static void main(String[] args) {
		int input = 43;

		ClimbingStairsDynamicProgramming executor = new ClimbingStairsDynamicProgramming();
		System.out.println(executor.climbStairs(input));
	}

	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

}
