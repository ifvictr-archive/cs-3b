/*
 * Lab 8: P10.7 by Victor Truong
 *
 * This program calculates the average balance of a given array of bank accounts, including only the
 * accounts with balances greater than $1000 in the average. Then it outputs the average and the
 * expected output.
 */

public class Demo {
    public static void main(String[] args) {
        BankAccount[] accounts = {new BankAccount(100), new BankAccount(250), new BankAccount(500),
                new BankAccount(750), new BankAccount(1000), new BankAccount(2000),
                new BankAccount(5000), new BankAccount(1000000)};

        // Prepare measurer and filter
        Measurer accountMeasurer = new BankAccountMeasurer();
        // Measurer accountMeasurer = (Object obj) -> ((BankAccount) obj).getBalance();
        Filter accountFilter = (Object obj) -> ((BankAccount) obj).getBalance() > 1000;
        double averageBalance = Data.average(accounts, accountMeasurer, accountFilter);

        // Print results
        System.out.println(String.format("Average balance: $%.2f", averageBalance));
        System.out.println("Expected: $335666.67");
    }
}
