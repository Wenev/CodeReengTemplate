package before.message_chains;

public class OrderTracker {
    public String getCustomerCity(Order order) {
        return order.getCustomer().getAddress().getCity();
    }

    public String getShippingInfo(Order order) {
        return order.getCustomer().getAddress().getShippingZone();
    }
}
