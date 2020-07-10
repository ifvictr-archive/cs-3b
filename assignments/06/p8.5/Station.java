import java.util.ArrayList;
import java.util.Random;

/**
 * Models a car station with passengers.
 */
public class Station {
    private final int id;
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public Station(int id) {
        this.id = id;
    }

    /**
     * Gets the station's ID.
     *
     * @return station ID
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the distance between the current station and another station.
     *
     * @param station to get distance to
     * @return distance between
     */
    public int distanceTo(Station station) {
        return Math.abs(this.getId() - station.getId());
    }

    /**
     * Drops off passengers who have arrived at the station, and picks up passengers if this station
     * isn't the car's destination yet. Removes the car if this is its destination.
     *
     * @param car the car dropping off and picking up passengers
     */
    public void dropOffAndPickup(Car car) {
        car.setCurrentStation(this);

        // Drop off all passengers whose destination is this station, then pay the driver.
        for (int i = 0; i < car.getPassengers().size(); i++) {
            Passenger carPassenger = car.getPassengers().get(i);
            if (!carPassenger.getDestination().equals(this)) {
                continue;
            }

            // Pay fare, remove from car, and add to station
            carPassenger.payFare(car);
            car.drop(carPassenger);
            this.addPassenger(carPassenger);
            System.out.println(String.format("[Station #%d] Car %d dropped off passenger %d.",
                    this.getId(), car.getId(), carPassenger.getId()));
        }

        // If the car has reached its destination, remove it
        if (car.hasReachedDestination()) {
            return;
        }

        // Pick up passengers whose destination matches that of the car
        for (int i = 0; i < this.getPassengers().size(); i++) {
            if (!car.hasSpaceAvailable()) {
                break;
            }

            Passenger randomPassenger = this.getRandomPassenger();
            if (!randomPassenger.getDestination().equals(this)) {
                this.removePassenger(randomPassenger);
                car.pickup(randomPassenger);
                System.out.println(String.format("[Station #%d] Car %d picked up passenger %d.",
                        this.getId(), car.getId(), randomPassenger.getId()));
            }
        }
    }

    /**
     * Gets a list of the cars at the station.
     *
     * @return a list of cars
     */
    public ArrayList<Car> getCars() {
        return this.cars;
    }

    /**
     * Checks whether or not there are still outbound cars at the station.
     *
     * @return has outbound cars
     */
    public boolean hasActiveCars() {
        for (Car car : this.getCars()) {
            if (car.isActive()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Adds a car to the station.
     *
     * @param car to add
     */
    public void addCar(Car car) {
        this.cars.add(car);
    }

    /**
     * Removes a car from the station.
     *
     * @param car to remove
     */
    public void removeCar(Car car) {
        this.cars.remove(car);
    }

    /**
     * Gets all the waiting passengers at the station.
     *
     * @return
     */
    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    /**
     * Adds a waiting passenger to the station.
     *
     * @param passenger to add
     */
    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    /**
     * Removes a waiting passenger from the station.
     *
     * @param passenger to remove
     */
    public void removePassenger(Passenger passenger) {
        this.passengers.remove(passenger);
    }

    /**
     * Gets a random passenger.
     *
     * @return a random passenger
     */
    public Passenger getRandomPassenger() {
        Random random = new Random();
        int randomIndex = random.nextInt(this.getPassengers().size());

        return this.getPassengers().get(randomIndex);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Station)) {
            return false;
        }

        Station station = (Station) obj;
        return this.getId() == station.getId();
    }
}
