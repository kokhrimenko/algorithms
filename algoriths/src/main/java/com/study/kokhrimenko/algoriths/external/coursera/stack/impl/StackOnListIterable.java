package com.study.kokhrimenko.algoriths.external.coursera.stack.impl;

import java.util.Iterator;

import com.study.kokhrimenko.algoriths.external.coursera.stack.Stack;

/**
 * Implements LIFO strategy.
 * Not thread-safety.
 *
 * Complexity: constant time for all operations.
 *
 * Memory usage: ~ 40* N
 *     explanation: 16b - object overhead
 *                  8b  - inner class extra overhead
 *                  8b  - data reference (T extends Object)
 *                  8b  - next element pointer
 *         totally: 40b - for 1 element
 *
 * @author kostic
 *
 * @param <T>
 */
public class StackOnListIterable<T extends Object> implements Stack<T>, Iterable<T> {

    private Node root;

    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            super();
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
    
    @Override
    public void push(T data) {
        Node oldRoot = root;
        root = new Node(data, oldRoot);
    }

    @Override
    public T pop() {
        Node item = root;
        root = root.next;

        return item.item;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private Node current = root;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
