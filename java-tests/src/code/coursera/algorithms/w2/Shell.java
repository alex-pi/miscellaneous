package code.coursera.algorithms.w2;

import java.util.Comparator;

/**
 * User: pi
 * Date: 2/27/13
 * Time: 6:50 PM
 */
public class Shell extends AbstractSorter {

    public void sort(Object[] arr, Comparator c) {

        int n = arr.length;
        int h = 1;
        while (h < n/3) h = 3*h+1;

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j-h], c); j-=h)
                    exch(j, j-1, arr);
            }
            h = h/3;
        }
    }
}
