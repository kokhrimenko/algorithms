package com.study.kokhrimenko.algoriths.external.coursera.sort;

/**
 * Complexity:
 *        N * log N compares + 6* N * log N -array accesses
 *        uses extra space proportional to N (aux array).
 * 
 * @author kostic
 *
 */
public class MergeSort {

    public static <T> void sort(Comparable<T>[] a) {
        @SuppressWarnings("unchecked")
        Comparable<T>[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
    
    private static <T> void sort(Comparable<T>[] a, Comparable<T>[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }
    
    private static <T> void merge(Comparable<T>[] a, Comparable<T>[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid); // precondition: first halve or the input array is sorted
        assert isSorted(a, mid + 1, hi); // precondition: second halve or the input array is sorted

        System.arraycopy(a, 0, aux, 0, a.length);
        /*for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }*/
        int i = lo,
            j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

        assert isSorted(a, lo, hi);
    }

    private static <T> boolean less(Comparable a, Comparable b) {
        return a != null && a.compareTo(b) <= 0;
    }

    private static <T> boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo; i < hi - 2; i++) {
            if (a[i].compareTo(a[i + 1]) <= 0) {
                return false;
            }
        }
        return true;
    }
}
