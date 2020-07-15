/*
 * Assignment 8: P9.2 by Victor Truong
 *
 * This program constructs three clocks: one in the user's current timezone, one that's three hours
 * ahead, and one that's nine hours ahead. Then it outputs the hour and minute in each of the offset
 * zones.
 */

/**
 * Demos Clock and WorldClock classes.
 */
public class Demo {
    public static void main(String[] args) {
        Clock clock1 = new Clock();
        System.out.println("Clock times:");
        Demo.printClock(clock1);

        Clock clock2 = new WorldClock(3);
        System.out.println("WorldClock (+3) times:");
        Demo.printClock(clock2);

        Clock clock3 = new WorldClock(9);
        System.out.println("WorldClock (+9) times:");
        Demo.printClock(clock3);
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
