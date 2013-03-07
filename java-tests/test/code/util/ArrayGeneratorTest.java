package code.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * User: pi
 * Date: 2/27/13
 * Time: 7:28 PM
 */
public class ArrayGeneratorTest {

    Integer[] arr;
    Integer[] nums;
    Integer[] numsCopy;

    @Before
    public void before() {
        nums = new Integer[]{0,1,2,3,4,5};
        numsCopy = new Integer[]{0,1,2,3,4,5};
    }

    @Test
    public void testOrderedAsc() {
        arr = ArrayGenerator.asc(10);
        Assert.assertArrayEquals(new Integer[]{0,1,2,3,4,5,6,7,8,9}, arr);
    }

    @Test
    public void testOrderedDesc() {
        arr = ArrayGenerator.desc(10);
        Assert.assertArrayEquals(new Integer[]{9,8,7,6,5,4,3,2,1,0}, arr);
    }

    @Test
    public void testExchn() {
        int changed = ArrayGenerator.exchn(3, nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!nums[i].equals(numsCopy[i]))
                count++;
        }

        Assert.assertTrue(count > 0 && count <= changed * 2);
    }
}
