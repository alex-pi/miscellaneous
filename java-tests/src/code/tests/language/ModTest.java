package code.tests.language;

/**
 * User: pi
 * Date: 3/1/13
 * Time: 9:57 PM
 */
public class ModTest {

    public static void main(String[] args) {
        double res1 = 12.5 % 12;
        System.out.println(res1);
        double res2 = 12.4 % 12;
        System.out.println(res2);

        if(12.5 % 12 > 0)
            System.out.println("hay residuo con 12.5");
        if(12.4 % 12 > 0)
            System.out.println("hay residuo con 12.4");
    }
}
