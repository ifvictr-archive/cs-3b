public class Monthly extends Appointment {
    private int day;

    public Monthly(String reason, int day) {
        super(reason);

        this.day = day;
    }

    /**
     * Checks whether or not an appointment occurs on the given day of the month.
     *
     * @param year  date year
     * @param month date month
     * @param day   date day
     * @return if it occurs on that date
     */
    public boolean occursOn(int year, int month, int day) {
        return day == this.day;
    }
}
