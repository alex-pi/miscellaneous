package code.coursera.algorithms.w3;

import code.coursera.algorithms.w2.AbstractSorter;
import code.coursera.algorithms.w2.Insertion;
import code.util.StdRandom;

import java.util.Comparator;

/**
 * User: pi
 * Date: 3/7/13
 * Time: 5:04 PM
 */
public class QuickSort extends AbstractSorter {

    private static final int CUTOFF = 7;

    public void sort(Object[] arr, Comparator c) {
        StdRandom.shuffle(arr);
        sort(arr, c, 0, arr.length-1);
    }

    /**
     * Using normal partitioning. It is supposed to be quadratic when
     * many duplicated keys, but it is working ok...
     *
     */
    /*private void sort(Object[] arr, Comparator c, int lo, int hi) {
        // improvement 1
        if(hi <= lo + CUTOFF - 1) {
            new Insertion().sort(lo, hi, arr, c);
            return;
        }
        //if(hi <= lo) return;
        int part = partition(arr, c, lo, hi);
        sort(arr, c, lo, part-1);
        sort(arr, c, part+1, hi);
    }*/

    /**
     * Using Dijstra 3-way partitioning. Fixes the duplicate keys problem.
     *
     * @param arr
     * @param c
     * @param lo
     * @param hi
     */
    private void sort(Object[] arr, Comparator c, int lo, int hi) {
        if(hi <= lo) return;

        int lt = lo;
        int gt = hi;
        int i = lo;
        Object v = arr[lo];

        while(i <= gt) {
            if(less(arr[i], v, c)) exch(lt++, i++, arr);
            else if(less(v, arr[i], c)) exch(gt--, i, arr);
            else i++;
        }

        sort(arr, c, lo, lt-1);
        sort(arr, c, gt+1, hi);
    }

    public int partition(Object[] arr, Comparator c, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while(true) {
            while(less(arr[++i], arr[lo], c))
                if(i == hi) break;

            while(less(arr[lo], arr[--j], c))
                if(j == lo) break;

            if(j <= i) break;
            exch(i, j, arr);
        }
        exch(lo, j, arr);

        return j;
    }
}
