/**
 * Models a combo lock with a three digit pin.
 */
public class ComboLock {
    // Inclusive range of the combo lock
    public static final int MIN = 0;
    public static final int MAX = 39;
    public static final int RANGE = ComboLock.MAX + 1;

    private int secret1;
    private int secret2;
    private int secret3;
    private int dialPosition = 0;
    private boolean[] unlockFlags = new boolean[3];

    /**
     * Constructs a ComboLock with a three digit pin.
     *
     * @param secret1 first digit of the pin
     * @param secret2 second digit of the pin
     * @param secret3 third digit of the pin
     */
    public ComboLock(int secret1, int secret2, int secret3) {
        this.secret1 = secret1;
        this.secret2 = secret2;
        this.secret3 = secret3;
    }

    /**
     * Constructs a ComboLock with default pin "123".
     */
    public ComboLock() {
        this(1, 2, 3);
    }

    /**
     * Gets the dial position.
     *
     * @return dial position
     */
    public int getDialPosition() {
        return this.dialPosition;
    }

    /**
     * Resets the combo lock position and unlocked flags.
     */
    public void reset() {
        this.dialPosition = 0;

        // Revert the flags to locked
        for (int i = 0; i < this.unlockFlags.length; i++) {
            this.unlockFlags[i] = false;
        }
    }

    /**
     * Turn the dial counterclockwise by a given amount of ticks.
     *
     * @param ticks amount of ticks to turn to the left
     */
    public void turnLeft(int ticks) {
        this.dialPosition += ticks % ComboLock.RANGE;

        // Wrap it back around to zero
        if (this.dialPosition > ComboLock.MAX) {
            this.dialPosition -= ComboLock.RANGE;
        }

        // Digit 2 is only affected on left turns
        if (this.dialPosition == this.secret2) {
            this.unlockFlags[1] = true;
        }
    }

    /**
     * Turn the dial clockwise by a given amount of ticks.
     *
     * @param ticks amount of ticks to turn to the right
     */
    public void turnRight(int ticks) {
        this.dialPosition -= ticks % ComboLock.RANGE;

        // Wrap it back around to 39
        if (this.dialPosition < ComboLock.MIN) {
            this.dialPosition += ComboLock.RANGE;
        }

        // Digits 1 and 3 are only affected on right turns
        if (this.dialPosition == this.secret1) {
            this.unlockFlags[0] = true;
        } else if (this.dialPosition == this.secret3) {
            this.unlockFlags[2] = true;
        }
    }

    /**
     * Attempts to open the lock. Will work if all the unlock flags are true.
     *
     * @return whether the open `attempt was successful
     */
    public boolean open() {
        for (boolean isUnlocked : this.unlockFlags) {
            if (!isUnlocked) {
                return false;
            }
        }

        return true;
    }
}
