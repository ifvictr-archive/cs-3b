/*
 * Assignment 3: P5.13 by Victor Truong
 *
 * This program lets a user input a PIN for their bank account. It’ll check if the PIN is correct
 * and let the user know. On the third failed attempt, the user will be locked and the program will
 * exit.
 */

import java.util.Scanner;

/**
 * Tests our ATM class.
 */
public class ATMTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM("1234");

        // The user can only attempt three times
        while (atm.getFailedAttemptsCount() < 3) {
            System.out.print("Enter your bank card PIN: ");
            String enteredPin = scanner.next();

            if (atm.checkPin(enteredPin)) {
                System.out.println("Your PIN is correct");
                return;
            }

            System.out.println("Your PIN is incorrect");
            // Block the card on the third failed attempt
            if (atm.getFailedAttemptsCount() == 3) {
                System.out.println("Your bank card is blocked");
            }
        }
    }
}
