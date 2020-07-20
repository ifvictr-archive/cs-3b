/*
 * Lab 9: P11.9 by Victor Truong
 *
 * This program takes in a file of bank accounts, each line with its number and the balance. Then it
 * finds the account with the highest balance and prints it. However, if the given file doesn't
 * exist or is malformed, it will prompt the user to try another file.
 */

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        // Prompt for filename to read from
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        while (true) {
            try {
                // Will break out of the loop if successful
                System.out.print("Enter the name of the file to pull from: ");
                String filename = scanner.next();
                bank.readFile(filename);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File not found, please enter another filename.");
            } catch (InputMismatchException e) {
                System.out.println(
                        "The specified file isn’t in a valid format. Please try another file.");
            }
        }
        scanner.close();

        // Can't get top account if there are none
        if (bank.getAccounts().size() == 0) {
            System.out.println("No bank accounts, exiting…");
            return;
        }

        // Find and print top account
        BankAccount topAccount = bank.getAccounts().get(0);
        for (BankAccount account : bank.getAccounts()) {
            if (account.getBalance() > topAccount.getBalance()) {
                topAccount = account;
            }
        }
        System.out.printf("The top account is #%d, with a balance of $%.2f.%n",
                topAccount.getNumber(), topAccount.getBalance());
    }
}
