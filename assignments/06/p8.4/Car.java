import java.util.ArrayList;

/**
 * Models a car in the system. Carries passengers and can move around to different stations.
 */
public class Car {
    public static final int PASSENGER_CAPACITY = 4;
    public static final double FARE_PER_MILE = 5;

    private static int nextId = 1;

    private int id;
    private ArrayList<Passenger> passengers = new ArrayList<>();
    private Station currentStation;
    private Station destination;
    private boolean isActive = true;
    private int totalMiles = 0;
    private double totalRevenue = 0;

    public Car() {
        this.id = nextId;
        Car.nextId++;
    }

    /**
     * Gets the car's ID.
     *
     * @return car ID
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the list of passengers in the car.
     *
     * @return the car passengers
     */
    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    /**
     * Checks whether or not the car has space.
     *
     * @return whether or not it has space
     */
    public boolean hasSpaceAvailable() {
        return this.passengers.size() < Car.PASSENGER_CAPACITY;
    }

    /**
     * Adds a passenger to the car.
     *
     * @param passenger the passenger to add
     */
    public void pickup(Passenger passenger) {
        this.passengers.add(passenger);
    }

    /**
     * Remove a passenger from the car.
     *
     * @param passenger the passenger to remove
     */
    public void drop(Passenger passenger) {
        this.passengers.remove(passenger);
    }

    /**
     * Checks if the car has reached its destination yet.
     *
     * @return if the the car is at the destination yet
     */
    public boolean hasReachedDestination() {
        return this.getCurrentStation().equals(this.getDestination());
    }

    /**
     * Drives to a destination station. Updates the stations with the car, the total miles driven,
     * and the current station.
     *
     * @param destination where to drive to
     */
    public void driveTo(Station destination) {
        // Can't drive to the same station
        if (destination.equals(this.getCurrentStation())) {
            return;
        }

        // Move the car
        this.getCurrentStation().removeCar(this);
        destination.addCar(this);

        // Increment the total miles driven
        int milesDriven = this.getCurrentStation().distanceTo(destination);
        for (Passenger passenger : this.getPassengers()) {
            passenger.addMiles(milesDriven);
        }
        this.totalMiles += milesDriven;

        this.setCurrentStation(destination);
    }

    /**
     * Gets the car's current station.
     *
     * @return current station
     */
    public Station getCurrentStation() {
        return this.currentStation;
    }

    /**
     * Sets the car's current station.
     *
     * @param destination where it currently is
     */
    public void setCurrentStation(Station station) {
        this.currentStation = station;
    }

    /**
     * Gets the car's destination station.
     *
     * @return destination station
     */
    public Station getDestination() {
        return this.destination;
    }

    /**
     * Sets the car's destination station.
     *
     * @param destination where to drive to
     */
    public void setDestination(Station destination) {
        this.destination = destination;
    }

    /**
     * Checks whether the car is active.
     *
     * @return active or not
     */
    public boolean isActive() {
        return this.isActive;
    }

    /**
     * Sets whether or not the car can take new passengers and drive.
     *
     * @param active
     */
    public void setActive(boolean active) {
        this.isActive = active;
    }

    /**
     * Gets the total miless driven.
     *
     * @return total miles driven
     */
    public int getTotalMiles() {
        return this.totalMiles;
    }

    /**
     * Gets the total revenue.
     *
     * @return total revenue
     */
    public double getTotalRevenue() {
        return this.totalRevenue;
    }

    /**
     * Adds money to the total revenue.
     *
     * @param amount money to add
     */
    public void addMoney(double amount) {
        if (amount > 0) {
            this.totalRevenue += amount;
        }
    }
}
