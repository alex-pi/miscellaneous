package code.tests.javasiete.features;

/**
 * Created with IntelliJ IDEA.
 * User: pi
 * Date: 4/17/13
 * Time: 8:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class SecondAutoCloseableResource implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Trying to close second resource.");

        throw new UnsupportedOperationException("There was a problem closing first resource");
    }

    public void manipulateResource() {
        System.out.println("Doing something with second resource.");
    }
}
