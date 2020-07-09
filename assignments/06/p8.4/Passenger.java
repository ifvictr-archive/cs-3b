/**
 * Models a passenger, with origin and destination stations. Can pay a fare.
 */
public class Passenger {
    private static int nextId = 1;

    private int id;
    private int totalMiles = 0;
    private Station origin;
    private Station destination;

    public Passenger(Station origin) {
        this.id = nextId;
        this.origin = origin;

        Passenger.nextId++;
    }

    /**
     * Gets the passenger's ID.
     *
     * @return passenger ID
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets total miles traveled.
     *
     * @return total miles
     */
    public int getTotalMiles() {
        return this.totalMiles;
    }

    /**
     * Adds miles to total miles.
     *
     * @param miles to add
     */
    public void addMiles(int miles) {
        if (miles > 0) {
            this.totalMiles += miles;
        }
    }

    /**
     * Gets the passenger's origin station.
     *
     * @return origin station
     */
    public Station getOrigin() {
        return this.origin;
    }

    /**
     * Gets the passenger's destination station.
     *
     * @return destination station
     */
    public Station getDestination() {
        return this.destination;
    }

    /**
     * Sets the passenger's destination station.
     *
     * @param destination
     */
    public void setDestination(Station destination) {
        this.destination = destination;
    }

    /**
     * Pays a fare to a car.
     *
     * @param car the payee
     */
    public void payFare(Car car) {
        car.addMoney(Car.FARE_PER_MILE * this.getTotalMiles());
    }
}
