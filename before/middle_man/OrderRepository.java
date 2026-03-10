package before.middle_man;

import java.util.List;

public class OrderRepository {

    public Order findById(Long id) {
        System.out.println("Finding order by id: " + id);
        return new Order(id, "Order-" + id, 100.0);
    }

    public List<Order> findAll() {
        System.out.println("Finding all orders");
        return List.of(
            new Order(1L, "Order-1", 100.0),
            new Order(2L, "Order-2", 200.0)
        );
    }

    public List<Order> findByCustomer(Long customerId) {
        System.out.println("Finding orders for customer: " + customerId);
        return List.of(new Order(1L, "Order-1", 100.0));
    }

    public List<Order> findByStatus(String status) {
        System.out.println("Finding orders with status: " + status);
        return List.of(new Order(1L, "Order-1", 100.0));
    }

    public Order save(Order order) {
        System.out.println("Saving order: " + order);
        return order;
    }

    public void delete(Long id) {
        System.out.println("Deleting order: " + id);
    }

    public boolean exists(Long id) {
        System.out.println("Checking if order exists: " + id);
        return true;
    }

    public int count() {
        System.out.println("Counting orders");
        return 42;
    }
}
