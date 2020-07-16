public abstract class Appointment {
    private String reason = "";

    public Appointment(String reason) {
        this.reason = reason;
    }

    /**
     * Gets reason for an appointment.
     *
     * @return reason
     */
    public String getReason() {
        return this.reason;
    }

    /**
     * Checks whether or not an appointment occurs on the given date.
     *
     * @param year  date year
     * @param month date month
     * @param day   date day
     * @return if it occurs on that date
     */
    abstract boolean occursOn(int year, int month, int day);
}
