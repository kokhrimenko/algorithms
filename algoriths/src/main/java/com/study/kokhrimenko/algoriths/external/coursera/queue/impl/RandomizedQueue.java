package com.study.kokhrimenko.algoriths.external.coursera.queue.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random among items in the data structure.
 *
 * Performance requirements:
 *      Your randomized queue implementation must support each randomized queue operation (besides creating an iterator) in constant
 *      amortized time. That is, any intermixed sequence of m randomized queue operations (starting from an empty queue) must take at most c*m steps in the
 *      worst case, for some constant c. A randomized queue containing n items must use at most 48n + 192 bytes of memory. Additionally, your iterator
 *      implementation must support operations next() and hasNext() in constant worst-case time; and construction in linear time; you may (and will need to)
 *      use a linear amount of extra memory per iterator.
 *
 * @author kostic
 *
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int INITIAL_CAPACITY = 10;

    private Item[] storage;
    private int size;

    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
        storage = (Item[]) new Object[INITIAL_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    private RandomizedQueue(Item[] array, int size) {
        int length = array.length;
        storage = (Item[]) new Object[length];
        System.arraycopy(array, 0, storage, 0, length);
        this.size = size;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Doesn't accept NULL values");
        }

        if (size == storage.length) {
            resizeStorage(2 * storage.length);
        }
        storage[size++] = item;
    }

    private void resizeStorage(int capacity) {
        @SuppressWarnings("unchecked")
        Item[] newStorage = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newStorage[i] = storage[i];
        }
        storage = newStorage;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Currently - randomizedQeque is empty!");
        }
        int randomElementIndex = StdRandom.uniform(0, size);
        Item data = storage[randomElementIndex];
        storage[randomElementIndex] = storage[--size];
        storage[size] = null;
        if (size == storage.length / 4) {
            resizeStorage(storage.length);
        }
        return data;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Currently - randomizedQeque is empty!");
        }
        int randomElementIndex = StdRandom.uniform(0, size);
        return storage[randomElementIndex];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private RandomizedQueue<Item> innerRandomizedQueue = new RandomizedQueue<>(storage, size);

        @Override
        public boolean hasNext() {
            return !innerRandomizedQueue.isEmpty();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("This implementation doesn't support remove operation!");
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("You've already reached the end of randomizedQueue!");
            }
            return innerRandomizedQueue.dequeue();
        }
    }

    public static void main(String[] args) {
        final int iterationCount = 150;
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();

        StdOut.println("Queue is empty: " + randomizedQueue.isEmpty());
        for (int i = 0; i < iterationCount; i++) {
            randomizedQueue.enqueue(i);
            if (i % 3 == 0) {
                randomizedQueue.dequeue();
            }
        }
        StdOut.println("Size: " + randomizedQueue.size());

        randomizedQueue.iterator().forEachRemaining(item -> StdOut.print(item + " "));
        StdOut.println();

        StdOut.print("Random pick ups: ");
        for (int j = 0; j < randomizedQueue.size(); j++) {
            StdOut.print(randomizedQueue.sample() + " ");
        }
    }
}
