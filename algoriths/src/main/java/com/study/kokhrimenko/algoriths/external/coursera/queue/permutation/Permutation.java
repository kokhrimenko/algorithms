package com.study.kokhrimenko.algoriths.external.coursera.queue.permutation;

import com.study.kokhrimenko.algoriths.external.coursera.queue.impl.RandomizedQueue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Command-line argument. You may assume that 0 ≤ k ≤ n, where n is the number of string on standard input. Note that you are not given n.
 *
 * Performance requirements:
 *      The running time of Permutation must be linear in the size of the input. You may use only a constant amount of memory plus
 *      either one Deque or RandomizedQueue object of maximum size at most n. (For an extra challenge and a small amount of extra credit, use only one Deque or
 *      RandomizedQueue object of maximum size at most k.).
 *
 * @author kostic
 *
 */
public class Permutation {

    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            randomizedQueue.enqueue(StdIn.readString());
        }
        int countToPrint = Integer.parseInt(args[0]);
        if (countToPrint > randomizedQueue.size()) {
            throw new IllegalArgumentException("Maximum items to print is: " + randomizedQueue.size());
        }
        for (int i = 0; i < countToPrint; i++) {
            StdOut.println(randomizedQueue.dequeue());
        }
    }
}
