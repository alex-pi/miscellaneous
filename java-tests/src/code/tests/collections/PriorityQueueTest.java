/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.collections;

import java.util.PriorityQueue;

/**
 *
 * @author Alejandro Pimentel
 */
public class PriorityQueueTest {

    public static void main(String... args){
        PriorityQueue<String> pq1 = new PriorityQueue(2);
        
        pq1.offer("Paco");
        pq1.offer("Alex");
        pq1.offer("Chio");
        pq1.offer("Redo");        
        pq1.offer("Monin");        
                
        
        System.out.println(pq1.peek());
        pq1.offer("Ups!"); 
        System.out.println(pq1);
    }
}
