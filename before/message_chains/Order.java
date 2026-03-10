package before.message_chains;

public class Order {
    private Customer customer;
    private String orderNumber;

    public Order(Customer customer, String orderNumber) {
        this.customer = customer;
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() { return customer; }
    public String getOrderNumber() { return orderNumber; }
}
