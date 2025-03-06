package edu.unimagdalena.order.service;

import edu.unimagdalena.order.model.Order;
import reactor.core.publisher.Mono;
import java.util.List;

public interface OrderService {
    Mono<Order> saveOrder(Order order);
    List<Order> getAllOrder();
    Mono<Order> getOrderByID(Long id);
}
