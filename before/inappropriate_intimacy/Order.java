package before.inappropriate_intimacy;

import java.util.ArrayList;
import java.util.List;

/**
 * CODE SMELL: Inappropriate Intimacy
 *
 * This class exhibits Inappropriate Intimacy because:
 * 1. OrderProcessor accesses Order's internal fields directly (status, orderItems)
 * 2. Order exposes its internal structure through package-private access
 * 3. OrderProcessor manipulates Order's internal state directly
 * 4. The two classes are tightly coupled - changes to Order break OrderProcessor
 */
public class Order {
    // Package-private access - too intimate!
    String status;
    List<OrderItem> orderItems;
    PaymentGateway paymentGateway;

    public Order() {
        this.status = "PENDING";
        this.orderItems = new ArrayList<>();
        this.paymentGateway = new PaymentGateway();
    }

    // Inappropriate Intimacy: OrderProcessor will access these directly
    public void setStatus(String status) { this.status = status; }
    public String getStatus() { return status; }

    // Inappropriate Intimacy: Exposing internal list allows external modification
    public List<OrderItem> getOrderItems() { return orderItems; }

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    // Inappropriate Intimacy: Exposing payment gateway
    public PaymentGateway getPaymentGateway() { return paymentGateway; }
}
