package before.message_chains;

public class Address {
    private String city;
    private String shippingZone;

    public Address(String city, String shippingZone) {
        this.city = city;
        this.shippingZone = shippingZone;
    }

    public String getCity() { return city; }
    public String getShippingZone() { return shippingZone; }
}
