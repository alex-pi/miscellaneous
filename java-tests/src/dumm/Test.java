/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumm;

import dumm.Test.MyClass;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro Pimentel
 */
public class Test<T extends MyClass> {

    public static void main(String[] args) {
String str = null;
//str = reader.readln();

switch(str) {
case "comando1":
    System.out.println("LOL");
//ejecutaComando1();
break;
case "comando2":
//ejecutaComando1();
break;
case "comando3":
//ejecutaComando1();
break;
default:
//ejecutaComandoIlegal();
    System.out.println("null");
break;
} 
    }

    public T getFirstValid(List<T> list) {
        for (T m : list) {
            if (m.isValid()) {
                return m;
            }
        }
        return null;
    }
    
    static class MyClass{ boolean isValid(){return true;} }
    static class MySubclass extends MyClass{}
}
