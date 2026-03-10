package before.inappropriate_intimacy;

public class PaymentInfo {
    private String accountNumber = "ACC-12345";
    private boolean valid = true;

    public boolean isAccountValid() { return valid; }
    public String getAccountNumber() { return accountNumber; }
}
