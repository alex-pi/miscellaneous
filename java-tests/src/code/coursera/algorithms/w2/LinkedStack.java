package code.coursera.algorithms.w2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: pi
 * Date: 2/19/13
 * Time: 10:53 AM
 */
public class LinkedStack<I> implements Iterable<I> {

    private Node first;

    public Iterator<I> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<I> {

        private Node current = first;

        public void remove() { throw new UnsupportedOperationException(); }

        public boolean hasNext() {
            return current != null;
        }

        public I next() {
            if(current == null) throw new NoSuchElementException();
            I item = current.item;
            current = current.next;

            return item;
        }
    }

    private class Node {
        I item;
        Node next;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public LinkedStack<I> push(I newItem) {
        Node prev = this.first;
        this.first = new Node();
        this.first.item = newItem;

        this.first.next = prev;

        return this;
    }

    public I pop() {
        if(this.first == null) return null;
        I item = this.first.item;
        this.first =  this.first.next;
        return item;
    }
}
