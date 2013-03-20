package code.coursera.algorithms.w1;

import code.coursera.algorithms.w1.WeightedQuickUnionPathCompression;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * User: pi
 * Date: 2/11/13
 * Time: 2:40 PM
 */
public class WeightedQuickUnionPathCompressionTest {

    private WeightedQuickUnionPathCompression wqcpc;
    private static final int SIZE = 1000000;
    private static final int MOVS = 10000000;

    @Before
    public void setUp() throws Exception {
        wqcpc = new WeightedQuickUnionPathCompression(10);
    }

    private void unionSteps(){
        wqcpc.union(3,6)
                .union(5, 3)
                .union(1, 2)
                .union(2, 6);
    }

    @Test
    public void testUnion(){
        wqcpc.union(3,6);
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,3,7,8,9}, wqcpc.getId());
        Assert.assertArrayEquals(new int[]{1,1,1,2,1,1,1,1,1,1}, wqcpc.getSize());
        wqcpc.union(5,3);
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,3,3,7,8,9}, wqcpc.getId());
        Assert.assertArrayEquals(new int[]{1,1,1,3,1,1,1,1,1,1}, wqcpc.getSize());
        wqcpc.union(1,2);
        Assert.assertArrayEquals(new int[]{0,1,1,3,4,3,3,7,8,9}, wqcpc.getId());
        Assert.assertArrayEquals(new int[]{1,2,1,3,1,1,1,1,1,1}, wqcpc.getSize());
        wqcpc.union(2,6);
        Assert.assertArrayEquals(new int[]{0,3,1,3,4,3,3,7,8,9}, wqcpc.getId());
        Assert.assertArrayEquals(new int[]{1,2,1,5,1,1,1,1,1,1}, wqcpc.getSize());
    }

    @Test(timeout = 1500)
    public void testUnionTime(){
        WeightedQuickUnionPathCompression bigWqcpc = new WeightedQuickUnionPathCompression(SIZE);
        Random ran = new Random();
        for(int n = 0; n < MOVS; n++){
            int p = ran.nextInt(SIZE);
            int q = ran.nextInt(SIZE);
            bigWqcpc.union(p, q);
        }
    }

    @Test
    public void testInit() {
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, wqcpc.getId());
        Assert.assertArrayEquals(new int[]{1,1,1,1,1,1,1,1,1,1}, wqcpc.getSize());
    }

    @Test
    public void testConnected(){
        this.unionSteps();
        Assert.assertArrayEquals(new int[]{0,3,1,3,4,3,3,7,8,9}, wqcpc.getId());
        Assert.assertArrayEquals(new int[]{1,2,1,5,1,1,1,1,1,1}, wqcpc.getSize());
        Assert.assertTrue(wqcpc.connected(3,5));
        Assert.assertTrue(wqcpc.connected(2,5));
        Assert.assertFalse(wqcpc.connected(0,1));
        Assert.assertFalse(wqcpc.connected(7,8));
    }
}
