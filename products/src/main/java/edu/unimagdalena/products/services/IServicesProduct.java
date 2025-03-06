package edu.unimagdalena.products.services;

import edu.unimagdalena.products.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IServicesProduct {
    Mono<Product> save(Product product);

    Flux<Product> findAll();

    Mono<Product> findById(String id);

    Mono<Void> deleteById(String id);
}

