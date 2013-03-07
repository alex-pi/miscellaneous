package code.coursera.algorithms.w1;

import code.coursera.algorithms.w1.QuickFind;
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
public class QuickFindTest {

    private QuickFind ufSplitted;
    private QuickFind uf;

    @Before
    public void before(){
        this.ufSplitted = new QuickFind(10);
        this.uf = new QuickFind(10);
        uf.union(3,6).union(2,4).union(6,2);
    }

    @Test
    public void testInit(){
        QuickFind uf = new QuickFind(10);
        int[] ids =  uf.getId();

        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, ids);
    }

    @Test
    public void testConnectedWhenInitialized(){
        Assert.assertFalse(this.ufSplitted.connected(2, 7));
    }

    @Test
    public void testConnected(){
        Assert.assertFalse(this.uf.connected(2, 7));
        Assert.assertTrue(this.uf.connected(2, 3));
    }

    @Test
    public void testUnion(){
        ufSplitted.union(3, 6);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 6, 4, 5, 6, 7, 8, 9}, ufSplitted.getId());
        ufSplitted.union(2,4);
        Assert.assertArrayEquals(new int[]{0, 1, 4, 6, 4, 5, 6, 7, 8, 9}, ufSplitted.getId());
        ufSplitted.union(6, 2);
        Assert.assertArrayEquals(new int[]{0,1,4,4,4,5,4,7,8,9}, ufSplitted.getId());
    }
}
