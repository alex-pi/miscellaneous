/**
 * User: pi
 * Date: 2/21/13
 * Time: 12:04 PM
 */
public class MainStdRandom {

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            int ram = StdRandom.uniform(0, 5);
            StdOut.println("generado: " + ram);
        }
    }
}
