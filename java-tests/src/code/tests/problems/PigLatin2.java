package code.tests.problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: pi
 * Date: 3/31/13
 * Time: 3:38 PM
 */
public class PigLatin2 {
    public static void main(String[] args) {

        System.out.println("Please enter the sentence: ");
        Scanner console= new Scanner(System.in);

        String sentence = console.nextLine();
        StringBuilder translated = new StringBuilder();
        String[] words = sentence.split("\\W+");
        Pattern rule1 = Pattern.compile("^[aeiouAEIOU]");
        Pattern rule2 = Pattern.compile("[^aeiouAEIOU]+");

        for (String word : words) {
            Matcher m1 = rule1.matcher(word);
            if(m1.find()){
                translated.append(word).append("way ");
            } else {
                Matcher m2 = rule2.matcher(word);
                m2.find();
                String pre = m2.group();
                translated.append(word.substring(m2.end())).append(pre).append("ay ");
            }
        }
        System.out.println("Original = " + sentence);
        System.out.println("Translated = " + translated);
    }
}
