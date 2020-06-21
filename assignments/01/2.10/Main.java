/*
 * Assignment 1: P2.10 by Victor Truong
 *
 * This program outputs the weekday of the current year’s Pi Day, the date and weekday of Programmer
 * Day, and also the date and weekday of the day 10,000 days before today.
 */

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Print Pi day
        LocalDate today = LocalDate.now();
        LocalDate piDay = LocalDate.of(today.getYear(), 3, 14);

        System.out.println("This year’s Pi Day is on a " + piDay.getDayOfWeek());

        // Print programmer day
        LocalDate newYearsDay = LocalDate.of(today.getYear(), 1, 1);
        LocalDate programmerDay = newYearsDay.plusDays(255); // 256 = 1 + 255

        System.out.println("This year’s Programmer’s Day is on " + programmerDay.toString()
                + " on a " + programmerDay.getDayOfWeek());

        // Print 10,000 days before today
        LocalDate earlierDay = today.minusDays(10000);
        System.out.println("The date that was 10,000 days before today is " + earlierDay.toString()
                + ", which was a " + earlierDay.getDayOfWeek());
    }
}
