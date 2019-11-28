package com.study.kokhrimenko.algoriths.external.turing.task;

/**
 * You are the owner of a co-working space like WeWork and your office building is rectangular.
 * Your team just built wall partitions to create mini offices for startups.
 * This office campus is represented by a 2D array of 1s (floor spaces) and 0s (walls).
 * Each point on this array is a one foot by one foot square. You need to calculate the number of offices.
 * A single office is bordered by walls and is constructed by placing floors next to each other, horizontally and/or vertically.
 * Two 1s adjacent to each other horizontally or vertically are always part of the same office.
 *
 * Functions numOffices() has one parameter:
 *     grid: a 2D grid/array of 1s and 0s
 *
 * Expected Output
 * Return the number of valid offices in the grid.
 * 
 * Constraints:
 *   - Assume all four edges of the grid are all surrounded by walls.
 *   - Assume that the bounds of the array are the following:
 *   - The total amount of elements in the array: width x height <= 10^6
 *
 * Example numOffices() Input
 * 
 * grid: 
 *	[[1, 1, 0, 0, 0],
 *	 [1, 1, 0, 0, 0],
 *	 [0, 0, 1, 0, 0],
 *	 [0, 0, 0, 1, 1]]
 *
 * Example Output: 3
 * 
 * Solution
 * There's 3 offices in this grid, one made of four 1s on the top left, one made of one 1 in the middle, and one made of two 1s in the bottom right.
 * 
 * @author kostic
 *
 */
public class OfficesCount {

	public static int numOffices(String[][] grid) {
        int result = 0;
        //Put your code here.
        if(grid == null || grid.length ==0) {
            return 0;
        }
        for(int i = 0; i< grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
               if(grid[i][j].equals("1")) {
                   result ++;

                   grid = markRoom(grid, i, j);
               } 
            }
        }
        return result;
    }
	
	private  static String[][] markRoom(String[][] grid, int curX, int curY) {
		String value = grid[curX][curY];
		if (!value.equals("1")) {
			return grid;
		}

		grid[curX][curY] = "0";

		if (curY > 0) {
			grid = markRoom(grid, curX, curY - 1);
		}

		if (curX < grid.length - 1) {
			grid = markRoom(grid, curX + 1, curY);
		}

		if (curY < grid[1].length - 1) {
			grid = markRoom(grid, curX, curY + 1);
		}

		if (curX > 0) {
			grid = markRoom(grid, curX - 1, curY);
		}
		return grid;
	}
	
	public static void main(String[] args) {
		/*String[][] matrix = {
				{"1", "1", "0", "0", "0"},
				{"1", "1", "0", "0", "0"},
				{"0", "0", "1", "0", "0"},
				{"0", "0", "0", "1", "1"},
			};*/
		String[][] matrix = {
				{"1", "1", "1", "1", "1"},
				{"1", "0", "0", "0", "1"},
				{"1", "0", "0", "0", "0"},
				{"1", "1", "1", "0", "1"},
			};
		
		System.out.println(OfficesCount.numOffices(matrix));
	}
	
}
