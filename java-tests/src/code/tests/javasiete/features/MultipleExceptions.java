package code.tests.javasiete.features;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: pi
 * Date: 4/18/13
 * Time: 10:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class MultipleExceptions {

    private final static Logger logger = Logger.getLogger("log.txt");

    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        try {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            if(number < 10)
                throw new InvalidParameter();
            System.out.println("The number is: " + number);
        } catch(InputMismatchException | InvalidParameter ip) {
            logger.log(Level.INFO, "Invalid input, try again.");
            logger.log(Level.INFO, ip.getMessage());
        }

    }
}
