package after.inappropriate_intimacy;

public class OrderProcessor {

    public void processOrder(Order order) {
        if (order.status.equals("PENDING")) {
            if (order.getPaymentInfo().isAccountValid()) {
                order.status = "APPROVED";
            } else {
                order.status = "PAYMENT_FAILED";
            }

            //buik-discount
            if (order.amount > 1000) {
                order.amount = order.amount * 0.9;
            }
        }
    }

    public String getCustomerStatus(Order order) {
        return order.customerName + " - Order: $" + order.amount + " - " + order.status;
    }
}
