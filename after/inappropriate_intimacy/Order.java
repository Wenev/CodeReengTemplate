package after.inappropriate_intimacy;

import java.util.ArrayList;
import java.util.List;

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
    private final List<OrderItem> orderItems;
    private final PaymentGateway paymentGateway;

    public Order() {
        this.status = "PENDING";
        this.orderItems = new ArrayList<>();
        this.paymentGateway = new PaymentGateway();
    }

    /**
     * REFACTORED: Expose behavior, not data
     */
    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public boolean hasItems() {
        return !orderItems.isEmpty();
    }

    public boolean allItemsAvailable() {
        return orderItems.stream().allMatch(OrderItem::isAvailable);
    }

    public double getTotal() {
        return orderItems.stream().mapToDouble(OrderItem::getPrice).sum();
    }

    /**
     * REFACTORED: State changes through validated methods
     */
    public void approve() {
        if (status.equals("PENDING") && hasItems() && allItemsAvailable()) {
            status = "APPROVED";
        }
    }

    public void markAsProcessing() {
        if (status.equals("PENDING")) {
            status = "PROCESSING";
        }
    }

    public void markPaymentFailed() {
        status = "PAYMENT_FAILED";
    }

    public void markOutOfStock() {
        status = "OUT_OF_STOCK";
    }

    public String getStatus() {
        return status;
    }

    /**
     * REFACTORED: Delegate method for payment check
     */
    public boolean hasSufficientFunds() {
        return paymentGateway.getAccountBalance() >= 0;
    }

    /**
     * REFACTORED: Apply discount through Order's API
     */
    public double calculateDiscountedTotal(double discountPercent) {
        return getTotal() * (1 - discountPercent / 100);
    }
}
