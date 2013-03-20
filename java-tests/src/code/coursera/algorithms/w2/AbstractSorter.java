package code.coursera.algorithms.w2;

import java.util.Comparator;

/**
 * User: pi
 * Date: 3/7/13
 * Time: 5:04 PM
 */
public abstract class AbstractSorter implements Sorter<Comparable> {

    public void sort(Comparable[] arr) {
        sort(arr, new Comparator<Comparable>() {
            public int compare(Comparable o1, Comparable o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public abstract void sort(Object[] arr, Comparator c);

    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public boolean less(Object a, Object b, Comparator c) {
        return c.compare(a, b) < 0;
    }

    public boolean lessOrEqual(Comparable a, Comparable b) {
        return a.compareTo(b) <= 0;
    }

    public boolean lessOrEqual(Object a, Object b, Comparator c) {
        return c.compare(a, b) <= 0;
    }

    public void exch(int j, int k, Object... arr) {
        Object a = arr[j];
        arr[j] = arr[k];
        arr[k] = a;
    }
}
