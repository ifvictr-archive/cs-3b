# P7.3 Design

## Methods

- Get a die toss (random number between 1–6, inclusive)
- Get an array of die tosses
- Get longest run of numbers in an array

## Public interface

```java
// BoundingPair
public BoundingPair(int startPos, int endPos);
public int getStartPos();
public int getEndPos();
public int length();

// DiceUtil
public int tossDice();
public int[] getDiceTosses(int times);
public BoundingPair getLongestRun(int[] tosses);
```

## Instance variables

```java
// BoundingPair
private int startPos;
private int endPos;
```
