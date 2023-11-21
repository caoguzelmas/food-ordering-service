package com.caoguzelmas.foodorderingservice.paymentservice.domain.core.event;

import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.Payment;

import java.time.ZonedDateTime;
import java.util.Collections;

public class PaymentCompletedEvent extends PaymentEvent{

    public PaymentCompletedEvent(Payment payment, ZonedDateTime createdAt) {
        super(payment, createdAt, Collections.emptyList());
    }
}
