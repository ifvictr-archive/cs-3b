/**
 * Models the basic interface of an ATM.
 */
public class ATM {
    private String accountPin;
    private int failedAttemptsCount;

    /**
     * Constructs an ATM object with the specified PIN.
     *
     * @param pin the account PIN
     */
    public ATM(String pin) {
        this.accountPin = pin;
    }

    /**
     * Check if the specified PIN is correct. Increments the failed attempts count on mismatch.
     *
     * @param pin the PIN to check
     * @return if the PIN was correct
     */
    public boolean checkPin(String pin) {
        boolean doesMatch = pin.equals(this.accountPin);

        if (!doesMatch) {
            this.failedAttemptsCount++;
        }

        return doesMatch;
    }

    /**
     * Get failed attempts count.
     *
     * @return the failed attempts count.
     */
    public int getFailedAttemptsCount() {
        return this.failedAttemptsCount;
    }
}
