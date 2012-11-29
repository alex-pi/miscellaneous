/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.collections;

import java.util.LinkedHashSet;

/**
 *
 * @author Alejandro Pimentel
 */
public class LinkedHashSetTest {
    
    public static void main(String... args){
        LinkedHashSet<String> s1 = new LinkedHashSet();
        
        s1.add("Alex");
        s1.add("Chio");
        
        for(String s : s1){
            System.out.println(s);
        }
    }

}
