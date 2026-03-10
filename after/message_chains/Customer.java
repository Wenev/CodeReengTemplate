package after.message_chains;

public class Customer {
    private Address address;
    private String name;

    public Customer(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    public Address getAddress() { return address; }
    public String getName() { return name; }
}
