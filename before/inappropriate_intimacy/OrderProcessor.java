package before.inappropriate_intimacy;

/**
 * CODE SMELL: Inappropriate Intimacy
 *
 * This class:
 * 1. Accesses Order's internal fields directly (order.status, order.orderItems)
 * 2. Modifies Order's internal state without proper encapsulation
 * 3. Accesses nested objects' internals (order.paymentGateway.accountBalance)
 * 4. Knows too much about Order's implementation details
 */
public class OrderProcessor {

    /**
     * Process an order with inappropriate intimacy
     */
    public void processOrder(Order order) {
        // Inappropriate Intimacy: Direct field access
        if (order.status.equals("PENDING")) {
            // Inappropriate Intimacy: Accessing internal list
            if (order.orderItems.isEmpty()) {
                throw new IllegalStateException("Cannot process empty order");
            }

            // Inappropriate Intimacy: Accessing nested object internals
            if (order.paymentGateway.getAccountBalance() < 0) {
                order.status = "PAYMENT_FAILED";
                return;
            }

            // Inappropriate Intimacy: Direct field manipulation
            order.status = "PROCESSING";

            // Inappropriate Intimacy: Iterating over internal collection
            for (OrderItem item : order.orderItems) {
                if (!item.isAvailable()) {
                    order.status = "OUT_OF_STOCK";
                    return;
                }
            }

            order.status = "APPROVED";
        }
    }

    /**
     * Another example of inappropriate intimacy - applying discount
     */
    public void applyDiscount(Order order, double discountPercent) {
        // Inappropriate Intimacy: Accessing internal list to calculate total
        double total = 0;
        for (OrderItem item : order.orderItems) {
            total += item.getPrice();
        }

        // Inappropriate Intimacy: Direct field access
        double discountedTotal = total * (1 - discountPercent / 100);
        System.out.println("Applied discount. New total: " + discountedTotal);
    }
}
