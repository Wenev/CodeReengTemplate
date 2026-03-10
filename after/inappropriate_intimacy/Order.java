package after.inappropriate_intimacy;

public class Order {
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

    public void setStatus(String status) { this.status = status; }
    public String getStatus() { return status; }
    public double getAmount() { return amount; }
    public String getCustomerName() { return customerName; }

    public PaymentInfo getPaymentInfo() { return paymentInfo; }
}
