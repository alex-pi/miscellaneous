/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.threads;

/**
 *
 * @author Alejandro Pimentel
 */
public class ThreadInteraction {

    public static void main(String [] args) throws InterruptedException {
        ThreadB b = new ThreadB();
        b.start();
        Thread.sleep(5000);
        synchronized(b) {
            try {
                System.out.println("Waiting for b to complete...");
                b.wait();
            } catch (InterruptedException e) {System.out.println("Interrumpido...");}
            System.out.println("Total is: " + b.total);
        }
    }
    
}
