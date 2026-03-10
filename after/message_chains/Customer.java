package after.message_chains;

/**
 * REFACTORED: Customer also hides its delegates
 */
public class Customer {
    private Address address;
    private String name;

    public Customer(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    public Address getAddress() { return address; }
    public String getName() { return name; }

    /**
     * REFACTORED: Delegate method that Order can use
     */
    public String getCity() {
        return address.getCity();
    }

    /**
     * REFACTORED: Delegate method for shipping zone
     */
    public String getShippingZone() {
        return address.getShippingZone();
    }
}
