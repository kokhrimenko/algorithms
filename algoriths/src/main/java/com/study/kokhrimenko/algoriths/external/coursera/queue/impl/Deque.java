package com.study.kokhrimenko.algoriths.external.coursera.queue.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

/**
 * A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue that supports adding and removing items from either the
 * front or the back of the data structure.
 *
 * Performance requirements:
 *      Your deque implementation must support each deque operation (including construction) in constant worst-case time.
 *      A deque containing n items must use at most 48n + 192 bytes of memory. Additionally, your iterator implementation must support
 *      each operation (including construction) in constant worst-case time.
 *
 * @author kostic
 *
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size = 0;

    private class Node {
        Item item;
        Node next;
        Node previous;

        public Node(Item item) {
            super();
            this.item = item;
        }
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Doesn't accept NULL values");
        }

        Node oldFirst = first;
        first = new Node(item);
        first.previous = null;
        first.next = oldFirst;
        if (oldFirst != null) {
            oldFirst.previous = first;
        }
        if (size == 0) {
            last = first;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Doesn't accept NULL values");
        }
        Node oldLast = last;
        last = new Node(item);
        last.previous = oldLast;
        last.next = null;
        if (oldLast != null) {
            oldLast.next = last;
        }
        if (size == 0) {
            first = last;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (first == null) {
            throw new NoSuchElementException("Currently - deque is empty!");
        }

        Node data = first;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.previous = null;
        }
        size--;
        return data.item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (last == null) {
            throw new NoSuchElementException("Currently - deque is empty!");
        }

        Node data = last;
        last = last.previous;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        size--;
        return data.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("This implementation doesn't support remove operation!");
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("You've already reached the end of queue!");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        final int iterationCount = 150;
        Deque<Integer> deque = new Deque<>();

        for (int i = 0; i <= iterationCount; i++) {
            if (i % 2 == 0) {
                deque.addFirst(i);
            } else {
                deque.addLast(i);
            }
        }
        StdOut.println(deque.size());

        for (int i = 0; i <= iterationCount; i++) {
            if (i % 3 == 0) {
                deque.removeLast();
            } else {
                deque.removeFirst();
            }
        }
        StdOut.println(deque.size());

        for (int i = 0; i <= iterationCount; i++) {
            if (i % 2 == 0) {
                deque.addFirst(i);
            } else {
                deque.addLast(i);
            }
        }
        StdOut.println(deque.size());
    }

}
