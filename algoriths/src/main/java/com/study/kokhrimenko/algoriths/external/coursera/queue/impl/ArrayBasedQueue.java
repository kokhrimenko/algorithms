package com.study.kokhrimenko.algoriths.external.coursera.queue.impl;

import com.study.kokhrimenko.algoriths.external.coursera.queue.PriorityQueue;

/**
 * Contains some basic array operations like exchange and less and so on..
 *
 * @author kostic
 *
 */
abstract class ArrayBasedQueue<Key extends Comparable<Key>> implements PriorityQueue<Key> {

    protected final Key[] storage;
    protected int size;

    protected ArrayBasedQueue(int capacity) {
        storage = (Key[]) new Comparable[capacity + 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    protected boolean less(int i, int j) {
        return storage[i].compareTo(storage[j]) < 0;
    }

    protected void exchange(int i, int j) {
        final Key tmp = storage[i];
        storage[i] = storage[j];
        storage[j] = tmp;
    }
}
