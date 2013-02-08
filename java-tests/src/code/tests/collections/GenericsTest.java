/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.collections;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro Pimentel
 */
public class GenericsTest {
    
    class Animal{}
    class Cat extends Animal {}
    class Dog extends Animal {}
    
    public static void main(String... args){
        new GenericsTest().test();
    }

    public void test() {
        List<Animal> animals = new ArrayList();
        animals.add(new Cat());
        animals.add(new Dog());
        List<Cat> cats = new ArrayList();
        cats.add(new Cat());
        cats.add(new Cat());
        
        add4(animals);
        // Not allowed because the method could add a Dog to a List of Cats!!!!
        //add1(cats);
        
        // Using ? extends Animal we are saying to the compiler that we won't add nothing at all.
        add2(cats);
        
        // Cat and its super classes can go here.
        add3(cats);
        add3(animals);
        
        add4(cats);
    }
    
    void add1(List<Animal> animals){
       // Nice, but what if animals was originally a list of dogs?
       animals.add(new Cat());
    }
    
    void add2(List<? extends Animal> animals){
       // So now the error comes when I try to add something to the array.
       // Both lines produce errors.
       //animals.add(new Animal());
       //animals.add(new Cat());
    }
    
    void add3(List<? super Cat> animals){
        animals.add(new Cat());
        //not allowed by the compiler.
        //animals.add(new Animal());
    }
    
    <T extends Animal> void add4(List<T> animals){
        animals.add((T)(new Dog()));
    }
}
