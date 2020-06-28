# P6.18 Design

## Methods

- Calculate radioactive decay of material by taking in remaining material, time, and half life. Implements the equation `A = A0^(e-t(log2/h))`, with A0 being the initial amount, t being the time, and h being the half life. A is the amount left at t time.

## Public interface

```java
public double calculateDecay(double initialAmount, double time, double halfLife);
```

## Instance variables

```java
// None
```
