/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.collections;

import java.util.TreeSet;

/**
 *
 * @author Alejandro Pimentel
 */
public class TreeSetTest {
    
    public static void main(String... args){
        TreeSet<String> tree = new TreeSet();
        
        tree.add("Alex");
        tree.add("Carlos");
        tree.add("Redo");
        tree.add("Chio");
        tree.add("Adriana");
        tree.add("Nancy");
        tree.add("Monin");
        
        System.out.println(tree.headSet("Gloria"));
        System.out.println(tree.ceiling("Chumina"));
        
    }

}
