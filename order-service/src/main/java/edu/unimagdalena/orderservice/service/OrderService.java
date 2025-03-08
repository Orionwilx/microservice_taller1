package edu.unimagdalena.orderservice.service;

import edu.unimagdalena.orderservice.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {
    Mono<Order> saveOrder(Order order);

    Flux<Order> getAllOrder();

    Mono<Order> getOrderById(Long id);
}
