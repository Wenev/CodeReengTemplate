# Message Chains - After

## The Fix

The `Order` class now provides delegate methods that hide the internal object graph.

## Changes Made

1. **Delegate methods on Order** - `getCustomerCity()`, `getWarehouseLocation()`
2. **Delegate methods on intermediate classes** - `Customer.getCity()`, `Product.getWarehouseLocation()`
3. **Clean client code** - `OrderTracker` uses simple method calls

## Before vs After

### Before (Smelly)
```java
// Client code must traverse entire object graph
String city = order.getCustomer().getAddress().getCity();
String location = order.getProduct().getWarehouse().getLocation();
```

### After (Clean)
```java
// Client code uses simple delegate methods
String city = order.getCustomerCity();
String location = order.getWarehouseLocation();
```

## Benefits

1. **Loose coupling** - Clients don't depend on the object graph structure
2. **Easier to maintain** - Changes to the graph only affect delegate methods
3. **Better readability** - Method names express intent
4. **Easier to test** - Less mocking required

## Key Insight

The Law of Demeter: Talk only to friends (immediate collaborators), not strangers.

If you find yourself writing `a.getB().getC().doSomething()`, consider Hide Delegate.
