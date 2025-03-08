package edu.unimagdalena.orderservice.service;

import edu.unimagdalena.orderservice.model.Order;
import edu.unimagdalena.orderservice.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    private final IOrderRepository orderRepository;

    public Mono<Order> saveOrder(Order order) {
        log.info("Guardando orden en la base de datos");
        return Mono.fromCallable(() -> orderRepository.save(order))
                .doOnSuccess(savedOrder -> log.info("Orden guardada con ID: {}", savedOrder.getId()));
    }

    public Flux<Order> getAllOrder() {
        log.info("Buscando todas las órdenes");
        return Flux.fromIterable(orderRepository.findAll())
                .doOnComplete(() -> log.info("Búsqueda de órdenes completada"));
    }

    public Mono<Order> getOrderById(Long id) {
        log.info("Buscando orden con ID: {}", id);
        return Mono.justOrEmpty(orderRepository.findById(id))
                .doOnSuccess(order -> {
                    if (order != null) {
                        log.info("Orden encontrada: {}", order);
                    } else {
                        log.info("No se encontró ninguna orden con ID: {}", id);
                    }
                });
    }

}
