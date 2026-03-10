# Inappropriate Intimacy - Before

## The Smell

This example exhibits **Inappropriate Intimacy** because:

1. `OrderProcessor` accesses `Order`'s internal fields directly (`status`, `amount`)
2. `Order` exposes its internal structure through package-private access
3. `OrderProcessor` manipulates `Order`'s internal state directly
4. The two classes are tightly coupled - changes to `Order` break `OrderProcessor`

## Code Indicators

```java
// Inappropriate Intimacy: Direct field access
if (order.status.equals("PENDING")) {
    // Inappropriate Intimacy: Accessing nested object
    if (order.getPaymentInfo().isAccountValid()) {
        // Inappropriate Intimacy: Direct field manipulation
        order.status = "APPROVED";
    }

    // Inappropriate Intimacy: Accessing amount directly
    if (order.amount > 1000) {
        order.amount = order.amount * 0.9;
    }
}
```

## Classes in This Example (3 classes - simple!)

- `Order` - Exposes internal fields (package-private)
- `OrderProcessor` - Accesses Order's internals directly
- `PaymentInfo` - Nested object that's also exposed

## Problems

1. **Fragile** - Any change to `Order`'s internal structure breaks `OrderProcessor`
2. **Hard to test** - Must mock internal state
3. **Violates encapsulation** - External classes manipulate internal fields
4. **Tight coupling** - `Order` and `OrderProcessor` must evolve together

## Refactoring Applied

**Increase Encapsulation** - Make fields private and expose behavior instead of data.

See `../after/inappropriate_intimacy/Order.java` for the refactored version.
