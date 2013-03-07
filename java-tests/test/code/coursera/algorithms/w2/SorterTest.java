package code.coursera.algorithms.w2;

import code.util.ArrayGenerator;
import code.util.StdRandom;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * User: pi
 * Date: 2/27/13
 * Time: 8:10 PM
 */
public abstract class SorterTest {

    String[] small;
    String[] smallSorted;
    Double[] big;
    Double[] notSoSmall;
    Double[] notSoBig;
    Integer[] shuffled;
    Integer[] partiallySorted;
    Integer[] reverseSorted;
    Sorter sorter;

    @Before
    public void before() {
        small = new String[]{"pi", "bob", "zoz", "fear", "all"};
        smallSorted = new String[]{"all", "bob", "fear", "pi", "zoz"};

        big = ArrayGenerator.random(100000, -1000000, 1000000);
        notSoBig = ArrayGenerator.random(1000, -10000, 10000);
        notSoSmall = ArrayGenerator.random(100, -1000, 1000);
        partiallySorted = ArrayGenerator.asc(100000);
        ArrayGenerator.exchn(4000, partiallySorted);
        reverseSorted = ArrayGenerator.desc(100000);
        shuffled = ArrayGenerator.asc(100000);
        StdRandom.shuffle(shuffled);
    }

    @Test
    public void testSmallSort() {
        sorter.sort(small);
        Assert.assertArrayEquals(smallSorted, small);
    }

    @Test
    public void testRandomBigSort() {
        sorter.sort(big);
        for (int i = 0; i < big.length-1; i++) {
            Assert.assertTrue(sorter.lessOrEqual(big[i], big[i + 1]));
        }
    }

    @Test
    public void testShuffledBigSort() {
        sorter.sort(shuffled);
        for (int i = 0; i < shuffled.length-1; i++) {
            Assert.assertTrue(sorter.lessOrEqual(shuffled[i], shuffled[i + 1]));
        }
    }

    @Test
    public void testPartialBigSort() {
        sorter.sort(partiallySorted);
        for (int i = 0; i < partiallySorted.length-1; i++) {
            Assert.assertTrue(sorter.lessOrEqual(partiallySorted[i], partiallySorted[i + 1]));
        }
    }

    @Test
    public void testRandomNotSoBigSort() {
        sorter.sort(notSoBig);
        for (int i = 0; i < notSoBig.length-1; i++) {
            Assert.assertTrue(sorter.lessOrEqual(notSoBig[i], notSoBig[i + 1]));
        }
    }

    @Test
    public void testRandomNotSoSmallSort() {
        sorter.sort(notSoSmall);
        for (int i = 0; i < notSoSmall.length-1; i++) {
            Assert.assertTrue(sorter.lessOrEqual(notSoSmall[i], notSoSmall[i + 1]));
        }
    }

    @Test
    public void testReverseBigSort() {
        sorter.sort(reverseSorted);
        for (int i = 0; i < reverseSorted.length-1; i++) {
            Assert.assertTrue(sorter.lessOrEqual(reverseSorted[i], reverseSorted[i + 1]));
        }
    }
}
