package code.coursera.algorithms.w3;

import code.util.ArrayGenerator;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * User: pi
 * Date: 3/8/13
 * Time: 5:34 PM
 */
public class SelectionKthTest {

    private Integer[] small;
    private Integer[] big;

    @Before
    public void before() {
        small = new Integer[]{3, 5, 1, 8, 4, 2};
        big = ArrayGenerator.asc(1000000);
    }

    @Test
    public void testSelectkth() {
        Assert.assertEquals(new Integer(4), SelectionKth.<Integer>select(small, 3));
    }

    @Test
    public void testSelectMin() {
        Assert.assertEquals(new Integer(1), SelectionKth.<Integer>min(small));
    }

    @Test
    public void testSelectMax() {
        Assert.assertEquals(new Integer(8), SelectionKth.<Integer>max(small));
    }

    @Test(timeout = 5000)
    public void testBigSelectkth() {
        Assert.assertEquals(new Integer(314159), SelectionKth.<Integer>select(big, 314159));
    }
}
