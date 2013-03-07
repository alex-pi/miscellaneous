package code.coursera.algorithms.w2;

/**
 * User: pi
 * Date: 2/27/13
 * Time: 6:50 PM
 */
public class Shell implements Sorter {

    public void sort(Comparable[] arr) {

        int n = arr.length;
        int h = 1;
        while (h < n/3) h = 3*h+1;

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j-h]); j-=h)
                    exch(j, j-1, arr);
            }
            h = h/3;
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
