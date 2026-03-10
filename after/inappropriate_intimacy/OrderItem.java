package after.inappropriate_intimacy;

public class OrderItem {
    private String name;
    private double price;
    private boolean available;

    public OrderItem(String name, double price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }
}
