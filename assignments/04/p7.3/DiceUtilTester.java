/*
 * Assignment 4: P7.3 by Victor Truong
 *
 * This program generates a sequence of 20 random die tosses in an array and that prints the die
 * values, marking only the longest run.
 */

/**
 * Tests our DiceUtil class.
 */
public class DiceUtilTester {
    public static void main(String[] args) {
        // Test getDiceTosses
        final int TIMES = 20;
        int[] tosses = DiceUtil.getDiceTosses(TIMES);
        System.out.println(String.format("Wanted %d tosses, got %d tosses", TIMES, tosses.length));

        // Test getLongestRun
        int[] testTosses = {1, 2, 5, 5, 3, 1, 2, 4, 3, 2, 2, 2, 2, 3, 6, 5, 5, 6, 3, 1};
        // Print out the tosses while marking the longest run
        BoundingPair longestRun = DiceUtil.getLongestRun(testTosses);
        for (int i = 0; i < testTosses.length; i++) {
            if (i == longestRun.getStartPos()) {
                System.out.print("(");
            }
            System.out.print(testTosses[i]);
            if (i + 1 == longestRun.getEndPos()) {
                System.out.print(")");
            }
            System.out.print(" ");
        }

        System.out.println();
        System.out.println(String.format("Longest run was %d roll(s). Starts at %d, ends at %d",
                longestRun.length(), longestRun.getStartPos(), longestRun.getEndPos()));
    }
}
