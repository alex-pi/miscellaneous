package code.coursera.algorithms.w2;

import code.coursera.algorithms.w2.ArrayQueue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

/**
 * User: pi
 * Date: 2/19/13
 * Time: 10:03 PM
 */
public class ArrayQueueTest {

    private ArrayQueue<String> aq;

    @Before
    public void before() {
        aq = new ArrayQueue();
    }

    @Test
    public void testIsEmpty(){
        Assert.assertTrue(aq.isEmpty());
    }

    @Test
    public void testQueue() {
        aq.queue("Pi")
                .queue("Chio");
        Assert.assertFalse(aq.isEmpty());
    }

    @Test
    public void testDequeueWhenEmpty() {
        Assert.assertEquals(null, aq.dequeue());
    }

    @Test
    public void testDequeue() {
        aq.queue("Pi")
                .queue("Chio");
        Assert.assertFalse(aq.isEmpty());
        Assert.assertEquals("Pi", aq.dequeue());
        Assert.assertFalse(aq.isEmpty());
        Assert.assertEquals("Chio", aq.dequeue());
        Assert.assertTrue(aq.isEmpty());
    }

    @Test
    public void testQueueThenDequeue() {
        aq.queue("Pi")
                .queue("Chio");
        Assert.assertFalse(aq.isEmpty());
        Object[] array = (Object[]) Whitebox.getInternalState(this.aq, "q");
        int head = (int)Whitebox.getInternalState(this.aq, "head");
        int tail = (int)Whitebox.getInternalState(this.aq, "tail");
        Assert.assertEquals(0, head);
        Assert.assertEquals(2, tail);
        Assert.assertEquals(2, array.length);
        aq.queue("Chumina");
        array = (Object[]) Whitebox.getInternalState(this.aq, "q");
        Assert.assertEquals(4, array.length);

        Assert.assertEquals("Pi", aq.dequeue());
        Assert.assertFalse(aq.isEmpty());
        Assert.assertEquals("Chio", aq.dequeue());
        Assert.assertFalse(aq.isEmpty());

        array = (Object[]) Whitebox.getInternalState(this.aq, "q");
        Assert.assertEquals(2, array.length);
        head = (int)Whitebox.getInternalState(this.aq, "head");
        tail = (int)Whitebox.getInternalState(this.aq, "tail");
        Assert.assertEquals(0, head);
        Assert.assertEquals(1, tail);

        Assert.assertEquals("Chumina", aq.dequeue());
        Assert.assertTrue(aq.isEmpty());
        array = (Object[]) Whitebox.getInternalState(this.aq, "q");
        Assert.assertEquals(1, array.length);
    }
}
