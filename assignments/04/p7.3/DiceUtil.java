import java.util.Random;

/**
 * Small functions for working with die.
 */
public class DiceUtil {
    /**
     * Get a toss of a six-sided dice
     *
     * @return the number rolled
     */
    public static int tossDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    /**
     * Gets the specified amount of dice tosses.
     *
     * @param times amount of tosses
     * @return an array with the number rolled in each toss
     */
    public static int[] getDiceTosses(int times) {
        int[] tosses = new int[times];
        for (int i = 0; i < times; i++) {
            tosses[i] = DiceUtil.tossDice();
        }

        return tosses;
    }

    /**
     * Get the starting and ending indices of the first longest run.
     *
     * @param tosses times the dice should be tossed
     * @return the bounding pair (start index, end index) of the longest run
     */
    public static BoundingPair getLongestRun(int[] tosses) {
        int prevNum = -1;
        int currentRun = 1;

        int longestRun = 1;
        int longestRunEndPos = 1;

        for (int i = 0; i < tosses.length; i++) {
            int currentNum = tosses[i];

            // Reset the previous number and run the numbers differs
            if (currentNum != prevNum) {
                prevNum = currentNum;
                currentRun = 1;
                continue;
            }

            // Increase the run length and update the running longest run
            currentRun++;
            if (currentRun > longestRun) {
                longestRun = currentRun;
                // Add one because the end is the index of the first number that doesn't match after
                longestRunEndPos = i + 1;
            }
        }

        int longestRunStartPos = longestRunEndPos - longestRun;
        return new BoundingPair(longestRunStartPos, longestRunEndPos);
    }
}
