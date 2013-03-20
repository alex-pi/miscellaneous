package code.coursera.algorithms.w2;

import java.util.Comparator;

/**
 * User: pi
 * Date: 2/27/13
 * Time: 6:50 PM
 */
public class Insertion extends AbstractSorter {

    public void sort(Object[] arr, Comparator c) {

        sort(0, arr.length-1, arr, c);
    }

    public void sort(int lo, int hi, Object[] arr, Comparator c) {

        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo; j--)
                if (less(arr[j], arr[j-1], c))
                    exch(j, j-1, arr);
                else break;
        }

    }
}
