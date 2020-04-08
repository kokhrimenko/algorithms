package com.study.kokhrimenko.algoriths.external.coursera.queue.impl;

import com.study.kokhrimenko.algoriths.external.coursera.queue.Queue;

public class QueueOnLinkedList<T extends Object> implements Queue<T> {

    private Node first;
    private Node last;
    
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
        return first == null;
    }

    @Override
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node(item, null);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    @Override
    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
}
