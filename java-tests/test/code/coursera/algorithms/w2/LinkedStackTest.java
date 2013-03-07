package code.coursera.algorithms.w2;

import code.coursera.algorithms.w2.LinkedStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * User: pi
 * Date: 2/19/13
 * Time: 11:09 AM
 */
public class LinkedStackTest {

    LinkedStack<String> ls = new LinkedStack();

    @Test
    public void isEmptyWhenEmpty() {
        Assert.assertTrue(ls.isEmpty());
    }

    @Test
    public void testPush() {
        ls.push("Hola ").push("qué hace");
        Assert.assertFalse(ls.isEmpty());
    }

    @Test
    public void testPop() {
        ls.push("Hola ").push("qué hace");
        Assert.assertEquals("qué hace", ls.pop());
        Assert.assertEquals("Hola ", ls.pop());
        Assert.assertTrue(ls.isEmpty());
    }

    @Test
    public void testPopWhenEmpty() {
        Assert.assertEquals(null, ls.pop());
    }

    @Test
    public void testIteration() {
        ls.push("Hola ").push("qué hace");

        int count = 0;
        for(String s : ls) {
            count++;
            System.out.println(s);
        }

        Assert.assertEquals(2, count);
    }
}
