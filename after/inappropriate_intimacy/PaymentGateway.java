package after.inappropriate_intimacy;

public class PaymentGateway {
    private double accountBalance = 1000.0;

    public double getAccountBalance() { return accountBalance; }

    public void charge(double amount) {
        accountBalance -= amount;
    }
}
