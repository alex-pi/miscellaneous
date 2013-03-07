package code.coursera.algorithms.w2;

/**
 * User: pi
 * Date: 2/27/13
 * Time: 6:50 PM
 */
public class Insertion implements Sorter {

    public void sort(Comparable[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--)
                if (less(arr[j], arr[j-1]))
                    exch(j, j-1, arr);
                else break;
        }

    }

    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public boolean lessOrEqual(Comparable a, Comparable b) {
        return a.compareTo(b) <= 0;
    }

    public void exch(int j, int k, Comparable... arr) {
        Comparable a = arr[j];
        arr[j] = arr[k];
        arr[k] = a;
    }
}
