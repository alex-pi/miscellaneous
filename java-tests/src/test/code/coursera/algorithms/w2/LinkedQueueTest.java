package test.code.coursera.algorithms.w2;

import code.coursera.algorithms.w2.LinkedQueue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * User: pi
 * Date: 2/19/13
 * Time: 10:03 PM
 */
public class LinkedQueueTest {

    private LinkedQueue<String> lq;

    @Before
    public void before() {
        lq = new LinkedQueue();
    }

    @Test
    public void testIsEmpty(){
        Assert.assertTrue(lq.isEmpty());
    }

    @Test
    public void testQueue() {
        lq.queue("Pi")
                .queue("Chio");
        Assert.assertFalse(lq.isEmpty());
    }

    @Test
    public void testDequeueWhenEmpty() {
        Assert.assertEquals(null, lq.dequeue());
    }

    @Test
    public void testDequeue() {
        lq.queue("Pi")
                .queue("Chio");
        Assert.assertFalse(lq.isEmpty());
        Assert.assertEquals("Pi", lq.dequeue());
        Assert.assertFalse(lq.isEmpty());
        Assert.assertEquals("Chio", lq.dequeue());
        Assert.assertTrue(lq.isEmpty());
    }
}
