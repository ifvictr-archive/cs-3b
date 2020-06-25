# P3.6 Design

A Person has a name (just a first name for simplicity) and friends. Store the names of the friends in a string, separated by spaces. Provide a constructor that constructs a  person with a given name and no friends.

## Methods

- Befriend a person
- Unfriend a person
- Get friend names

## Public interface

```java
public Person(String name);
public void befriend(Person person);
public void unfriend(Person person);
public String getName();
public String getFriendNames();
```

## Instance variables

```java
private String name;
private String friendNames;
```
