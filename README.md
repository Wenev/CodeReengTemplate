# Code Couplers Refactoring Examples

This project demonstrates the **"Couplers"** code smell categories with clear before/after examples.
Each example shows smelly code and its refactored, clean version.

## Code Smell Categories

### 1. Feature Envy (3 classes)
**Location:** `before/feature_envy/` → `after/feature_envy/`

A method that accesses more data from another class than its own.

**Refactoring:** Move Method - relocate the method to the class it envies.

**Classes:**
- Before: `OrderDiscountCalculator`, `Customer`, `MembershipLevel` (3 classes)
- After: `Customer`, `MembershipLevel` (2 classes - calculator removed!)

### 2. Inappropriate Intimacy (4 classes)
**Location:** `before/inappropriate_intimacy/` → `after/inappropriate_intimacy/`

Classes that know too much about each other's internal workings.

**Refactoring:** Increase encapsulation, use delegate methods.

**Classes:** `Order`, `OrderProcessor`, `OrderItem`, `PaymentGateway` (4 classes)

### 3. Message Chains (4 classes)
**Location:** `before/message_chains/` → `after/message_chains/`

Long chains of method calls like `a.getB().getC().getD()`.

**Refactoring:** Hide Delegate - provide direct access through wrapper methods.

**Classes:** `OrderTracker`, `Order`, `Customer`, `Address` (4 classes)

### 4. Middle Man (3 classes)
**Location:** `before/middle_man/` → `after/middle_man/`

A class that only delegates work to another class.

**Refactoring:** Remove Middle Man - use the real class directly.

**Classes:**
- Before: `OrderService`, `OrderRepository`, `Order` (3 classes)
- After: `OrderRepository`, `Order` (2 classes - service removed!)

## Theme: E-Commerce Order System

All examples use a consistent e-commerce domain with Orders, Customers, Addresses, Payments, etc.

## File Structure

```
before/                              after/
├── feature_envy/                    ├── feature_envy/
│   ├── OrderDiscountCalculator.java │   └── Customer.java (with moved method)
│   ├── Customer.java                │
│   └── MembershipLevel.java         │
├── inappropriate_intimacy/          ├── inappropriate_intimacy/
│   ├── Order.java                   │   ├── Order.java (encapsulated)
│   ├── OrderProcessor.java          │   ├── OrderProcessor.java (uses API)
│   ├── OrderItem.java               │   ├── OrderItem.java
│   └── PaymentGateway.java          │   └── PaymentGateway.java
├── message_chains/                  ├── message_chains/
│   ├── OrderTracker.java            │   ├── OrderTracker.java (clean)
│   ├── Order.java                   │   ├── Order.java (delegates)
│   ├── Customer.java                │   ├── Customer.java (delegates)
│   └── Address.java                 │   └── Address.java
└── middle_man/                      └── middle_man/
    ├── OrderService.java            │   └── OrderRepository.java
    ├── OrderRepository.java         │   └── Order.java
    └── Order.java                   │
```

## How to Use

1. **Study the "before" code** - See the code smell in action with explanatory comments
2. **Compare with "after" code** - See the clean, refactored version
3. **Read the comments** - Each file explains what makes the code smelly or clean

## Language

Java - chosen for:
- Clear visibility modifiers (private, public, package-private)
- Strong typing makes smells obvious
- Commonly taught in refactoring courses
