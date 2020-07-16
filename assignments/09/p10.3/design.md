# P10.3 Design

## Methods

### `Sequence`

- Return next number

### `PrimeSequence` (implements `Sequence`)

- Return the next prime number
- Check if a given number is a prime

## Public interface

```java
// Sequence
int next();

// PrimeSequence
public int next();
public static boolean isPrime(int n);
```

## Instance variables

```java
// PrimeSequence
private int prevN;
```
