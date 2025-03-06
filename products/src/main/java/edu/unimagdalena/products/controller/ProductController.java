package edu.unimagdalena.products.controller;

import edu.unimagdalena.products.entity.Product;
import edu.unimagdalena.products.services.ProductServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServices productService;

    public ProductController(ProductServices productService) {
        this.productService = productService;
    }

    @GetMapping
    public Flux<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping
    public Mono<ResponseEntity<Product>> save(@RequestBody Product product) {
        return productService.save(product)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.status(500).build());
    }
}
