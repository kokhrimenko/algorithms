package com.study.kokhrimenko.algoriths.external.coursera.queue.impl;

import com.study.kokhrimenko.algoriths.external.coursera.queue.PriorityQueue;

/**
 * Complexity:
 *          insert - 1 + log N
 *          delete - 2 * log N
 *          max - constant
 *
 * @author kostic
 *
 * @param <Key>
 */
public class BinayHeapPriorityQueue<Key extends Comparable<Key>> extends ArrayBasedQueue<Key> implements PriorityQueue<Key> {

    public BinayHeapPriorityQueue(int capacity) {
        super(capacity);
    }

    @Override
    public void insert(Key key) {
        storage[++size] = key;
        swim(size);
    }

    // Parent of node with index k is k/2
    // exchange child with its parent till child's is a bigger than its parent.
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }
    
    @Override
    public Key delMax() {
        Key max = storage[1];
        exchange(1, size --);
        sink(1);
        // preventing memory leak, making element available for GC.
        storage[size + 1] = null;
        return max;
    }

    // exchange key in parent with key in larger child
    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }

    @Override
    public Key max() {
        return storage[1];
    }
/*
    public static void main(String[] args) {
        HeapTreePriorityQueue<String> heapTree = new HeapTreePriorityQueue<>(12);
        heapTree.insert("P");
        heapTree.insert("O");
        heapTree.insert("A");
        heapTree.insert("R");
        heapTree.insert("H");
        heapTree.insert("G");
        heapTree.insert("E");
        heapTree.insert("I");
        heapTree.insert("N");
        heapTree.insert("T");
        heapTree.insert("S");
        System.out.println(heapTree.delMax());
        System.out.println(heapTree.delMax());
        System.out.println(heapTree.delMax());
    }
*/
}
