package before.middle_man;

/**
 * Supporting class: Order
 */
public class Order {
    private Long id;
    private String name;
    private double amount;

    public Order(Long id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return "Order{id=" + id + ", name='" + name + "', amount=" + amount + "}";
    }
}
