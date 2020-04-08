package com.study.kokhrimenko.algoriths.external.coursera.stack.impl;

import java.util.Iterator;

import com.study.kokhrimenko.algoriths.external.coursera.stack.Stack;

/**
 * Implements LIFO strategy.
 * Not thread-safety.
 *
 * Implementation details:
 *      Use T[] to store N items on stack;
 *      push() - add new item at storage[N];
 *      pop()  - remove item from storage[N-1]
 * Defect:
 *      stack overflow exception when exceeds storage capacity (not auto-extendable);
 *      throw exception when pop() from an empty stack;
 *      allowing null data items;
 *      we, on pop() method, just decrement the counter (index) but data - still doesn't allowed for garbage collector (still in array).
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
public class StackOnArrayIterable<T extends Object> implements Stack<T>, Iterable<T> {

    private T[] storage;
    private int index;

    @SuppressWarnings("unchecked")
    public StackOnArrayIterable(int capacity) {
        storage = (T[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public void push(T data) {
        storage[index++] = data;
    }

    @Override
    public T pop() {
        return storage[--index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {

        private int ind = index;

        @Override
        public boolean hasNext() {
            return ind > 0;
        }

        @Override
        public T next() {
            return storage[--ind];
        }
    }
}
