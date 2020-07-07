# P8.1 Design

## Methods

### `ComboLock`

- Get the dial’s current position
- Reset the lock’s dial and lock flags
- Turn the dial left by X ticks
- Turn the dial right by X ticks
- Attempt to open the lock (will only be successful if all the unlock flags are on)

## Public interface

```java
// ComboLock
public ComboLock(int secret1, int secret2, int secret3);
public int getDialPosition();
public void reset();
public void turnLeft(int ticks);
public void turnRight(int ticks);
public boolean open();
```

## Instance variables

```java
// ComboLock
private int secret1;
private int secret2;
private int secret3;
private int dialPosition = 0;
private boolean[] unlockFlags = new boolean[3];
```
