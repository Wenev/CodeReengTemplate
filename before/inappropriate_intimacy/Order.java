package before.inappropriate_intimacy;

/**
 * CODE SMELL: Inappropriate Intimacy
 *
 * This class exhibits Inappropriate Intimacy because:
 * 1. OrderProcessor accesses Order's internal fields directly (status, amount, customerName)
 * 2. Order exposes its internal structure through package-private access
 * 3. OrderProcessor manipulates Order's internal state directly
 * 4. The two classes are tightly coupled - changes to Order break OrderProcessor
 */
public class Order {
    // Package-private access - too intimate!
    String status;
    double amount;
    String customerName;
    private PaymentInfo paymentInfo;

    public Order(String customerName, double amount) {
        this.customerName = customerName;
        this.amount = amount;
        this.status = "PENDING";
        this.paymentInfo = new PaymentInfo();
    }

    // Inappropriate Intimacy: OrderProcessor will access these directly
    public void setStatus(String status) { this.status = status; }
    public String getStatus() { return status; }
    public double getAmount() { return amount; }
    public String getCustomerName() { return customerName; }

    // Inappropriate Intimacy: Exposing payment info
    public PaymentInfo getPaymentInfo() { return paymentInfo; }
}
