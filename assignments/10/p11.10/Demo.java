/*
 * Assignment 10: P11.10 by Victor Truong
 *
 * This program takes in a text file with one sale per line, with the client name, service sold,
 * amount of the sale, and date separated by semicolons. This calculates the total amount of each
 * category and then outputs it.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        // Initialize input stream
        Scanner saleScanner;
        try {
            saleScanner = new Scanner(new File("sales.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }

        // name; category; sale amount; date
        Map<String, Double> categoryAmounts = new HashMap<>();
        try {
            while (saleScanner.hasNextLine()) {
                // Extract info from the line
                String line = saleScanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(";");

                // Check if the line is in the correct format first using regex
                lineScanner.next(); // Ignore name
                String category = lineScanner.next();
                double saleAmount = lineScanner.nextDouble();

                // Add to total
                Double currentTotal = categoryAmounts.getOrDefault(category, Double.valueOf(0));
                categoryAmounts.put(category, currentTotal + saleAmount);

                lineScanner.close();
            }
        } catch (InputMismatchException e) {
            System.out.println("The file isn’t in the valid format. Exiting…");
            return;
        }

        // Print the total amounts for each category
        System.out.println("Category totals in USD ($)");
        System.out.println();
        for (String category : categoryAmounts.keySet()) {
            System.out.printf("%-20s%10.2f%n", category, categoryAmounts.get(category));
        }

        // Close everything
        saleScanner.close();
    }
}
