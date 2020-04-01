package com.study.kokhrimenko.algoriths.external.coursera.union_find.impl;

import java.util.stream.IntStream;

import com.study.kokhrimenko.algoriths.external.coursera.union_find.UnionFind;

/**
 * Input data: 
 *    We have the graph of data (see below)
 *       0 - 5 - 6
 *       1 - 2 - 7
 *       8 - 3 - 4 - 9
 *
 * Solution:
 *    1 declare array id[] of size N, where N - count of elements in the graph (see above)
 *    2 transform graph to the array representation. See example below:
 *       - graph nodes =  0  1  2  3  4  5  6  7  8  9
 *               id[]  =  0  1  1  8  8  0  0  1  8  8
 *
 * Interpretation:
 *    p and q are connected if they have the same ID.
 *
 * Algorithm:
 *   Find: check if p and q have the same id
 *       Example(see graph above)
 *           id[6] = 0
 *           id[1] = 1
 *         so, 6 and 1 are not connected
 *   Union: to merge components containing p and q, change all entries whose id equals id[p] to id[q].
 *        Example(see id[] array above): after connected 6 and 1, resulted array will looks like:
 *           - graph nodes =  0  1  2  3  4  5  6  7  8  9
 *                   id[]  =  1  1  1  8  8  1  1  1  8  8
 *
 * Complexity:
 *   find - 1 (constant always 1)
 *   union - O (N) (we iterate over a whole array)
 *
 * @author kostic
 *
 */
public class QuickFind implements UnionFind {

    private final int[] id;

    public QuickFind(int N) {
        id = IntStream.range(0, N).toArray();
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        
        /*
         * Doesn't have any sense to use here StreamAPI because firstly wi will transform array to stream and, at the end - back to array.
         */
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
}
