import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: pi
 * Date: 2/20/13
 * Time: 6:55 PM
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node current = first;

            public void remove() { throw new UnsupportedOperationException(); }
            public boolean hasNext() {
                return current != null;
            }
            public Item next() {
                if (current == null) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;

                return item;
            }
        };
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item newItem) {
        if (newItem == null) throw new NullPointerException();
        Node oldFirst = first;
        first = new Node();
        first.item = newItem;

        first.next = oldFirst;
        if (last == null)
            last = first;
        else
            oldFirst.previous = first;
        size++;
    }

    public void addLast(Item newItem) {
        if (newItem == null) throw new NullPointerException();
        Node oldLast = last;
        last = new Node();
        last.item = newItem;

        if (first == null)
            first = last;
        else
            oldLast.next = last;

        last.previous = oldLast;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        if (first == null)
            last = null;
        else
            first.previous = null;
        size--;

        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = last.item;
        last = last.previous;
        if (last == null)
            first = null;
        else
            last.next = null;
        size--;

        return item;
    }
}
