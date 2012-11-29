/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.problems;

import code.tests.structures.SuffixArray;

/**
 *
 * @author Alejandro Pimentel
 */
public class LCS {

    public static void main(String[] args) {
        String text1 = "CAGTCAGG";
        String text2 = "TCAGAGCTGA";
        int N1 = text1.length();
        int N2 = text2.length();

        SuffixArray sa = new SuffixArray(text1 + "\0" + text2);
        int N = sa.length();

        String substring = "";
        for (int i = 1; i < N; i++) {

            // adjacent suffixes both from second text string
            if (sa.select(i).length() <= N2 && sa.select(i-1).length() <= N2) continue;

            // adjacent suffixes both from first text string
            if (sa.select(i).length() > N2+1 && sa.select(i-1).length() > N2+1) continue;

            // check if adjacent suffixes longer common substring
            int length = sa.lcp(i);
            if (length > substring.length())
                substring = sa.select(i).substring(0, length);
        }

        System.out.println(substring.length());
        System.out.println("'" + substring + "'");
        System.out.println(sa);
    }
}
