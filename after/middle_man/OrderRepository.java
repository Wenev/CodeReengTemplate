package after.middle_man;

import java.util.List;

/**
 * REFACTORED: Middle Man - Fixed with Remove Middle Man
 *
 * The OrderService class has been removed entirely.
 * Clients now use OrderRepository directly.
 *
 * Benefits:
 * 1. Less code to maintain
 * 2. Clearer architecture - no unnecessary abstraction
 * 3. Fewer layers of indirection
 * 4. Easier to understand the codebase
 *
 * When to keep a service layer:
 * - When it adds business logic beyond simple delegation
 * - When it coordinates multiple repositories
 * - When it provides transactions or other cross-cutting concerns
 *
 * When to remove a service layer:
 * - When every method just delegates to another class
 * - When it provides no additional value
 * - When it's created "just in case" we need it later
 */
public class OrderRepository {
    // In a real app, this would have database connections, etc.

    public Order findById(Long id) {
        // Actual implementation
        System.out.println("Finding order by id: " + id);
        return new Order(id, "Order-" + id, 100.0);
    }

    public List<Order> findAll() {
        // Actual implementation
        System.out.println("Finding all orders");
        return List.of(
            new Order(1L, "Order-1", 100.0),
            new Order(2L, "Order-2", 200.0)
        );
    }

    public List<Order> findByCustomer(Long customerId) {
        // Actual implementation
        System.out.println("Finding orders for customer: " + customerId);
        return List.of(new Order(1L, "Order-1", 100.0));
    }

    public List<Order> findByStatus(String status) {
        // Actual implementation
        System.out.println("Finding orders with status: " + status);
        return List.of(new Order(1L, "Order-1", 100.0));
    }

    public Order save(Order order) {
        // Actual implementation
        System.out.println("Saving order: " + order);
        return order;
    }

    public void delete(Long id) {
        // Actual implementation
        System.out.println("Deleting order: " + id);
    }

    public boolean exists(Long id) {
        // Actual implementation
        System.out.println("Checking if order exists: " + id);
        return true;
    }

    public int count() {
        // Actual implementation
        System.out.println("Counting orders");
        return 42;
    }
}
