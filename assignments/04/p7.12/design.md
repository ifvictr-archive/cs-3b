# P7.12 Design

## Methods

### `Invoice`

- Add item to invoice
- Calculate discount based on current items

### `Item`

- Check if it’s a pet
- Get the price
- Get the quantity

## Public interface

```java
// Invoice
public Invoice();
public void add(Item item);
public double getDiscount();
// Item
public Item(double price, boolean isPet, int quantity);
public boolean isPet();
public double getPrice();
public int getQuantity();
```

## Instance variables

```java
// Invoice
private ArrayList<Item> items;

// Item
private boolean isPet;
private double price;
private int quantity;
```
