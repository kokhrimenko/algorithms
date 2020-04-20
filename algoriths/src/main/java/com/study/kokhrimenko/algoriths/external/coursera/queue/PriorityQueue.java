package com.study.kokhrimenko.algoriths.external.coursera.queue;

public interface PriorityQueue<Key extends Comparable<Key>> {

    void insert(Key key);

    /**
     * Delete from a queue and return the largest element.
     *
     * @return
     */
    Key delMax();

    boolean isEmpty();

    Key max();

    int size();
}
