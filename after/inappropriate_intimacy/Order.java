package after.inappropriate_intimacy;

/**
 * REFACTORED: Inappropriate Intimacy - Fixed with Encapsulation
 *
 * Changes made:
 * 1. All fields are now private
 * 2. Order exposes behavior, not data
 * 3. OrderProcessor uses public methods, not internal access
 *
 * The Order class now controls its own state through well-defined methods.
 */
public class Order {
    // Private fields - proper encapsulation
    private String status;
    private double amount;
    private String customerName;
    private final PaymentInfo paymentInfo;

    public Order(String customerName, double amount) {
        this.customerName = customerName;
        this.amount = amount;
        this.status = "PENDING";
        this.paymentInfo = new PaymentInfo();
    }

    /**
     * REFACTORED: Expose behavior, not data
     */
    public void approve() {
        if (status.equals("PENDING") && paymentInfo.isAccountValid()) {
            status = "APPROVED";
        }
    }

    public void markPaymentFailed() {
        status = "PAYMENT_FAILED";
    }

    public String getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    /**
     * REFACTORED: Delegate method for payment validation
     */
    public boolean hasValidPayment() {
        return paymentInfo.isAccountValid();
    }

    /**
     * REFACTORED: Apply discount through Order's API
     */
    public void applyBulkDiscount(double percent) {
        if (amount > 1000) {
            amount = amount * (1 - percent / 100);
        }
    }

    /**
     * REFACTORED: Get formatted status through Order's API
     */
    public String getFormattedStatus() {
        return customerName + " - Order: $" + amount + " - " + status;
    }
}
