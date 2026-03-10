package after.feature_envy;

import java.util.ArrayList;
import java.util.List;

/**
 * REFACTORED: Feature Envy - Fixed with Move Method
 *
 * The calculateDiscount() method has been moved from OrderDiscountCalculator
 * to Customer class, where the data actually lives.
 *
 * Benefits:
 * 1. Method is now in the same class as most of the data it uses
 * 2. Better encapsulation - customer calculates its own discount
 * 3. Easier to test - no need to mock separate calculator
 * 4. Follows "Tell, Don't Ask" principle
 */
public class Customer {
    private String name;
    private MembershipLevel membershipLevel;
    private int yearsAsMember;
    private double totalPurchases;
    private List<String> purchaseHistory;

    public Customer(String name, MembershipLevel membershipLevel, int yearsAsMember,
                    double totalPurchases) {
        this.name = name;
        this.membershipLevel = membershipLevel;
        this.yearsAsMember = yearsAsMember;
        this.totalPurchases = totalPurchases;
        this.purchaseHistory = new ArrayList<>();
    }

    public String getName() { return name; }
    public MembershipLevel getMembershipLevel() { return membershipLevel; }
    public int getYearsAsMember() { return yearsAsMember; }
    public double getTotalPurchases() { return totalPurchases; }
    public List<String> getPurchaseHistory() { return purchaseHistory; }

    public void addPurchase(String item) {
        purchaseHistory.add(item);
    }

    /**
     * REFACTORED: Method moved here from OrderDiscountCalculator
     *
     * Now this method has direct access to its own fields instead of
     * going through getters. This is where this logic belongs.
     */
    public double calculateDiscount() {
        double discount = 0.0;

        // Direct field access - no need for getters!
        if (membershipLevel == MembershipLevel.GOLD) {
            discount += 10.0;
        } else if (membershipLevel == MembershipLevel.SILVER) {
            discount += 5.0;
        }

        if (yearsAsMember > 5) {
            discount += 3.0;
        }

        if (totalPurchases > 10000) {
            discount += 5.0;
        }

        if (purchaseHistory.size() > 20) {
            discount += 2.0;
        }

        return discount;
    }

    /**
     * REFACTORED: Status message calculation also moved here
     */
    public String getStatusMessage() {
        String message;

        if (membershipLevel == MembershipLevel.GOLD) {
            message = "Valued Gold Member";
        } else if (membershipLevel == MembershipLevel.SILVER) {
            message = "Valued Silver Member";
        } else {
            message = "Valued Customer";
        }

        if (yearsAsMember > 10) {
            message += " - Loyalty Champion!";
        }

        return message;
    }
}
