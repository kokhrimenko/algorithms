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
 * Solution (smaller tree always goes below):
 *    1 declare array id[] of size N, where N - count of elements in the graph (see above)    
 *    2 transform graph to the array representation (id[i] pointer to the parent of i).
 *    3 we will maintain extra array sz[i] to count number of objects in the tree rooted to i
 *
 * Interpretation:
 *    p and q are connected if they have the same ROOT node.
 *
 * Algorithm:
 *   Find: check if p and q have the same ROOT
 *
 *   Union: to merge components containing p and q - link root of smaller tree to root of larger tree & update the sz[] size.
 *
 * Complexity:
 *   find - ln N (base-2 logarithm)
 *   union - ln N (base-2 logarithm)
 *
 * @author kostic
 *
 */
public class WeightedQuickUnion implements UnionFind {

    private final int[] id;
    private final int[] sz;

    public WeightedQuickUnion(int N) {
        id = IntStream.range(0, N).toArray();
        sz = IntStream.range(0, N)
                    .map(sz -> 1)
                    .toArray();
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public int find(int element) {
        return 0;
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
        if (pRoot == qRoot) {
            return;
        }
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
