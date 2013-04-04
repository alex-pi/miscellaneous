package code.tests.problems;

/**
 * User: pi
 * Date: 3/24/13
 * Time: 4:43 PM
 */
public class BizzBuzz {

    public static void main(String... args) {
        Integer num = Integer.parseInt(args[0]);

        if(num % 3 == 0) {
            System.out.print("Bizz");
            if(num % 5 == 0)
                System.out.print("Buzz");
        }
    }
}
