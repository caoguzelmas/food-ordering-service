package com.caoguzelmas.foodorderingservice.paymentservice.domain.core.event;

import com.caoguzelmas.foodorderingservice.domain.event.publisher.DomainEventPublisher;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.Payment;

import java.time.ZonedDateTime;
import java.util.Collections;

public class PaymentCanceledEvent extends PaymentEvent {

    private final DomainEventPublisher<PaymentCanceledEvent> paymentCanceledEventDomainEventPublisher;

    public PaymentCanceledEvent(Payment payment,
                                ZonedDateTime createdAt,
                                DomainEventPublisher<PaymentCanceledEvent> paymentCanceledEventDomainEventPublisher) {
        super(payment, createdAt, Collections.emptyList());
        this.paymentCanceledEventDomainEventPublisher = paymentCanceledEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        paymentCanceledEventDomainEventPublisher.publish(this);
    }
}
