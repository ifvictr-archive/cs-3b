public class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int number, double balance) {
        this.accountNumber = number;
        this.balance = balance;
    }

    /**
     * Gets the account number.
     *
     * @return number
     */
    public int getNumber() {
        return this.accountNumber;
    }

    /**
     * Gets the account balance.
     *
     * @return balance
     */
    public double getBalance() {
        return this.balance;
    }
}
