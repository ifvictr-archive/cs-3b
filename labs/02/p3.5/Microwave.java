/**
 * Models the behavior of a microwave.
 */
public class Microwave {
    private int remainingSeconds = 0;
    private int powerLevel = 1;

    /**
     * Increases the remaining time by 30 seconds.
     */
    public void increaseTime() {
        this.remainingSeconds += 30;
    }

    /**
     * Toggles the power between levels 1 and 2.
     */
    public void togglePowerLevel() {
        this.powerLevel = this.powerLevel == 1 ? 2 : 1;
    }

    /**
     * Sets the remaining time to 0 and the power level back to 1.
     */
    public void reset() {
        this.remainingSeconds = 0;
        this.powerLevel = 1;
    }

    /**
     * Prints the remaining time and the current power level.
     */
    public void start() {
        System.out.println(
                "Cooking for " + this.remainingSeconds + " seconds at level " + this.powerLevel);
    }
}
