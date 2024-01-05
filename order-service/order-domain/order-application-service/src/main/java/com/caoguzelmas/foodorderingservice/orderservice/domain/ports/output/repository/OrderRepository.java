package com.caoguzelmas.foodorderingservice.orderservice.domain.ports.output.repository;

import com.caoguzelmas.foodorderingservice.domain.valueobject.OrderId;
import com.caoguzelmas.foodorderingservice.orderservice.domain.entity.Order;
import com.caoguzelmas.foodorderingservice.orderservice.domain.valueobject.TrackingId;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(OrderId orderId);

    Optional<Order> findByTrackingId(TrackingId trackingId);
}
