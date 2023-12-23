package com.caoguzelmas.foodorderingservice.restaurantservice.container;

import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.RestaurantDomainService;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.RestaurantDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public RestaurantDomainService restaurantDomainService() {
        return new RestaurantDomainServiceImpl();
    }
}
