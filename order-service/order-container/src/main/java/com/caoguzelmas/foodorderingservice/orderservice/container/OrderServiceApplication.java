package com.caoguzelmas.foodorderingservice.orderservice.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.caoguzelmas.foodorderingservice.orderservice",
        "com.caoguzelmas.foodorderingservice.common"})
@EntityScan(basePackages = {"com.caoguzelmas.foodorderingservice.orderservice",
        "com.caoguzelmas.foodorderingservice.common"})
@SpringBootApplication(scanBasePackages = "com.caoguzelmas.foodorderingservice")
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
