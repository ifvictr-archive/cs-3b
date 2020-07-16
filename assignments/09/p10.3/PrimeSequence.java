public class PrimeSequence implements Sequence {
    private int prevN = 2; // Very first prime number

    /**
     * Gets the next prime number.
     *
     * @return the next prime number
     */
    public int next() {
        // If we're on the first prime, return it and then move to the first odd number prime.
        if (this.prevN == 2) {
            return this.prevN++;
        }

        // Calculate the next prime number (odd numbers only)
        int n = this.prevN;
        while (!PrimeSequence.isPrime(n)) {
            // Advance to the next odd number
            n += 2;
        }

        // Set the starting point for the next call at the next greater odd number
        this.prevN = n + 2;
        return n;
    }

    /**
     * Checks if the given number is a prime.
     *
     * @param n number to check
     * @return is prime or not
     */
    public static boolean isPrime(int n) {
        // 2 is the only even prime
        if (n == 2) {
            return true;
        }

        // Negative and even numbers (with the above exception) can't be prime
        boolean isNegative = n < 0;
        boolean isEven = n % 2 == 0;
        if (isNegative || isEven) {
            return false;
        }

        // Check all the odd numbers up to N/2
        for (int i = 3; i < n / 2; i += 2) {
            // Found a divisor, which means it isn't a prime
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
