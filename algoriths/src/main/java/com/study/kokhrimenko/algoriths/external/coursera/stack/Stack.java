package com.study.kokhrimenko.algoriths.external.coursera.stack;

/**
 * Implements LIFO strategy.
 *
 * @author kostic
 *
 * @param <T>
 */
public interface Stack <T extends Object> {

    boolean isEmpty();

    public void push(T data);

    public T pop();
}
