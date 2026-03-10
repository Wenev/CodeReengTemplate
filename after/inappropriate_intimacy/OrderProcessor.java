package after.inappropriate_intimacy;

/**
 * REFACTORED: OrderProcessor now uses proper encapsulation
 *
 * Instead of accessing internal fields, it uses the public API.
 */
public class OrderProcessor {

    /**
     * REFACTORED: Uses Order's public API, not internal fields
     *
     * No more:
     * - order.status (direct field access)
     * - order.orderItems (internal collection access)
     * - order.paymentGateway.accountBalance (nested object access)
     */
    public void processOrder(Order order) {
        if (order.getStatus().equals("PENDING")) {
            // Use behavior-exposing methods instead of direct access
            if (!order.hasItems()) {
                throw new IllegalStateException("Cannot process empty order");
            }

            // Use delegate method instead of order.paymentGateway.getAccountBalance()
            if (!order.hasSufficientFunds()) {
                order.markPaymentFailed();
                return;
            }

            order.markAsProcessing();

            // Use behavior method instead of iterating internal list
            if (!order.allItemsAvailable()) {
                order.markOutOfStock();
                return;
            }

            order.approve();
        }
    }

    /**
     * REFACTORED: Apply discount using Order's public API
     */
    public void applyDiscount(Order order, double discountPercent) {
        // Use public method instead of accessing orderItems directly
        double discountedTotal = order.calculateDiscountedTotal(discountPercent);
        System.out.println("Applied discount. New total: " + discountedTotal);
    }
}
