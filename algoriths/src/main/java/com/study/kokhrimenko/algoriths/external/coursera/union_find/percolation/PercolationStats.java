package com.study.kokhrimenko.algoriths.external.coursera.union_find.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONFIDENCE_FACTOR = 1.96;
    private final double[] results;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n < 1) {
            throw new IllegalArgumentException("Matrix size should be greater than 0");
        }
        if (trials < 1) {
            throw new IllegalArgumentException("Trials should be greater than 0");
        }

        results = new double[trials];

        for (int i = 0; i < trials; i++) {
            final Percolation percolation = new Percolation(n);

            int iteration = 0;
            int matrixSize = n * n;
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                // if not already opened - then increment and open
                if(!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                    iteration ++;
                }
            }
            results[i] = (double) iteration / matrixSize;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (CONFIDENCE_FACTOR * stddev() / Math.sqrt(results.length));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (CONFIDENCE_FACTOR * stddev() / Math.sqrt(results.length));
    }

   // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats percolationStats = new PercolationStats(n, T);
        System.out.println(String.format("mean                     = %.10f", percolationStats.mean()));
        System.out.println(String.format("stddev                   = %.10f", percolationStats.stddev()));
        System.out.println(String.format("95%% confidence interval = %.10f, %.10f", percolationStats.confidenceLo(), percolationStats.confidenceHi()));
    }

}
