package after.message_chains;

/**
 * REFACTORED: Message Chains - Fixed with Hide Delegate
 *
 * Changes made:
 * 1. Order now provides delegate methods for commonly accessed data
 * 2. Clients don't need to traverse the entire object graph
 * 3. Law of Demeter is respected - talk only to friends
 * 4. Changes in the object graph only affect Order, not all clients
 *
 * Instead of: order.getCustomer().getAddress().getCity()
 * We now have: order.getCustomerCity()
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

    /**
     * REFACTORED: Hide Delegate - provide direct access to needed data
     *
     * Instead of forcing clients to do:
     *   order.getCustomer().getAddress().getCity()
     *
     * They can now simply call:
     *   order.getCustomerCity()
     *
     * If the internal structure changes (e.g., city moves from Address to Customer),
     * only this method needs to change, not all the clients.
     */
    public String getCustomerCity() {
        return customer.getCity();
    }

    /**
     * REFACTORED: Delegate method for shipping zone
     *
     * Instead of the message chain:
     *   order.getCustomer().getAddress().getShippingZone()
     *
     * Clients can now call:
     *   order.getShippingZone()
     */
    public String getShippingZone() {
        return customer.getShippingZone();
    }
}
