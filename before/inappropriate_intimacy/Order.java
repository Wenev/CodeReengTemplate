package before.inappropriate_intimacy;

import java.util.ArrayList;
import java.util.List;

public class Order {
    String status;
    List<OrderItem> orderItems;
    PaymentGateway paymentGateway;

    public Order() {
        this.status = "PENDING";
        this.orderItems = new ArrayList<>();
        this.paymentGateway = new PaymentGateway();
    }

    public void setStatus(String status) { this.status = status; }
    public String getStatus() { return status; }

    public List<OrderItem> getOrderItems() { return orderItems; }

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public PaymentGateway getPaymentGateway() { return paymentGateway; }
}
