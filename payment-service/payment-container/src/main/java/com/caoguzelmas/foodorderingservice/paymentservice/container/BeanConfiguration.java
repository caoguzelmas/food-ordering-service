package com.caoguzelmas.foodorderingservice.paymentservice.container;

import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.PaymentDomainService;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.PaymentDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PaymentDomainService paymentDomainService() {
        return new PaymentDomainServiceImpl();
    }
}
