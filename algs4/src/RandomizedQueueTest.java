import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * User: pi
 * Date: 2/20/13
 * Time: 9:35 PM
 */
public class RandomizedQueueTest {

    private RandomizedQueue<String> rq;
    private RandomizedQueue<String> notEmpty;

    @Before
    public void before() {
        rq = new RandomizedQueue<String>();
        notEmpty = new RandomizedQueue<String>();
        notEmpty.enqueue("Adios");
        notEmpty.enqueue("Pi");
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(rq.isEmpty());
    }

    @Test
    public void testSize() {
        notEmpty.enqueue("Yeee");
        Assert.assertEquals(3, notEmpty.size());
    }

    @Test
    public void testEnqueueWhenEmpty() {
        rq.enqueue("Hola");
        rq.enqueue("Chio");
        Assert.assertEquals(2, rq.size());
    }

    @Test
    public void testDequeue() {
        String item = notEmpty.dequeue();
        Assert.assertTrue(item.equals("Adios") || item.equals("Pi"));
        Assert.assertEquals(1, notEmpty.size());
    }

    @Test
    public void testSample() {
        rq.enqueue("Hola");
        rq.enqueue("Chio");
        rq.enqueue("Bonita");
        String item = rq.sample();
        Assert.assertTrue(item.equals("Hola") || item.equals("Chio")
                || item.equals("Bonita"));
    }

    @Test
    public void testIterator() {
        rq.enqueue("Hola");
        rq.enqueue("Chio");
        rq.enqueue("Bonita");
        rq.enqueue("Chumina");

        int count = 0;
        for (String s : rq) {
            Assert.assertTrue(s.equals("Hola") || s.equals("Chio")
                    || s.equals("Bonita") || s.equals("Chumina"));
            count++;
        }
        Assert.assertEquals(4, count);
        rq.dequeue();
        rq.dequeue();
        count = 0;
        for (String s : rq) {
            Assert.assertTrue(s.equals("Hola") || s.equals("Chio")
                    || s.equals("Bonita") || s.equals("Chumina"));
            count++;
        }
        Assert.assertEquals(2, count);
    }

    private RandomizedQueue<Integer> createRq(int size) {
        RandomizedQueue<Integer> rqi = new RandomizedQueue<Integer>();

        for (int i = 1; i <= size; i++) {
            rqi.enqueue(i);
        }

        return rqi;
    }

    @Test
    public void testDequeueBigOne() {
        int size = 5000000;
        RandomizedQueue<Integer> rqi = createRq(size);

        int i;
        for (i = 1; i <= size; i++) {
            int num = rqi.dequeue();
            Assert.assertTrue(num >= 1 && num <= size);
        }
        Assert.assertEquals(size, i-1);
    }

    @Test
    public void testBigIteration() {
        int size = 5000000;
        RandomizedQueue<Integer> rqi = createRq(size);

        int count = 0;
        for (int num : rqi) {
            Assert.assertTrue(num >= 1 && num <= size);
            count++;
        }
        Assert.assertEquals(size, count);
    }
}
