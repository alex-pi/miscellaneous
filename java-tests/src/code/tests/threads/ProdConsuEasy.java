/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.threads;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Pimentel
 */
public class ProdConsuEasy {
    
    
    class Consumer implements Runnable {
        private final List<Integer> source;
        private Integer toConsume = 100;
        private Integer consumed = 0;
        
        public Consumer(List<Integer> source){
            this.source = source;
        }
        
        public void run(){
            while(consumed<=100){
                synchronized(source){
                    while(source.isEmpty()){
                        synchronized(source) {
                            try {
                                wait();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ProdConsuEasy.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }                        
                    }
                }
            }
        }
    }
    
    class Producer implements Runnable {
        private final List<Integer> source;
        private Integer max = 10;
        
        public Producer(List<Integer> source){
            this.source = source;
        }
        
        @Override
        public void run(){
            for(int i=1; i<=100 ; i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProdConsuEasy.class.getName()).log(Level.SEVERE, null, ex);
                }
                synchronized(source) {
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProdConsuEasy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Producing: " + i);
                source.add(i);
            }            
        }
    }

}
