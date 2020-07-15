import java.time.LocalTime;

public class Clock {
    private int alarmHour = -1;
    private int alarmMinute = -1;

    /**
     * Gets current timezone's hour.
     *
     * @return current hour
     */
    public int getHours() {
        String hoursStr = LocalTime.now().toString().substring(0, 2);
        return Integer.parseInt(hoursStr);
    }

    /**
     * Gets current timezone's minute.
     *
     * @return current minute
     */
    public int getMinutes() {
        String minutesStr = LocalTime.now().toString().substring(3, 5);
        return Integer.parseInt(minutesStr);
    }

    /**
     * Get the hour and time in string format.
     *
     * @return hour and time string
     */
    public String getTime() {
        int hour = this.getHours();
        int minute = this.getMinutes();
        String time = String.format("%02d:%02d", this.getHours(), this.getMinutes());

        // Display alarm and then clear if it's time
        boolean isAlarmSet = this.alarmHour >= 0 && this.alarmMinute >= 0;
        boolean hasAlarmBeenReached = hour >= this.alarmHour && minute >= this.alarmMinute;
        if (isAlarmSet && hasAlarmBeenReached) {
            time += " \u23F0"; // Append the clock character to indicate it's an alarm
            this.resetAlarm();
        }

        return time;
    }

    /**
     * Set an alarm for the given time.
     *
     * @param hour   alarm hour
     * @param minute alarm minute
     */
    public void setAlarm(int hour, int minute) {
        this.alarmHour = hour;
        this.alarmMinute = minute;
    }

    /**
     * Clears the current alarm.
     */
    public void resetAlarm() {
        this.setAlarm(-1, -1);
    }
}
