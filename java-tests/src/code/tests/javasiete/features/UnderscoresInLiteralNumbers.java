package code.tests.javasiete.features;

/**
 * Created with IntelliJ IDEA.
 * User: pi
 * Date: 4/10/13
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class UnderscoresInLiteralNumbers {

    public static void main(String[] args) {
        long debitCard = 1234_5678_9034_2355L;
        System.out.println("The card number is: " + debitCard);
        System.out.println("The formatted card number is: ");
        printFormatted(debitCard);

        float minAmount = 5_000F;
        float currentAmount = 5_250F;
        float withdrawalAmount = 500F;

        if((currentAmount - withdrawalAmount) < minAmount)
            System.out.println("Minimum amount limit exceeded " + minAmount);
    }

    private static void printFormatted(long cardNumber) {
        String formatted = Long.toString(cardNumber);
        for (int i = 0; i < formatted.length(); i++) {
            if(i != 0 && i % 4 == 0)
                System.out.print(" ");
            System.out.print(formatted.charAt(i));
        }
        System.out.println();
    }
}
