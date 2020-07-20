# P11.9 Design

## Methods

### `Bank`

- Get account number
- Get balance

### `BankAccount`

- Read in a file with accounts and balances, then save them internally
- Get all accounts

## Public interface

```java
// Bank
public ArrayList<BankAccount> getAccounts();
public void readFile(String filename);

// BankAccount
public BankAccount(int number, double balance);
public int getNumber();
public double getBalance();
```

## Instance variables

```java
// Bank
private ArrayList<BankAccount> accounts;

// BankAccount
private int accountNumber;
private double balance;
```
