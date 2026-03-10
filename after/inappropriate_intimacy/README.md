# Inappropriate Intimacy - After

## The Fix

Classes now respect each other's boundaries through proper encapsulation.

## Changes Made

1. **All fields are private** - No direct access from outside
2. **Behavior-exposing methods** - `approve()`, `hasValidPayment()`, etc.
3. **State change methods** - `markPaymentFailed()`, `applyBulkDiscount()`

## Before vs After

### Before (Smelly)
```java
public void processOrder(Order order) {
    if (order.status.equals("PENDING")) {
        if (order.getPaymentInfo().isAccountValid()) {
            order.status = "APPROVED";
        }
        if (order.amount > 1000) {
            order.amount = order.amount * 0.9;
        }
    }
}
```

### After (Clean)
```java
public void processOrder(Order order) {
    if (order.getStatus().equals("PENDING")) {
        if (order.hasValidPayment()) {
            order.approve();
        }
        order.applyBulkDiscount(10);
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
