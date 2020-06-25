# P3.9 Design

## Methods

- Drain the battery capacity
- Recharage to capacity
- Get capacity

## Public interface

```java
public Battery(double capacity);

public void drain(double amount);
public void charge();
public double getRemainingCapacity();
```

## Instance variables

```java
private double capacity; // Original capacity
private double remainingCapacity; // Max capacity
```
