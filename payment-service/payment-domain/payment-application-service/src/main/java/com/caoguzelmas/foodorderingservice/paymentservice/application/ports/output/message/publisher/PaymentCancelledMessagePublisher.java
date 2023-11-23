package com.caoguzelmas.foodorderingservice.paymentservice.application.ports.output.message.publisher;

import com.caoguzelmas.foodorderingservice.domain.event.publisher.DomainEventPublisher;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.event.PaymentCanceledEvent;

public interface PaymentCancelledMessagePublisher extends DomainEventPublisher<PaymentCanceledEvent> {
}
