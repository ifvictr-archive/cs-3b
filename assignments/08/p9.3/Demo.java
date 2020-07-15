/*
 * Assignment 8: P9.3 by Victor Truong
 *
 * This program constructs two clocks: one in the user's current timezone aand one that's three
 * hours ahead. Then it outputs the hour and minute in each of the offset zones. It also sets an
 * alarm at the current time to demo the alarm functionality.
 */

/**
 * Demos Clock and WorldClock classes.
 */
public class Demo {
    public static void main(String[] args) {
        // Prints Clock stuff
        Clock clock1 = new Clock();
        clock1.setAlarm(clock1.getHours(), clock1.getMinutes());
        System.out.println("Clock times (with alarm):");
        Demo.printClock(clock1);
        System.out.println("Clock times (without alarm):");
        Demo.printClock(clock1);

        // Prints WorldClock stuff
        Clock clock2 = new WorldClock(3);
        clock2.setAlarm(clock2.getHours(), clock2.getMinutes());
        System.out.println("WorldClock (+3) times (with alarm):");
        Demo.printClock(clock2);
        System.out.println("WorldClock (+3) times (without alarm):");
        Demo.printClock(clock2);
    }

    /**
     * Prints the hour, minute, and full time of a clock.
     *
     * @param clock the clock to print
     */
    public static void printClock(Clock clock) {
        System.out.println("  getHours: " + clock.getHours());
        System.out.println("  getMinutes: " + clock.getMinutes());
        System.out.println("  getTime: " + clock.getTime());
    }
}
