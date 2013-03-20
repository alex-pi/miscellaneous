package code.coursera.algorithms.w1;

import code.coursera.algorithms.w1.WeightedQuickUnion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * User: pi
 * Date: 2/8/13
 * Time: 6:27 PM
 */
public class WeightedQuickUnionTest {

    private WeightedQuickUnion wqu;

    @Before
    public void setUp() throws Exception {
        wqu = new WeightedQuickUnion(10);
    }

    @Test
    public void testInit() {
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, wqu.getId());
        Assert.assertArrayEquals(new int[]{1,1,1,1,1,1,1,1,1,1}, wqu.getSize());
    }

    @Test
    public void testUnion() {
        wqu.union(4,3);
        Assert.assertArrayEquals(new int[]{0,1,2,4,4,5,6,7,8,9}, wqu.getId());
        Assert.assertArrayEquals(new int[]{1,1,1,1,2,1,1,1,1,1}, wqu.getSize());
        wqu.union(3,8);
        Assert.assertArrayEquals(new int[]{0,1,2,4,4,5,6,7,4,9}, wqu.getId());
        Assert.assertArrayEquals(new int[]{1,1,1,1,3,1,1,1,1,1}, wqu.getSize());
        wqu.union(6,5);
        Assert.assertArrayEquals(new int[]{0,1,2,4,4,6,6,7,4,9}, wqu.getId());
        Assert.assertArrayEquals(new int[]{1,1,1,1,3,1,2,1,1,1}, wqu.getSize());
        wqu.union(9,4);
        Assert.assertArrayEquals(new int[]{0,1,2,4,4,6,6,7,4,4}, wqu.getId());
        Assert.assertArrayEquals(new int[]{1,1,1,1,4,1,2,1,1,1}, wqu.getSize());
        wqu.union(2,1);
        Assert.assertArrayEquals(new int[]{0,2,2,4,4,6,6,7,4,4}, wqu.getId());
        Assert.assertArrayEquals(new int[]{1,1,2,1,4,1,2,1,1,1}, wqu.getSize());
        wqu.union(5,0);
        Assert.assertArrayEquals(new int[]{6,2,2,4,4,6,6,7,4,4}, wqu.getId());
        Assert.assertArrayEquals(new int[]{1,1,2,1,4,1,3,1,1,1}, wqu.getSize());
        wqu.union(7,2);
        Assert.assertArrayEquals(new int[]{6,2,2,4,4,6,6,2,4,4}, wqu.getId());
        Assert.assertArrayEquals(new int[]{1,1,3,1,4,1,3,1,1,1}, wqu.getSize());
        wqu.union(6,1);
        Assert.assertArrayEquals(new int[]{6,2,6,4,4,6,6,2,4,4}, wqu.getId());
        Assert.assertArrayEquals(new int[]{1,1,3,1,4,1,6,1,1,1}, wqu.getSize());
        wqu.union(7,3);
        Assert.assertArrayEquals(new int[]{6,2,6,4,6,6,6,2,4,4}, wqu.getId());
        Assert.assertArrayEquals(new int[]{1,1,3,1,4,1,10,1,1,1}, wqu.getSize());
    }
}
