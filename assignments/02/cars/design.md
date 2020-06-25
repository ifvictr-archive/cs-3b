# Car Design

## Methods

- Draw the car onto the graphics context

## Public interface

```java
public Car(int x, int y, Color color, int size);
// The last two are optional, so we’ll have other constructors that’ll populate them if they’re not specified.

public void draw(Graphics2D g2);
```

## Instance variables

```java
private int xLeft;
private int yTop;
private Color bodyColor;
private int size;
```
