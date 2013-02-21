import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: pi
 * Date: 2/20/13
 * Time: 8:26 PM
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] rq;
    private int head;
    private int tail;
    private int size;

    public RandomizedQueue() {
        rq = (Item[]) new Object[1];
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Item[] items;
            private int toIterate;

            public boolean hasNext() {
                return toIterate > 0;
            }
            public Item next() {
                if (toIterate <= 0) throw new NoSuchElementException();
                int idx = randomIndex(0, size, items);
                Item item = items[idx];
                toIterate--;
                items[idx] = null;

                return item;
            }
            public void remove() { throw new UnsupportedOperationException(); }

            public Iterator<Item> init() {
                items = (Item[]) new Object[size];

                int pos = 0;
                for (int i = head; i < tail; i++) {
                    if (rq[i] != null) {
                        items[pos++] = rq[i];
                    }
                }
                toIterate = size;
                return this;
            }
        } .init();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item newItem) {
        if (newItem == null) throw new NullPointerException();
        if (tail == rq.length) {
            resize(rq.length * 2);
        }
        rq[tail++] = newItem;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int idx = randomIndex(head, tail, rq);
        Item item = rq[idx];
        rq[idx] = null;
        size--;

        if (size <= rq.length/3)
            resize(rq.length/2);

        return item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int idx = randomIndex(head, tail, rq);

        return rq[idx];
    }

    private int randomIndex(int l, int r, Item[] items) {
        int idx;
        do {
            idx = StdRandom.uniform(l, r);
            //StdOut.printf("%1$d -> [%2$d, %3$d)\n", idx, l, r);
        } while(items[idx] == null);

        return idx;
    }

    private void resize(int newSize) {
        Object[] qn = new Object[newSize];

        int pos = 0;
        for (int i = head; i < tail; i++) {
            if (rq[i] != null) {
                qn[pos++] = rq[i];
            }
        }

        tail = pos;
        head = 0;
        rq = (Item[]) qn;
    }
}
