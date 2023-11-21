package com.caoguzelmas.foodorderingservice.paymentservice.domain.core.event;

import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.Payment;

import java.time.ZonedDateTime;
import java.util.List;

public class PaymentFailedEvent extends PaymentEvent {

    public PaymentFailedEvent(Payment payment, ZonedDateTime createdAt, List<String> failureMessages) {
        super(payment, createdAt, failureMessages);
    }
}
