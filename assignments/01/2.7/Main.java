/*
 * Assignment 1: P2.6 by Victor Truong
 *
 * This program simply outputs 1) the date and weekday of the day that’s 100 days from the current
 * date, 2) the weekday of Alan Turing’s birthday, and 3) the date that’s 10,000 days from Turing’s
 * birthday.
 */

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        // Print the date and weekday that is 100 days from today
        Calendar cal1 = new GregorianCalendar();
        cal1.add(Calendar.DAY_OF_MONTH, 100);

        System.out.println("100 days from today:");
        System.out.println("  Date: " + getDateFormat(cal1));
        System.out.println("  Weekday: " + cal1.get(Calendar.DAY_OF_WEEK));

        // Print the weekday of Alan Turing’s birthday
        Calendar cal2 = new GregorianCalendar(1912, Calendar.JUNE, 23);
        System.out.println("Weekday of Alan Turing’s birthday: " + cal2.get(Calendar.DAY_OF_WEEK));

        // Print the date that is 10,000 days from Alan Turing’s birthday
        cal2.add(Calendar.DAY_OF_MONTH, 10000);
        System.out.println(
                "Date that is 10,000 days from Alan Turing’s birthday: " + getDateFormat(cal2));
    }

    public static String getDateFormat(Calendar calendar) {
        return calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
                + calendar.get(Calendar.DATE);
    }
}
