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
public class ThreadB extends Thread {
    int total = -1;

    public void run() {
        synchronized(this) {
            for(int i=0;i<100;i++) {
                total += i;
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            notify();
        }
    }
}
