package before.middle_man;

import java.util.List;

/**
 * The class that does all the actual work
 * OrderService is just a unnecessary wrapper around this
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
