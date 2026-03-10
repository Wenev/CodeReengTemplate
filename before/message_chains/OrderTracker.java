package before.message_chains;

/**
 * CODE SMELL: Message Chains (Law of Demeter Violation)
 *
 * This class exhibits Message Chains because:
 * 1. Long chains of method calls: a.getB().getC().getD()
 * 2. Violates the Law of Demeter - talking to strangers
 * 3. Creates tight coupling to the entire object graph
 * 4. Brittle - any change in the chain breaks this code
 *
 * Example chain: order.getCustomer().getAddress().getCity()
 */
public class OrderTracker {

    /**
     * CODE SMELL: Message Chain
     *
     * This method has a long chain of method calls that:
     * - Violates the Law of Demeter
     * - Creates coupling to Order -> Customer -> Address -> City
     * - Is brittle to changes in any class in the chain
     */
    public String getCustomerCity(Order order) {
        // Message Chain: order -> customer -> address -> city
        return order.getCustomer().getAddress().getCity();
    }

    /**
     * Another Message Chain example
     */
    public String getShippingInfo(Order order) {
        // Message Chain: order -> customer -> address -> shippingZone
        return order.getCustomer().getAddress().getShippingZone();
    }
}
