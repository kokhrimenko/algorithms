package com.study.kokhrimenko.algoriths.external.coursera.union_find.impl;

import java.util.stream.IntStream;

import com.study.kokhrimenko.algoriths.external.coursera.union_find.UnionFind;

/**
 * Input data: 
 *    We have the graph of data (see below)
 *       0
 *       1
 *       2 - 9 - 4 - 3
 *       6 - 5
 *       7
 *       8
 *
 * Solution:
 *    1 declare array id[] of size N, where N - count of elements in the graph (see above)
 *    2 transform graph to the array representation (id[i] pointer to the parent of i). See example below:
 *       - graph nodes =  0  1  2  3  4  5  6  7  8  9
 *               id[]  =  0  1  9  4  9  6  6  7  8  9
 *
 * Interpretation:
 *    p and q are connected if they have the same ROOT node.
 *
 * Algorithm:
 *   Find: check if p and q have the same ROOT
 *       Example(see graph above)
 *           root for 3 is 9
 *           root for 2 is 9
 *         so, 3 and 2 are connected
 *   Union: to merge components containing p and q, set the id of p's root to the id of q's root.
 *        Example(see id[] array above): after connected 9 to 6, resulted array will looks like:
 *           - graph nodes =  0  1  2  3  4  5  6  7  8  9
 *                   id[]  =  0  1  9  4  9  6  6  7  8  6
 *             so, just a root of 9 was changed from 9 to 6 and that's it!
 *
 * Complexity:
 *   find - N
 *   union - N
 *
 * @author kostic
 *
 */
public class QuickUnion implements UnionFind {

    private final int[] id;

    public QuickUnion(int N) {
        id = IntStream.range(0, N).toArray();
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int element) {
        while (element != id[element]) {
            element = id[element];
        }
        return element;
    }
    
    @Override
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        id[pRoot] = qRoot;
    }
}
