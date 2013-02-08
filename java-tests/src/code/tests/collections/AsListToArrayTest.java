/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Alejandro Pimentel
 */
public class AsListToArrayTest {
    
    public static void main(String... args) {
        String[] nums = {"one","two","three","four"};
        
        List<String> list = Arrays.asList(nums);
        
        list.set(3, "six");
        //Adding to this list is an unsupported operation
        //list.add("seven");
        //Same goes for removing
        //list.remove(0);
        
        print(nums);
        
        List<Integer> iL = new ArrayList();
        for(int x=0; x<3; x++)
            iL.add(x);
        Object[] oa = iL.toArray();
        // create an Object array
        Integer[] ia2 = new Integer[3];
        ia2 = iL.toArray(ia2);
        
        //Does not modify the original array.
        iL.add(3);
        
        System.out.println(iL);
        print(ia2);
        
    }
    
    public static <T> void print(T... arr){
        for (T v : arr) {
            System.out.print(v+",");
        }
        System.out.println();
    }

}
