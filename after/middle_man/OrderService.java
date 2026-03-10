package after.middle_man;

import java.util.List;

public class OrderService {
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order findById(Long id) {
        return repository.findById(id);
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public List<Order> findByCustomer(Long customerId) {
        return repository.findByCustomer(customerId);
    }

    public List<Order> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    public Order save(Order order) {
        return repository.save(order);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public boolean exists(Long id) {
        return repository.exists(id);
    }

    public int count() {
        return repository.count();
    }
}
