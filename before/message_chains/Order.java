package before.message_chains;

/**
 * Supporting class: Order
 *
 * CODE SMELL: This class enables message chains by exposing nested objects.
 */
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
