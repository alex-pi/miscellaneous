package code.tests.problems;

/**
 * User: pi
 * Date: 4/3/13
 * Time: 11:00 AM
 */
public class LargestCommonSubstringNaive2 {

    public static String lcs(String s1, String s2) {
        String tmp = s2;
        if(s2.length() < s1.length()) {
            s2 = s1;
            s1 = tmp;
        }
        String largest = "";
        int idx1 = 0;
        int idx2 = 0;

        while(idx2 < s2.length()) {
            if(idx1 >= s1.length()) {
                idx1 = 0;
                idx2++;
            }

            int end = nextSubstring(s1, s2, idx1, idx2);

            if(end > idx2 && largest.length() < (end - idx2)) {
                largest = s2.substring(idx2, end);
                idx2++;
                idx1 = 0;
            } else {
                idx1++;
            }
        }

        return largest;
    }

    protected static int nextSubstring(String s1, String s2, int idx1, int idx2) {

        while(s1.length() > idx1 && s2.length() > idx2 && s1.charAt(idx1) == s2.charAt(idx2)) {
            idx1++;
            idx2++;
        }

        return idx2;
    }
}
