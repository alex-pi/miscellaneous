package code.coursera.algorithms.w2;

/**
 * User: pi
 * Date: 2/20/13
 * Time: 12:29 PM
 */
public class ArrayQueue<I extends Object> {

    private Object[] q;
    private int head;
    private int tail;

    public ArrayQueue() {
        q = new Object[1];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public ArrayQueue<I> queue(I newItem) {
        if(tail == q.length) {
            resize(q.length * 2);
        }
        q[tail++] = newItem;

        return this;
    }

    public I dequeue() {
        if (isEmpty()) return null;

        I item = (I)q[head];
        q[head++] = null;
        if((tail - head) <= q.length/4)
            resize(q.length/2);

        return item;
    }

    private void resize(int size) {
        Object[] qn = new Object[size];

        System.arraycopy(q, head, qn, 0, tail-head);

        tail -= head;
        head = 0;
        q = qn;
    }
}
