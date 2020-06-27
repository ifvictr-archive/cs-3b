/*
 * Assignment 3: P6.10 by Victor Truong
 *
 * This program takes in a float value number set with no limits from the user. After the user is
 * finished, it will output the total amount of numbers added, the average, and the standard
 * deviation.
 */

import java.util.Scanner;

/**
 * Lets a user interact with the DataSet class.
 */
public class DataSetDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataSet data = new DataSet();

        // Start taking input from the user
        System.out.println(
                "Start entering your floating point values below! After you finish, just type ‘q’ and hit enter.");
        System.out.print("> ");
        while (scanner.hasNext()) {
            String input = scanner.next();

            // Check if the user wants to quit
            if (input.equals("q")) {
                break;
            }

            try {
                data.add(Float.parseFloat(input));
                System.out.println(String.format("%s has been added!", input));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }

            System.out.print("> ");
        }

        scanner.close();

        // Print the results
        System.out.println("Done! Here are the results:");
        System.out.println(String.format("Numbers entered: %d", data.getCount()));
        System.out.println(String.format("Average: %.2f", data.getAverage()));
        System.out.println(String.format("Standard deviation: %.2f", data.getStandardDeviation()));
    }
}
