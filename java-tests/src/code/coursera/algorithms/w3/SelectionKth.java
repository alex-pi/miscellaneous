package code.coursera.algorithms.w3;

import code.util.StdRandom;

import java.util.Comparator;

/**
 * User: pi
 * Date: 3/8/13
 * Time: 3:19 PM
 */
public class SelectionKth {

    public static <I> I min(I[] arr) {
        return select(arr, 0) ;
    }

    public static <I> I max(I[] arr) {
        return select(arr, arr.length-1) ;
    }

    public static <I> I select(I[] arr, int k) {
        return select(arr, k, new Comparator<Comparable>() {
            @Override
            public int compare(Comparable o1, Comparable o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public static <I> I select(I[] arr, int k, Comparator c) {
        StdRandom.shuffle(arr);
        int lo = 0;
        int hi = arr.length-1;

        while(hi > lo) {
            int part = partition(arr, c, lo, hi);
            if(k > part) lo = part+1;
            else if(k < part) hi = part-1;
            else return arr[k];
        }
        return arr[k];
    }

    private static <I> int partition(I[] arr, Comparator c, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while(true) {
            while(less(arr[++i], arr[lo], c))
                if(i == hi) break;

            while(less(arr[lo], arr[--j], c))
                if(j == lo) break;

            if(j <= i) break;
            exch(i, j, arr);
        }
        exch(lo, j, arr);

        return j;
    }

    public static <I> boolean less(I a, I b, Comparator c) {
        return c.compare(a, b) < 0;
    }

    public static <I> void exch(int j, int k, I... arr) {
        I a = arr[j];
        arr[j] = arr[k];
        arr[k] = a;
    }
}
