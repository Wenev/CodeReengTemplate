package after.feature_envy;

public class OrderDiscountCalculator {

    public double calculateDiscount(Customer customer) {
        double discount = 0.0;

        if (customer.getMembershipLevel() == MembershipLevel.GOLD) {
            discount += 10.0;
        } else if (customer.getMembershipLevel() == MembershipLevel.SILVER) {
            discount += 5.0;
        }

        if (customer.getYearsAsMember() > 5) {
            discount += 3.0;
        }

        if (customer.getTotalPurchases() > 10000) {
            discount += 5.0;
        }

        if (customer.getPurchaseHistory().size() > 20) {
            discount += 2.0;
        }

        return discount;
    }

    public String getCustomerStatusMessage(Customer customer) {
        String message = "";

        if (customer.getMembershipLevel() == MembershipLevel.GOLD) {
            message = "Valued Gold Member";
        } else if (customer.getMembershipLevel() == MembershipLevel.SILVER) {
            message = "Valued Silver Member";
        } else {
            message = "Valued Customer";
        }

        if (customer.getYearsAsMember() > 10) {
            message += " - Loyalty Champion!";
        }

        return message;
    }
}
