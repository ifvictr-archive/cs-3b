import java.util.ArrayList;

/**
 * Models a basic invoice with items and discounts.
 */
public class Invoice {
    private ArrayList<Item> items = new ArrayList<>();

    /**
     * Adds an item to the invoice.
     *
     * @param item the item to add
     */
    public void add(Item item) {
        this.items.add(item);
    }

    /**
     * Gets the total cost that can be discounted.
     *
     * @return the total cost that can be discounted
     */
    public double getDiscount() {
        // Tally up the counts and costs
        int petsCount = 0;
        int otherItemsCount = 0;
        double otherItemsCost = 0;
        for (Item item : this.items) {
            if (item.isPet()) {
                petsCount += item.getQuantity();
                continue; // Exclude pets from the total cost
            }

            otherItemsCount += item.getQuantity();
            otherItemsCost += item.getPrice() * item.getQuantity(); // Quantity can be >1
        }

        // Check if a discount is applicable
        final int MIN_PETS = 1;
        final int MIN_OTHER_ITEMS = 5;
        final double DISCOUNT = 0.2;
        if (petsCount >= MIN_PETS && otherItemsCount >= MIN_OTHER_ITEMS) {
            return otherItemsCost * DISCOUNT;
        }

        return 0;
    }
}
