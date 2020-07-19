/*
 * Assignment 10: P11.1 by Victor Truong
 *
 * This program takes in a file called babynames.txt with the top 1000 most popular boy and girl
 * names. Then it reads it and separates the names into different files according to the gender
 * category it's in.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        // Initialize input stream
        Scanner nameScanner = new Scanner(new File("babynames.txt"));

        // Initialize output streams
        PrintWriter boyNameWriter = new PrintWriter("boynames.txt");
        PrintWriter girlNameWriter = new PrintWriter("girlnames.txt");

        // rank [boy name] frequency percentage [girl name] frequency percentage
        while (nameScanner.hasNextLine()) {
            // Extract names from the line
            Scanner lineScanner = new Scanner(nameScanner.nextLine());
            lineScanner.nextInt(); // Ignore rank
            String boyName = lineScanner.next(); // Get boy name
            lineScanner.nextInt(); // Ignore frequency
            lineScanner.nextDouble(); // Ignore percentage
            String girlName = lineScanner.next(); // Get girl name

            // Write them to their respective files
            boyNameWriter.println(boyName);
            girlNameWriter.println(girlName);
        }

        // Close everything
        boyNameWriter.close();
        girlNameWriter.close();
        nameScanner.close();
    }
}
