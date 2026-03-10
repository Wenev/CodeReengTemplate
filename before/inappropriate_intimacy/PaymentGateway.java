package before.inappropriate_intimacy;

/**
 * Supporting class: PaymentGateway
 *
 * CODE SMELL: This class is too intimately connected with Order
 */
public class PaymentGateway {
    private double accountBalance = 1000.0;

    public double getAccountBalance() { return accountBalance; }

    public void charge(double amount) {
        accountBalance -= amount;
    }
}
