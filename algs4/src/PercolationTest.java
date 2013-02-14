import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

/**
 * User: pi
 * Date: 2/13/13
 * Time: 10:27 AM
 */
public class PercolationTest {

    private Percolation percolation;
    private int top;
    private int bottom;

    @Before
    public void setUp() throws Exception {
        this.percolation = new Percolation(5);
        top = Whitebox.getInternalState(this.percolation, "top", Percolation.class, int.class);
        bottom = Whitebox.getInternalState(this.percolation, "bottom", Percolation.class, int.class);
    }

    @Test
    public void testInit() {
        boolean[][] grid = Whitebox.getInternalState(this.percolation, "grid");
        int n = Whitebox.getInternalState(this.percolation, "n", Percolation.class, int.class);

        Assert.assertEquals(5, n);
        Assert.assertEquals(25, top);
        Assert.assertEquals(26, bottom);
        for (boolean[] row : grid) {
            for (boolean val : row) {
                Assert.assertFalse(val);
            }
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOpenWhenOutOfBounds() {
        percolation.open(6, 5);
    }

    @Test
    public void testOpen() {
        percolation.open(1, 2);
        percolation.open(1, 1);
        percolation.open(3, 2);
        boolean[][] grid = Whitebox.getInternalState(this.percolation, "grid");

        Assert.assertTrue(grid[0][1]);
        Assert.assertTrue(grid[0][0]);
        Assert.assertTrue(grid[2][1]);
        Assert.assertFalse(grid[3][1]);

        WeightedQuickUnionUF wquf = Whitebox.getInternalState(this.percolation, "wquf");
        Assert.assertTrue(wquf.connected(0, 1));
        Assert.assertTrue(wquf.connected(top, 1));

        percolation.open(2, 2);
        Assert.assertTrue(wquf.connected(top, 6));
        Assert.assertFalse(wquf.connected(top, 5));
        Assert.assertFalse(wquf.connected(6, 5));

        Assert.assertFalse(wquf.connected(bottom, 24));
        percolation.open(5, 5);
        Assert.assertTrue(wquf.connected(bottom, 24));
    }

    @Test
    public void testPercolates() {
        Assert.assertFalse(this.percolation.percolates());
        openSitesWithOutPercolating();
        Assert.assertFalse(this.percolation.percolates());
        percolation.open(3, 3);
        Assert.assertFalse(this.percolation.percolates());
        percolation.open(4, 2);
        Assert.assertTrue(this.percolation.percolates());
    }

    @Test
    public void testPercolationWhenNIs1() {
        Percolation p = new Percolation(1);
        Assert.assertFalse(p.percolates());
        Assert.assertFalse(p.isFull(1, 1));
        p.open(1, 1);
        Assert.assertTrue(p.percolates());
        Assert.assertTrue(p.isFull(1, 1));
    }

    @Test
    public void testPercolationWhenNIs2() {
        Percolation p = new Percolation(2);
        Assert.assertFalse(p.percolates());
        Assert.assertFalse(p.isFull(1, 1));
        Assert.assertFalse(p.isFull(2, 2));
        p.open(1, 1);
        Assert.assertFalse(p.percolates());
        Assert.assertTrue(p.isFull(1, 1));
        Assert.assertFalse(p.isFull(2, 2));
        p.open(1, 2);
        Assert.assertFalse(p.percolates());
        Assert.assertTrue(p.isFull(1, 1));
        Assert.assertFalse(p.isFull(2, 2));
        p.open(2, 1);
        Assert.assertTrue(p.percolates());
        Assert.assertTrue(p.isFull(1, 1));
        Assert.assertTrue(p.isFull(1, 2));
        Assert.assertTrue(p.isFull(2, 1));

        Assert.assertFalse(p.isOpen(2, 2));
        Assert.assertFalse(p.isFull(2, 2));
    }

    @Test
    public void testIsOpen() {
        openSitesWithOutPercolating();
        Assert.assertTrue(this.percolation.isOpen(3, 5));
        Assert.assertFalse(this.percolation.isOpen(5, 3));
    }

    @Test
    public void testIsFull() {
        openSitesWithOutPercolating();
        Assert.assertTrue(this.percolation.isFull(3, 5));
        Assert.assertTrue(this.percolation.isFull(1, 1));
        Assert.assertFalse(this.percolation.isFull(5, 1));
    }

    @Test(timeout = 500)
    public void testPercolatesTiming() {
        Percolation p = new Percolation(1024);

        while (!p.percolates()) {
            int r, c;
            do {
                r = StdRandom.uniform(1024) + 1;
                c = StdRandom.uniform(1024) + 1;
            } while(p.isOpen(r, c));

            p.open(r, c);
        }
    }

    private void openSitesWithOutPercolating() {
        percolation.open(1, 2);
        percolation.open(1, 1);

        percolation.open(3, 2);

        percolation.open(1, 4);
        percolation.open(2, 4);
        percolation.open(3, 4);
        percolation.open(3, 5);

        percolation.open(4, 1);
        percolation.open(5, 1);
        percolation.open(5, 2);

        percolation.open(4, 3);

        percolation.open(5, 4);
        percolation.open(5, 5);
    }
}
