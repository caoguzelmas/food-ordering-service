package com.caoguzelmas.foodorderingservice.orderservice.domain.event;

import com.caoguzelmas.foodorderingservice.orderservice.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderPaidEvent extends OrderEvent {
    public OrderPaidEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
