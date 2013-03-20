package code.coursera.algorithms.w2;

import java.util.Comparator;

/**
 * User: pi
 * Date: 2/26/13
 * Time: 6:02 PM
 */
public class Selection extends AbstractSorter {

    public void sort(Object[] arr, Comparator c) {

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++)
                if (less(arr[j], arr[min], c))
                    min = j;
            exch(i, min, arr);
        }

    }
}
