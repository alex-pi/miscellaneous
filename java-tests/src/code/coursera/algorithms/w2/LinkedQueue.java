package code.coursera.algorithms.w2;

/**
 * User: pi
 * Date: 2/19/13
 * Time: 9:20 PM
 */
public class LinkedQueue<I> {

    private Node first;
    private Node last;

    private class Node {
        I item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public LinkedQueue<I> queue(I newItem) {
        Node newNode = new Node();
        newNode.item = newItem;

        Node prev = last;
        last = newNode;
        if(first == null)
            first =  newNode;
        else
            prev.next = last;

        return this;
    }

    public I dequeue() {
        if(first == null) return null;
        Node f = first;

        if(first == last)
            last = null;
        first = f.next;
        f.next = null;

        return f.item;
    }
}
