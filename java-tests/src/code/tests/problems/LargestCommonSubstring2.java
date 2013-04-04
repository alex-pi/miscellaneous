package code.tests.problems;

import java.util.Arrays;

/**
 * User: pi
 * Date: 4/3/13
 * Time: 3:13 PM
 */
public class LargestCommonSubstring2 {

    public static String lcs(String s1, String s2) {
        String largest = "";
        String[] suff1 = buildSuffixes(s1);
        String[] suff2 = buildSuffixes(s2);
        int idx1 = 0;
        int idx2 = 0;

        while(idx1 < suff1.length && idx2 < suff2.length) {
            if(suff1[idx1].charAt(0) < suff2[idx2].charAt(0)){
                idx1++;
                idx2=0;
            }  else {
                String found = nextSubstring(suff1[idx1], suff2[idx2]);
                if(found.length() > largest.length())
                    largest = found;
                idx2++;
            }
        }

        return largest;
    }

    protected static String[] buildSuffixes(String s) {
        String[] indexes = new String[s.length()];
        String lastIndex = "";

        for(int i = s.length()-1; i>=0; i--) {
            indexes[i] = s.charAt(i) + lastIndex;
            lastIndex = indexes[i];
        }

        Arrays.sort(indexes);
        return indexes;
    }

    protected static String nextSubstring(String s1, String s2) {
        int idx = 0;

        while(idx < s1.length() && idx < s2.length() && s1.charAt(idx) == s2.charAt(idx))
            idx++;

        return s1.substring(0, idx);
    }
}
