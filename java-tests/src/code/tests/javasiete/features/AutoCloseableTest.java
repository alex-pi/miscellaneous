package code.tests.javasiete.features;

/**
 * Created with IntelliJ IDEA.
 * User: pi
 * Date: 4/17/13
 * Time: 9:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class AutoCloseableTest {

    public static void main(String[] args) {

        try(FirstAutoCloseableResource facr = new FirstAutoCloseableResource() ;
            SecondAutoCloseableResource sacr = new SecondAutoCloseableResource()) {
            facr.manipulateResource();
            sacr.manipulateResource();

        } catch(Exception ex) {
            System.out.println("Catch block executed.");
            ex.printStackTrace();
            for (Throwable throwable : ex.getSuppressed()) {
                System.out.println(throwable);
            }
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}
