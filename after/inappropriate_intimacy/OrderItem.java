package after.inappropriate_intimacy;

/**
 * Supporting class: OrderItem
 */
public class OrderItem {
    private final String name;
    private final double price;
    private final boolean available;

    public OrderItem(String name, double price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }
}
