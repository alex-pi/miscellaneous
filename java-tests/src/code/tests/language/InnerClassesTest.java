/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.language;

/**
 *
 * @author Alejandro Pimentel
 */
public class InnerClassesTest {
    
    private Integer x = 1;
    
    public InnerClassesTest(){
        Inner1 in1 = new Inner1();
        Inner2 in2 = new Inner2();
        in1.doSomething();
        in1.doMore();
    }

    static  {
        class LOL{};
    }

    interface Papadril {
        interface Lala {}
    }
    
    class Inner1{
        private Integer y = 2;
        private Integer x = 3;
        public static final String s = "";
        
        class InnerInner {
            public void whoAreYou(){
                System.out.println("I'm the father.");
            }
        }

        //No static members are allowed inside inner classes
        //public static Integer x = 1;
        
        public void doSomething(){
            Integer w = 4;
            final Integer u = 5;
            //We can c all the private members of our Outer class
            System.out.println(InnerClassesTest.this.x);
            System.out.println(this.y);

            new Papadril(){
                public void modo() {
                    int xxx = x;
                }
            };
            
            //Method-Innerclass can only be instiated inside this method
            class MethodInnerClass {
                public MethodInnerClass doAnother(){
                    System.out.println(x);
                    // Can't use the cariables declared in the method,
                    //System.out.println(w);
                    // Only can use final variables.
                    System.out.println(u);
                    
                    // So, in fact the object could live more than the local
                    // variables of this method. (That is why... O_o)
                    return this;
                }
            }
            MethodInnerClass mic = new MethodInnerClass();
            mic.doAnother();
        }
        
        public void doMore(){
            // Here we are creating an anonymous class which is subclass of InnerInner
            // that is why we can override the method whoAreYou. You know this
            // works even if InnerInner was an interface, You'll do this with Comparator.
            new InnerInner(){
                @Override
                public void whoAreYou(){
                    System.out.println("I'm the son.");
                }                
            }.whoAreYou();
            
        }
        
    }
    
    static class Inner2{
        //Static non-static members in static inner classes.
        public Integer x = 1;
        public static Integer y = 1;
    }
    
    public static void main(String... args){
        InnerClassesTest ict = new InnerClassesTest();
        
        //We need an instance of the outer class to instantiate Inner1
        Inner1 in1 = ict.new Inner1();
        
        //But not for Inner2, coz it is a static member
        Inner2 in2 = new Inner2();
    }

}

class External {
    
    public External(){
        System.out.println(InnerClassesTest.Inner2.y);
        InnerClassesTest out = new InnerClassesTest();
        InnerClassesTest.Inner1 in1 = out.new Inner1();
        InnerClassesTest.Inner1 inn = new InnerClassesTest().new Inner1();
        InnerClassesTest.Inner2 inn2 = new InnerClassesTest.Inner2();
    }
}
