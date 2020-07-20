import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    /**
     * Gets a list of all the bank accounts.
     *
     * @return list of all accounts
     */
    public ArrayList<BankAccount> getAccounts() {
        return this.accounts;
    }

    /**
     * Reads a file with all the accounts into the internal store.
     *
     * @param filename file to read from
     * @throws FileNotFoundException
     */
    public void readFile(String filename) throws FileNotFoundException, InputMismatchException {
        // Clear the accounts before adding the accounts from this file
        this.accounts.clear();

        Scanner accountScanner = new Scanner(new File(filename));
        while (accountScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(accountScanner.nextLine());

            // Create BankAccount instance from line and add it
            int accountNumber = lineScanner.nextInt();
            double balance = lineScanner.nextDouble();
            this.accounts.add(new BankAccount(accountNumber, balance));

            lineScanner.close();
        }

        // Clean up
        accountScanner.close();
    }
}
