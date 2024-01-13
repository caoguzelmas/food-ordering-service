package com.caoguzelmas.foodorderingservice.orderservice.domain.ports.output.message.publisher.payment;

import com.caoguzelmas.foodorderingservice.orderservice.domain.outbox.model.payment.OrderPaymentOutboxMessage;
import com.caoguzelmas.foodorderingservice.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface PaymentRequestMessagePublisher {

    void publish(OrderPaymentOutboxMessage orderPaymentOutboxMessage,
                 BiConsumer<OrderPaymentOutboxMessage, OutboxStatus> outboxCallback);
}
