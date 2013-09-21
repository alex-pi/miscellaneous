package code.tests.javasiete.features;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 * User: pi
 * Date: 4/11/13
 * Time: 4:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class TryWithResources {

    public static void main(String[] args) {
        try (BufferedReader inputReader = Files.newBufferedReader(
                Paths.get(new URI("file:///home/pi/workspace/miscellaneous/java-tests/users.txt")), Charset.defaultCharset());
             BufferedWriter outputWriter = Files.newBufferedWriter(
                     Paths.get(new URI("file:///home/pi/workspace/miscellaneous/java-tests/users.bak")), Charset.defaultCharset());
        ) {
            String inputLine;
            while((inputLine = inputReader.readLine()) != null) {
                outputWriter.write(inputLine);
                outputWriter.newLine();
            }
            System.out.println("Copy complete!");

        } catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
        }

    }
}
