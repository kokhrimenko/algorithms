package com.study.kokhrimenko.algoriths.external.coursera.table;

import java.util.Iterator;

public interface Table<Key extends Comparable<Key>, Value> {

    /**
     * @param key
     * @return value corresponding to given key, or null if no such key.
     */
    Value get(Key key);

    void put(Key key, Value value);

    void delete(Key key);

    Iterator<Key> iterator();

    boolean isEmpty();

    Iterable<Key> keys();
}
