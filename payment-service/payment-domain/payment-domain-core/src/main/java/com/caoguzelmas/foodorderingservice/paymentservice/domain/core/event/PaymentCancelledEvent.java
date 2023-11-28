package com.caoguzelmas.foodorderingservice.paymentservice.domain.core.event;

import com.caoguzelmas.foodorderingservice.domain.event.publisher.DomainEventPublisher;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.Payment;

import java.time.ZonedDateTime;
import java.util.Collections;

public class PaymentCancelledEvent extends PaymentEvent {

    private final DomainEventPublisher<PaymentCancelledEvent> paymentCanceledEventDomainEventPublisher;

    public PaymentCancelledEvent(Payment payment,
                                 ZonedDateTime createdAt,
                                 DomainEventPublisher<PaymentCancelledEvent> paymentCanceledEventDomainEventPublisher) {
        super(payment, createdAt, Collections.emptyList());
        this.paymentCanceledEventDomainEventPublisher = paymentCanceledEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        paymentCanceledEventDomainEventPublisher.publish(this);
    }
}
