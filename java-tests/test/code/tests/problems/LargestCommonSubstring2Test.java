package code.tests.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: pi
 * Date: 4/3/13
 * Time: 3:18 PM
 */
public class LargestCommonSubstring2Test extends LargestCommonSubstring2 {
    
    @Test
    public void testLargestSubstring(){
        String ss = LargestCommonSubstring2.nextSubstring("llox", "llow");

        Assert.assertEquals("llo", ss);
    }

    @Test
    public void testLargestSubstringWhenNoInitialMatch() {
        String ss = LargestCommonSubstring2.nextSubstring("hello", "pillow");

        Assert.assertEquals("", ss);
    }

    @Test
    public void testLargestSubstringWhenOneLetterMatch() {
        String ss = LargestCommonSubstring2.nextSubstring("llox", "low");

        Assert.assertEquals("l", ss);
    }

    @Test
    public void testBuildIndexes() {
        String[] indxs = LargestCommonSubstring2.buildSuffixes("hello");

        Assert.assertArrayEquals(new String[]{"ello","hello","llo","lo","o"}, indxs);
    }

    @Test
    public void testSimple() {
        String l = LargestCommonSubstring2.lcs("hello", "pillow");

        Assert.assertEquals("llo", l);
    }

    @Test
    public void testBiggerFirst() {
        String l = LargestCommonSubstring2.lcs("pillow", "hello");

        Assert.assertEquals("llo", l);
    }

    @Test
    public void testLcsWhenLargestAhead() {
        String l = LargestCommonSubstring2.lcs("hello", "pillow hell");
        Assert.assertEquals("hell", l);
    }

    @Test
    public void testLcsWhenLargestAhead2() {
        String l = LargestCommonSubstring2.lcs("rhello w","pillowhelloh");
        Assert.assertEquals("hello", l);
    }

    @Test
    public void testLcsWhenLargestAtBeginning() {
        String l = LargestCommonSubstring2.lcs("hello llow","pillowhelloh");
        Assert.assertEquals("hello", l);
    }

    @Test
    public void testLcsWhenFirstStringIsBigger() {
        String l = LargestCommonSubstring2.lcs("pillowhelloh jg", "hello llow");
        Assert.assertEquals("hello", l);
    }

    @Test
    public void testLcsDegenerated() {
        String l = LargestCommonSubstring2.lcs("xxxxzzzz", "yyy");
        Assert.assertEquals("", l);
    }
}
