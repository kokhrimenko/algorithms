package com.study.kokhrimenko.algoriths.external.coursera.union_find.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final int TOP_BOTTOM_NODES = 2;

    private final int[][] data;
    private final int dataSize;    
    private final WeightedQuickUnionUF quickUnionEngine;
    private final int topRoot;
    private final int bottomFinish;
    private int openedCellCount;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Matrix Dimension should be positive integer!");
        }

        data = new int[n][n];
        dataSize = n;
        quickUnionEngine = new WeightedQuickUnionUF(dataSize * dataSize + TOP_BOTTOM_NODES);
        topRoot = 0;
        bottomFinish = dataSize * dataSize +1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateMatrixCoordinate(row);
        validateMatrixCoordinate(col);
        if (isOpen(row, col)) {
            return;
        }
        data[row - 1][col - 1] = 1;

        int linearPos = matrixToLinearCoord(row, col);
        // might be connect to an upper element?
        if (row - 1 > 0) {
            open(row - 1, col, linearPos);
        }
        // might be connect to a left element?
        if(col + 1 <= dataSize) {
            open(row, col + 1, linearPos);
        }
        // might be connect to a lower element?
        if(row + 1 <= dataSize) {
            open(row + 1, col, linearPos);
        }
        // might be connect to a lower element?
        if(col - 1 > 0) {
            open(row, col - 1, linearPos);
        }
        // might be connect to the dummy ROOT element?
        if(row == 1) {
            quickUnionEngine.union(linearPos, topRoot);
        }
        // might be connect to the dummy TARGET element?
        if(row == dataSize) {
            quickUnionEngine.union(bottomFinish, linearPos);
        }
        openedCellCount++;
    }

    private void open(int row, int col, int linear) {
        if (isOpen(row, col)) {
            quickUnionEngine.union(linear, matrixToLinearCoord(row, col));
        }
    }

    private int matrixToLinearCoord(int row, int col) {
        return (row - 1) * dataSize + col;
    }
    
    private void validateMatrixCoordinate(int coordinale) {
        if (coordinale <= 0 || coordinale > dataSize) {
            throw new IllegalArgumentException(String.format("Input coordinate: %d exceed allowed range between %d and %d", coordinale, 1, dataSize));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateMatrixCoordinate(row);
        validateMatrixCoordinate(col);

        return data[row - 1][col - 1] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateMatrixCoordinate(row);
        validateMatrixCoordinate(col);

        return quickUnionEngine.find(topRoot) == quickUnionEngine.find(matrixToLinearCoord(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openedCellCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return quickUnionEngine.find(topRoot) == quickUnionEngine.find(bottomFinish);
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation percolation = new Percolation(2);
        percolation.open(1, 1);
        percolation.open(2, 2);
        percolation.open(1, 2);
        System.out.println(percolation.percolates());
    }

}
