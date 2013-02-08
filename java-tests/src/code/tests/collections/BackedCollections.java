/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.collections;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author Alejandro Pimentel
 */
public class BackedCollections {
    
    public static void main(String... args){
        TreeMap<String, String> tm = new TreeMap();
        tm.put("a", "ant");
        tm.put("d", "dog");
        tm.put("h", "horse");
        
        SortedMap<String, String> subMap = tm.subMap("b", "g");
        
        tm.put("b","bat");
        subMap.put("f","fish");
        
        tm.put("r", "racoon");
        
        System.out.println(tm);
        System.out.println(subMap);
        
        subMap.remove("d");
        
        System.out.println(tm);
        System.out.println(subMap);
    }

}
