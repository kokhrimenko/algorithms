package com.study.kokhrimenko.algoriths.array.fill;

import java.util.Arrays;

/**
 * 1) Create two temporary arrays row[M] and col[N]. Initialize all values of
 * row[] and col[] as 0. 
 * 2) Traverse the input matrix mat[M][N]. If you see an
 * entry mat[i][j] as true, then mark row[i] and col[j] as true. 
 * 3) Traverse the input matrix mat[M][N] again. For each entry mat[i][j], check the values of
 * row[i] and col[j]. If any of the two values (row[i] or col[j]) is true, then
 * mark mat[i][j] as true.
 * 
 * Time Complexity: O(M*N)
 * Auxiliary Space: O(M + N)
 * 
 * @author kostic
 *
 */
public class FillByZeroIfCellIsZero {

	public static void modifyMatrix(int mat[][]) {
		int rLength = mat.length,
			cLength = mat[0].length;
				
		int row[] = new int[rLength];
		int col[] = new int[cLength];

		Arrays.fill(row, 1);
		Arrays.fill(col, 1);

		final int valueToReplace = 0;
		for (int i = 0; i < rLength; i++) {
			for (int j = 0; j < cLength; j++) {
				if (mat[i][j] == valueToReplace) {
					row[i] = valueToReplace;
					col[j] = valueToReplace;
				}
			}
		}

		for (int i = 0; i < rLength; i++) {
			for (int j = 0; j < cLength; j++) {
				if (row[i] == valueToReplace || col[j] == valueToReplace) {
					mat[i][j] = valueToReplace;
				}
			}
		}
	}

	private static void print(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(String.format("% 3d ", mat[i][j]));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int mat[][] = {
				{ 5, 0, 77, 7 }, 
				{ 9, 0, 13, 0 }, 
				{ 1, 2, 11, 33 }};

		System.out.println("Matrix Intially:");

		print(mat);

		modifyMatrix(mat);
		System.out.println("Modified matrix:");
		print(mat);

	}
}
