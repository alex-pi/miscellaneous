package code.tests.problems;

import junit.framework.Assert;
import org.junit.Test;

/**
 * User: pi
 * Date: 4/3/13
 * Time: 11:20 AM
 */
public class LargestCommonSubstringNaive2Test extends LargestCommonSubstringNaive2 {

    @Test
    public void testLargestSubstring(){
        int end = LargestCommonSubstringNaive2.nextSubstring("hello", "pillow", 2, 2);

        Assert.assertEquals(5, end);
    }

    @Test
    public void testLargestSubstringWhenNoInitialMatch() {
        int end = LargestCommonSubstringNaive2.nextSubstring("hello", "pillow", 1, 1);

        Assert.assertEquals(1, end);
    }

    @Test
    public void testLargestSubstringWhenOneLetterMatch() {
        int end = LargestCommonSubstringNaive2.nextSubstring("hello", "pillow", 4, 4);

        Assert.assertEquals(5, end);
    }

    @Test
    public void testLargestSubstringWhenDifferentIndexes() {
        int end = LargestCommonSubstringNaive2.nextSubstring("hello", "pillow hell", 0, 7);

        Assert.assertEquals(11, end);
    }

    @Test
    public void testLcs() {
        String l = LargestCommonSubstringNaive2.lcs("hello", "pillow");
        Assert.assertEquals("llo", l);
    }

    @Test
    public void testLcsWhenLargestAhead() {
        String l = LargestCommonSubstringNaive2.lcs("hello", "pillow hell");
        Assert.assertEquals("hell", l);
    }

    @Test
    public void testLcsWhenLargestAhead2() {
        String l = LargestCommonSubstringNaive2.lcs("rhello w","pillowhelloh");
        Assert.assertEquals("hello", l);
    }

    @Test
    public void testLcsWhenLargestAtBeginning() {
        String l = LargestCommonSubstringNaive2.lcs("hello llow","pillowhelloh");
        Assert.assertEquals("hello", l);
    }

    @Test
    public void testLcsWhenLargestFirstStringIsBigger() {
        String l = LargestCommonSubstringNaive2.lcs("pillowhelloh jg", "hello llow");
        Assert.assertEquals("hello", l);
    }

    @Test
    public void testLcsDegenerated() {
        String l = LargestCommonSubstringNaive2.lcs("xxxxzzzz", "yyy");
        Assert.assertEquals("", l);
    }
}
