package code.coursera.algorithms.w3;

import java.util.Comparator;

/**
 * User: pi
 * Date: 3/8/13
 * Time: 11:16 PM
 */
public class Questions {

    public static void main(String[] args) {
        //Integer[] arr = new Integer[]{34, 73, 51, 94, 27, 15, 70, 22, 46, 84, 26, 44};
        //new MergeSort().sort(arr);

        //Integer[] arr = new Integer[]{11, 40, 87, 56, 71, 92, 32, 34, 12, 51};
        //new BottomUpMerge().sort(arr);

        String[] arr = new String[]{"B","A","A","B","A","B","B","A","B","B","A","B"};
        new QuickSort().partition(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        },0, arr.length-1);

        System.out.println();
    }
}
