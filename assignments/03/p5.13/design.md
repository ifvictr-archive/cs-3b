# P5.13 Design

## Methods

- Prompt user for pin
- Check if a given pin is correct
- Get failed count, then see if the user

## Public interface

```java
public ATM(String pin);
public boolean checkPin(String pin);
public int getFailedAttemptsCount();
```

## Instance variables

```java
private String accountPin;
private int failedAttemptsCount;
```
