package code.coursera.algorithms.w1;

import code.coursera.algorithms.w1.QuickUnionUF;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: pi
 * Date: 2/7/13
 * Time: 8:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class QuickUnionUFTest {

    private QuickUnionUF quSplitted;
    private QuickUnionUF qu;
    private QuickUnionUF qum;
    private QuickUnionUF qucon;

    @Before
    public void before(){
        this.quSplitted = new QuickUnionUF(10);
        this.qu = new QuickUnionUF(10);
        this.qum = new QuickUnionUF(new int[]{0,1,9,4,9,6,6,7,8,9});
        this.qucon = new QuickUnionUF(new int[]{1,8,1,8,3,0,5,1,8,8});
        //uf.union(3,6).union(2,4).union(6,2);
    }

    @Test
    public void testInit(){
        QuickUnionUF quf = new QuickUnionUF(10);

        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, quf.getId());

        QuickUnionUF quf2 = new QuickUnionUF(new int[]{0,1,9,4,9,6,6,7,8,9});

        Assert.assertArrayEquals(new int[]{0,1,9,4,9,6,6,7,8,9}, quf2.getId());
    }

    @Test
    public void testRoot(){
        Assert.assertEquals(9, qum.root(2));
        Assert.assertEquals(9, qum.root(4));
        Assert.assertEquals(9, qum.root(3));
        Assert.assertEquals(9, qum.root(9));
        Assert.assertEquals(7, qum.root(7));
        Assert.assertEquals(6, qum.root(5));
    }

    @Test
    public void testConnectedWhenUnconnected(){
        Assert.assertFalse(quSplitted.connected(2,9));
        Assert.assertFalse(quSplitted.connected(1,3));
        Assert.assertFalse(quSplitted.connected(4,7));
    }

    @Test
    public void testConnectedWhenAllConnected(){
        Assert.assertTrue(qucon.connected(2,9));
        Assert.assertTrue(qucon.connected(1,3));
        Assert.assertTrue(qucon.connected(4,7));
    }

    @Test
    public void testConnected(){
    }

    @Test
    public void testUnion(){
        quSplitted.union(4,3)
                .union(3,8)
                .union(6,5)
                .union(9,4)
                .union(2,1)
                .union(5,0)
                .union(7,2)
                .union(6,1)
                .union(7,3)
                ;
        Assert.assertArrayEquals(new int[]{1,8,1,8,3,0,5,1,8,8}, quSplitted.getId());
    }
}
