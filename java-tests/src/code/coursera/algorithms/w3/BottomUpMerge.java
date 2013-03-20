package code.coursera.algorithms.w3;

import code.coursera.algorithms.w2.AbstractSorter;

import java.util.Comparator;

/**
 * User: pi
 * Date: 3/7/13
 * Time: 5:04 PM
 */
public class BottomUpMerge extends AbstractSorter {

    public void sort(Object[] arr, Comparator c) {
        Comparable[] aux = new Comparable[arr.length];
        int n = arr.length;
        for(int sz = 1; sz < n; sz *= 2)
            for(int lo = 0; lo < n-sz; lo += 2*sz)
                merge(arr, aux, c, lo, lo+sz-1, Math.min((sz*2)+lo-1, n-1) );
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
}
