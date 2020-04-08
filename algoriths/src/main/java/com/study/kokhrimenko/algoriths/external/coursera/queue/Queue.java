package com.study.kokhrimenko.algoriths.external.coursera.queue;

/**
 * Implements FIFO strategy.
 *
 * @author kostic
 *
 * @param <T>
 */
public interface Queue<T extends Object> {

    boolean isEmpty();

    void enqueue(T item);

    T dequeue();

}
