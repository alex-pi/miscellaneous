package code.tests.javasiete.features;

/**
 * Created with IntelliJ IDEA.
 * User: pi
 * Date: 4/10/13
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringSwitchExample {
    private static boolean verbose = false;
    private static boolean logging = false;
    private static boolean displayHelp = false;
    private static final String ddash = "--";

    public static void main(String... args) {
        for(String argument : args) {
            switch (argument) {
                case ddash+"verbose":
                case "-v":
                    verbose = true;
                    break;
                case "--logging":
                    logging = true;
                    break;
                case "--help":
                    displayHelp = true;
                    break;
                default:
                    System.out.println("Illegal command line argument.");
            }
        }
        displayApplicationSettings();
    }

    private static void displayApplicationSettings() {
        System.out.println("Application settings: ");
        System.out.println("Verbose: " + verbose);
        System.out.println("Logging: " + logging);
        System.out.println("Help: " + displayHelp);
    }
}
