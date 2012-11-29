/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.structures;

/**
 *
 * @author Alejandro Pimentel
 */
public class SuffixTreeMain {
    
    public static void main(String... args){
        //SuffixTree st = SuffixTree.build("BANANA");
        SuffixTree st2 = SuffixTree.build("CAGTCAGG");
        
        System.out.println(st2);
    }
}
