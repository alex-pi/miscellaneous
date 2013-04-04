package code.tests.problems;

import java.util.HashSet;
import java.util.Scanner;

/**
 * User: pi
 * Date: 3/31/13
 * Time: 2:55 PM
 */
public class PigLatin1 {
    public static void main(String[] args) {

        Scanner console= new Scanner(System.in);
        HashSet vowels = new HashSet();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");
        System.out.println("Please enter the word: ");
        String sentence = console.nextLine();
        String pigLatin = "";
        String[] words = sentence.split(" ");

        for (String word : words) {
            String t = "";
            if (vowels.contains(word.charAt(0)+"")) {
                t += word + "way ";
            } else {
                String q = "";
                int i = 0;
                while(!vowels.contains(word.charAt(i)+"")) {
                    q = q + word.charAt(i++);
                }
                t = word.substring(i, word.length()) + q + "ay";
            }
            pigLatin += t + " ";
        }
        System.out.println("Original = " + sentence);
        System.out.println("Translated = " + pigLatin);
    }
}
