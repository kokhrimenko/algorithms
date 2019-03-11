package com.study.kokhrimenko.algoriths.external.leetcode.retursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0.
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author kostic
 *
 */
public class PascalsTriangle_O_k {

	public static void main(String[] args) {
		PascalsTriangle_O_k executor = new PascalsTriangle_O_k();

		System.out.println(executor.getRow(3));
	}

	public List<Integer> getRow(int rowIndex) {
		if (rowIndex == 0) {
			return Arrays.asList(new Integer[] { 1 });
		}

		List<Integer> row = Arrays.asList(new Integer[] { 1, 1 });
		if (rowIndex == 1) {
			return row;
		}

		return this.generate(row, 1, rowIndex);
	}

	private List<Integer> generate(List<Integer> prevRow, int curIndex, int rowIndex) {
		List<Integer> row = new ArrayList<>();
		row.add(1);
		for (int i = 1; i < curIndex + 1; i++) {
			row.add(prevRow.get(i - 1) + prevRow.get(i));
		}
		row.add(1);

		if (curIndex == rowIndex - 1) {
			return row;
		}

		return this.generate(row, curIndex + 1, rowIndex);
	}
}
