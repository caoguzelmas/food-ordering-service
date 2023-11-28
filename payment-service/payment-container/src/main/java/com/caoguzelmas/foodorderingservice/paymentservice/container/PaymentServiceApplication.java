package com.caoguzelmas.foodorderingservice.paymentservice.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.caoguzelmas.foodorderingservice.paymentservice.dataaccess")
@EntityScan(basePackages = "com.caoguzelmas.foodorderingservice.paymentservice")
@SpringBootApplication(scanBasePackages = "com.caoguzelmas.foodorderingservice")
public class PaymentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}
