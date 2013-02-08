package code.tests.problems;

import java.util.Arrays;


/**
 * 
 * The problem can be solved in the same way "Largest repeated substring" is solved.
 * 
 * Considering the string "hello pillow" the suffix array would look like:
 * 
 *   0   pillow
 *   1  ello pillow
 *   2  hello pillow
 *   3  illow
 *   4  llo pillow
 *   5  llow
 *   6  lo pillow
 *   7  low
 *   8  o pillow
 *   9  ow
 *   10 pillow
 *   12 w
 * 
 * All the suffixes alphabetically ordered are present here (the first one has a space). So,
 * the suffixes 4 and 5 share the largest common prefix (llo), which is also de "Largest repeated substring".
 * 
 * Therefore, the LCS problem can be solved building a suffix array for "hellopillow" and adding restrictions
 * for the pairs of suffixes that we'll use for getting the common prefix. (See lines 51 and 55).
 * 
 * Sources: 
 * @see <a href="http://goo.gl/g3xzd">http://goo.gl/g3xzd</a>
 * @see <a href="http://goo.gl/zsNy0">Wiki suffix array.</a>
 *
 * @author Alejandro Pimentel
 * 
 */
public class LargestCommonSubstring {

    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = "pillow";
        int length2 = string2.length();

        String[] sa = buildAdjacentSuffixes(string1 + string2);

        String lcsCandidate = "";
        for (int i = 1; i < sa.length; i++) {

            // when adjacent suffixes are <= than string2 they are from the string2
            // so we must ignore them.
            if (sa[i].length() <= length2 && sa[i-1].length() <= length2) 
                continue;

            // we also must ignore them when both of them come from the first string (string1).
            if (sa[i].length() > length2 && sa[i-1].length() > length2) 
                continue;

            // when both preffixes (i and i-1) are from different input strings we need
            // to know their largest common prefix. 
            String prefix = largestCommonPrefix(sa[i], sa[i-1]);
            if (prefix.length() > lcsCandidate.length())
                lcsCandidate = prefix;
        }

        System.out.println("Largest common substring: '" + lcsCandidate + "'");
        printSuffixes(sa);
    }
    
    private static String[] buildAdjacentSuffixes(String s) {
        String[] suffixes = new String[s.length()];
        for (int i = 0; i < s.length(); i++)
            suffixes[i] = s.substring(i);
        Arrays.sort(suffixes);
        
        return suffixes;
    }    
    
    private static String largestCommonPrefix(String s, String t) {
        int min = Math.min(s.length(), t.length());
        String prefix = "";
        for (int i = 0; i < min; i++)
            if (s.charAt(i) != t.charAt(i)) break;
            else prefix += s.charAt(i);
        
        return prefix;
    }    
    
    public static void printSuffixes(String[] suffixes) {
        StringBuilder sb = new StringBuilder();
        for (String s : suffixes) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }    
    
}
