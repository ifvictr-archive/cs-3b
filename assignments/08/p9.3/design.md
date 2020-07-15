# P9.3 Design

## Methods

### `Clock`

- Get hour of time in current location
- Get minute of time in current location
- Get time string with hour and minutes
- Set alarm at a given hour and minute
- Reset alarm

### `WorldClock extends Clock`

- Constructor that takes in an integer offset
- Override the method from `Clock` to add a specified offset to the hour method

## Public interface

```java
// Clock
public int getHour();
public int getMinutes();
public String getTime();
public void setAlarm(int hour, int minute);
public void resetAlarm();

// WorldClock
public WorldClock(int offset);
@Override
public int getHour();
```

## Instance variables

```java
// Clock
private int alarmHour;
private int alarmMinute;

// WorldClock
private int offset;
```
