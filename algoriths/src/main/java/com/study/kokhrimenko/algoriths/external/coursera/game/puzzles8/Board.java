package com.study.kokhrimenko.algoriths.external.coursera.game.puzzles8 ;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * The problem. The 8-puzzle is a sliding puzzle that is played on a 3-by-3 grid with 8 square tiles labeled 1 through 8,
 * plus a blank square. The goal is to rearrange the tiles so that they are in row-major order, using as few moves
 * as possible. You are permitted to slide tiles either horizontally or vertically into the blank square.
 *
 * Board data type. To begin, create a data type that models an n-by-n board with sliding tiles.
 *
 * Notices:
 *          Your implementation should support all Board methods in time proportional to n2 (or better) in the worst case.
 *
 * @author kostic
 *
 */
public class Board {
    private static final int EMPTY_TILE = 0;
    private static final int MOVE_X_MATRIX[] = { -1, 0, 1, 0 };
    private static final int MOVE_Y_MATRIX[] = { 0, 1, 0, -1 };
    private static final int COUNT_OF_FREEDOM = 4;

    private final int size;
    private final int[][] tiles;
    /**
     * You may assume that the constructor receives an n-by-n array containing the n2 integers between 0 and n2 − 1, where 0 represents the blank square.
     * You may also assume that 2 ≤ n < 128.
     *
     * @param tiles
     */
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        if (tiles == null || tiles.length == 0) {
            throw new IllegalArgumentException("Input array can't be NULL or enpty!");
        }
        size = tiles.length;
        this.tiles = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(tiles[i], 0, this.tiles[i], 0, size);
        }
    }

    // board dimension n
    public int dimension() {
        return size;
    }

    /**
     * @return distance between a board and the goal board is the number of tiles in the wrong position.
     */
    // number of tiles out of place
    public int hamming() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tiles[i][j] == EMPTY_TILE) {
                    continue;
                }
                final int etalom = calculateEtalonValueForCell(i, j);
                if (tiles[i][j] != etalom) {
                    count++;
                }
            }
        }
        return count;
    }

    private int calculateEtalonValueForCell(int i, int j) {
        return i * size + j + 1;
    }

    /**
     * @return distance between a board and the goal board is the sum of the Manhattan distances (sum of the vertical and horizontal distance)
     *         from the tiles to their goal positions.
     */
    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int distance = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tiles[i][j] == EMPTY_TILE) {
                    continue;
                }
                final int etalom = calculateEtalonValueForCell(i, j);
                if (tiles[i][j] != etalom) {
                    int value = tiles[i][j];
                    int x, y;
                    x = (value - 1) / size;
                    y = value - 1 - size * x;
                    distance += Math.abs(x - i) + Math.abs(y - j);
                }
            }
        }
        return distance;
    }

    // is this board the goal board?
    public boolean isGoal() {
        final int lastIndex = size - 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tiles[i][j] == EMPTY_TILE && i == lastIndex && j == lastIndex) {
                    return true;
                }
                final int etalom = calculateEtalonValueForCell(i, j);
                if (tiles[i][j] != etalom) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Two boards are equal if they are have the same size and their corresponding tiles are in the same positions.
     * The equals() method is inherited from java.lang.Object, so it must obey all of Java’s requirements.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Board other = (Board) obj;
        if (!Arrays.deepEquals(tiles, other.tiles))
            return false;
        return true;
    }

    /**
     * @return an iterable containing the neighbors of the board. Depending on the location of the blank square, a board can have 2, 3, or 4 neighbors.
     */
    // all neighboring boards
    public Iterable<Board> neighbors() {
        Position emptyTilePos = defineEmptyTilePoisition();
        final int i = emptyTilePos.i;
        final int j = emptyTilePos.j;

        Queue<Board> movingQueue = new Queue<Board>();
        for (int k = 0; k < COUNT_OF_FREEDOM; k++) {
            if (isInRange(i + MOVE_X_MATRIX[k], j + MOVE_Y_MATRIX[k])) {
                int num = tiles[i + MOVE_X_MATRIX[k]][j + MOVE_Y_MATRIX[k]];
                tiles[i][j] = num;
                tiles[i + MOVE_X_MATRIX[k]][j + MOVE_Y_MATRIX[k]] = EMPTY_TILE;
                Board b = new Board(tiles);
                movingQueue.enqueue(b);
                tiles[i][j] = EMPTY_TILE;
                tiles[i + MOVE_X_MATRIX[k]][j + MOVE_Y_MATRIX[k]] = num;
            }
        }
        return movingQueue;
    }

    private boolean isInRange(int i, int j) {
        return (0 <= i && i < size && 0 <= j && j < size);
    }

    private Position defineEmptyTilePoisition() {
        int i = 0, j = 0;
        boolean isEmptyTile = false;
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                if (tiles[i][j] == EMPTY_TILE) {
                    isEmptyTile = true;
                    break;
                }
            }
            if (isEmptyTile) {
                break;
            }
        }
        return new Position(i, j);
    }

    private static class Position {
        private final int i;
        private final int j;
        public Position(int i, int j) {
            super();
            this.i = i;
            this.j = j;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.deepHashCode(tiles);
        return result;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int i = 0,
            j = 0;
        boolean found = false;
        for (i = 0; i < size; i++) {
            for (j = 0; j < size - 1; j++) {
                if (tiles[i][j] != EMPTY_TILE && tiles[i][j + 1] != EMPTY_TILE) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        int x = tiles[i][j];
        int y = tiles[i][j + 1];
        tiles[i][j + 1] = x;
        tiles[i][j] = y;
        Board res = new Board(tiles);
        tiles[i][j] = x;
        tiles[i][j + 1] = y;
        return res;
    }

    /**
     * @return string composed of n + 1 lines. The first line contains the board size n;
     *          the remaining n lines contains the n-by-n grid of tiles in row-major order, using 0 to designate the blank square.
     */
    // string representation of this board
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(size + "\n");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                s.append(String.format("%3d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    // unit tests
    public static void main(String[] args) {
        // create initial board from file
        // create initial board from file
        In in = new In(args[0]);
        final int size = in.readInt();
        int[][] blocks = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                blocks[i][j] = in.readInt();
            }
        }
        Board initial = new Board(blocks);
        Board swapped = initial.twin();
        StdOut.println(initial.toString());
        StdOut.println(swapped.toString());
        for (Board board : initial.neighbors()) {
            StdOut.println(board);
        }
    }
}
