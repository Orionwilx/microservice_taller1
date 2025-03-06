package edu.unimagdalena.order.service;



import edu.unimagdalena.order.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Override
    public Mono<Order> saveOrder(Order order) {
        return null;
    }

    @Override
    public List<Order> getAllOrder() {
        return List.of();
    }

    @Override
    public Mono<Order> getOrderByID(Long id) {
        return null;
    }
}
