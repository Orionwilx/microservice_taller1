package com.unimagdalena.inventary;

import org.springframework.boot.SpringApplication;

public class TestInventaryApplication {

	public static void main(String[] args) {
		SpringApplication.from(InventaryApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
