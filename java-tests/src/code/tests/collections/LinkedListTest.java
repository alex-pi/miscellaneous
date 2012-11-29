/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.collections;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Alejandro Pimentel
 */
public class LinkedListTest {
    
    public static void main(String... args){
        LinkedList<String> ll1 = new LinkedList();
                
        // Adds to the end of the queue (FIFO).
        // offer considers size restrictions
        ll1.offer("Alex");
        ll1.offer("Chio");
        ll1.offer("Redo");
        ll1.offer("Monin");
        
        System.out.println(ll1);
        // This one gives "Alex" without removing it
        System.out.println(ll1.peek());
        // poll removes the on head element
        System.out.println(ll1.poll());
        System.out.println(ll1);
        
        ll1.offer("Alex");
        System.out.println(ll1);
        
        // Same as peek but throwing exception when the col is empty.
        System.out.println(ll1.element());
        
        /*Using it as a stack*/
        ll1.push("Carlos");
        System.out.println(ll1);
        System.out.println(ll1.pop());
        System.out.println(ll1.peek());
        
        // The sort is not an "in place sort", it uses an auxiliary array.
        // This avoids the performance hit of ordering a LinkedList which is (n² log n)
        Collections.sort(ll1);
        System.out.println(ll1);
    }

}
