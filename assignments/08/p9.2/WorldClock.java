public class WorldClock extends Clock {
    public static int HOURS_PER_DAY = 24;

    private int offset;

    /**
     * Constructs a WorldClock.
     *
     * @param offset amount of hours from current timezone
     */
    public WorldClock(int offset) {
        this.offset = offset;
    }

    /**
     * Gets the current hour with a timezone offzone.
     *
     * @return current hour in offset timezone
     */
    @Override
    public int getHours() {
        return (super.getHours() + this.offset) % WorldClock.HOURS_PER_DAY;
    }
}
