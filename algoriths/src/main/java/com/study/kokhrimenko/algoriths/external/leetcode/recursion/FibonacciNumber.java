package com.study.kokhrimenko.algoriths.external.leetcode.recursion;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
 * Fibonacci sequence, such that each number is the sum of the two preceding
 * ones, starting from 0 and 1. That is,
 * 
 * @author kostic
 *
 */
public class FibonacciNumber {

	public static void main(String[] args) {
		int input = 4;
		FibonacciNumber executor = new FibonacciNumber();
		System.out.println(executor.fib(input));
	}

	public int fib(int N) {
		if (N == 0) {
			return 0;
		}

		if (N == 1 || N == 2) {
			return 1;
		}

		return fib(N - 1) + fib(N - 2);
	}

}
