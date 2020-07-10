import java.util.ArrayList;
import java.util.Random;

/**
 * Models a single simulation of the car sharing system.
 */
public class Simulation {
    private ArrayList<Station> stations = new ArrayList<>();

    /**
     * Runs a full simulation once.
     */
    public void run() {
        // Create stations
        final int STATION_COUNT = 30;
        for (int id = 1; id <= STATION_COUNT; id++) {
            Station newStation = new Station(id);
            this.stations.add(newStation);
        }

        // Generate cars and passengers for every station
        final int CAR_COUNT = 5;
        final int PASSENGER_COUNT = 20;
        for (Station station : this.stations) {
            for (Car car : this.generateCars(station, CAR_COUNT)) {
                station.addCar(car);
            }
            for (Passenger passenger : this.generatePassengers(station, PASSENGER_COUNT)) {
                station.addPassenger(passenger);
            }
        }

        // Keep dropping and picking up while there are stations with cars that aren't at their
        // destination yet.
        while (this.canProgress()) {
            for (Station station : this.stations) {
                // System.out.println("dropping off and picking up at station " + station.getId());
                for (int i = 0; i < station.getCars().size(); i++) {
                    Car car = station.getCars().get(i);
                    // The removed car gets re-added to the next station.
                    station.dropOffAndPickup(car);

                    // If this station was the car's destination, remove it.
                    if (car.hasReachedDestination() && car.isActive()) {
                        System.out.println(String.format(
                                "[Station #%d] Car %d has arrived at its destination. Total miles: %d, total revenue: $%.2f",
                                station.getId(), car.getId(), car.getTotalMiles(),
                                car.getTotalRevenue()));
                        car.setActive(false);
                        continue;
                    }

                    car.driveTo(this.getNextStation(station));
                }
            }
        }
    }

    /**
     * Generates cars for a station.
     *
     * @param origin station to generate for
     * @param count  number of cars to generate
     * @return list of new cars
     */
    private ArrayList<Car> generateCars(Station origin, int count) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Car newCar = new Car();
            newCar.setCurrentStation(origin);
            newCar.setDestination(this.getRandomStation());

            cars.add(newCar);
        }

        return cars;
    }

    /**
     * Generates waiting passengers for a station.
     *
     * @param origin station to generate for
     * @param count  number of passengers to generate
     * @return list of new passengers
     */
    private ArrayList<Passenger> generatePassengers(Station origin, int count) {
        ArrayList<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Passenger newPassenger = new Passenger(origin);

            newPassenger.setDestination(this.getRandomStation());
            passengers.add(newPassenger);
        }

        return passengers;
    }

    /**
     * Gets the total miles driven of the entire network of cars.
     *
     * @return total miles driven by all cars
     */
    public int getTotalMiles() {
        int totalMiles = 0;
        for (Station station : this.stations) {
            for (Car car : station.getCars()) {
                totalMiles += car.getTotalMiles();
            }
        }

        return totalMiles;
    }

    /**
     * Gets the total revenue made by the entire network of cars.
     *
     * @return total revenue made all cars
     */
    public double getTotalRevenue() {
        double totalRevenue = 0;
        for (Station station : this.stations) {
            for (Car car : station.getCars()) {
                totalRevenue += car.getTotalRevenue();
            }
        }

        return totalRevenue;
    }

    /**
     * Gets a random station.
     *
     * @return random station
     */
    private Station getRandomStation() {
        Random random = new Random();
        int randomIndex = random.nextInt(this.stations.size());

        return this.stations.get(randomIndex);
    }

    /**
     * Gets the station that follows a given station. Will return the first station if this is the
     * last one.
     *
     * @param station current station
     * @return next station
     */
    private Station getNextStation(Station station) {
        int currentIndex = station.getId() - 1;
        // Route goes in a loop, so the last station will go back to the first station.
        int nextIndex = (currentIndex + 1) % this.stations.size();
        return this.stations.get(nextIndex);
    }

    /**
     * Checks if there are still cars that can be moved.
     *
     * @return if the simulation can progress
     */
    private boolean canProgress() {
        for (Station station : this.stations) {
            if (station.hasActiveCars()) {
                return true;
            }
        }

        return false;
    }
}
