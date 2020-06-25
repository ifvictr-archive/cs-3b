# P3.12 Design

## Methods

- Clear machine state
- Vote for Democrat
- Vote for Republican
- Get tally for Democrat votes
- Get tally for Republican votes

## Public interface

```java
public VotingMachine();

public void clear();
public void addDemocratVote();
public void addRepublicanVote();
public int getDemocratVotesCount();
public int getRepublicanVotesCount();
```

## Instance variables

```java
private int democratVotesCount;
private int republicanVotesCount;
```
