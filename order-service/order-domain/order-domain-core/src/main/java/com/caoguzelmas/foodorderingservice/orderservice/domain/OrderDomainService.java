package com.caoguzelmas.foodorderingservice.orderservice.domain;

import com.caoguzelmas.foodorderingservice.domain.event.publisher.DomainEventPublisher;
import com.caoguzelmas.foodorderingservice.orderservice.domain.entity.Order;
import com.caoguzelmas.foodorderingservice.orderservice.domain.entity.Restaurant;
import com.caoguzelmas.foodorderingservice.orderservice.domain.event.OrderCancelledEvent;
import com.caoguzelmas.foodorderingservice.orderservice.domain.event.OrderCreatedEvent;
import com.caoguzelmas.foodorderingservice.orderservice.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant, DomainEventPublisher<OrderCreatedEvent> orderCreatedEventDomainEventPublisher);

    OrderPaidEvent payOrder(Order order, DomainEventPublisher<OrderPaidEvent> orderPaidEventDomainEventPublisher);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages, DomainEventPublisher<OrderCancelledEvent> orderCancelledEventDomainEventPublisher);

    void approveOrder(Order order);

    void cancelOrder(Order order, List<String> failureMessages);
}
