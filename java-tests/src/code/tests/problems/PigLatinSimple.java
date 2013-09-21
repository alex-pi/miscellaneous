package code.tests.problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: pi
 * Date: 3/31/13
 * Time: 3:38 PM
 */
public class PigLatinSimple {

    static char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };

    public static boolean isVowel(char ch) {
        for (char vowel : vowels) {
            if (vowel == ch) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("Please enter the sentence: ");
        Scanner console= new Scanner(System.in);

        // The space we add is to allow translation of the last word in sentence.
        String sentence = console.nextLine() + " ";
        String translated = "";

        String word = "";
        for (int i = 0; i < sentence.length(); i++) {
            char nextChar = sentence.charAt(i);
            if(nextChar != ' ') {
                word += nextChar;
                continue;
            }
            char firstLetter = word.charAt(0);
            if (isVowel(firstLetter)) {
                translated += word + "way ";
            } else {
                String q = "";
                int j = 0;
                while(!isVowel(word.charAt(j))) {
                    q = q + word.charAt(j++);
                }
                translated += word.substring(j, word.length()) + q + "ay ";
            }
            word = "";
        }

        System.out.println("Original = " + sentence);
        System.out.println("Translated = " + translated);
    }
}
