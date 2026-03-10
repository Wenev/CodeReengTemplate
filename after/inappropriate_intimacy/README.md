# Inappropriate Intimacy - After

## The Fix

Classes now respect each other's boundaries through proper encapsulation.

## Changes Made

1. **All fields are private** - No direct access from outside
2. **Behavior-exposing methods** - `hasItems()`, `allItemsAvailable()`, etc.
3. **State change methods** - `approve()`, `markAsProcessing()`, etc.
4. **Delegate methods** - `hasSufficientFunds()`, `calculateDiscountedTotal()`

## Before vs After

### Before (Smelly)
```java
public void processOrder(Order order) {
    if (order.status.equals("PENDING")) {
        if (order.orderItems.isEmpty()) { ... }
        if (order.paymentGateway.getAccountBalance() < 0) { ... }
        order.status = "PROCESSING";
        for (OrderItem item : order.orderItems) { ... }
    }
}
```

### After (Clean)
```java
public void processOrder(Order order) {
    if (order.getStatus().equals("PENDING")) {
        if (!order.hasItems()) { ... }
        if (!order.hasSufficientFunds()) { ... }
        order.markAsProcessing();
        if (!order.allItemsAvailable()) { ... }
    }
}
```

## Benefits

1. **Loose coupling** - `OrderProcessor` doesn't depend on `Order`'s internal structure
2. **Easier to maintain** - Internal changes to `Order` don't affect `OrderProcessor`
3. **Better encapsulation** - `Order` controls its own state
4. **More testable** - Can test behavior without mocking internal state

## Key Insight

Expose behavior, not data. Let objects control their own state through well-defined methods.
