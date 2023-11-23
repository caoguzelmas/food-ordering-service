package com.caoguzelmas.foodorderingservice.orderservice.domain.event;

import com.caoguzelmas.foodorderingservice.domain.event.publisher.DomainEventPublisher;
import com.caoguzelmas.foodorderingservice.orderservice.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderPaidEvent extends OrderEvent {

    private final DomainEventPublisher<OrderPaidEvent> orderPaidEventDomainEventPublisher;
    public OrderPaidEvent(Order order, ZonedDateTime createdAt, DomainEventPublisher<OrderPaidEvent> orderPaidEventDomainEventPublisher) {
        super(order, createdAt);
        this.orderPaidEventDomainEventPublisher = orderPaidEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        orderPaidEventDomainEventPublisher.publish(this);
    }
}
