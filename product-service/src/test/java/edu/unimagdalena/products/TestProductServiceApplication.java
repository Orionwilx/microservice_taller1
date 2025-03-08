package edu.unimagdalena.products;

import org.springframework.boot.SpringApplication;

public class TestProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(TestProductServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
