public class BankAccountMeasurer implements Measurer {
    /**
     * Measures a BankAccount.
     *
     * @param obj object to get the measure of
     * @return the balance of a BankAccount
     */
    public double measure(Object obj) {
        BankAccount account = (BankAccount) obj;
        return account.getBalance();
    }
}
