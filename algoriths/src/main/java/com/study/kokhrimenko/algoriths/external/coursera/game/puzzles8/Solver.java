package com.study.kokhrimenko.algoriths.external.coursera.game.puzzles8;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * A*search.
 * Now, we describe a solution to the 8-puzzle problem that illustrates a general artificial intelligence methodology known as the A*search algorithm.
 * We define a search node of the game to be a board, the number of moves made to reach the board, and the previous search node.
 * First, insert the initial search node (the initial board, 0 moves, and a null previous search node) into a priority queue.
 * Then, delete from the priority queue the search node with the minimum priority, and insert onto the priority queue all neighboring search nodes
 * (those that can be reached in one move from the dequeued search node). Repeat this procedure until the search node dequeued corresponds to the goal board.
 * 
 * The efficacy of this approach hinges on the choice of priority function for a search node.
 * We consider two priority functions:
 *          - The Hamming priority function is the Hamming distance of a board plus the number of moves made so far to get to the search node. Intuitively, a search
 *              node with a small number of tiles in the wrong position is close to the goal, and we prefer a search node if has been reached using a small number of
                moves.
            - The Manhattan priority function is the Manhattan distance of a board plus the number of moves made so far to get to the search node.
 * To solve the puzzle from a given search node on the priority queue, the total number of moves we need to make (including those already made) is at least its
 * priority, using either the Hamming or Manhattan priority function. Why? Consequently, when the goal board is dequeued, we have discovered not only a
 * sequence of moves from the initial board to the goal board, but one that makes the fewest moves. (Challenge for the mathematically inclined: prove this fact.)
 * 
 * Game tree.
 *      One way to view the computation is as a game tree, where each search node is a node in the game tree and the children of a node correspond
 * to its neighboring search nodes. The root of the game tree is the initial search node; the internal nodes have already been processed; the leaf nodes
 * are maintained in a priority queue; at each step, the A* algorithm removes the node with the smallest priority from the priority queue and processes it
 * (by adding its children to both the game tree and the priority queue).
 *
 * Implementation requirement.
 *          To implement the A* algorithm, you must use the MinPQ data type for the priority queue.
 *
 * Corner case.
 *          Throw an IllegalArgumentException in the constructor if the argument is null.
 *
 * Two optimizations.
 *          To speed up your solver, implement the following two optimizations:
 *          - The critical optimization. A* search has one annoying feature: search nodes corresponding to the same board are enqueued on the priority queue many times
 *              (e.g., the bottom-left search node in the game-tree diagram above). To reduce unnecessary exploration of useless search nodes, when considering the 
 *              neighbors of a search node, don’t enqueue a neighbor if its board is the same as the board of the previous search node in the game tree.
 *          - Caching the Hamming and Manhattan priorities. To avoid recomputing the Manhattan priority of a search node from scratch each time during various priority
 *              queue operations, pre-compute its value when you construct the search node; save it in an instance variable; and return the saved value as needed.
 *              This caching technique is broadly applicable: consider using it in any situation where you are recomputing the same quantity many times and for which
 *              computing that quantity is a bottleneck operation.
 *
 * Detecting unsolvable boards. Not all initial boards can lead to the goal board by a sequence of moves.
 * To detect such situations, use the fact that boards are divided into two equivalence classes with respect to reachability:
 *          - Those that can lead to the goal board
 *          - Those that can lead to the goal board if we modify the initial board by swapping any pair of tiles (the blank square is not a tile).
 * (Difficult challenge for the mathematically inclined: prove this fact.) To apply the fact, run the A* algorithm on two puzzle instances—one with the initial board
 * and one with the initial board modified by swapping a pair of tiles—in lockstep (alternating back and forth between exploring search nodes in each of the two game trees).
 * Exactly one of the two will lead to the goal board.
 *
 * @author kostic
 *
 */
public class Solver {
    private final MinPQ<BoardNode> pq = new MinPQ<>();
    private final MinPQ<BoardNode> pqTwin = new MinPQ<>();

    private final int dimension;
    private final Board initial;
    private final Board goal;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initialBoard) {
        if (initialBoard == null) {
            throw new IllegalArgumentException("Input parameter can't be NULL!");
        }
        this.initial = initialBoard;
        dimension = initial.dimension();

        int[][] blocks = new int[dimension][dimension];
        int k = 1;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                blocks[i][j] = k;
                k++;
            }
        }
        blocks[dimension - 1][dimension - 1] = 0;
        goal = new Board(blocks);

        BoardNode minNode;
        BoardNode minNodeTwin;
        pq.insert(new BoardNode(initial, 0, null));
        pqTwin.insert(new BoardNode(initial.twin(), 0, null));
        while (!pq.min().board.equals(goal) && !pqTwin.min().board.equals(goal)) {
            minNode = pq.min();
            minNodeTwin = pqTwin.min();
            pq.delMin();
            pqTwin.delMin();
            for (Board neighbor : minNode.board.neighbors()) {
                if (minNode.moves == 0) {
                    pq.insert(new BoardNode(neighbor, minNode.moves + 1, minNode));
                } else if (!neighbor.equals(minNode.previousNode.board)) {
                    pq.insert(new BoardNode(neighbor, minNode.moves + 1, minNode));
                }
            }
            // Twin
            for (Board neighbor : minNodeTwin.board.neighbors()) {
                if (minNodeTwin.moves == 0) {
                    pqTwin.insert(new BoardNode(neighbor, minNodeTwin.moves + 1, minNodeTwin));
                } else if (!neighbor.equals(minNodeTwin.previousNode.board)) {
                    pqTwin.insert(new BoardNode(neighbor, minNodeTwin.moves + 1, minNodeTwin));
                }
            }
        }
    }

    private static class BoardNode implements Comparable<BoardNode> {
        private Board board;
        private int moves;
        private int priority;
        private BoardNode previousNode;

        public BoardNode(Board board, int moves, BoardNode previousNode) {
            this.board = board;
            this.moves = moves;
            priority = moves + board.manhattan();
            this.previousNode = previousNode;
        }

        @Override
        public int compareTo(BoardNode that) {
            return (this.priority - that.priority);
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        if (pq.min().board.equals(goal)) {
            return true;
        }
        if (pqTwin.min().board.equals(goal)) {
            return false;
        }
        return false;
    }

    // min number of moves to solve initial board
    public int moves() {
        if (!isSolvable()) {
            return -1;
        }
        return pq.min().moves;
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution() {
        if (!isSolvable()) {
            return null;
        }
        Stack<Board> stackSolution = new Stack<Board>();
        BoardNode current = pq.min();
        while (current.previousNode != null) {
            stackSolution.push(current.board);
            current = current.previousNode;
        }
        stackSolution.push(initial);
        return stackSolution;
    }

    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tiles[i][j] = in.readInt();
            }
        }
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable()) {
            StdOut.println("No solution possible");
        } else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
