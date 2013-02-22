/**
 * User: pi
 * Date: 2/21/13
 * Time: 8:26 PM
 */
public class Subset {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> q = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            q.enqueue(s);
        }

        for (int i = 1; i <= k; i++) {
            StdOut.println(q.dequeue());
        }
    }
}
