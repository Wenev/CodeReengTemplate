# Middle Man - Before

## The Smell

This `OrderService` class exhibits **Middle Man** because:

1. Every method just delegates to `OrderRepository`
2. It adds no value - just passes calls through
3. Creates unnecessary abstraction layer
4. Clients should talk directly to `OrderRepository`

## Code Indicators

```java
public class OrderService {
    private OrderRepository repository;

    public Order findById(Long id) {
        return repository.findById(id);  // Just delegating!
    }

    public List<Order> findAll() {
        return repository.findAll();  // Just delegating!
    }

    public Order save(Order order) {
        return repository.save(order);  // Just delegating!
    }

    // ... every method is the same
}
```

## Classes in This Example

- `OrderService` - The middle man (should be removed)
- `OrderRepository` - Does all the actual work
- `Order` - The domain class

## Problems

1. **Unnecessary code** - Adds files and lines without adding value
2. **Extra indirection** - Harder to follow the code
3. **Misleading abstraction** - Looks like a service layer but isn't
4. **Waste of cognitive load** - Developers must understand an extra class

## Refactoring Applied

**Remove Middle Man** - Delete the unnecessary wrapper class.

See `../after/middle_man/OrderRepository.java` for the refactored version.
