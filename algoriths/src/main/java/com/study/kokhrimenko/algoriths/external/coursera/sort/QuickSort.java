package com.study.kokhrimenko.algoriths.external.coursera.sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Algorithm:
 *          shuffle the input array ( for the performance guarantee, skip worst case)
 *          partition, for example:
 *                  all elements on the left is smaller then current element
 *                  all elements on the right - greater.
 *          sort each piece recursively.
 *
 * Complexity:
 *          ~ 2 * N * log N -array accesses
 *          ~ 1/3 * N * log N - exchanges
 *
 * @author kostic
 *
 */
public class QuickSort {

    public static <T> void sort(Comparable<T>[] arr) {
        // Shuffling is needed for performance guarantee!
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private static <T> void sort(Comparable<T>[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    private static <T> int partition(Comparable<T>[] arr, int lo, int hi) {
        int i = lo,
            j = hi;
        while (i < j) {
            while (less(arr[++i], arr[lo]) && i < hi) {
            }

            while (less(arr[lo], arr[--j]) && j > lo) {
            }

            exhange(arr, i, j);
        }
        exhange(arr, lo, j);
        return j;
    }
    
    @SuppressWarnings("unchecked")
    private static <T> boolean less(Comparable<T> first, Comparable<T> second) {
        return first.compareTo((T) second) < 0;
    }

    private static <T> void exhange(T[] arr, int first, int second) {
        T tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }
}
