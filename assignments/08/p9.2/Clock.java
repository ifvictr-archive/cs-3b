import java.time.LocalTime;

public class Clock {
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
        return String.format("%02d:%02d", this.getHours(), this.getMinutes());
    }
}
