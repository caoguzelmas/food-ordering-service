package com.caoguzelmas.foodorderingservice.paymentservice.domain.core.event;

import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.Payment;

import java.time.ZonedDateTime;
import java.util.Collections;

public class PaymentCanceledEvent extends PaymentEvent{

    public PaymentCanceledEvent(Payment payment, ZonedDateTime createdAt) {
        super(payment, createdAt, Collections.emptyList());
    }
}
