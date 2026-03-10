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
     * - order.amount (direct field access)
     * - order.paymentInfo (nested object access)
     */
    public void processOrder(Order order) {
        if (order.getStatus().equals("PENDING")) {
            // Use delegate method instead of order.paymentInfo.isAccountValid()
            if (order.hasValidPayment()) {
                order.approve();
            } else {
                order.markPaymentFailed();
            }

            // Use public method instead of accessing amount directly
            order.applyBulkDiscount(10);
        }
    }

    /**
     * REFACTORED: Use public API method
     */
    public String getCustomerStatus(Order order) {
        // Use public method instead of accessing internal fields
        return order.getFormattedStatus();
    }
}
