package code.coursera.algorithms.w3;

import code.coursera.algorithms.w2.AbstractSorter;
import code.coursera.algorithms.w2.Insertion;

import java.util.Comparator;

/**
 * User: pi
 * Date: 3/7/13
 * Time: 5:04 PM
 */
public class MergeSort extends AbstractSorter {

    private static final int CUTOFF = 7;

    public void sort(Object[] arr, Comparator c) {
        Comparable[] aux = new Comparable[arr.length];
        sort(arr, aux, c, 0, arr.length-1);
    }

    private void merge(Object[] a, Object[] aux, Comparator c, int lo, int mid, int hi) {
        System.arraycopy(a, lo, aux, lo, hi-lo+1);

        int i = lo;
        int j = mid + 1;

        for(int k=lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if(less(aux[i], aux[j], c)) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    private void sort(Object[] a, Object[] aux, Comparator c, int lo, int hi) {
        // improvement 1
        /*if(hi <= lo + CUTOFF - 1) {
            new Insertion().sort(lo, hi, a, c);
            return;
        }*/
        if (hi <= lo) return;
        int mid = lo+(hi-lo)/2;
        sort(a, aux, c, lo, mid);
        sort(a, aux, c, mid+1, hi);
        // improvement 2
        //if(less(a[mid], a[mid+1], c)) return;
        merge(a, aux, c, lo, mid, hi);
    }
}
