package com.example.demo4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo4.service.ProductService;
import com.example.demo4.service.TableService;

@SpringBootApplication
public class Demo4Application {

	private static final Logger logger = LoggerFactory.getLogger(Demo4Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Demo4Application.class, args);
	}

	@Bean
    CommandLineRunner runner(TableService tableService, ProductService productService) {
        return args -> {
			logger.info("Initializing database");
            tableService.resetDatabase();
			logger.info("Database initialized successfully");
			logger.info("Generating products");
			productService.loadProductsFromFile();
			logger.info("Products generated successfully");
        };
    }

}
