package before.inappropriate_intimacy;

/**
 * Supporting class: PaymentInfo
 *
 * CODE SMELL: This class is too intimately connected with Order
 */
public class PaymentInfo {
    private String accountNumber = "ACC-12345";
    private boolean valid = true;

    public boolean isAccountValid() { return valid; }
    public String getAccountNumber() { return accountNumber; }
}
