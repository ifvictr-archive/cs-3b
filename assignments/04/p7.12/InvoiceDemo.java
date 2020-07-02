/*
 * Assignment 4: P7.12 by Victor Truong
 *
 * This program takes the price and quantity of a list of items and adds them to an invoice. Then,
 * it calculates the applicable discount and outputs it to the user.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Demos our Invoice and Item classes.
 */
public class InvoiceDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Invoice invoice = new Invoice();

        System.out.println(
                "Enter the items below. Use '-1' as the price to see the applicable discount of the total cost.");
        while (true) {
            try {
                // Prompt price
                System.out.print("What’s the price of the item? ");
                double price = scanner.nextDouble();
                if (price == -1) {
                    break;
                }

                // Prompt quantity
                System.out.print("How many were purchased? ");
                int quantity = scanner.nextInt();

                // Prompt isPet
                System.out.print("Was it a pet? (Y/N) ");
                String isPetInput = scanner.next();
                boolean isPet = isPetInput.equalsIgnoreCase("Y");

                // Construct the object and add to invoice
                Item item = new Item(price, isPet, quantity);
                invoice.add(item);
            } catch (InputMismatchException e) {
                System.out.println("Wrong input! Please start over for the current item.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        scanner.close();

        System.out.println(String.format("Discount: %.2f", invoice.getDiscount()));
    }
}
