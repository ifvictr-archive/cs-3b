/*
 * Lab 3: P6.18 by Victor Truong
 *
 * This program tests a mock implementation of a microwave in code and outputs results like a real
 * microwave would.
 */

/**
 * Tests our calculateDecay method.
 */
public class DecayTester {
    public static void main(String[] args) {
        final double INITIAL_AMOUNT = 3000;
        final int HALF_LIFE = 6;

        // Print the amount of dosage remaining for the first 24 hours
        System.out.println(String.format("Initial Technetium-99 dosage: %.2f", INITIAL_AMOUNT));
        for (int hour = 1; hour <= 24; hour++) {
            double currentAmount = DecayTester.calculateDecay(INITIAL_AMOUNT, hour, HALF_LIFE);
            System.out.println(
                    String.format("Amount remaining after %d hours: %.2f", hour, currentAmount));
        }
    }

    /**
     * Calculate the relative amount of material remaining.
     *
     * @param initialAmount Initial amount of the material
     * @param time          Time after the initial amount, in hours
     * @param halfLife      Half life of the material
     * @return the remaining material after the specified time
     */
    public static double calculateDecay(double initialAmount, double time, double halfLife) {
        double euler = Math.exp(-time * Math.log(2) / halfLife);
        return initialAmount * euler;
    }
}
