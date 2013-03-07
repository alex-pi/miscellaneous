package code.coursera.algorithms.w2;

/**
 * User: pi
 * Date: 2/27/13
 * Time: 8:06 PM
 */
public interface Sorter {

    public void sort(Comparable[] arr);

    public boolean less(Comparable a, Comparable b);

    public boolean lessOrEqual(Comparable a, Comparable b);

    public void exch(int j, int k, Comparable... arr);
}
