package code.coursera.algorithms.w2;

import java.util.Comparator;

/**
 * User: pi
 * Date: 2/27/13
 * Time: 8:06 PM
 */
public interface Sorter<I extends Comparable> {

    public void sort(I[] arr);

    public boolean less(I a, I b);

    public boolean lessOrEqual(I a, I b);

    public void sort(Object[] arr, Comparator c);

    public boolean less(Object a, Object b, Comparator c);

    public boolean lessOrEqual(Object a, Object b, Comparator c);

    public void exch(int j, int k, Object... arr);
}
