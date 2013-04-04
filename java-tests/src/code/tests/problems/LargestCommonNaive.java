package code.tests.problems;

/**
 * User: pi
 * Date: 3/25/13
 * Time: 10:33 AM
 */
public class LargestCommonNaive {

    public static String clsn(String... args) {
        String str1 = args[0].length() <= args[1].length() ? args[0]:args[1];
        String str2 = args[0].length() > args[1].length() ? args[0]:args[1];
        String last = "";
        String current = "";
        int idx1 = 0;
        int idx2 = 0;

        // hello   pillowhell   hello
        // xxx zzzz
        while (idx2 < str2.length()) {
            if(str1.charAt(idx1) == str2.charAt(idx2))
                current += str2.charAt(idx2++);
              //else
               // current = "";
            idx1++;
            if(current.length() > last.length())
                last = current;

            if(idx1 >= str1.length()) {
                idx1 = 0;
                idx2++;
                current = "";
            }
        }

        return last;
    }
}
