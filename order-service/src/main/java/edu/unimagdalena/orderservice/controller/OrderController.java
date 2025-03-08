package edu.unimagdalena.orderservice.controller;

import edu.unimagdalena.orderservice.model.Order;
import edu.unimagdalena.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    @PostMapping
    public Mono<Order> createOrder(@RequestBody Order order) {
        log.info("Recibida solicitud para crear orden: {}", order);
        return orderService.saveOrder(order)
                .doOnSuccess(savedOrder -> log.info("Orden creada con éxito: {}", savedOrder));
    }

    @GetMapping
    public Flux<Order> getAllOrders() {
        log.info("Recibida solicitud para obtener todas las órdenes");
        return orderService.getAllOrder();
    }

    @GetMapping("/{id}")
    public Mono<Order> getOrderById(@PathVariable Long id) {
        log.info("Recibida solicitud para obtener orden con ID: {}", id);
        return orderService.getOrderById(id);
    }
}
