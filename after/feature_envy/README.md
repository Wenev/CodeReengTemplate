# Feature Envy - After

## The Fix

The `calculateDiscount()` method has been **moved** from `OrderDiscountCalculator` to `Customer`.

## Benefits

1. **Better cohesion** - Method is now in the same class as the data it uses
2. **Direct field access** - No more getters needed for own fields
3. **Follows "Tell, Don't Ask"** - Customer calculates its own discount
4. **Easier to test** - No need to mock a separate calculator class
5. **More intuitive API** - `customer.calculateDiscount()` makes sense

## Before vs After

### Before (Smelly)
```java
OrderDiscountCalculator calculator = new OrderDiscountCalculator();
double discount = calculator.calculateDiscount(customer);
```

### After (Clean)
```java
double discount = customer.calculateDiscount();
```

## What Changed

- `OrderDiscountCalculator` class was removed entirely
- `calculateDiscount()` is now a method on `Customer`
- `getStatusMessage()` was also moved to `Customer`
- The method now accesses its own fields directly (no getters needed)

## Key Insight

When a method uses more data from another class than its own, it's telling you where it belongs!
