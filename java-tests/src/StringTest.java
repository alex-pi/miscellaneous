/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro Pimentel
 */
public class StringTest {
    
    public static void main(String... args){
        String s1 = "Hola mundo";
        
        String[] as2 = s1.split("(?!^)");
        
        for (String s : as2) {
            System.out.print("-"+s.length());
        }
    }

}
