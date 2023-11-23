package com.caoguzelmas.foodorderingservice.paymentservice.application.ports.output.message.publisher;

import com.caoguzelmas.foodorderingservice.domain.event.publisher.DomainEventPublisher;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.event.PaymentFailedEvent;

public interface PaymentFailedMessagePublisher extends DomainEventPublisher<PaymentFailedEvent> {
}
