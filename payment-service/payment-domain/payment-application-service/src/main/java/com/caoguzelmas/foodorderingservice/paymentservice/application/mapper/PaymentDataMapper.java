package com.caoguzelmas.foodorderingservice.paymentservice.application.mapper;

import com.caoguzelmas.foodorderingservice.domain.valueobject.CustomerId;
import com.caoguzelmas.foodorderingservice.domain.valueobject.Money;
import com.caoguzelmas.foodorderingservice.domain.valueobject.OrderId;
import com.caoguzelmas.foodorderingservice.paymentservice.application.dto.PaymentRequest;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.Payment;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PaymentDataMapper {
    public Payment paymentRequestModelToPayment(PaymentRequest paymentRequest) {
        return Payment.Builder.builder()
                .orderId(new OrderId(UUID.fromString(paymentRequest.getOrderId())))
                .customerId(new CustomerId(UUID.fromString(paymentRequest.getCustomerId())))
                .price(new Money(paymentRequest.getPrice()))
                .build();
    }
}
