/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro Pimentel
 */
public final class Test4 {
    class Inner {
        void test() {
            if(Test4.this.flag); {
                sample();
            }
        }
    }
    
    private boolean flag = false;
    
    public void sample(){
        System.out.println("Sample");
    }
    
    public Test4(){
        (new Inner()).test();
    }
    
    public static void main(String args[]){
        new Test4();
    }

}
