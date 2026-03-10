# Feature Envy - Before

## The Smell

This `OrderDiscountCalculator` class exhibits **Feature Envy** because:

1. The `calculateDiscount()` method accesses more data from `Customer` than from its own class
2. It constantly calls getters on customer objects
3. The logic really belongs in `Customer` since it's mostly about customer properties
4. The class has NO fields of its own - it's purely envious!

## Code Indicators

```java
// All this data belongs to Customer, not OrderDiscountCalculator!
if (customer.getMembershipLevel() == MembershipLevel.GOLD) { ... }
if (customer.getYearsAsMember() > 5) { ... }
if (customer.getTotalPurchases() > 10000) { ... }
if (customer.getPurchaseHistory().size() > 20) { ... }
```

## Classes in This Example

- `OrderDiscountCalculator` - The smelly class (envies Customer)
- `Customer` - The class being envied
- `MembershipLevel` - Supporting enum

## Refactoring Applied

**Move Method** - The `calculateDiscount()` method should be moved to the `Customer` class.

See `../after/feature_envy/Customer.java` for the refactored version.
