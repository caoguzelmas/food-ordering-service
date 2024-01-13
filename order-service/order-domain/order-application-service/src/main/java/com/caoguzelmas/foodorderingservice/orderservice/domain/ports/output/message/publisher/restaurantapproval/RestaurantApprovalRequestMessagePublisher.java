package com.caoguzelmas.foodorderingservice.orderservice.domain.ports.output.message.publisher.restaurantapproval;

import com.caoguzelmas.foodorderingservice.orderservice.domain.outbox.model.approval.OrderApprovalOutboxMessage;
import com.caoguzelmas.foodorderingservice.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface RestaurantApprovalRequestMessagePublisher {

    void publish(OrderApprovalOutboxMessage orderApprovalOutboxMessage,
                 BiConsumer<OrderApprovalOutboxMessage, OutboxStatus> outboxCallback);
}
