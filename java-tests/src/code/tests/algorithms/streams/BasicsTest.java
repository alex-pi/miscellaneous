/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code.tests.algorithms.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;

/**
 *
 * @author Alejandro Pimentel
 */
public class BasicsTest {
    
    public static void main(String... args) throws Exception{
        File f = new File("texto.txt");
        File img = new File("Image.jpg");
        File imgo = new File("Image-copy.jpg");
        
        
        try (BufferedReader bf = new BufferedReader( new FileReader(f))) {
            String line;
            while((line = bf.readLine()) != null){
                System.out.println(line);
            }
        }
        
        try (FileWriter fw = new FileWriter(f, true);
                PrintWriter pw = new PrintWriter(fw);) {
            fw.append("Alex Pi");
            pw.println("Adios");
        }
        
        try (FileChannel fis = new FileInputStream(img).getChannel();
                FileChannel fos = new FileOutputStream(imgo).getChannel() ) {
            fos.transferFrom(fis, 0, fis.size());
        }
    }
}
