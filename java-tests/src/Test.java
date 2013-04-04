/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alejandro Pimentel
 */
public class Test {

    public static void main(String... args) throws Exception  {
        int i=0, j=0;
        cnt:
        for(i=0;i<10;i++){
            for(j=0;j<5;j++){
                continue cnt;
            }

        }
        System.out.println(i+" "+ j+"");
        Super s = new Sub();
        System.out.println(s.x);

        Long a = new Long(10);
        Integer b = new Integer(10);
        System.out.println(a.equals(b));
    }

    public double h(float f, int i){
          return f*i;
    }

    static int call(int i) {
        System.out.print(i + " ");
        return i;
    }

    public void doSome() {
        Object[] objArray = new Object[2];
        for (int i = 0; i < objArray.length; i++) {
            objArray[i] = new Object();

        }
    }
}

class Super {
    int x = 3;
}
class Sub extends Super{
    int x = 2;
}

