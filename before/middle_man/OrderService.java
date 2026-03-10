package before.middle_man;

import java.util.List;

/**
 * CODE SMELL: Middle Man
 *
 * This class exhibits Middle Man because:
 * 1. Every method just delegates to OrderRepository
 * 2. It adds no value - just passes calls through
 * 3. Creates unnecessary abstraction layer
 * 4. Clients should talk directly to OrderRepository
 */
public class OrderService {
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    /**
     * Middle Man: Just delegates to repository
     * This method does nothing but call repository.findById()
     */
    public Order findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Middle Man: Just delegates to repository
     */
    public List<Order> findAll() {
        return repository.findAll();
    }

    /**
     * Middle Man: Just delegates to repository
     */
    public List<Order> findByCustomer(Long customerId) {
        return repository.findByCustomer(customerId);
    }

    /**
     * Middle Man: Just delegates to repository
     */
    public List<Order> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    /**
     * Middle Man: Just delegates to repository
     */
    public Order save(Order order) {
        return repository.save(order);
    }

    /**
     * Middle Man: Just delegates to repository
     */
    public void delete(Long id) {
        repository.delete(id);
    }

    /**
     * Middle Man: Even complex operations are just delegated
     */
    public boolean exists(Long id) {
        return repository.exists(id);
    }

    /**
     * Middle Man: Count operation also just delegated
     */
    public int count() {
        return repository.count();
    }
}
