package after.inappropriate_intimacy;

/**
 * REFACTORED: PaymentInfo with proper encapsulation
 */
public class PaymentInfo {
    private final String accountNumber = "ACC-12345";
    private final boolean valid = true;

    public boolean isAccountValid() { return valid; }
    public String getAccountNumber() { return accountNumber; }
}
