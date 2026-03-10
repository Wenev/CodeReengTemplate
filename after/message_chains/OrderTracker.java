package after.message_chains;

/**
 * REFACTORED: OrderTracker now uses simple delegate methods
 *
 * Instead of message chains like:
 *   order.getCustomer().getAddress().getCity()
 *
 * We now call:
 *   order.getCustomerCity()
 */
public class OrderTracker {

    /**
     * REFACTORED: Uses delegate method instead of message chain
     */
    public String getCustomerCity(Order order) {
        // Clean: order.getCustomerCity()
        return order.getCustomerCity();
    }

    /**
     * REFACTORED: Uses delegate method instead of message chain
     */
    public String getShippingInfo(Order order) {
        // Clean: order.getShippingZone()
        return order.getShippingZone();
    }
}
