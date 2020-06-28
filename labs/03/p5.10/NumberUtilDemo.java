/*
 * Lab 3: P5.10 by Victor Truong
 *
 * This program takes in numbers between 1 and 3999 (inclusive) in decimal format from the user,
 * then converts them into Roman numerals, and outputs them.
 */

import java.util.Scanner;

/**
 * Demos the NumberUtil methods.
 */
public class NumberUtilDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Start taking input from the user
        System.out.println(
                "Start entering the numbers you want to convert to Roman numerals below. After you finish, just type ‘q’ and hit enter.");
        System.out.print("> ");
        while (scanner.hasNext()) {
            String input = scanner.next();

            // Check if the user wants to quit
            if (input.equals("q")) {
                break;
            }

            try {
                String result = NumberUtil.toRoman(Integer.parseInt(input));
                if (result != "") {
                    System.out.println(String.format("%s → %s", input, result));
                } else {
                    System.out.println("Input must be between 1 and 3999, inclusively");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }

            System.out.print("> ");
        }

        scanner.close();
        System.out.println("Exiting…");
    }
}
