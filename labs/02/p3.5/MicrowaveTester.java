/*
 * Lab 2: P3.5 by Victor Truong
 *
 * This program tests a mock implementation of a microwave in code and outputs results like a real
 * microwave would.
 */

/**
 * Tests the Microwave class.
 */
public class MicrowaveTester {
    public static void main(String[] args) {
        Microwave microwave = new Microwave();

        // Print initial values
        System.out.println("Starting microwave…");
        microwave.start();

        // Test increaseTime
        System.out.println("Increased time");
        microwave.increaseTime();
        microwave.start();

        // Test increaseTime again
        System.out.println("Increased time");
        microwave.increaseTime();
        System.out.println("Increased time");
        microwave.increaseTime();
        microwave.start();

        // Test togglePowerLevel
        microwave.togglePowerLevel();
        microwave.start();
        microwave.togglePowerLevel();
        microwave.start();
        microwave.togglePowerLevel();
        microwave.start();

        // Test reset
        microwave.reset();
        microwave.start();
    }
}
