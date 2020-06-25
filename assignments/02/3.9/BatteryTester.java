/*
 * Assignment 2: P3.9 by Victor Truong
 *
 * This program instantiates an instance of a Battery and tests all of its public methods.
 */

/**
 * Tests our Battery class.
 */
public class BatteryTester {
    public static void main(String[] args) {
        Battery battery = new Battery(3000);
        System.out.println("Initial battery capacity: " + battery.getRemainingCapacity());

        // Drain amount
        battery.drain(1000);
        System.out.println(
                "Drained 1000. New capacity should be 2000: " + battery.getRemainingCapacity());

        // Recharge battery
        battery.charge();
        System.out.println(
                "Recharged. New capacity should be 3000: " + battery.getRemainingCapacity());
    }
}
