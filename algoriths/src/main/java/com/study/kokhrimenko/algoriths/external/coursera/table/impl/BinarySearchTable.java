package com.study.kokhrimenko.algoriths.external.coursera.table.impl;

import java.util.Iterator;

import com.study.kokhrimenko.algoriths.external.coursera.table.Table;

/**
 * Symbol Table implementation based on binary search algorithm.
 *
 * Implementation:
 *      keep keys into sorted array and use binary search algorithm to get/put operations.
 * Problem:
 *      to insert, needs to shift all greater keys over.
 *
 * Complexity:
 *      search - log N;
 *      insert - N / 2.
 *
 * @author kostic
 *
 */
public class BinarySearchTable<Key extends Comparable<Key>, Value> implements Table<Key, Value> {

    private Key[] keys;
    private Value[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public BinarySearchTable(int capacity) {
        keys = (Key[]) new Comparable[capacity + 1];
        values = (Value[]) new Object[capacity + 1];
        size = 0;
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int index = rank(key);
        if (index < size && keys[index].compareTo(key) == 0) {
            return values[index];
        }
        return null;
    }

    private int rank(Key key) {
        int lo = 0,
            hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);

            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void put(Key key, Value value) {
       throw new RuntimeException("this method not implemented yet"); 
    }

    @Override
    public void delete(Key key) {
        throw new RuntimeException("this method not implemented yet"); 
    }

    @Override
    public Iterator<Key> iterator() {
        throw new RuntimeException("this method not implemented yet");
    }

    @Override
    public Iterable<Key> keys() {
        throw new RuntimeException("this method not implemented yet");
    }
}
