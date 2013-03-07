package code.coursera.algorithms.w2;

/**
 * User: pi
 * Date: 2/26/13
 * Time: 6:02 PM
 */
public class Selection implements Sorter {

    public void sort(Comparable[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++)
                if (less(arr[j], arr[min]))
                    min = j;
            exch(i, min, arr);
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
