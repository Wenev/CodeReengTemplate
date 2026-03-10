package before.inappropriate_intimacy;

public class OrderProcessor {
    public void processOrder(Order order) {
        if (order.status.equals("PENDING")) {
            if (order.orderItems.isEmpty()) {
                throw new IllegalStateException("Cannot process empty order");
            }

            if (order.paymentGateway.getAccountBalance() < 0) {
                order.status = "PAYMENT_FAILED";
                return;
            }

            order.status = "PROCESSING";

            for (OrderItem item : order.orderItems) {
                if (!item.isAvailable()) {
                    order.status = "OUT_OF_STOCK";
                    return;
                }
            }

            order.status = "APPROVED";
        }
    }

    public void applyDiscount(Order order, double discountPercent) {
        double total = 0;
        for (OrderItem item : order.orderItems) {
            total += item.getPrice();
        }

        double discountedTotal = total * (1 - discountPercent / 100);
        System.out.println("Applied discount. New total: " + discountedTotal);
    }
}
