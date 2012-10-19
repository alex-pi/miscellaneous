/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Pimentel
 */
public class Counter implements Runnable{
    
    public static void main(String... args) throws InterruptedException{
        Thread t = new Thread(new Counter());
        t.start();
        t.join();
        
        System.out.println("The main joins the counter. ");
    }

    @Override
    public void run(){
        for (int i = 1; i <= 100; i++) {
            System.out.println("Counter says: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(i % 10 == 0){
                System.out.println("Ten more: " + i);
            }
        }
    }
}
