/**
 * Tests our calculateDecay method.
 */
public class DecayTester {
    public static void main(String[] args) {
        test(3000, 0, 6, 3000);
        test(3000, 6, 6, 1500);
        test(3000, 12, 6, 750);
        test(3000, 18, 6, 375);
        test(3000, 24, 6, 187.5);
    }

    public static void test(double initialAmount, double time, double halfLife,
            double expectedResult) {
        double result = DecayDemo.calculateDecay(initialAmount, time, halfLife);
        System.out.println(String.format("Amount %.2f should be %.2f after %d hours, got %.2f",
                initialAmount, expectedResult, (int) time, result));
    }
}
