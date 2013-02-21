import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * User: pi
 * Date: 2/20/13
 * Time: 7:44 PM
 */
public class DequeTest {

    private Deque<String> deque = new Deque<String>();
    private Deque<String> dequeNotEmpty = new Deque<String>();

    @Before
    public void before() {
        dequeNotEmpty.addFirst("Hola");
        dequeNotEmpty.addFirst("Chio");
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void testSize() {
        Assert.assertEquals(2, dequeNotEmpty.size());
    }

    @Test
    public void testAddFirstWhenEmpty() {
        deque.addFirst("Pi");
        deque.addFirst("Alex");
        Assert.assertEquals(2, deque.size());
    }

    @Test
    public void testAddLastWhenEmpty() {
        deque.addLast("Pi");
        deque.addLast("Alex");
        Assert.assertEquals(2, deque.size());
    }

    @Test
    public void testAddFirstWhenNoEmpty() {
        dequeNotEmpty.addFirst("Pi");
        dequeNotEmpty.addFirst("Alex");
        Assert.assertEquals(4, dequeNotEmpty.size());
    }

    @Test
    public void testAddLastWhenNoEmpty() {
        dequeNotEmpty.addLast("Pi");
        dequeNotEmpty.addLast("Alex");
        Assert.assertEquals(4, dequeNotEmpty.size());
    }

    @Test
    public void testRemoveFirst() {
        Assert.assertEquals("Chio", dequeNotEmpty.removeFirst());
        Assert.assertEquals(1, dequeNotEmpty.size());
        Assert.assertEquals("Hola", dequeNotEmpty.removeFirst());
        Assert.assertEquals(0, dequeNotEmpty.size());
    }

    @Test
    public void testRemoveLast() {
        Assert.assertEquals("Hola", dequeNotEmpty.removeLast());
        Assert.assertEquals(1, dequeNotEmpty.size());
        Assert.assertEquals("Chio", dequeNotEmpty.removeLast());
        Assert.assertEquals(0, dequeNotEmpty.size());
    }
}
