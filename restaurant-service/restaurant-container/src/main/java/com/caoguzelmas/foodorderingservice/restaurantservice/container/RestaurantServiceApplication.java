package com.caoguzelmas.foodorderingservice.restaurantservice.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.caoguzelmas.foodorderingservice.restaurantservice.dataaccess",
        "com.caoguzelmas.foodorderingservice.common.dataaccess"})
@EntityScan(basePackages = {"com.caoguzelmas.foodorderingservice.restaurantservice.dataaccess",
        "com.caoguzelmas.foodorderingservice.common.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.caoguzelmas.foodorderingservice")
public class RestaurantServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantServiceApplication.class, args);
    }
}
