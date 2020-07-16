public class Daily extends Appointment {
    public Daily(String reason) {
        super(reason);
    }

    /**
     * Checks whether or not an appointment occurs on that day. Will always be true because it
     * occurs daily.
     *
     * @param year  date year
     * @param month date month
     * @param day   date day
     * @return if it occurs on that date
     */
    public boolean occursOn(int year, int month, int day) {
        return true;
    }
}
