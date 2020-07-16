public class Onetime extends Appointment {
    private int year;
    private int month;
    private int day;

    public Onetime(String reason, int year, int month, int day) {
        super(reason);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Checks whether or not an appointment occurs on the given date.
     *
     * @param year  date year
     * @param month date month
     * @param day   date day
     * @return if it occurs on that date
     */
    public boolean occursOn(int year, int month, int day) {
        return year == this.year && month == this.month && day == this.day;
    }
}
