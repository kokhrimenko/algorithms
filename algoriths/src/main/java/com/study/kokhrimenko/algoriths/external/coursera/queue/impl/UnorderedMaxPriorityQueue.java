package com.study.kokhrimenko.algoriths.external.coursera.queue.impl;

/**
 * Complexity:
 *      insert - constant time
 *      delete and max - N
 *
 * @author kostic
 *
 * @param <Key>
 */
public class UnorderedMaxPriorityQueue<Key extends Comparable<Key>> extends ArrayBasedQueue<Key> {

    public UnorderedMaxPriorityQueue(int capacity) {
        super(capacity);
    }

    @Override
    public void insert(Key key) {
        storage[size++] = key;
    }

    @Override
    public Key delMax() {
        int max = getMaxIndex();
        exchange(max, size - 1);
        return storage[--size];
    }

    private int getMaxIndex() {
        int max = 0;
        for (int i = 1; i < size; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public Key max() {
        return storage[getMaxIndex()];
    }
}
