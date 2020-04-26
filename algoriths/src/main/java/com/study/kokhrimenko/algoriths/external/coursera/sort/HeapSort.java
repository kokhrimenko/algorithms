package com.study.kokhrimenko.algoriths.external.coursera.sort;

/**
 * Based on the binary heap logic, see
 * {@link com.study.kokhrimenko.algoriths.external.coursera.queue.impl.BinayHeapPriorityQueue}
 *
 * Complexity:
 *      ~ 2 * N - heap construction
 *      ~ 2 * N * log N - heapsort
 *      ~ 2 * N * (1 + log N) - total complexity
 *
 * @author kostic
 *
 */
public class HeapSort {

    private HeapSort() {
        super();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void sort(Comparable[] array) {
        int size = array.length;
        for (int k = size / 2; k > 1; k--) {
            sink(array, k, size);
        }
        while (size > 1) {
            exchange(array, 1, size);
            sink(array, 1, --size);
        }
    }
    
    private static <T> void sink(Comparable<T>[] array, int k, int size) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(array, j, j + 1)) {
                j++;
            }
            if (!less(array, k, j)) {
                break;
            }
            exchange(array, k, j);
            k = j;
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static boolean less(Comparable[] array, int i, int j) {
        return array[i].compareTo(array[j]) < 0;
    }

    @SuppressWarnings("rawtypes")
    private static void exchange(Comparable[] array, int i, int j) {
        final Comparable tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
