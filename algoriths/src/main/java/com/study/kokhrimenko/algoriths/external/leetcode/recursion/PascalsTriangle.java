package com.study.kokhrimenko.algoriths.external.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle. In Pascal's triangle, each number is the sum of the two numbers
 * directly above it.
 * 
 * @author kostic
 *
 */
public class PascalsTriangle {

	public static void main(String[] args) {
		PascalsTriangle executor = new PascalsTriangle();
		
		System.out.println(executor.generate(5));
	}
	
	public List<List<Integer>> generate(int numRows) {
		if(numRows == 0) {
			return Collections.emptyList();
		}
		List<List<Integer>> result = new ArrayList<>();
		result.add(Arrays.asList(new Integer[] {1}));
		if(numRows == 1) {
			return result;
		}
		
		result.add(Arrays.asList(new Integer[] {1, 1}));
		if(numRows == 2) {
			return result;
		}
		
		this.generate(result, numRows);
		
		return result;
	}
	
	private void generate(List<List<Integer>> items, int numRows) {
		if(items.size() < numRows-1) {
			this.generate(items, numRows - 1);
		}
		
		List<Integer> row = new ArrayList<>();
		List<Integer> prevRow = items.get(numRows - 1 - 1);
		row.add(1);
		for(int i = 1; i < numRows-1; i++) {
			row.add(prevRow.get(i-1) + prevRow.get(i));	
		}
		row.add(1);
		items.add(row);
	}
}
