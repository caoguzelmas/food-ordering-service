package com.caoguzelmas.foodorderingservice.orderservice.container;

import com.caoguzelmas.foodorderingservice.orderservice.domain.OrderDomainService;
import com.caoguzelmas.foodorderingservice.orderservice.domain.OrderDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public OrderDomainService orderDomainService() {
        return new OrderDomainServiceImpl();
    }
}
