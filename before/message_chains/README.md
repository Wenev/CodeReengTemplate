# Message Chains - Before

## The Smell

This `OrderTracker` class exhibits **Message Chains** (Law of Demeter violation) because:

1. Long chains of method calls: `a.getB().getC().getD()`
2. Violates the Law of Demeter - talking to strangers
3. Creates tight coupling to the entire object graph
4. Brittle - any change in the chain breaks this code

## Code Indicators

```java
// Message Chain: order -> customer -> address -> city
return order.getCustomer().getAddress().getCity();

// Message Chain: order -> product -> warehouse -> location
return order.getProduct().getWarehouse().getLocation();
```

## Classes in This Example

- `OrderTracker` - The class with message chains
- `Order` - Enables chains by exposing nested objects
- `Customer` - Has an Address
- `Address` - Has a city
- `Product` - Has a Warehouse
- `Warehouse` - Has a location

## Problems

1. **Brittle** - Change any class in the chain and this code breaks
2. **Hard to test** - Must mock the entire object graph
3. **Violates encapsulation** - Clients depend on internal structure
4. **Poor readability** - Long chains are hard to understand

## Refactoring Applied

**Hide Delegate** - Add wrapper methods that hide the object graph traversal.

See `../after/message_chains/Order.java` for the refactored version.
