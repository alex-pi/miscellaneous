/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Alejandro Pimentel
 */
public class ComparingTest {
    
    public static void main(String... args){        
        Movie m1 = new Movie("Clockwork Orange", 1980);
        Movie m2 = new Movie("Blade Runner", 1982);
        Movie m3 = new Movie("Matrix", 1999);
        Movie m4 = new Movie(null, null);
        
        ArrayList<Movie> l1 = new ArrayList();
        l1.add(m1);
        l1.add(m2);
        l1.add(m3);
        l1.add(m4);
        

        Collections.sort(l1, new Comparator<Movie>(){

            @Override
            public int compare(Movie t, Movie t1) {
                if(t != null && t1 != null && t.getYear() != null && t1.getYear() != null)
                    return t.getYear().compareTo(t1.getYear());
                else return 0;
            }
            
        });
        System.out.println(l1);
        Collections.sort(l1);
        System.out.println(l1);        
        
        System.out.println(Collections.binarySearch(l1, new Movie("Blade Runner", null)));
    }

    static class Movie implements Comparable<Movie> {
        
        private String name;
        private Integer year;

        public Movie(String name, Integer year) {
            this.name = name;
            this.year = year;
        }        
        
        @Override
        public String toString(){
            return this.getName() + " " + this.getYear();            
            // + this.getYear();
        }
        
        @Override
        public int compareTo(Movie that){
            if(that != null && that.getName() != null && this.getName() != null)
                return this.getName().compareTo(that.getName());
            else 
                return 0;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }                
    }
    
}
