# P9.2 Design

## Methods

### `Clock`

- Get hour of time in current location
- Get minute of time in current location
- Get time string with hour and minutes

### `WorldClock extends Clock`

- Constructor that takes in an integer offset
- Override the method from `Clock` to add a specified offset to the hour method

## Public interface

```java
// Clock
public int getHour();
public int getMinutes();
public String getTime();

// WorldClock
public WorldClock(int offset);
@Override
public int getHour();
```

## Instance variables

```java
// WorldClock
private int offset;
```
