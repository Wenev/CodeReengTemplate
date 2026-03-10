package before.feature_envy;

/**
 * CODE SMELL: Feature Envy
 *
 * This class exhibits Feature Envy because:
 * 1. The calculateDiscount() method accesses more data from Customer than its own class
 * 2. It's constantly calling getters on customer object
 * 3. The logic really belongs in Customer since it's mostly about customer properties
 *
 * The method uses:
 * - customer.getMembershipLevel()
 * - customer.getYearsAsMember()
 * - customer.getTotalPurchases()
 * - customer.getPurchaseHistory().size()
 *
 * But OrderDiscountCalculator itself has NO data of its own!
 */
public class OrderDiscountCalculator {

    // This class has no fields - it's just a shell that envies other classes

    /**
     * Calculates discount based almost entirely on Customer data.
     * This method should be moved to the Customer class (Move Method refactoring).
     */
    public double calculateDiscount(Customer customer) {
        double discount = 0.0;

        // Feature Envy: Accessing customer's internal data
        if (customer.getMembershipLevel() == MembershipLevel.GOLD) {
            discount += 10.0;
        } else if (customer.getMembershipLevel() == MembershipLevel.SILVER) {
            discount += 5.0;
        }

        // Feature Envy: More customer data access
        if (customer.getYearsAsMember() > 5) {
            discount += 3.0;
        }

        // Feature Envy: Accessing customer purchase history
        if (customer.getTotalPurchases() > 10000) {
            discount += 5.0;
        }

        // Feature Envy: Accessing nested purchase history
        if (customer.getPurchaseHistory().size() > 20) {
            discount += 2.0;
        }

        return discount;
    }

    /**
     * Another method that envies Customer features
     */
    public String getCustomerStatusMessage(Customer customer) {
        String message = "";

        // Feature Envy: All about customer data
        if (customer.getMembershipLevel() == MembershipLevel.GOLD) {
            message = "Valued Gold Member";
        } else if (customer.getMembershipLevel() == MembershipLevel.SILVER) {
            message = "Valued Silver Member";
        } else {
            message = "Valued Customer";
        }

        // Feature Envy: More customer data
        if (customer.getYearsAsMember() > 10) {
            message += " - Loyalty Champion!";
        }

        return message;
    }
}
