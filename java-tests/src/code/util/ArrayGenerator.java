package code.util;

/**
 * User: pi
 * Date: 2/26/13
 * Time: 6:47 PM
 */
public class ArrayGenerator {

    public static Double[] random(int n, double min, double max) {
        Double[] arr = new Double[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniform(min, max);
        }

        return arr;
    }

    public static Integer[] asc(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        return arr;
    }

    public static Integer[] desc(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n-i-1;
        }

        return arr;
    }

    public static int exchn(int n, Object... arr) {
        if(n < 1) throw new IllegalArgumentException();
        int changed = 0;
        for (int i = 0; i < n; i++) {
            int a = StdRandom.uniform(0, arr.length);
            int b = StdRandom.uniform(0, arr.length);
            exch(a, b, arr);
            if(a != b && !arr[a].equals(arr[b]))
                changed++;
        }

        return changed;
    }

    public static void exch(int j, int k, Object... arr) {
        Object a = arr[j];
        arr[j] = arr[k];
        arr[k] = a;
    }
}
