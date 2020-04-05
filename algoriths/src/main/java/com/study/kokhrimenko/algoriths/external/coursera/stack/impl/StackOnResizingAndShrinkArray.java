package com.study.kokhrimenko.algoriths.external.coursera.stack.impl;

import com.study.kokhrimenko.algoriths.external.coursera.stack.Stack;

/**
 * Implements LIFO strategy.
 * Not thread-safety.
 * This implementation also has memory utilization for pop operation (pop element will become allowing for garbage collector).
 *
 * Implementation details:
 *      Use T[] to store N items on stack;
 *      push() - add new item at storage[N];
 *      pop()  - remove item from storage[N-1]
 * Defect:
 *      throw exception when pop() from an empty stack;
 *      allowing null data items;
 *      we, on pop() method, just decrement the counter (index) but data - still doesn't allowed for garbage collector (still in array).
 *
 * Complexity:
 *      ~ 3*N - for insert (because of we will extend out storage from time to time);
 *      constant - for all another operations.
 *
 * Memory usage:
 *      ~ 8* N - when full;
 *      ~ 32 * N - when one-quarter full.
 * Explanation:
 *      8 bytes  - reference to array
 *      24 bytes - array overhead
 *      8 bytes * array size
 *      4 bytes - index
 *      4 bytes - padding.
 *
 * @author kostic
 *
 */
public class StackOnResizingAndShrinkArray<T extends Object> implements Stack<T> {

    private T[] storage;
    private int index;

    @SuppressWarnings("unchecked")
    public StackOnResizingAndShrinkArray(int capacity) {
        storage = (T[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public void push(T data) {
        if (index == storage.length) {
            resizeStorage(2 * storage.length);
        }
        storage[index++] = data;
    }

    private void resizeStorage(int capacity) {
        @SuppressWarnings("unchecked")
        T[] newStorage = (T[]) new Object[capacity];
        for (int i = 0; i < index; i++) {
            newStorage[i] = storage[i];
        }
        storage = newStorage;
    }

    @Override
    public T pop() {
        T data = storage[--index];
        storage[index] = null;
        if (index == storage.length / 4) {
            resizeStorage(storage.length);
        }
        return data;
    }
}
