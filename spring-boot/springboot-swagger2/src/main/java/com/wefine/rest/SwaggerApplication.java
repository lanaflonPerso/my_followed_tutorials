package com.wefine.rest;

import com.wefine.rest.model.Product;
import com.wefine.rest.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

@Slf4j
@SpringBootApplication
public class SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            Product testProduct = new Product();
            testProduct.setId("1");
            testProduct.setName("Simple Product");
            testProduct.setDescription("This is a tester product");
            testProduct.setType("CUSTOM");
            testProduct.setCategory("SPECIAL");

            productRepository.save(testProduct);

            log.info(testProduct.toString());
        };
    }
}
