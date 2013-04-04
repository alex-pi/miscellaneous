package code.tests.problems;

import junit.framework.Assert;
import org.junit.Test;

/**
 * User: pi
 * Date: 3/25/13
 * Time: 12:30 PM
 */
public class LargestCommonNaiveTest {

    @Test
    public void testEasy() {
        String r = LargestCommonNaive.clsn("hello","pillow");
        Assert.assertEquals("llo",r);
    }

    @Test
    public void testAtTheEnd() {
        String r = LargestCommonNaive.clsn("hello","pillow hell");
        Assert.assertEquals("hell",r);
    }

    @Test
    public void testEnclosed() {
        String r = LargestCommonNaive.clsn("rhello w","pillowhelloh");
        Assert.assertEquals("hello",r);
    }
}
