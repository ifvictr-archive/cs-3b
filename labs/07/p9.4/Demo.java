/*
 * Lab 7: P9.4 by Victor Truong and Gurpal Kundi
 *
 * This program takes in a date from the user and lists out all the appointmentss that occur on that
 * date.
 */

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Appointment[] appointments = {new Daily("Go meditate"), new Daily("Go workout"),
                new Monthly("Set monthly goals and plans", 1), new Monthly("Go to the beach", 25),
                new Onetime("Turn in Lab 7", 2020, 7, 16),
                new Onetime("Celebrate the end of 2020", 2020, 12, 31),
                new Onetime(
                        "Realize that the pandemic will probably still be a thing and cry in a corner",
                        2021, 1, 1)};

        // Take in a date from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Enter the date you want to list your appointments for in (YYYY MM DD format): ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        // Print out all the appointments that occur on that day
        System.out.println(String.format("Your appointments on %04d-%02d-%02d:", year, month, day));
        for (Appointment appointment : appointments) {
            if (appointment.occursOn(year, month, day)) {
                System.out.println("- " + appointment.getReason());
            }
        }
    }
}
