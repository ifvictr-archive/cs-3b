public class Item {
    private boolean isPet;
    private double price;
    private int quantity;

    /**
     * Constructs of Item.
     *
     * @param price    the price of the item
     * @param isPet    whether it is a pet or not
     * @param quantity the amount bought
     */
    public Item(double price, boolean isPet, int quantity) {
        this.price = price;
        this.isPet = isPet;
        this.quantity = quantity;
    }

    /**
     * Whether or not the item is a pet.
     *
     * @return is a pet or not
     */
    public boolean isPet() {
        return this.isPet;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Gets the quantity of the item.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return this.quantity;
    }
}
