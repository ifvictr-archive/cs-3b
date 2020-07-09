# P8.4 Design

## Methods

### `Car`

- Picks up 3 random passengers whose destination is same as the car
- Max capacity of a car is 4

- `getId`: Get ID of car
- `getPassengers`: Get list of passengers in car
- `hasSpaceAvailable`: Whether or not the car has space left (can hold up to 4 passengers)
- `pickup`: Pick up a passenger from a station
- `drop`: Drop off a passenger at station
- `hasReachedDestination`: Check if the car has reached its destination
- `driveTo`: Go to station
- `getCurrentStation`: Get current station the car is at
- `setCurrentStation`: Set current station the car is at
- `getDestination`: Get destination station
- `setDestination`: Set destination station
- `isActive`: Whether or not the car is active and can take new passengers
- `setActive`: Change active value
- `getTotalMiles`: Total amount of miles driven
- `getTotalRevenue`: Total amount of revenue made from fares
- `addMoney`: Add money to the total revenue

### `Passenger`

- `getId`: Get ID of passenger
- `getTotalMiles`: Total miles traveled
- `addMiles`: Add miles to total miles
- `getOrigin`: Get origin station
- `getDestination`: Get destination station
- `setDestination`: Set destination station
- `payFare`: Pay fare to a car

### `Simulation`

- `run`: Run the simulation
- `generateCars`: Generate a list of cars
- `generatePassengers`: Generate a list of passengers
- `getTotalMiles`: Add up the total miles driven in the whole network
- `getTotalRevenue`: Add up the total revenue of all the cars in the whole network
- `getRandomStation`: Get a random station from the stations list
- `getNextStation`: Get the station that comes after a given station
- `canProgress`: Check if there are still cars that haven’t reached their destination yet

### `Station`

- Note: There are 30 stations, one at every mile along a route
- Randomly generate X cars and Y passengers, each with a random target station

- `getId`: Get ID of the station
- `distanceTo`: Get distance between current station and other station
- `dropOffAndPickup`: Drops off and adds new passengers from a car
- `getCars`: Get cars at station
- `hasActiveCars`: Check if the station has any cars
- `addCar`: Add a car to the station
- `removeCar`: Remove a car from the station
- `getPassengers`: Get all passengers currently at the station
- `addPassenger`: Add a passenger to the station
- `removePassenger`: Remove a passenger from the station
- `equals`: See if a station is equal to another station

## Public interface

```java
// Car
public Car();
public int getId();
public ArrayList<Passenger> getPassengers();
public boolean hasSpaceAvailable();
public void pickup(Passenger passenger);
public void drop(Passenger passenger);
public boolean hasReachedDestination();
public void driveTo(Station destination);
public Station getCurrentStation();
public void setCurrentStation(Station station);
public Station getDestination();
public void setDestination(Station destination);
public boolean isActive();
public void setActive(boolean active);
public int getTotalMiles();
public double getTotalRevenue();
public void addMoney(double amount);

// Passenger
public Passenger(Station origin);
public int getId();
public int getTotalMiles();
public void addMiles(int miles);
public Station getOrigin();
public Station getDestination();
public void setDestination(Station destination);
public void payFare(Car car);

// Simulation
public void run();
private ArrayList<Car> generateCars(Station origin, int count);
private ArrayList<Passenger> generatePassengers(Station origin, int count);
public int getTotalMiles();
public double getTotalRevenue();
private Station getRandomStation();
private Station getNextStation(Station station);
private boolean canProgress();

// Station
public Station(int id);
public int getId();
public int distanceTo(Station station);
public void dropOffAndPickup(Car car);
public ArrayList<Car> getCars();
public boolean hasActiveCars();
public void addCar(Car car);
public void removeCar(Car car);
public ArrayList<Passenger> getPassengers();
public void addPassenger(Passenger passenger);
public void removePassenger(Passenger passenger);
public boolean equals(Object obj);
```

## Instance variables

```java
// Car
public static final int PASSENGER_CAPACITY = 4;
public static final double FARE_PER_MILE = 5;

private static int nextId = 0;

private int id;
private ArrayList<Passenger> passengers;
private Station currentStation;
private Station destination;
private boolean isActive = true;
private int totalMiles;
private double totalRevenue;

// Passenger
private static int nextId = 0;
private int id;
private int totalMiles;
private Station origin;
private Station destination;

// Simulation
private ArrayList<Station> stations;

// Station
private int id;
private ArrayList<Car> cars;
private ArrayList<Passenger> passengers;
```
