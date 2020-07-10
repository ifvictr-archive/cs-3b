/*
 * Assignment 6: P8.5 by Victor Truong
 *
 * This program simulates a car sharing system in which car commuters pick up and drop off
 * passengers at designated stations. Passengers pay a fare and the cars keep track of the miles it
 * takes to complete each trip. The program them runs the simulatio a large number of times to
 * calculate the average revenue per mile, which it then outputs to the user.
 */

/**
 * Entry point to Simulation.
 */
public class Demo {
    public static void main(String[] args) {
        final int SIMULATION_COUNT = 1000;

        // Start running the sims N times
        int totalMiles = 0;
        double totalRevenue = 0;
        for (int i = 0; i < SIMULATION_COUNT; i++) {
            Simulation sim = new Simulation();
            sim.run();

            // Add the values to the overall total
            totalMiles += sim.getTotalMiles();
            totalRevenue += sim.getTotalRevenue();
        }

        // Output average revenue per mile
        double averageRevenuePerMile = totalRevenue / (double) totalMiles;
        System.out.println(String.format("Total miles driven: %d", totalMiles));
        System.out.println(String.format("Total revenue made: $%.2f", totalRevenue));
        System.out.println(String.format("Average revenue per mile: $%.2f", averageRevenuePerMile));
    }
}
