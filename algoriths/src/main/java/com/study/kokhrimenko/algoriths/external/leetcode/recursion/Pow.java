package com.study.kokhrimenko.algoriths.external.leetcode.recursion;

public class Pow {

	public static void main(String[] args) {
		double x = -1.00000;		
		int n = -2147483648;
		Pow executor = new Pow();
		System.out.println(executor.myPow(x, n));
	}

	public double myPow(double x, int n) {
		if(x == 0.0) {
			return 1;
		}
		boolean isMultiple = n > 0;
		double pow = 1.0;
		long nLong = Math.abs((long) n);
		int incrementalMultiplier = 1000;
		if (nLong > incrementalMultiplier) {
			double pow100 = this.pow(x, incrementalMultiplier);
			while (nLong >= incrementalMultiplier) {
				pow *= pow100;
				nLong -= incrementalMultiplier;
			}
			pow = pow * this.pow(x, (int) nLong);
		} else {
			pow = this.pow(x, Math.abs(n));
		}
		return isMultiple ? pow : 1 / pow;
	}

	private double pow(double x, int n) {
		if(n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		if (x == 1.0) {
			return x;
		}

		return x * pow(x, n - 1);
	}
}
