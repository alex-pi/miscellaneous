package code.coursera.algorithms.w2;

import code.coursera.algorithms.w2.ArrayStack;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

/**
 * User: pi
 * Date: 2/19/13
 * Time: 11:09 AM
 */
public class ArrayStackTest {

    ArrayStack<String> as = new ArrayStack();

    @Test
    public void isEmptyWhenEmpty() {
        Assert.assertTrue(as.isEmpty());
    }

    @Test
    public void testPush() {
        as.push("Hola ").push("qué hace");
        Assert.assertFalse(as.isEmpty());
    }

    @Test
    public void testPop() {
        as.push("Hola ").push("qué hace");
        Assert.assertEquals("qué hace", as.pop());
        Assert.assertEquals("Hola ", as.pop());
        Assert.assertTrue(as.isEmpty());
    }

    @Test
    public void testPopWhenEmpty() {
        Assert.assertEquals(null, as.pop());
    }

    @Test
    public void testGrow() {
        as.push("Hola ")
                .push("qué hace");
        Object[] array = (Object[]) Whitebox.getInternalState(this.as, "array");
        Assert.assertEquals(2, array.length);

        as.push("Alex");
        array = (Object[]) Whitebox.getInternalState(this.as, "array");
        Assert.assertEquals(4, array.length);

        as.push("Pi").push("Chio");
        array = (Object[]) Whitebox.getInternalState(this.as, "array");
        Assert.assertEquals(8, array.length);
    }
}
