package com.study.kokhrimenko.algoriths.external.coursera.union_find;

public interface UnionFind {

    /**
     * Is two nodes in a graph connected ?
     * @param p
     * @param q
     */
    boolean connected(int p, int q);

    /**
     * Make a connections between two nodes in a graph.
     *
     * @param p
     * @param q
     */
    void union(int p, int q);
}
