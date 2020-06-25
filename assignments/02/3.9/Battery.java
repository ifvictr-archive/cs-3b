/**
 * A Battery models a rechargeable battery.
 */
public class Battery {
    private double capacity;
    private double remainingCapacity;

    /**
     * Constructs a Battery with a certain capacity.
     *
     * @param capacity Max capacity of the battery
     */
    public Battery(double capacity) {
        this.capacity = capacity;
        this.remainingCapacity = capacity;
    }

    /**
     * Drains the battery capacity by a certain amount.
     *
     * @param amount The amount to drain by
     */
    public void drain(double amount) {
        this.remainingCapacity -= amount;
    }

    /**
     * Recharges to max capacity.
     */
    public void charge() {
        this.remainingCapacity = capacity;
    }

    /**
     * Gets the battery's remaining capacity.
     *
     * @return the remaining capacity
     */
    public double getRemainingCapacity() {
        return this.remainingCapacity;
    }
}
