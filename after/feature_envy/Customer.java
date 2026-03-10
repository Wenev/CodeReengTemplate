package after.feature_envy;

import java.util.ArrayList;
import java.util.List;

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
}
