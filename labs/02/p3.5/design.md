# P3.5 Design

## Methods

- Increase time by 30 seconds
- Switch between power level 1 and 2
- Reset
- Start

## Public interface

```java
public void increaseTime();
public void togglePowerLevel();
public void reset();
public void start();
```

## Instance variables

```java
private int remainingSeconds;
private int powerLevel;
```
