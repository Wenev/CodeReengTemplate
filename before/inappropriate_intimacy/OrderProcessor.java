package before.inappropriate_intimacy;

/**
 * CODE SMELL: Inappropriate Intimacy
 *
 * This class:
 * 1. Accesses Order's internal fields directly (order.status, order.amount)
 * 2. Modifies Order's internal state without proper encapsulation
 * 3. Accesses nested objects' internals (order.paymentInfo.accountNumber)
 * 4. Knows too much about Order's implementation details
 */
public class OrderProcessor {

    /**
     * Process an order with inappropriate intimacy
     */
    public void processOrder(Order order) {
        // Inappropriate Intimacy: Direct field access
        if (order.status.equals("PENDING")) {
            // Inappropriate Intimacy: Accessing nested object internals
            if (order.getPaymentInfo().isAccountValid()) {
                // Inappropriate Intimacy: Direct field manipulation
                order.status = "APPROVED";
            } else {
                order.status = "PAYMENT_FAILED";
            }

            // Inappropriate Intimacy: Applying discount by accessing amount directly
            if (order.amount > 1000) {
                order.amount = order.amount * 0.9; // 10% discount
            }
        }
    }

    /**
     * Another example of inappropriate intimacy
     */
    public String getCustomerStatus(Order order) {
        // Inappropriate Intimacy: Accessing internal fields
        return order.customerName + " - Order: $" + order.amount + " - " + order.status;
    }
}
